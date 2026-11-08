package it.uniroma3.siw_festival;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.function.Supplier;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.model.Interpretazione;
import it.uniroma3.siw_festival.repository.FestivalRepository;
import it.uniroma3.siw_festival.repository.FilmRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@SpringBootTest(properties = {
    "spring.main.banner-mode=off",
    "spring.jpa.show-sql=false",
    "logging.level.root=OFF",
    "spring.jpa.properties.hibernate.generate_statistics=true"
})
public class SiwFestivalBenchmarkTest {

    @Autowired private EntityManager entityManager;
    @Autowired private EntityManagerFactory entityManagerFactory;
    @Autowired private FestivalRepository festivalRepository;
    @Autowired private FilmRepository filmRepository;

    private record Risultato(int film, int personaggi, long query, long ms) {}

    @Test
    @Transactional
    public void compareFetchStrategies() {
        Statistics statistics = entityManagerFactory.unwrap(SessionFactory.class).getStatistics();
        Long festivalId = festivalRepository.findAll().iterator().next().getId();

        // Warm-up: esecuzione scartata (connessione, classi, JIT)
        esegui(statistics, () -> filmRepository.findByFestivalId(festivalId));
        esegui(statistics, () -> filmRepository.findByFestivalIdWithInterpretazioni(festivalId));

        Risultato lazy = esegui(statistics, () -> filmRepository.findByFestivalId(festivalId));
        Risultato join = esegui(statistics, () -> filmRepository.findByFestivalIdWithInterpretazioni(festivalId));

        System.out.println("\n=== Test accesso ai film del festival " + festivalId + " ===\n");
        stampa("Strategia 1: LAZY", lazy);
        stampa("Strategia 2: JOIN FETCH", join);

        // Stesso insieme di dati nelle due strategie
        assertEquals(lazy.film(), join.film(), "Numero di film diverso");
        assertEquals(lazy.personaggi(), join.personaggi(), "Numero di personaggi diverso");
    }

    private Risultato esegui(Statistics statistics, Supplier<List<Film>> caricamento) {
        entityManager.flush();
        entityManager.clear();      // svuota la cache di primo livello
        statistics.clear();         // azzera il contatore delle query

        long start = System.nanoTime();
        List<Film> films = caricamento.get();
        int personaggi = 0;
        for (Film film : films) {
            for (Interpretazione i : film.getInterpretazioni()) {
                i.getPersonaggio();
                personaggi++;
            }
        }
        long ms = (System.nanoTime() - start) / 1_000_000;

        return new Risultato(films.size(), personaggi, statistics.getPrepareStatementCount(), ms);
    }

    private void stampa(String titolo, Risultato r) {
        System.out.println(titolo);
        System.out.println("Film caricati: " + r.film());
        System.out.println("Personaggi caricati: " + r.personaggi());
        System.out.println("Query SQL: " + r.query());
        System.out.println("Tempo: " + r.ms() + " ms\n");
    }
}
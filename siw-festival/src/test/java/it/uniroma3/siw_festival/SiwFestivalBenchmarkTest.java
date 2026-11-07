package it.uniroma3.siw_festival;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.model.Interpretazione;
import it.uniroma3.siw_festival.repository.FestivalRepository;
import it.uniroma3.siw_festival.repository.FilmRepository;
import it.uniroma3.siw_festival.repository.ProiezioneRepository;
import it.uniroma3.siw_festival.repository.RecensioneRepository;
import it.uniroma3.siw_festival.repository.AttoreRepository;
import it.uniroma3.siw_festival.repository.SalaRepository;
import it.uniroma3.siw_festival.repository.UtenteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@SpringBootTest
public class SiwFestivalBenchmarkTest {

        @Autowired
        private EntityManager entityManager;

        @Autowired
        private FestivalRepository festivalRepository;
        @Autowired
        private FilmRepository filmRepository;
        @Autowired
        private ProiezioneRepository proiezioneRepository;
        @Autowired
        private RecensioneRepository recensioneRepository;
        @Autowired
        private AttoreRepository attoreRepository;
        @Autowired
        private SalaRepository salaRepository;
        @Autowired
        private UtenteRepository utenteRepository;
        @Autowired
        private EntityManagerFactory entityManagerFactory;

        private static final Logger logger = LoggerFactory.getLogger(SiwFestivalBenchmarkTest.class);

        @Test
        @Transactional
        public void compareFetchStrategies() {
                SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
                Statistics statistics = sessionFactory.getStatistics();
                statistics.clear();

                // =========================
                // STRATEGIA 1 - LAZY
                // =========================

                statistics.clear();

                long startLazy = System.nanoTime();

                Long festivalId = 1L;

                List<Film> filmsLazy = filmRepository.findByFestivalId(festivalId);

                int personaggiLazy = 0;

                for (Film film : filmsLazy) {
                        if (!film.getInterpretazioni().isEmpty()) {
                                for (Interpretazione interpretazione : film.getInterpretazioni())
                                        interpretazione.getPersonaggio();
                                personaggiLazy++;
                        }
                }

                long endLazy = System.nanoTime();

                long timeLazy = (endLazy - startLazy) / 1_000_000;

                long queriesLazy = statistics.getPrepareStatementCount();

                logger.info("Strategia 1: LAZY");
                logger.info("Film caricati: " + filmsLazy.size());
                logger.info("Personaggi caricati: " + personaggiLazy);
                logger.info("Query SQL: " + queriesLazy);
                logger.info("Tempo: " + timeLazy + " ms");

                // =========================
                // STRATEGIA 2 - JOIN FETCH
                // =========================

                statistics.clear();
                entityManager.clear();

                long startJoin = System.nanoTime();

                List<Film> filmsJoin = filmRepository.findByFestivalIdWithInterpretazioni(festivalId);

                int personaggiJoin = 0;

                for (Film film : filmsLazy) {
                        if (!film.getInterpretazioni().isEmpty()) {
                                for (Interpretazione interpretazione : film.getInterpretazioni())
                                        interpretazione.getPersonaggio();
                                personaggiJoin++;
                        }
                }

                long endJoin = System.nanoTime();

                long timeJoin = (endJoin - startJoin) / 1_000_000;

                long queriesJoin = statistics.getPrepareStatementCount();

                logger.info("Strategia 2: JOIN FETCH");
                logger.info("Film caricati: " + filmsJoin.size());
                logger.info("Personaggi caricati: " + personaggiJoin);
                logger.info("Query SQL: " + queriesJoin);
                logger.info("Tempo: " + timeJoin + " ms");
        };
}
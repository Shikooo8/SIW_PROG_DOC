-- REGISTA 
insert into regista (id, nome, cognome, data_nascita, nazionalità) values (nextval('regista_seq') , 'Christopher', 'Nolan', '1970-07-30', 'Britannica');
insert into regista (id, nome, cognome, data_nascita, nazionalità) values (nextval('regista_seq'), 'Quentin', 'Tarantino', '1963-03-27', 'Statunitense');
insert into regista (id, nome, cognome, data_nascita, nazionalità) values (nextval('regista_seq'), 'Hayao', 'Miyazaki', '1941-01-05', 'Giappone');


-- SALA 
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Grande', 'Via Roma 1', 200);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Blu', 'Via Milano 5', 100);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Piccola', 'Via Trieste 2', 80);


-- UTENTE  -- password: hash bcrypt fittizio, sostituiscilo quando avrai Spring Security
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'admin', '$2a$10$yWAIDyuEr78BBBFZ5cYh8.Nw4gUHFTRG5FwaWqNCGeOD8M4mh3.xy', 'ADMIN');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'mario', '$2a$10$yWAIDyuEr78BBBFZ5cYh8.Nw4gUHFTRG5FwaWqNCGeOD8M4mh3.xy', 'DEFAULT');


-- FESTIVAL 
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Festival del Cinema di Roma', 'Roma', 'Un grande festival internazionale', '2026-10-01', '2026-10-10', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Venezia Classic', 'Venezia', 'Retrospettive', '2026-09-01', '2026-09-10', 2026);

-- FILM 
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista_id) values (nextval('film_seq'), 'Inception', 2010, 148, 'Fantascienza', 'USA', 1);
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista_id) values (nextval('film_seq'), 'Pulp Fiction', 1994, 154, 'Crime', 'USA', 51);
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista_id) values (nextval('film_seq'), 'Oppenheimer', 2023, 180, 'Biografico', 'USA', 1);
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista_id) values (nextval('film_seq'), 'Barbie', 2023, 114, 'Commedia', 'USA', 51);
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista_id) values (nextval('film_seq'), 'La città incantata', 2001, 125, 'Animazione', 'Giappone', 101);


-- FILM_FESTIVALS 
insert into film_festivals (film_id, festivals_id) values (1, 1);
insert into film_festivals (film_id, festivals_id) values (51, 1);
insert into film_festivals (film_id, festivals_id) values (101, 1);
insert into film_festivals (film_id, festivals_id) values (1, 51);
insert into film_festivals (film_id, festivals_id) values (151, 51);
insert into film_festivals (film_id, festivals_id) values (201, 51);


-- PROIEZIONE 
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-10-02', '20:30:00', 'SCHEDULED', 1, 1, 1);
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-10-03', '18:00:00', 'SCHEDULED', 1, 51, 51);

-- RECENSIONE -- attenzione: unique(film_id, utente_id), niente doppioni
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 9, 'Capolavoro assoluto', now(), 1, 51);
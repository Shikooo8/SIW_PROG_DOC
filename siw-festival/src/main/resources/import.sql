-- SALA
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Grande', 'Via Roma 1', 200);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Blu', 'Via Milano 5', 100);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Piccola', 'Via Trieste 2', 80);

-- UTENTE
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'admin', '$2a$10$yWAIDyuEr78BBBFZ5cYh8.Nw4gUHFTRG5FwaWqNCGeOD8M4mh3.xy', 'ADMIN');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'mario', '$2a$10$yWAIDyuEr78BBBFZ5cYh8.Nw4gUHFTRG5FwaWqNCGeOD8M4mh3.xy', 'DEFAULT');

-- FESTIVAL
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Festival del Cinema di Roma', 'Roma', 'Un grande festival internazionale', '2026-10-01', '2026-10-10', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Venezia Classic', 'Venezia', 'Retrospettive', '2026-09-01', '2026-09-10', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Tokyo on Fest!', 'Tokyo', 'Grande evento specializzato in animazione', '2026-05-01', '2026-05-16', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Grande Venezuela Film', 'Caracas', 'Il festival più grande del Venezuela', '2025-12-10', '2025-12-20', 2025);

-- FILM (regista ora è una stringa)
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Inception', 2010, 148, 'Fantascienza', 'USA', 'Christopher Nolan');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Pulp Fiction', 1994, 154, 'Crime', 'USA', 'Quentin Tarantino');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Oppenheimer', 2023, 180, 'Biografico', 'USA', 'Christopher Nolan');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Barbie', 2023, 114, 'Commedia', 'USA', 'Greta Gerwig');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'La città incantata', 2001, 125, 'Animazione', 'Giappone', 'Hayao Miyazaki');

-- ATTORE
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Leonardo', 'DiCaprio', '1974-11-11', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Tom', 'Hardy', '1977-09-15', 'Britannica');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'John', 'Travolta', '1954-02-18', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Samuel L.', 'Jackson', '1948-12-21', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Uma', 'Thurman', '1970-04-29', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Cillian', 'Murphy', '1976-05-25', 'Irlandese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Emily', 'Blunt', '1983-02-23', 'Britannica');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Matt', 'Damon', '1970-10-08', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Margot', 'Robbie', '1990-07-02', 'Australiana');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Ryan', 'Gosling', '1980-11-12', 'Canadese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Rumi', 'Hiiragi', '1987-08-01', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Miyu', 'Irino', '1988-02-19', 'Giapponese');

-- INTERPRETAZIONE (film, attore, personaggio)
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Dom Cobb', (select id from film where titolo='Inception'), (select id from attore where cognome='DiCaprio'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Eames', (select id from film where titolo='Inception'), (select id from attore where cognome='Hardy'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Vincent Vega', (select id from film where titolo='Pulp Fiction'), (select id from attore where cognome='Travolta'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Jules Winnfield', (select id from film where titolo='Pulp Fiction'), (select id from attore where cognome='Jackson'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Mia Wallace', (select id from film where titolo='Pulp Fiction'), (select id from attore where cognome='Thurman'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'J. Robert Oppenheimer', (select id from film where titolo='Oppenheimer'), (select id from attore where cognome='Murphy'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Kitty Oppenheimer', (select id from film where titolo='Oppenheimer'), (select id from attore where cognome='Blunt'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Leslie Groves', (select id from film where titolo='Oppenheimer'), (select id from attore where cognome='Damon'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Barbie', (select id from film where titolo='Barbie'), (select id from attore where cognome='Robbie'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Ken', (select id from film where titolo='Barbie'), (select id from attore where cognome='Gosling'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Chihiro (voce)', (select id from film where titolo='La città incantata'), (select id from attore where cognome='Hiiragi'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Haku (voce)', (select id from film where titolo='La città incantata'), (select id from attore where cognome='Irino'));

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

-- RECENSIONE (unique film_id + utente_id)
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 9, 'Capolavoro assoluto', now(), 1, 51);
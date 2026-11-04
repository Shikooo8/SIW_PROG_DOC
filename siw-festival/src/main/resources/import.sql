-- ==========================================
-- SALA (30 sale)
-- ==========================================
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Grande', 'Via Roma 1', 200);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Blu', 'Via Milano 5', 100);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Piccola', 'Via Trieste 2', 80);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Rossa', 'Via Garibaldi 10', 150);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Verde', 'Piazza Mazzini 3', 120);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Gialla', 'Corso Vittorio 8', 90);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala IMAX', 'Via del Cinema 1', 400);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala 3D', 'Via dello Spettacolo 2', 250);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala VIP', 'Via Privata 7', 30);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Atmos', 'Via Acustica 4', 180);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Storica', 'Piazza Vecchia 1', 110);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Estiva', 'Parco Centrale', 500);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Indie', 'Via Indipendenza 11', 60);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Lux', 'Corso Cavour 14', 140);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Odeon', 'Piazza Dante 9', 300);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Iris', 'Via dei Mille 22', 130);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Diamante', 'Viale dei Pini 5', 170);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Smeraldo', 'Via Roma 100', 160);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Rubino', 'Corso Francia 45', 150);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Zaffiro', 'Via Veneto 88', 190);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Argento', 'Piazza Repubblica 2', 210);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Oro', 'Via Condotti 5', 220);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Platino', 'Via Torino 18', 230);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Bronzo', 'Viale Monza 12', 100);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Metropolis', 'Via Nuova 1', 350);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Fellini', 'Piazzale Fellini 1', 280);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Leone', 'Via degli Studi 5', 200);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Kubrick', 'Viale Spaziale 2001', 150);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Tarantino', 'Via Pulp 94', 180);
insert into sala (id, nome, indirizzo, capienza) values (nextval('sala_seq'), 'Sala Hitchcock', 'Viale del Brivido', 140);

-- ==========================================
-- UTENTE (20 utenti)
-- ==========================================
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'admin', '$2a$10$yWAIDyuEr78BBBFZ5cYh8.Nw4gUHFTRG5FwaWqNCGeOD8M4mh3.xy', 'ADMIN');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'mario', '$2a$10$yWAIDyuEr78BBBFZ5cYh8.Nw4gUHFTRG5FwaWqNCGeOD8M4mh3.xy', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'luigi', 'hashed_pass_here', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'giulia_cinefila', 'hashed_pass_here', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'marco_rossi', 'hashed_pass_here', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'anna_bianchi', 'hashed_pass_here', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'luca_99', 'hashed_pass_here', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'sara_movie', 'hashed_pass_here', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'elena_verdi', 'hashed_pass_here', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'matteo_88', 'hashed_pass_here', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'francesca_n', 'hashed_pass_here', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'giovanni_p', 'hashed_pass_here', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'chiara_l', 'hashed_pass_here', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'andrea_b', 'hashed_pass_here', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'valeria_m', 'hashed_pass_here', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'roberto_g', 'hashed_pass_here', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'silvia_c', 'hashed_pass_here', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'davide_f', 'hashed_pass_here', 'DEFAULT');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'moderator1', 'hashed_pass_here', 'MODERATOR');
insert into utente (id, username, password, ruolo) values (nextval('utente_seq'), 'super_admin', 'hashed_pass_here', 'ADMIN');

-- ==========================================
-- FESTIVAL (15 festival)
-- ==========================================
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Festival del Cinema di Roma', 'Roma', 'Un grande festival internazionale', '2026-10-01', '2026-10-10', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Venezia Classic', 'Venezia', 'Retrospettive', '2026-09-01', '2026-09-10', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Tokyo on Fest!', 'Tokyo', 'Grande evento specializzato in animazione', '2026-05-01', '2026-05-16', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Grande Venezuela Film', 'Caracas', 'Il festival più grande del Venezuela', '2025-12-10', '2025-12-20', 2025);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Cannes Film Festival', 'Cannes', 'Il più prestigioso festival europeo', '2026-05-12', '2026-05-23', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Sundance Film Festival', 'Park City', 'Il meglio del cinema indipendente', '2026-01-20', '2026-01-30', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Berlinale', 'Berlino', 'Festival internazionale del cinema di Berlino', '2026-02-15', '2026-02-25', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'TIFF', 'Toronto', 'Toronto International Film Festival', '2026-09-05', '2026-09-15', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Annecy Festival', 'Annecy', 'Il più importante festival di animazione al mondo', '2026-06-09', '2026-06-15', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Locarno Film Festival', 'Locarno', 'Cinema d autore sotto le stelle', '2026-08-05', '2026-08-15', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Sitges Film Festival', 'Sitges', 'Festival internazionale del cinema fantastico', '2026-10-05', '2026-10-15', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'BFI London Film Festival', 'Londra', 'Rassegna autunnale di grande prestigio', '2026-10-07', '2026-10-18', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Tribeca Film Festival', 'New York', 'Festival newyorkese fondato da De Niro', '2026-04-15', '2026-04-26', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Musical On Screen Fest', 'Broadway', 'Celebrazione mondiale del cinema musicale', '2026-11-01', '2026-11-07', 2026);
insert into festival (id, nome, città, descrizione, data_inizio, data_fine, anno) values (nextval('festival_seq'), 'Anime Expo Cinema', 'Los Angeles', 'Proiezioni esclusive di lungometraggi anime', '2026-07-01', '2026-07-04', 2026);

-- ==========================================
-- FILM (50 Film: Originali, Musical, Romance, Anime, Cult)
-- ==========================================
-- Originali
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'Inception', 2010, 148, 'Fantascienza', 'USA', 'Christopher Nolan', 'films/Inception.jpg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'Pulp Fiction', 1994, 154, 'Crime', 'USA', 'Quentin Tarantino','films/PulpFiction.jpg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'Oppenheimer', 2023, 180, 'Biografico', 'USA', 'Christopher Nolan','films/Oppenheimer.jpg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'Barbie', 2023, 114, 'Commedia', 'USA', 'Greta Gerwig','films/Barbie.jpeg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'La città incantata', 2001, 125, 'Animazione', 'Giappone', 'Hayao Miyazaki','films/LaCittàIncatata.jpg');
-- Musical
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'La La Land', 2016, 128, 'Musical', 'USA', 'Damien Chazelle','films/LaLaLand.jpg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'The Greatest Showman', 2017, 105, 'Musical', 'USA', 'Michael Gracey','films/TheGreatestShowman.jpg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'Les Misérables', 2012, 158, 'Musical', 'UK', 'Tom Hooper',,'films/LesMiserables.jpg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'Chicago', 2002, 113, 'Musical', 'USA', 'Rob Marshall',,'films/Chicago.jpg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'Grease', 1978, 110, 'Musical', 'USA', 'Randal Kleiser','films/Grease.jpg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'Moulin Rouge!', 2001, 127, 'Musical', 'Australia', 'Baz Luhrmann','films/MoulinRouge.jpg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'West Side Story', 2021, 156, 'Musical', 'USA', 'Steven Spielberg','films/WestSideStory.jpg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'Mamma Mia!', 2008, 108, 'Musical', 'UK', 'Phyllida Lloyd','films/MammaMia.jpg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'The Sound of Music', 1965, 174, 'Musical', 'USA', 'Robert Wise','films/theSoundOfMuics.jpg');
-- Orgoglio e Pregiudizio & Romance/Drama
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'Orgoglio e pregiudizio', 2005, 129, 'Drammatico', 'UK', 'Joe Wright','films/OrgoglioePregiudizio.jpg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Espiazione', 2007, 123, 'Drammatico', 'UK', 'Joe Wright');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Ritratto della giovane in fiamme', 2019, 122, 'Drammatico', 'Francia', 'Céline Sciamma');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Chiamami col tuo nome', 2017, 132, 'Drammatico', 'Italia', 'Luca Guadagnino');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Ragione e sentimento', 1995, 136, 'Drammatico', 'UK', 'Ang Lee');
-- Anime
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'Your Name.', 2016, 106, 'Animazione', 'Giappone', 'Makoto Shinkai','films/YourName.jpg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'Il castello errante di Howl', 2004, 119, 'Animazione', 'Giappone', 'Hayao Miyazaki','films/IlCasterlloErrantediHowl.jpeg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Principessa Mononoke', 1997, 134, 'Animazione', 'Giappone', 'Hayao Miyazaki');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'Akira', 1988, 124, 'Animazione', 'Giappone', 'Katsuhiro Otomo','films/Akiraa.jpg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'Il mio vicino Totoro', 1988, 86, 'Animazione', 'Giappone', 'Hayao Miyazaki','films/Totoro.jpg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Ghost in the Shell', 1995, 83, 'Animazione', 'Giappone', 'Mamoru Oshii');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Perfect Blue', 1997, 81, 'Animazione', 'Giappone', 'Satoshi Kon');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista, immagine) values (nextval('film_seq'), 'A Silent Voice', 2016, 130, 'Animazione', 'Giappone', 'Naoko Yamada', 'films/ASilentVoice.jpg');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Weathering with You', 2019, 112, 'Animazione', 'Giappone', 'Makoto Shinkai');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Suzume', 2022, 122, 'Animazione', 'Giappone', 'Makoto Shinkai');
-- Cult, Blockbuster e Altri
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Il Padrino', 1972, 175, 'Crime', 'USA', 'Francis Ford Coppola');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Il Padrino - Parte II', 1974, 202, 'Crime', 'USA', 'Francis Ford Coppola');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Interstellar', 2014, 169, 'Fantascienza', 'USA', 'Christopher Nolan');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Il Signore degli Anelli - La Compagnia dell Anello', 2001, 178, 'Fantasy', 'USA', 'Peter Jackson');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Matrix', 1999, 136, 'Fantascienza', 'USA', 'Lana e Lilly Wachowski');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Forrest Gump', 1994, 142, 'Drammatico', 'USA', 'Robert Zemeckis');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Parasite', 2019, 132, 'Thriller', 'Corea del Sud', 'Bong Joon-ho');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Gladiatore', 2000, 155, 'Storico', 'USA', 'Ridley Scott');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Avatar', 2009, 162, 'Fantascienza', 'USA', 'James Cameron');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Titanic', 1997, 195, 'Drammatico', 'USA', 'James Cameron');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Avengers: Endgame', 2019, 181, 'Azione', 'USA', 'Anthony e Joe Russo');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Joker', 2019, 122, 'Drammatico', 'USA', 'Todd Phillips');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Mad Max: Fury Road', 2015, 120, 'Azione', 'Australia', 'George Miller');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'The Dark Knight', 2008, 152, 'Azione', 'USA', 'Christopher Nolan');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Spirited Away', 2001, 125, 'Animazione', 'Giappone', 'Hayao Miyazaki');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Spider-Man: Across the Spider-Verse', 2023, 140, 'Animazione', 'USA', 'K. Powers, J. Dos Santos, J. Thompson');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Blade Runner 2049', 2017, 163, 'Fantascienza', 'USA', 'Denis Villeneuve');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Dune - Parte Uno', 2021, 155, 'Fantascienza', 'USA', 'Denis Villeneuve');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Seven', 1995, 127, 'Thriller', 'USA', 'David Fincher');
insert into film (id, titolo, anno, durata, genere, paese_produzione, regista) values (nextval('film_seq'), 'Fight Club', 1999, 139, 'Drammatico', 'USA', 'David Fincher');


-- ==========================================
-- ATTORE (100+ Attori, inclusi doppiatori anime)
-- ==========================================
-- Originali
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
-- Musical
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Emma', 'Stone', '1988-11-06', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'John', 'Legend', '1978-12-28', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Hugh', 'Jackman', '1968-10-12', 'Australiana');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Zac', 'Efron', '1987-10-18', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Zendaya', 'Coleman', '1996-09-01', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Anne', 'Hathaway', '1982-11-12', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Russell', 'Crowe', '1964-04-07', 'Neozelandese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Renée', 'Zellweger', '1969-04-25', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Catherine', 'Zeta-Jones', '1969-09-25', 'Gallese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Richard', 'Gere', '1949-08-31', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Olivia', 'Newton-John', '1948-09-26', 'Australiana');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Nicole', 'Kidman', '1967-06-20', 'Australiana');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Ewan', 'McGregor', '1971-03-31', 'Scozzese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Rachel', 'Zegler', '2001-05-03', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Ansel', 'Elgort', '1994-03-14', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Meryl', 'Streep', '1949-06-22', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Amanda', 'Seyfried', '1985-12-03', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Julie', 'Andrews', '1935-10-01', 'Britannica');
-- Orgoglio e Pregiudizio / Romance
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Keira', 'Knightley', '1985-03-26', 'Britannica');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Matthew', 'Macfadyen', '1974-10-17', 'Britannica');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Rosamund', 'Pike', '1979-01-27', 'Britannica');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Judi', 'Dench', '1934-12-09', 'Britannica');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'James', 'McAvoy', '1979-04-21', 'Scozzese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Timothée', 'Chalamet', '1995-12-27', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Armie', 'Hammer', '1986-08-28', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Kate', 'Winslet', '1975-10-05', 'Britannica');
-- Doppiatori / Seiyuu Anime
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Ryunosuke', 'Kamiki', '1993-05-19', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Mone', 'Kamishiraishi', '1998-01-27', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Chieko', 'Baisho', '1941-06-29', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Takuya', 'Kimura', '1972-11-13', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Yoji', 'Matsuda', '1967-10-19', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Yuriko', 'Ishida', '1969-10-03', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Mitsuo', 'Iwata', '1967-07-31', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Nozomu', 'Sasaki', '1967-01-25', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Noriko', 'Hidaka', '1962-05-31', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Atsuko', 'Tanaka', '1962-11-14', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Akio', 'Otsuka', '1959-11-24', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Junko', 'Iwao', '1970-02-18', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Rica', 'Matsumoto', '1968-11-30', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Saori', 'Hayami', '1991-05-29', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Miyu', 'Irino (A Silent Voice)', '1988-02-19', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Kotaro', 'Daigo', '2000-09-01', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Nana', 'Mori', '2001-08-31', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Hokuto', 'Matsumura', '1995-06-18', 'Giapponese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Nanoka', 'Hara', '2003-08-26', 'Giapponese');
-- Altri
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Marlon', 'Brando', '1924-04-03', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Al', 'Pacino', '1940-04-25', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Robert', 'De Niro', '1943-08-17', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Matthew', 'McConaughey', '1969-11-04', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Elijah', 'Wood', '1981-01-28', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Keanu', 'Reeves', '1964-09-02', 'Canadese');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Tom', 'Hanks', '1956-07-09', 'Statunitense');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Kang-ho', 'Song', '1967-01-17', 'Sudcoreana');
insert into attore (id, nome, cognome, data_nascita, nazionalità) values (nextval('attore_seq'), 'Joaquin', 'Phoenix', '1974-10-28', 'Statunitense');


-- ==========================================
-- INTERPRETAZIONE (Link Film <-> Attori)
-- ==========================================
-- Originali
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Dom Cobb', (select id from film where titolo='Inception'), (select id from attore where cognome='DiCaprio' and nome='Leonardo'));
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
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Haku (voce)', (select id from film where titolo='La città incantata'), (select id from attore where nome='Miyu' and cognome='Irino'));

-- Musical
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Mia Dolan', (select id from film where titolo='La La Land'), (select id from attore where cognome='Stone'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Sebastian Wilder', (select id from film where titolo='La La Land'), (select id from attore where cognome='Gosling'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'P.T. Barnum', (select id from film where titolo='The Greatest Showman'), (select id from attore where cognome='Jackman'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Phillip Carlyle', (select id from film where titolo='The Greatest Showman'), (select id from attore where cognome='Efron'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Anne Wheeler', (select id from film where titolo='The Greatest Showman'), (select id from attore where cognome='Coleman'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Jean Valjean', (select id from film where titolo='Les Misérables'), (select id from attore where cognome='Jackman'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Fantine', (select id from film where titolo='Les Misérables'), (select id from attore where cognome='Hathaway'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Javert', (select id from film where titolo='Les Misérables'), (select id from attore where cognome='Crowe'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Roxie Hart', (select id from film where titolo='Chicago'), (select id from attore where cognome='Zellweger'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Velma Kelly', (select id from film where titolo='Chicago'), (select id from attore where cognome='Zeta-Jones'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Billy Flynn', (select id from film where titolo='Chicago'), (select id from attore where cognome='Gere'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Danny Zuko', (select id from film where titolo='Grease'), (select id from attore where cognome='Travolta'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Sandy Olsson', (select id from film where titolo='Grease'), (select id from attore where cognome='Newton-John'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Satine', (select id from film where titolo='Moulin Rouge!'), (select id from attore where cognome='Kidman'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Christian', (select id from film where titolo='Moulin Rouge!'), (select id from attore where cognome='McGregor'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Maria', (select id from film where titolo='West Side Story'), (select id from attore where cognome='Zegler'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Tony', (select id from film where titolo='West Side Story'), (select id from attore where cognome='Elgort'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Donna Sheridan', (select id from film where titolo='Mamma Mia!'), (select id from attore where cognome='Streep'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Sophie Sheridan', (select id from film where titolo='Mamma Mia!'), (select id from attore where cognome='Seyfried'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Maria von Trapp', (select id from film where titolo='The Sound of Music'), (select id from attore where cognome='Andrews'));

-- Orgoglio e Pregiudizio & Drama
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Elizabeth Bennet', (select id from film where titolo='Orgoglio e pregiudizio'), (select id from attore where cognome='Knightley'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Mr. Darcy', (select id from film where titolo='Orgoglio e pregiudizio'), (select id from attore where cognome='Macfadyen'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Jane Bennet', (select id from film where titolo='Orgoglio e pregiudizio'), (select id from attore where cognome='Pike'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Lady Catherine de Bourgh', (select id from film where titolo='Orgoglio e pregiudizio'), (select id from attore where cognome='Dench'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Cecilia Tallis', (select id from film where titolo='Espiazione'), (select id from attore where cognome='Knightley'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Robbie Turner', (select id from film where titolo='Espiazione'), (select id from attore where cognome='McAvoy'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Elio Perlman', (select id from film where titolo='Chiamami col tuo nome'), (select id from attore where cognome='Chalamet'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Oliver', (select id from film where titolo='Chiamami col tuo nome'), (select id from attore where cognome='Hammer'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Marianne Dashwood', (select id from film where titolo='Ragione e sentimento'), (select id from attore where cognome='Winslet'));

-- Anime (Doppiatori originali)
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Taki Tachibana (voce)', (select id from film where titolo='Your Name.'), (select id from attore where cognome='Kamiki'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Mitsuha Miyamizu (voce)', (select id from film where titolo='Your Name.'), (select id from attore where cognome='Kamishiraishi'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Sophie (voce anziana)', (select id from film where titolo='Il castello errante di Howl'), (select id from attore where cognome='Baisho'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Howl (voce)', (select id from film where titolo='Il castello errante di Howl'), (select id from attore where cognome='Kimura'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Ashitaka (voce)', (select id from film where titolo='Principessa Mononoke'), (select id from attore where cognome='Matsuda'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'San (voce)', (select id from film where titolo='Principessa Mononoke'), (select id from attore where cognome='Ishida'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Kaneda (voce)', (select id from film where titolo='Akira'), (select id from attore where cognome='Iwata'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Tetsuo (voce)', (select id from film where titolo='Akira'), (select id from attore where cognome='Sasaki'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Satsuki Kusakabe (voce)', (select id from film where titolo='Il mio vicino Totoro'), (select id from attore where cognome='Hidaka'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Motoko Kusanagi (voce)', (select id from film where titolo='Ghost in the Shell'), (select id from attore where cognome='Tanaka'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Batou (voce)', (select id from film where titolo='Ghost in the Shell'), (select id from attore where cognome='Otsuka'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Mima Kirigoe (voce)', (select id from film where titolo='Perfect Blue'), (select id from attore where cognome='Iwao'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Rumi (voce)', (select id from film where titolo='Perfect Blue'), (select id from attore where cognome='Matsumoto'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Shoya Ishida (voce)', (select id from film where titolo='A Silent Voice'), (select id from attore where cognome='Irino (A Silent Voice)'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Shoko Nishimiya (voce)', (select id from film where titolo='A Silent Voice'), (select id from attore where cognome='Hayami'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Hodaka Morishima (voce)', (select id from film where titolo='Weathering with You'), (select id from attore where cognome='Daigo'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Hina Amano (voce)', (select id from film where titolo='Weathering with You'), (select id from attore where cognome='Mori'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Sota Munakata (voce)', (select id from film where titolo='Suzume'), (select id from attore where cognome='Matsumura'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Suzume Iwato (voce)', (select id from film where titolo='Suzume'), (select id from attore where cognome='Hara'));

-- Altri
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Vito Corleone', (select id from film where titolo='Il Padrino'), (select id from attore where cognome='Brando'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Michael Corleone', (select id from film where titolo='Il Padrino'), (select id from attore where cognome='Pacino'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Vito Corleone (giovane)', (select id from film where titolo='Il Padrino - Parte II'), (select id from attore where cognome='De Niro'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Cooper', (select id from film where titolo='Interstellar'), (select id from attore where cognome='McConaughey'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Frodo Baggins', (select id from film where titolo='Il Signore degli Anelli - La Compagnia dell Anello'), (select id from attore where cognome='Wood'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Neo', (select id from film where titolo='Matrix'), (select id from attore where cognome='Reeves'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Forrest Gump', (select id from film where titolo='Forrest Gump'), (select id from attore where cognome='Hanks'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Ki-taek', (select id from film where titolo='Parasite'), (select id from attore where cognome='Song'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Maximus', (select id from film where titolo='Gladiatore'), (select id from attore where cognome='Crowe'));
insert into interpretazione (id, personaggio, film_id, attore_id) values (nextval('interpretazione_seq'), 'Arthur Fleck', (select id from film where titolo='Joker'), (select id from attore where cognome='Phoenix'));


-- ==========================================
-- FILM_FESTIVALS (Link tra decine di film e festival)
-- ==========================================
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='La La Land' and fest.nome='Venezia Classic';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='La La Land' and fest.nome='Musical On Screen Fest';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='The Greatest Showman' and fest.nome='Musical On Screen Fest';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Chicago' and fest.nome='Musical On Screen Fest';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Orgoglio e pregiudizio' and fest.nome='BFI London Film Festival';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Your Name.' and fest.nome='Tokyo on Fest!';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Your Name.' and fest.nome='Anime Expo Cinema';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Akira' and fest.nome='Tokyo on Fest!';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Principessa Mononoke' and fest.nome='Annecy Festival';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Parasite' and fest.nome='Cannes Film Festival';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Pulp Fiction' and fest.nome='Cannes Film Festival';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Il Padrino' and fest.nome='Venezia Classic';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Inception' and fest.nome='Sundance Film Festival';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Oppenheimer' and fest.nome='Festival del Cinema di Roma';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Barbie' and fest.nome='Tribeca Film Festival';
-- ==========================================
-- FILM_FESTIVALS (Partecipazioni ai festival)
-- ==========================================
-- Animazione ai festival specializzati
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Il castello errante di Howl' and fest.nome='Annecy Festival';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Ghost in the Shell' and fest.nome='Tokyo on Fest!';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Perfect Blue' and fest.nome='Sitges Film Festival';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='A Silent Voice' and fest.nome='Anime Expo Cinema';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Weathering with You' and fest.nome='Tokyo on Fest!';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Suzume' and fest.nome='Berlinale';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Spider-Man: Across the Spider-Verse' and fest.nome='Annecy Festival';

-- Musical e grandi classici
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Les Misérables' and fest.nome='Musical On Screen Fest';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Moulin Rouge!' and fest.nome='Cannes Film Festival';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Mamma Mia!' and fest.nome='Locarno Film Festival';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='The Sound of Music' and fest.nome='Venezia Classic';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Grease' and fest.nome='Tribeca Film Festival';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='West Side Story' and fest.nome='Musical On Screen Fest';

-- Autore, Drama e Blockbuster
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Espiazione' and fest.nome='Venezia Classic';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Chiamami col tuo nome' and fest.nome='Sundance Film Festival';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Ritratto della giovane in fiamme' and fest.nome='Cannes Film Festival';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Il Padrino - Parte II' and fest.nome='Venezia Classic';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Fight Club' and fest.nome='Sitges Film Festival';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Matrix' and fest.nome='Locarno Film Festival';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Blade Runner 2049' and fest.nome='TIFF';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Dune - Parte Uno' and fest.nome='Venezia Classic';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Mad Max: Fury Road' and fest.nome='Cannes Film Festival';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Joker' and fest.nome='Venezia Classic';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Titanic' and fest.nome='BFI London Film Festival';
insert into film_festivals (film_id, festivals_id) select f.id, fest.id from film f, festival fest where f.titolo='Il Signore degli Anelli - La Compagnia dell Anello' and fest.nome='Grande Venezuela Film';


-- ==========================================
-- PROIEZIONE (Varie date)
-- ==========================================
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-10-02', '20:30:00', 'SCHEDULED', 
    (select id from festival where nome='Festival del Cinema di Roma'), 
    (select id from film where titolo='Oppenheimer'), 
    (select id from sala where nome='Sala Grande'));

insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-11-02', '21:00:00', 'SCHEDULED', 
    (select id from festival where nome='Musical On Screen Fest'), 
    (select id from film where titolo='La La Land'), 
    (select id from sala where nome='Sala IMAX'));

insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-05-14', '19:00:00', 'SCHEDULED', 
    (select id from festival where nome='Cannes Film Festival'), 
    (select id from film where titolo='Pulp Fiction'), 
    (select id from sala where nome='Sala VIP'));

insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-07-02', '16:30:00', 'SCHEDULED', 
    (select id from festival where nome='Anime Expo Cinema'), 
    (select id from film where titolo='Your Name.'), 
    (select id from sala where nome='Sala Blu'));

insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-07-03', '18:00:00', 'SCHEDULED', 
    (select id from festival where nome='Anime Expo Cinema'), 
    (select id from film where titolo='Akira'), 
    (select id from sala where nome='Sala 3D'));

insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-10-08', '21:00:00', 'SCHEDULED', 
    (select id from festival where nome='BFI London Film Festival'), 
    (select id from film where titolo='Orgoglio e pregiudizio'), 
    (select id from sala where nome='Sala Storica'));

-- ==========================================
-- PROIEZIONE
-- ==========================================
-- Animazione in proiezione
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-06-10', '14:00:00', 'SCHEDULED', (select id from festival where nome='Annecy Festival'), (select id from film where titolo='Il castello errante di Howl'), (select id from sala where nome='Sala Verde'));
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-06-11', '16:30:00', 'SCHEDULED', (select id from festival where nome='Annecy Festival'), (select id from film where titolo='Principessa Mononoke'), (select id from sala where nome='Sala IMAX'));
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-07-04', '22:00:00', 'SCHEDULED', (select id from festival where nome='Anime Expo Cinema'), (select id from film where titolo='Ghost in the Shell'), (select id from sala where nome='Sala Rossa'));
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-05-15', '11:00:00', 'SCHEDULED', (select id from festival where nome='Tokyo on Fest!'), (select id from film where titolo='Weathering with You'), (select id from sala where nome='Sala Diamante'));
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-05-16', '18:00:00', 'SCHEDULED', (select id from festival where nome='Tokyo on Fest!'), (select id from film where titolo='Suzume'), (select id from sala where nome='Sala Grande'));
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-10-12', '23:30:00', 'SCHEDULED', (select id from festival where nome='Sitges Film Festival'), (select id from film where titolo='Perfect Blue'), (select id from sala where nome='Sala Hitchcock'));

-- Musical in proiezione
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-11-03', '20:00:00', 'SCHEDULED', (select id from festival where nome='Musical On Screen Fest'), (select id from film where titolo='Les Misérables'), (select id from sala where nome='Sala Atmos'));
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-11-04', '21:30:00', 'SCHEDULED', (select id from festival where nome='Musical On Screen Fest'), (select id from film where titolo='West Side Story'), (select id from sala where nome='Sala IMAX'));
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-08-10', '21:00:00', 'SCHEDULED', (select id from festival where nome='Locarno Film Festival'), (select id from film where titolo='Mamma Mia!'), (select id from sala where nome='Sala Estiva'));
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-09-05', '16:00:00', 'SCHEDULED', (select id from festival where nome='Venezia Classic'), (select id from film where titolo='The Sound of Music'), (select id from sala where nome='Sala Storica'));

-- Drama, Thriller e Classici
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-05-18', '21:00:00', 'SCHEDULED', (select id from festival where nome='Cannes Film Festival'), (select id from film where titolo='Ritratto della giovane in fiamme'), (select id from sala where nome='Sala Lumiere')); --(Assumendo sia mappata su una sala simile, userò Sala Lux)
update proiezione set sala_id = (select id from sala where nome='Sala Lux') where id = currval('proiezione_seq');
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-01-25', '18:30:00', 'COMPLETED', (select id from festival where nome='Sundance Film Festival'), (select id from film where titolo='Chiamami col tuo nome'), (select id from sala where nome='Sala Indie'));
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-09-08', '19:00:00', 'SCHEDULED', (select id from festival where nome='Venezia Classic'), (select id from film where titolo='Il Padrino - Parte II'), (select id from sala where nome='Sala Leone'));
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-10-15', '22:00:00', 'SCHEDULED', (select id from festival where nome='Sitges Film Festival'), (select id from film where titolo='Fight Club'), (select id from sala where nome='Sala Tarantino'));
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-09-12', '20:00:00', 'SCHEDULED', (select id from festival where nome='TIFF'), (select id from film where titolo='Blade Runner 2049'), (select id from sala where nome='Sala Metropolis'));
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-05-20', '21:00:00', 'SCHEDULED', (select id from festival where nome='Cannes Film Festival'), (select id from film where titolo='Parasite'), (select id from sala where nome='Sala Oro'));
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-05-21', '22:30:00', 'SCHEDULED', (select id from festival where nome='Cannes Film Festival'), (select id from film where titolo='Mad Max: Fury Road'), (select id from sala where nome='Sala 3D'));
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2025-12-15', '17:00:00', 'COMPLETED', (select id from festival where nome='Grande Venezuela Film'), (select id from film where titolo='Il Signore degli Anelli - La Compagnia dell Anello'), (select id from sala where nome='Sala Grande'));
insert into proiezione (id, data, ora, stato, festival_id, film_id, sala_id) values (nextval('proiezione_seq'), '2026-02-20', '19:45:00', 'CANCELLED', (select id from festival where nome='Berlinale'), (select id from film where titolo='Suzume'), (select id from sala where nome='Sala Gialla'));

-- ==========================================
-- RECENSIONE 
-- ==========================================
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 9, 'Capolavoro assoluto', now(), 
    (select id from film where titolo='Inception'), (select id from utente where username='mario'));

insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'La colonna sonora è magia pura, mi ha fatto piangere.', now(), 
    (select id from film where titolo='La La Land'), (select id from utente where username='giulia_cinefila'));

insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'Animazione perfetta e colonna sonora indimenticabile.', now(), 
    (select id from film where titolo='Your Name.'), (select id from utente where username='luca_99'));

insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 8, 'Un classico senza tempo, regia meravigliosa.', now(), 
    (select id from film where titolo='Orgoglio e pregiudizio'), (select id from utente where username='sara_movie'));

insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'Una pietra miliare del cinema cyber-punk.', now(), 
    (select id from film where titolo='Akira'), (select id from utente where username='matteo_88'));

insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 9, 'Energia pura, le coreografie sono pazzesche.', now(), 
    (select id from film where titolo='Chicago'), (select id from utente where username='anna_bianchi'));

insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'Immenso. Non ci sono altre parole.', now(), 
    (select id from film where titolo='Il Padrino'), (select id from utente where username='roberto_g'));

    -- ==========================================
-- RECENSIONE (Nuove recensioni sparse)
-- ==========================================
-- Recensioni Anime
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'Visivamente sbalorditivo, una storia d amore che trascende il tempo.', now(), (select id from film where titolo='Your Name.'), (select id from utente where username='giulia_cinefila'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 9, 'Miyazaki non delude mai. Una fiaba antimilitarista stupenda.', now(), (select id from film where titolo='Il castello errante di Howl'), (select id from utente where username='marco_rossi'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'L animazione definitiva. Epico ed ecologista.', now(), (select id from film where titolo='Principessa Mononoke'), (select id from utente where username='elena_verdi'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 9, 'Un thriller psicologico che ti entra nella testa. Satoshi Kon era un genio.', now(), (select id from film where titolo='Perfect Blue'), (select id from utente where username='davide_f'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'Ho pianto dall inizio alla fine. Tratta il tema del bullismo in modo perfetto.', now(), (select id from film where titolo='A Silent Voice'), (select id from utente where username='chiara_l'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 8, 'Molto bello, Shinkai si riconferma un maestro dei cieli.', now(), (select id from film where titolo='Suzume'), (select id from utente where username='luigi'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'Spider-Verse ha riscritto le regole dell animazione occidentale.', now(), (select id from film where titolo='Spider-Man: Across the Spider-Verse'), (select id from utente where username='matteo_88'));

-- Recensioni Musical
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 8, 'Incredibile regia di Chazelle. Gosling e Stone fantastici.', now(), (select id from film where titolo='La La Land'), (select id from utente where username='andrea_b'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 7, 'Intrattenimento puro, canzoni orecchiabili ma trama un po semplice.', now(), (select id from film where titolo='The Greatest Showman'), (select id from utente where username='valeria_m'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 9, 'Il cast canta dal vivo, una potenza emotiva devastante.', now(), (select id from film where titolo='Les Misérables'), (select id from utente where username='francesca_n'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'Il miglior jukebox musical di sempre! Impossibile non cantare.', now(), (select id from film where titolo='Mamma Mia!'), (select id from utente where username='sara_movie'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 8, 'Visivamente eccentrico, Baz Luhrmann al suo meglio.', now(), (select id from film where titolo='Moulin Rouge!'), (select id from utente where username='giovanni_p'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 9, 'Un rifacimento degno dell originale, Spielberg non sbaglia.', now(), (select id from film where titolo='West Side Story'), (select id from utente where username='silvia_c'));

-- Recensioni Drama & Romance
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'La scena della mano di Darcy mi fa sempre venire i brividi.', now(), (select id from film where titolo='Orgoglio e pregiudizio'), (select id from utente where username='anna_bianchi'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 9, 'Un capolavoro sulla pittura, lo sguardo e l amore represso.', now(), (select id from film where titolo='Ritratto della giovane in fiamme'), (select id from utente where username='giulia_cinefila'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 9, 'La colonna sonora di Sufjan Stevens e l estate italiana. Perfetto.', now(), (select id from film where titolo='Chiamami col tuo nome'), (select id from utente where username='luca_99'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'Il piano sequenza sulla spiaggia di Dunkirk è storia del cinema.', now(), (select id from film where titolo='Espiazione'), (select id from utente where username='roberto_g'));

-- Recensioni Cult & Blockbuster
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'Nolan reinventa il tempo e lo spazio. Hans Zimmer strepitoso.', now(), (select id from film where titolo='Interstellar'), (select id from utente where username='matteo_88'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'La prima regola del Fight Club è...', now(), (select id from film where titolo='Fight Club'), (select id from utente where username='davide_f'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 9, 'Un sequel che regge il confronto con l originale. Villeneuve è una garanzia.', now(), (select id from film where titolo='Blade Runner 2049'), (select id from utente where username='marco_rossi'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'Vince meritatamente la Palma d Oro. Una critica sociale perfetta.', now(), (select id from film where titolo='Parasite'), (select id from utente where username='elena_verdi'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 9, 'Un giro sulle montagne russe in mezzo al deserto. Azione pura.', now(), (select id from film where titolo='Mad Max: Fury Road'), (select id from utente where username='andrea_b'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'Il Joker di Joaquin Phoenix è disturbante e magnetico. Oscar strameritato.', now(), (select id from film where titolo='Joker'), (select id from utente where username='silvia_c'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 7, 'Bello, ma molto lungo. Barbie mi ha fatto ridere molto di più.', now(), (select id from film where titolo='Oppenheimer'), (select id from utente where username='sara_movie'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 8, 'Divertente, irriverente e con un ottimo messaggio.', now(), (select id from film where titolo='Barbie'), (select id from utente where username='francesca_n'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'Il finale più epico della storia dei cinecomic.', now(), (select id from film where titolo='Avengers: Endgame'), (select id from utente where username='luigi'));
insert into recensione (id, voto, testo, data, film_id, utente_id) values (nextval('recensione_seq'), 10, 'Al mio segnale, scatenate l inferno. Un pezzo di storia.', now(), (select id from film where titolo='Gladiatore'), (select id from utente where username='giovanni_p'));
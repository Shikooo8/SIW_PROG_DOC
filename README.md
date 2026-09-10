# Sistemi Informativi sul Web

Progetto dato dal docente per il corso di Sistemi Informativi sul Web dell'anno accademico 2025/2026

## Descrizione Progetto

Un sistema per la gestione di festival cinematografici


### Funzionalità pubbliche (implementate!)
- visualizzazione dell’elenco dei festival
- visualizzazione del dettaglio di un festival
- visualizzazione dei film partecipanti a un festival
- visualizzazione del programma delle proiezioni (Implementato con REACT!!)
- visualizzazione del dettaglio di un film
- visualizzazione dei dati del regista di un film
- visualizzazione delle recensioni di un film
- Il dettaglio di un festival deve permettere di accedere ai film e alle proiezioni associate.
- Il dettaglio di un film deve mostrare almeno le informazioni sul film, il regista, i festival ai quali partecipa, le eventuali proiezioni e le recensioni.

### Funzionalità utenti registrati (implementate!!)
- inserimento di al massimo una sola recensione per utente relativa a ciascun film
- modifica di una propria recensione
- eliminazione di una propria recensione

### Funzionalità riservate all’amministratore
- creazione e modifica di un festival               (funziona! )
- inserimento e modifica di un film                 (funziona!)
- inserimento e modifica di un regista              (funziona !)
- associazione di un film a un festival             (funziona solo su modifica festival)
- inserimento e modifica di una sala                (funziona !)
- programmazione di una proiezione                  (funziona !)
- modifica o cancellazione di una proiezione        (funziona !)
- eliminazione di un film da un festival (ancora no)

Il sistema deve verificare la consistenza delle operazioni effettuate. Ad esempio, non deve essere possibile
programmare due proiezioni nella stessa sala nello stesso intervallo temporale.


## Errori trovati

- Alla creazione di un festival, i film scelti non vengono associati
- Non puoi salvare le recensioni, CRASH, ma puoi cancellarle.
- Quando si inseriscono le cose il seq number è a caso
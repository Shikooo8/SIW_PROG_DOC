document.querySelectorAll(".picker").forEach(avviaPicker);

function avviaPicker(picker) {
    const url = picker.dataset.url;
    const multiplo = picker.dataset.multiple === "true";       // true = festival, false = attore
    const campoRicerca = picker.querySelector(".picker-search");
    const lista = picker.querySelector(".picker-list");
    const badge = picker.querySelector(".picker-selected");    // solo selettore multiplo
    const campoId = picker.querySelector(".picker-id");        // solo selettore singolo
    let numeroRicerca = 0;

    campoRicerca.addEventListener("focus", cerca);
    campoRicerca.addEventListener("input", function () {
        if (!multiplo) campoId.value = "";    // se riscrivi, la scelta precedente non vale più
        cerca();
    });
    // Invio nella barra non deve salvare il form
    campoRicerca.addEventListener("keydown", function (e) {
        if (e.key === "Enter") e.preventDefault();
    });
    // click fuori: chiude la lista
    document.addEventListener("click", function (e) {
        if (!picker.contains(e.target)) lista.hidden = true;
    });
    // click sulla "x" di un badge: lo toglie
    if (badge) {
        badge.addEventListener("click", function (e) {
            if (e.target.classList.contains("chip-x")) e.target.closest(".badge").remove();
        });
    }

    async function cerca() {
        numeroRicerca++;
        const questaRicerca = numeroRicerca;
        const risposta = await fetch(url + "?q=" + encodeURIComponent(campoRicerca.value));
        const opzioni = await risposta.json();
        if (questaRicerca !== numeroRicerca) return;   // è arrivata una ricerca più recente: ignora questa
        mostraLista(opzioni);
    }

    function mostraLista(opzioni) {
        lista.innerHTML = "";
        const giaScelti = idScelti();
        const visibili = opzioni.filter(function (o) { return !giaScelti.includes(String(o.id)); });

        if (visibili.length === 0) {
            const vuota = document.createElement("li");
            vuota.className = "picker-empty";
            vuota.textContent = "Nessun risultato";
            lista.appendChild(vuota);
        }
        visibili.forEach(function (o) {
            const riga = document.createElement("li");
            riga.textContent = o.label;
            riga.addEventListener("click", function () { scegli(o); });
            lista.appendChild(riga);
        });
        lista.hidden = false;
    }

    // id dei festival già scelti (così non compaiono di nuovo nella lista)
    function idScelti() {
        if (!multiplo) return [];
        const campi = picker.querySelectorAll('input[name="' + picker.dataset.name + '"]');
        return Array.from(campi).map(function (c) { return c.value; });
    }

    function scegli(opzione) {
        if (multiplo) {
            aggiungiBadge(opzione);
            campoRicerca.value = "";
        } else {
            campoId.value = opzione.id;
            campoRicerca.value = opzione.label;
        }
        lista.hidden = true;
    }

    function aggiungiBadge(opzione) {
        const nuovo = document.createElement("span");
        nuovo.className = "badge";
        nuovo.append(opzione.label + " ");

        const x = document.createElement("button");
        x.type = "button";
        x.className = "chip-x";
        x.title = "Togli";
        x.textContent = "×";

        const nascosto = document.createElement("input");   // è questo che viene inviato al server
        nascosto.type = "hidden";
        nascosto.name = picker.dataset.name;
        nascosto.value = opzione.id;

        nuovo.append(x, nascosto);
        badge.appendChild(nuovo);
    }


}

// casella "Nuovo attore": mostra i campi del nuovo attore oppure la ricerca
document.querySelectorAll(".nuovo-attore-check").forEach(function (casella) {
  const riga = casella.closest(".review");
  const ricerca = riga.querySelector(".picker");
  const campiNuovoAttore = riga.querySelector(".nuovo-attore-box");

  casella.addEventListener("change", function () {
    ricerca.hidden = casella.checked;
    campiNuovoAttore.hidden = !casella.checked;
    if (casella.checked) {
      // se avevi scelto un attore dall'elenco, la scelta viene annullata
      riga.querySelector(".picker-id").value = "";
      riga.querySelector(".picker-search").value = "";
    }
  });
});

// input file: mostra il nome del file scelto
document.querySelectorAll(".file-input").forEach(function (blocco) {
  const campo = blocco.querySelector('input[type="file"]');
  const nome = blocco.querySelector(".file-nome");

  campo.addEventListener("change", function () {
    if (campo.files.length > 0) {
      nome.textContent = campo.files[0].name;
    } else {
      nome.textContent = "Nessun file selezionato";
    }
  });
});
const MESI = ["GEN","FEB","MAR","APR","MAG","GIU","LUG","AGO","SET","OTT","NOV","DIC"];

export function formatRangeData(dataInizio: string, dataFine: string): string {
  const inizio = new Date(dataInizio);
  const fine = new Date(dataFine);
  const giornoInizio = inizio.getDate();
  const giornoFine = fine.getDate();
  const meseFine = MESI[fine.getMonth()];

  // Se stesso mese: "28 — 7 SET" altrimenti "28 AGO — 7 SET"
  if (inizio.getMonth() === fine.getMonth()) {
    return `${giornoInizio} — ${giornoFine} ${meseFine}`;
  }
  const meseInizio = MESI[inizio.getMonth()];
  return `${giornoInizio} ${meseInizio} — ${giornoFine} ${meseFine}`;
}
export interface Festival {
  id: number;
  nome: string;
  anno: number;
  città: string;
  dataInizio: string;   // "YYYY-MM-DD"
  dataFine: string;     // "YYYY-MM-DD"
  descrizione?: string;
}
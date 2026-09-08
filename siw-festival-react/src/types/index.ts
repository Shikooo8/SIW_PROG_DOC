
export interface Regista {
  id: number;
  nome: string;
  dateOfBirth: string;   // "YYYY-MM-DD"
}

export interface Film {
  id: number;
  titolo: string;
  anno: number;
  urlImage?: string;
  director?: Regista;
}

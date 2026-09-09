export interface Recensione {
  id: number;
  testo: string;
  voto: number;
  data: string;
  autore: string;
  autoreId: number;
  filmId: number;
  filmTitolo: string;
}

export interface Me {
  autenticato: boolean;
  username?: string;
}
import api from "./api";
import type { Recensione } from "../types";

export const getRecensioni = (filmId: number) =>
  api.get<Recensione[]>(`/film/${filmId}/recensioni`).then(r => r.data);

export const creaRecensione = (filmId: number, testo: string, voto: number) =>
  api.post<Recensione>(`/film/${filmId}/recensione`, { testo, voto }).then(r => r.data);

export const modificaRecensione = (id: number, testo: string, voto: number) =>
  api.put<Recensione>(`/recensione/${id}`, { testo, voto }).then(r => r.data);

export const eliminaRecensione = (id: number) =>
  api.delete(`/recensione/${id}`);
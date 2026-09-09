import api from "./api.ts";
import { Festival } from "../types";

export async function getFestivals(): Promise<Festival[]> {
  const response = await api.get<Festival[]>("/festivals");
  return response.data;
}

// Utile per l'ordinamento: i più recenti/imminenti per primi
export function ordinaPerData(festivals: Festival[]): Festival[] {
  return [...festivals].sort(
    (a, b) => new Date(b.dataInizio).getTime() - new Date(a.dataInizio).getTime()
  );
}
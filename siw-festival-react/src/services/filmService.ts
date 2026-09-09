// src/services/filmService.ts
import api from './api';
import type { ProiezioneDTO } from '../types';

export const getProiezioniByFilm = async (filmId: string): Promise<ProiezioneDTO[]> => {
    try {
        const response = await api.get<ProiezioneDTO[]>(`/films/${filmId}/screenings`);
        return response.data;
    } catch (error) {
        console.error("Errore durante il recupero delle proiezioni:", error);
        return [];
    }
};
// src/services/festivalService.ts
import api from './api';
import type { ProiezioneDTO } from '../types';

export const getProiezioniByFestival = async (festivalId: string): Promise<ProiezioneDTO[]> => {
    try {
        // La chiamata GET all'endpoint richiesto dal professore
        const response = await api.get<ProiezioneDTO[]>(`/festivals/${festivalId}/screenings`);
        return response.data;
    } catch (error) {
        console.error("Errore durante il recupero delle proiezioni:", error);
        return [];
    }
};
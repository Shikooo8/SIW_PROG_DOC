import api from './api';
import type { ProiezioneDTO } from '../types';

export const getProiezioniByFestival = async (
    festivalId: string,
    data?: string
): Promise<ProiezioneDTO[]> => {
    try {
        const response = await api.get<ProiezioneDTO[]>(
            `/festivals/${festivalId}/screenings`,
            { params: data ? { data } : {} }
        );
        return response.data;
    } catch (error) {
        console.error("Errore durante il recupero delle proiezioni:", error);
        return [];
    }
};
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import type { ProiezioneDTO } from '../types';
import { getProiezioniByFilm } from '../services/filmService';
import Layout from './Layout';
import ProiezioneCard from './ProiezioneCard.tsx';

export default function ProgrammazioneFilm() {
    const { id } = useParams<{ id: string }>();
    const [proiezioni, setProiezioni] = useState<ProiezioneDTO[]>([]);
    const [loading, setLoading] = useState<boolean>(true);

    useEffect(() => {
        if (id) {
            getProiezioniByFilm(id)
                .then(setProiezioni)
                .finally(() => setLoading(false));
        }
    }, [id]);

    return (
        <Layout>
            <div className="page-header">
                <div>
                    <h1>Programmazione</h1>
                    <p className="page-subtitle">Tutte le proiezioni del film</p>
                </div>
                <a className="btn btn-secondary btn-sm" href={`/film/${id}`}>
                    ← Torna al film
                </a>
            </div>

            {loading ? (
                <p className="empty">Caricamento programmazione...</p>
            ) : proiezioni.length === 0 ? (
                <p className="empty">Nessuna proiezione programmata per questo film.</p>
            ) : (
                <ul className="screening-list">
                    {proiezioni.map((p) => (
                        <ProiezioneCard key={p.id} proiezione={p} titolo={p.festivalNome} />
                    ))}
                </ul>
            )}
        </Layout>
    );
}
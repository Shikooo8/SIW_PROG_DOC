// src/components/ProgrammazioneFilm.tsx
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import type { ProiezioneDTO } from '../types';
import { getProiezioniByFilm } from '../services/filmService';

function statusClass(stato: string) {
    if (stato === 'SCHEDULED') return 'status-badge status-scheduled';
    if (stato === 'CANCELLED') return 'status-badge status-cancelled';
    return 'status-badge status-default';
}

export default function ProgrammazioneFilm() {
    const { id } = useParams<{ id: string }>();
    const [proiezioni, setProiezioni] = useState<ProiezioneDTO[]>([]);
    const [loading, setLoading] = useState<boolean>(true);

    useEffect(() => {
        if (id) {
            getProiezioniByFilm(id).then(data => {
                setProiezioni(data);
                setLoading(false);
            });
        }
    }, [id]);

    if (loading) {
        return <p className="loading-message">Caricamento programmazione...</p>;
    }

    return (
        <div>
            <header className="react-header">
                <h1>Programmazione Film</h1>
            </header>

            <div className="page-container">
                <div className="back-link-wrapper">
                    <a href={`/film/${id}`} className="nav-button">
                        Torna al film
                    </a>
                </div>

                {proiezioni.length === 0 ? (
                    <p className="empty-message">
                        Nessuna proiezione programmata per questo film.
                    </p>
                ) : (
                    <div className="screening-grid">
                        {proiezioni.map((p) => (
                            <div key={p.id} className="screening-card">
                                <p className="screening-film-title">{p.festivalNome}</p>
                                <p className="screening-sala">{p.salaNome}</p>
                                <p className="screening-info">
                                    <strong>Data:</strong> {p.data}
                                </p>
                                <p className="screening-info">
                                    <strong>Ora:</strong> {p.ora}
                                </p>
                                <span className={statusClass(p.stato)}>{p.stato}</span>
                            </div>
                        ))}
                    </div>
                )}
            </div>
        </div>
    );
}
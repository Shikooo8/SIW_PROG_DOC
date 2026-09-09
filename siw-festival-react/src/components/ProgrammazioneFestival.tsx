// src/components/ProgrammazioneFestival.tsx
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import type { ProiezioneDTO } from '../types';
import { getProiezioniByFestival } from '../services/festivalService';

function statusClass(stato: string) {
    if (stato === 'SCHEDULED') return 'status-badge status-scheduled';
    if (stato === 'CANCELLED') return 'status-badge status-cancelled';
    return 'status-badge status-default';
}

export default function ProgrammazioneFestival() {
    const { id } = useParams<{ id: string }>();
    const [proiezioni, setProiezioni] = useState<ProiezioneDTO[]>([]);
    const [loading, setLoading] = useState<boolean>(true);

    useEffect(() => {
        if (id) {
            getProiezioniByFestival(id).then(data => {
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
                <h1>Programmazione Festival</h1>
            </header>

            <div className="page-container">
                <div className="back-link-wrapper">
                    <a href={`/festival/${id}`} className="nav-button">
                        Torna al dettaglio
                    </a>
                </div>

                {proiezioni.length === 0 ? (
                    <p className="empty-message">
                        Nessuna proiezione programmata per questo festival.
                    </p>
                ) : (
                    <div className="screening-grid">
                        {proiezioni.map((p) => (
                            <div key={p.id} className="screening-card">
                                <p className="screening-film-title">{p.filmTitolo}</p>
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
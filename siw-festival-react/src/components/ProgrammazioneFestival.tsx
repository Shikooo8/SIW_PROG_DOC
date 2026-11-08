import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import type { ProiezioneDTO } from '../types';
import { getProiezioniByFestival } from '../services/festivalService';
import Layout from './Layout';
import ProiezioneCard from './ProiezioneCard.tsx';

export default function ProgrammazioneFestival() {
    const { id } = useParams<{ id: string }>();
    const [proiezioni, setProiezioni] = useState<ProiezioneDTO[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [data, setData] = useState<string>(''); // "YYYY-MM-DD", '' = nessun filtro

    useEffect(() => {
        if (id) {
            setLoading(true);
            getProiezioniByFestival(id, data)
                .then(setProiezioni)
                .finally(() => setLoading(false));
        }
    }, [id, data]);

    return (
        <Layout>
            <div className="page-header">
                <div>
                    <h1>Programmazione</h1>
                    <p className="page-subtitle">Tutte le proiezioni del festival</p>
                </div>
                <a className="btn btn-secondary btn-sm" href={`/festival/${id}`}>
                    ← Torna al festival
                </a>
            </div>

            <div className="filter-bar">
                <label htmlFor="filtro-data">Cerca per data: </label>
                <input
                    id="filtro-data"
                    type="date"
                    value={data}
                    onChange={(e) => setData(e.target.value)}
                />
                {data && (
                    <button className="btn btn-secondary btn-sm" onClick={() => setData('')}>
                        Mostra tutte
                    </button>
                )}
            </div>

            {loading ? (
                <p className="empty">Caricamento programmazione...</p>
            ) : proiezioni.length === 0 ? (
                <p className="empty">
                    {data
                        ? 'Nessuna proiezione in questa data.'
                        : 'Nessuna proiezione programmata per questo festival.'}
                </p>
            ) : (
                <ul className="screening-list">
                    {proiezioni.map((p) => (
                        <ProiezioneCard key={p.id} proiezione={p} titolo={p.filmTitolo} />
                    ))}
                </ul>
            )}
        </Layout>
    );
}
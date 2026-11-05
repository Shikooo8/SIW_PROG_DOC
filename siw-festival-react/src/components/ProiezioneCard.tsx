import type { ProiezioneDTO } from '../types';

interface Props {
    proiezione: ProiezioneDTO;
    titolo: string; // il film (pagina festival) o il festival (pagina film)
}

const STATI: Record<string, string> = {
    SCHEDULED: 'Programmata',
    COMPLETED: 'Conclusa',
    CANCELLED: 'Annullata',
};

export default function ProiezioneCard({ proiezione: p, titolo }: Props) {
    // "2026-11-05" -> "05/11/2026" (formato italiano, spezzando la stringa: niente problemi di fuso)
    const data = p.data.split('-').reverse().join('/');
    const annullata = p.stato === 'CANCELLED';

    return (
        <li className={`screening ${annullata ? 'screening-cancelled' : ''}`}>
            <span className="screening-when">
                {data} · {p.ora.slice(0, 5)}
            </span>
            <span className="screening-what">
                {titolo}
                <small>{p.salaNome}</small>
            </span>
            <span className={`badge badge-${p.stato.toLowerCase()}`}>
                {STATI[p.stato] ?? p.stato}
            </span>
        </li>
    );
}
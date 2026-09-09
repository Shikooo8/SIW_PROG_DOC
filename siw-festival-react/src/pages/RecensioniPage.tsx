import { useEffect, useState } from "react";
import api from "../services/api";
import {
  getRecensioni,
  creaRecensione,
  modificaRecensione,
  eliminaRecensione,
} from "../services/recensioneService";
import type { Recensione, Me } from "../types";

interface Props {
  filmId: number;
}

export default function RecensioniPage({ filmId }: Props) {
  const [recensioni, setRecensioni] = useState<Recensione[]>([]);
  const [me, setMe] = useState<Me>({ autenticato: false });
  const [testo, setTesto] = useState("");
  const [voto, setVoto] = useState(10);
  const [editingId, setEditingId] = useState<number | null>(null);
  const [errore, setErrore] = useState<string | null>(null);

  const load = () => getRecensioni(filmId).then(setRecensioni);

  useEffect(() => {
    load();
    api.get<Me>("/utente/me").then(r => setMe(r.data));
  }, [filmId]);

  const giaRecensito = me.autenticato && recensioni.some(r => r.autore === me.username);

  const resetForm = () => {
    setTesto("");
    setVoto(10);
    setEditingId(null);
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setErrore(null);
    try {
      if (editingId) {
        await modificaRecensione(editingId, testo, voto);
      } else {
        await creaRecensione(filmId, testo, voto);
      }
      resetForm();
      load();
    } catch (err: any) {
      setErrore(err?.response?.data?.error ?? "Si è verificato un errore");
    }
  };

  const handleEdit = (r: Recensione) => {
    setEditingId(r.id);
    setTesto(r.testo);
    setVoto(r.voto);
  };

  const handleDelete = async (id: number) => {
    setErrore(null);
    try {
      await eliminaRecensione(id);
      load();
    } catch (err: any) {
      setErrore(err?.response?.data?.error ?? "Si è verificato un errore");
    }
  };

  return (
    <div>
      {errore && <p style={{ color: "red" }}>{errore}</p>}

      <ul style={{ listStyle: "none", padding: 0 }}>
        {recensioni.map(r => (
          <li key={r.id} style={{ borderBottom: "1px solid #eee", padding: "10px 0" }}>
            <strong>{r.autore}</strong> — voto: {r.voto}/10
            <p>{r.testo}</p>
            {me.username === r.autore && (
              <>
                <button onClick={() => handleEdit(r)}>Modifica</button>{" "}
                <button onClick={() => handleDelete(r.id)}>Elimina</button>
              </>
            )}
          </li>
        ))}
        {recensioni.length === 0 && <li>Nessuna recensione, sii il primo a lasciarne una.</li>}
      </ul>

      {me.autenticato && (!giaRecensito || editingId) && (
        <form onSubmit={handleSubmit} style={{ marginTop: 20 }}>
          <div>
            <textarea
              value={testo}
              onChange={e => setTesto(e.target.value)}
              placeholder="Scrivi la tua recensione..."
              required
              rows={4}
              style={{ width: "100%" }}
            />
          </div>
          <div>
            Voto:{" "}
            <select value={voto} onChange={e => setVoto(Number(e.target.value))}>
              {Array.from({ length: 10 }, (_, i) => i + 1).map(v => (
                <option key={v} value={v}>{v}</option>
              ))}
            </select>
          </div>
          <button type="submit">{editingId ? "Salva modifiche" : "Invia recensione"}</button>
          {editingId && (
            <button type="button" onClick={resetForm} style={{ marginLeft: 8 }}>
              Annulla
            </button>
          )}
        </form>
      )}

      {!me.autenticato && (
        <p>
          Effettua il <a href="/login">login</a> per lasciare una recensione.
        </p>
      )}
    </div>
  );
}
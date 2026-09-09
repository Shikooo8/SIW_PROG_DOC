import React from "react";
import { Festival } from "../types";
import { formatRangeData } from "../utils/formatDate.ts";

interface Props {
  festival: Festival;
}

export default function FestivalHero({ festival }: Props) {
  return (
    <section className="hero">
      <div className="hero-grid">
        <div>
          <div className="hero-eyebrow">
            <span className="hero-eyebrow__rule" />
            Edizione {festival.anno}
          </div>

          <h1 className="hero-title">{festival.nome}</h1>

          {festival.descrizione && (
            <p className="hero-desc">{festival.descrizione}</p>
          )}

          <div className="hero-tags">
            <span className="tag-outline">
              {formatRangeData(festival.dataInizio, festival.dataFine).toUpperCase()}
            </span>
            <span className="tag-gold">{festival.città.toUpperCase()}</span>
          </div>

          <div className="hero-actions">
            <a href={`/festival/${festival.id}`}>
              <button className="btn-primary">SCOPRI IL PROGRAMMA</button>
            </a>
            <a href="/festival">
              <button className="btn-secondary">TUTTI I FESTIVAL</button>
            </a>
          </div>
        </div>

        {/* Per ora nessuna immagine associata al festival: placeholder decorativo */}
        <div className="hero-media" style={{ backgroundColor: "#2b2620" }} />
      </div>
    </section>
  );
}
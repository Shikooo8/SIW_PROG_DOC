import React from "react";
import { Festival } from "../types";
import { formatRangeData } from "../utils/formatDate.ts";

interface Props {
  festival: Festival;
}

export default function FestivalCard({ festival }: Props) {
  return (
    <a href={`/festival/${festival.id}`} style={{ textDecoration: "none", color: "inherit" }}>
      <div className="festival-card">
        {/* Per ora nessuna immagine associata al festival: placeholder decorativo */}
        <div className="festival-card__poster" style={{ backgroundColor: "#2b2620" }}>
          <span className="festival-card__date">
            {formatRangeData(festival.dataInizio, festival.dataFine)}
          </span>
        </div>
        <div className="festival-card__title">{festival.nome}</div>
        <div className="festival-card__city">{festival.città}</div>
      </div>
    </a>
  );
}
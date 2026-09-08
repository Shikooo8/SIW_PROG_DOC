import React from "react";
import { Festival } from "../types";
import FestivalCard from "./FestivalCard";

interface Props {
  titolo: string;
  festivals: Festival[];
}

export default function FestivalCarousel({ titolo, festivals }: Props) {
  return (
    <section className="container">
      <div className="section-heading">
        <h2>{titolo}</h2>
        <div className="section-heading__rule" />
      </div>
      <div className="carousel">
        {festivals.map((f) => (
          <FestivalCard key={f.id} festival={f} />
        ))}
      </div>
    </section>
  );
}
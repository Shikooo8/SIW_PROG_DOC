import React, { useEffect, useState } from "react";
import Navbar from "../components/Navbar.tsx";
import FestivalHero from "../components/FestivalHero.tsx";
import FestivalCarousel from "../components/FestivalCarousel.tsx";
import { Festival } from "../types";
import { getFestivals, ordinaPerData } from "../services/festivalService.ts";
import "../styles/theme.css";

export default function HomePage() {
  const [festivals, setFestivals] = useState<Festival[]>([]);
  const [loading, setLoading] = useState(true);
  const [errore, setErrore] = useState<string | null>(null);

  useEffect(() => {
    getFestivals()
      .then((data) => setFestivals(ordinaPerData(data)))
      .catch(() => setErrore("Non è stato possibile caricare i festival. Riprova più tardi."))
      .finally(() => setLoading(false));
  }, []);

  if (loading) {
    return (
      <div>
        <Navbar />
        <div className="container" style={{ padding: "80px 0", textAlign: "center", color: "#8A8074" }}>
          Caricamento dei festival in corso…
        </div>
      </div>
    );
  }

  if (errore) {
    return (
      <div>
        <Navbar />
        <div className="container" style={{ padding: "80px 0", textAlign: "center", color: "#5B5347" }}>
          {errore}
        </div>
      </div>
    );
  }

  if (festivals.length === 0) {
    return (
      <div>
        <Navbar />
        <div className="container" style={{ padding: "80px 0", textAlign: "center", color: "#8A8074" }}>
          Nessun festival disponibile al momento.
        </div>
      </div>
    );
  }

  const [inEvidenza, ...altri] = festivals;

  return (
    <div>
      <Navbar />
      <div className="container">
        <FestivalHero festival={inEvidenza} />
      </div>
      {altri.length > 0 && (
        <FestivalCarousel titolo="Festival più recenti" festivals={altri} />
      )}
    </div>
  );
}
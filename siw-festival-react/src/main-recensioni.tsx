import React from "react";
import ReactDOM from "react-dom/client";
import RecensioniPage from "./pages/RecensioniPage.tsx";

const root = document.getElementById("recensioni-root");
if (root) {
  const filmId = Number(root.dataset.filmId);
  ReactDOM.createRoot(root).render(
    <React.StrictMode>
      <RecensioniPage filmId={filmId} />
    </React.StrictMode>
  );
}
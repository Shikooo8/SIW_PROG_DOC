import React from "react";

export default function Navbar() {
  return (
    <header className="navbar">
      <div className="navbar__brand">
        SIW <span>FESTIVAL</span>
      </div>
      <nav className="navbar__links">
        <a href="/" className="active">FESTIVAL</a>
        <a href="/film">FILM</a>
        <a href="/archivio">ARCHIVIO</a>
      </nav>
      <a href="/login">
        <button className="btn-login">ACCEDI</button>
      </a>
    </header>
  );
}
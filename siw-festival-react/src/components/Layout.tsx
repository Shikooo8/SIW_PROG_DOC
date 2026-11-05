import type { ReactNode } from 'react';

export default function Layout({ children }: { children: ReactNode }) {
    return (
        <>
            <header className="navbar">
                <div className="navbar-inner">
                    <a className="brand" href="/">SiwFestival</a>
                    <nav className="nav-links">
                        <a href="/festival">Festival</a>
                        <a href="/film">Film</a>
                        <a href="/login">Accedi</a>
                    </nav>
                </div>
            </header>

            <main>
                <div className="container">{children}</div>
            </main>

            <footer className="footer">
                <p>SiwFestival · Sistemi Informativi su Web</p>
            </footer>
        </>
    );
}
// In sviluppo i link verso le pagine Thymeleaf devono puntare a Spring (:8080).
// In produzione React è servito da Spring stesso, quindi basta il percorso relativo.
export const SPRING_URL = import.meta.env.DEV ? "https://siw-festival.onrender.com" : "";
// export const SPRING_URL = import.meta.env.DEV ? "http://localhost:8080" : "";
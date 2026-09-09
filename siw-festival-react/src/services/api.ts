import axios from "axios";

const api = axios.create({
  baseURL: "/api",
  withCredentials: true, // manda il cookie di sessione (JSESSIONID) e legge/scrive quello CSRF
});

export default api;
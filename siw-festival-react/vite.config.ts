import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";
import path from "path";

export default defineConfig({
  base: "/react/",
  plugins: [react()],
  build: {
    outDir: path.resolve(import.meta.dirname, "../siw-festival/src/main/resources/static/react"),
    emptyOutDir: true,
    rollupOptions: {
      input: path.resolve(__dirname, "index.html"),
    },
  },
});
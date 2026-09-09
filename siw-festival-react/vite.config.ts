import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";
import path from "path";

export default defineConfig({
  plugins: [react()],
  build: {
    outDir: path.resolve(__dirname, "../siw-festival/src/main/resources/static/react"),
    emptyOutDir: false,
    rollupOptions: {
      input: path.resolve(__dirname, "src/main-recensioni.tsx"),
      output: {
        entryFileNames: "recensioni.js",
        format: "es",
      },
    },
  },
});
// src/App.tsx
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ProgrammazioneFestival from './components/ProgrammazioneFestival';

function App() {
  return (
    <Router>
      <Routes>
        {/* Questa è la rotta chiamata dal pulsante in Thymeleaf */}
        <Route path="/react/festival/:id/programmazione" element={<ProgrammazioneFestival />} />
        
        {/* Qui in futuro potrai aggiungere la rotta per le recensioni */}
      </Routes>
    </Router>
  );
}

export default App;
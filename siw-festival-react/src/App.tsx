import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ProgrammazioneFestival from './components/ProgrammazioneFestival';
import ProgrammazioneFilm from './components/ProgrammazioneFilm';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/react/festival/:id/programmazione" element={<ProgrammazioneFestival />} />
        <Route path="/react/film/:id/programmazione" element={<ProgrammazioneFilm />} />
      </Routes>
    </Router>
  );
}

export default App;
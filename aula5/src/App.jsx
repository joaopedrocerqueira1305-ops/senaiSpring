import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';
import 'react-toastify/dist/ReactToastify.css'; // Importando estilos do react Toastify

import Footer from './components/Footer';
import Header from './components/Header';
import HomePage from './pages/HomePage';
import CadastroPage from './pages/CadastroPage';
import ListaUsuariosPage from './pages/ListaUsuariosPage';
import { ToastContainer } from 'react-toastify';

function App() {
  return (
    <Router>
      <Header />
      <main>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/cadastro" element={<CadastroPage />} />
          <Route path="/usuarios" element={<ListaUsuariosPage />} />
        </Routes>
      </main>
      <Footer />
      <ToastContainer position='top-right' autoClose={3000} />
    </Router>
  );
}

export default App;
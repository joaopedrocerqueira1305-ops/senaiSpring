import { BrowserRouter as Route, Router, Routes } from 'react-router-dom'
import './App.css'

import Footer from './components/Footer'
import Header from './components/Header'
import HomePage from './pages/HomePage'
import CadastroPage from './pages/CadastroPage'
import ListaUsuariosPage from './pages/ListaUsuariosPage'
import { ToastContainer } from 'react-toastify'

// Importando estilos do react Toastify
import 'react-toastify/dist/ReactToastify.css'

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

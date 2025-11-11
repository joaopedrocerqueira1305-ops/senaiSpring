import { Route, Routes } from 'react-router-dom'
import Footer from './components/Footer'
import Header from './components/Header'
import SobreNos from './pages/SobreNos'
import FaleConosco from './pages/FaleConosco'
import Home from "./pages/Home";
import Produtos from './pages/Produtos'

function App() {
  return (
    <div className='app'>
      <Header />
      <main className='container'>
        <Routes>
          <Route path='/' element={<Home />} /> 
          <Route path='/produtos' element={<Produtos />} />
          <Route path='/sobre-nos' element={<SobreNos />} />
          <Route path='/fale-conosco' element={<FaleConosco />} />
        </Routes>
      </main>
      <Footer />
    </div>
  )
}

export default App
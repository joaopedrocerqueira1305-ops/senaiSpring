import { Route, Routes } from 'react-router-dom'
import './App.css'
import Footer from './components/Footer'
import Header from './components/Header'
import SobreNos from './pages/SobreNosPage'
import HomePage from './pages/HomePage'
import FaleConosco from './pages/FaleConosco'

function App() {
  return (
    <>
      <Header />
      <main>
        <Routes>
          <Route path='/' element={<HomePage />} /> 
          <Route path='/sobre-nos' element={<SobreNos />} />
          <Route path='/fale-conosco' element={<FaleConosco />} />
        </Routes>
      </main>
      <Footer />
    </>
  )
}

export default App

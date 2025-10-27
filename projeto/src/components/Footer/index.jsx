// src\components\Footer\index.jsx

import './style.css';

function Footer() {
  return (
    <footer className='footer-container'>
      <p>&copy; {new Date().getFullYear()} Senai Dendezeiros </p>
      <p>Todos os direitos reservados</p>
    </footer>
  );
}

export default Footer;
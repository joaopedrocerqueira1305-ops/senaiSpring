// src\components\Footer\index.jsx

import './style.css';

export default function Footer() {
  return (
    <footer className="footer">
        <div className='footer__wrap'>
            <strong>Farmacia saude</strong>
            <br />
            CNPH - 00.000.000/0000
        </div>
        <div>
            Rua Exemplo, 123 - Salvador - Bahia
        </div>
        <div className='copy'>
            &copy; {new Date().getFullYear()} Todos os direitos reservados.
        </div>
    </footer>
  );
}
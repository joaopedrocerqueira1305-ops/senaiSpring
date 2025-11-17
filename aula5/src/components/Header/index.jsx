import { Link } from 'react-router-dom';
import './style.css'

export default function Header(){
    return(
        <header className='header'>
            <div className="container">
                <Link to="/">SENAI</Link>
                <nav>
                    <Link to="/cadastro">Cadastrar Usuario</Link>
                    <Link to="/usuarios">Listar Usuario</Link>
                </nav>
            </div>
        </header>
    );
}
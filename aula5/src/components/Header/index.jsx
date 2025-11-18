import { Link } from 'react-router-dom';
import './style.css'

function Header(){
    return(
        <header className='header'>
            <div className="container">
                <Link to="/">SENAI</Link>
                <nav>
                    <Link to="/cadastro" className='navLink'>Cadastrar Usuario</Link>
                    <Link to="/usuarios" className='navLink'>Listar Usuario</Link>
                </nav>
            </div>
        </header>
    );
}

export default Header;
// src\components\Header\index.jsx
import { Link, NavLink } from 'react-router-dom';
import logo from '../../assets/logo.png'
import './style.css';

export default function Header() {
    return(
        <header className='header'>
            <div className='header__wrap'>
                <Link to='/' className='brand'>
                    <img src={logo} alt="Logo da farmacia" />
                    <span>Farmacia saude</span>
                </Link>
            

                <nav className='nav'>
                    <NavLink to="/produtos" className={({ isActive }) => isActive ? "link active" : "link"}>
                        Produtos
                    </NavLink>
                    <NavLink to="/sobre-nos" className={({ isActive }) => isActive ? "link active" : "link"}>
                        Sobre nós
                    </NavLink>
                    <NavLink to="/fale-conosco" className={({ isActive }) => isActive ? "link active" : "link"}>
                        Fale conosco
                    </NavLink>
                </nav>
            </div>
        </header>
    )
}
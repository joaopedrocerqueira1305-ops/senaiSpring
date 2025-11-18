import './style.css';

export default function Footer(){
    const anoAtual = new Date().getFullYear()
    return(
        <footer className='footer'>
            <div className="container">
                <p>&copy; {anoAtual} - Todos os direitos reservados.</p>
            </div>
        </footer>
    );
}
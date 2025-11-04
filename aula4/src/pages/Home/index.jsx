import { Link } from 'react-router-dom';
import logo from "../../assets/logo.png";
import './style.css';

export default function Home() {
    return (
        <div className="home">
            {/* logo / Landing */}
            <section className="logo">
                <div className="logo__text">
                    <h1>Farmacia 24h </h1>
                    <p>Economize tempo e foque no que importa. Cuidamos de folha, impostos e obrigações com tecnologia e atendimento humano.</p>
                    <div className="logo__cta">
                        <Link to="/servicos" className="btn primary">Conheça nossos serviços</Link>
                        <Link to="/fale-conosco" className="btn">Fale com um especialista</Link>
                    </div>
                </div>
                <div className="logo__image">
                    <img src={logo} alt="Equipe de contabilidade" />
                </div>
            </section>


            {/* Destaques / benefícios */}
            <section className="features">
                <h2>Por que nos escolher?</h2>
                <div className="grid cols-3">
                    <div className="card">
                        <h3>Atendimento próximo</h3>
                        <p>Suporte rápido por WhatsApp, e-mail e reuniões online sempre que precisar.</p>
                    </div>
                    <div className="card">
                        <h3>Tecnologia</h3>
                        <p>Integrações com bancos e plataformas para automatizar lançamentos e reduzir erros.</p>
                    </div>
                    <div className="card">
                        <h3>Planejamento tributário</h3>
                        <p>Escolha do regime ideal e estratégias legais para pagar menos impostos.</p>
                    </div>
                </div>
            </section>


            {/* Prova social simples */}
            <section className="socialProof">
                <div className="socialProof__image">
                    <img src={office} alt="Escritório da empresa" />
                </div>
                <div className="socialProof__text">
                    <h2>Mais de 200 empresas atendidas</h2>
                    <p>De MEIs a pequenas e médias empresas em todo o Brasil. Cases em comércio, serviços e tecnologia.</p>
                </div>
            </section>
        </div>
    );
}
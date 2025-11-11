import "./style.css";


export default function Footer() {
    return (
        <footer className="footer">
            <div className="footer__wrap">
                <div>
                    <strong>Contabilidade Simples</strong> — CNPJ 00.000.000/0001-00
                </div>
                <div>
                    Rua Exemplo, 123 — Centro — Sua Cidade/UF | (00) 0000-0000 | contato@contasimple.com
                </div>
                <div className="copy">© {new Date().getFullYear()} Todos os direitos reservados.</div>
            </div>
        </footer>
    );
}
// src\pages\FaleConoscoPage\index.jsx

import './style.css';

export default function FaleConosco() {
    function handleSubmit(e) {
        e.preventDefault();
        alert("Mensagem enviada! Em breve entraremos em contato.")
    }

    return (
        <section>
            <h1>Fale Conosco</h1>
            <p>Tire suas dúvidas e peça um orçamento sem compromisso</p>

            <form className="form" onSubmit={handleSubmit}>
                <div className='grid- cols-3'>
                    <label className='field'>
                        <span>Nome</span>
                        <input type="text" required placeholder='Seu nome'/>
                    </label>
                    <label className='field'>
                        <span>E-mail</span>
                        <input type="email" required placeholder='Exemplo@email.com'/>
                    </label>
                    <label className='field'>
                        <span>Telefone</span>
                        <input type="tel" placeholder='(00) 00000-0000'/>
                    </label>
                </div>

                <label className="field">
                    <span>Assuntos</span>
                    <input type="text" required placeholder='Ex.: Abertura de empresa' />
                </label>

                <label className="field">
                    <span>Mensagem</span>
                    <textarea rows="6" required placeholder="Conte-nos um pouco do seu caso..."></textarea>
                </label>

                <button className="btn primary" type='submit'>Enviar</button>
            </form>
        </section>
    )
}
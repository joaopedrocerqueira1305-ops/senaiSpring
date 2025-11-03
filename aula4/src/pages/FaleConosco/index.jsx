// src\pages\FaleConoscoPage\index.jsx

import './style.css';

export default function FaleConosco() {
    return (
        <>
        <section>
            <h1>Fale Conosco</h1>
            <p>Tire suas dúvidas e peça um orçamento sem compromisso</p>

            <form className="form" onSubmit={handleSubmit}>
                <div className='grid- cols-3'>
                    <label className='field'>
                        <span>Nome</span>
                        <input type="text" />
                    </label>
                </div>
            </form>
        </section>
        </>
    )
}
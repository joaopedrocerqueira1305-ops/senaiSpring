// src\components\AdicionarFuncionario\index.jsx

import React, { useState } from 'react';
import './style.css';

function AdicionarFuncionario() {
    const [nome, setNome] = React.useState('');
    const [telefone, setTelefone] = React.useState('');

    const [funcionarios, setFuncionarios] = useState([]);

    const handleAdicionarFuncionario = (event) => {
        event.preventDefault();
        if (nome && telefone) {
            setFuncionarios([...funcionarios, { nome, telefone }]);
            setNome('');
            setEmail('');
        }
    }
    return (
        <div className='container'>
            <h2>Adicionar Funcionario</h2>
            <form onSubmit={handleAdicionarFuncionario}>
                <input
                    type="text"
                    placeholder="Nome"
                    value={nome}
                    onChange={(e) => setNome(e.target.value)}
                />
                <input
                    type="text"
                    placeholder="Telefone"
                    value={telefone}
                    onChange={(e) => setTelefone(e.target.value)}
                />
                <button type="submit">Adicionar</button>
            </form>
            <hr />
            <h3>Funcionarios Adicionados</h3>
            <ul>
                {funcionarios.map((funcionario, index) => (
                    <li key={index}>
                        {funcionario.nome} - {funcionario.telefone}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default AdicionarFuncionario;
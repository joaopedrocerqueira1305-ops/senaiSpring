// src\components\AdicionarUsuario\index.jsx

import React, { useState } from 'react';
import './style.css';

function AdicionarUsuario() {
    const [nome, setNome] = React.useState('');
    const [email, setEmail] = React.useState('');

    const [usuarios, setUsuarios] = useState([]);

    const handleAdicionarUsuario = (event) => {
        event.preventDefault();
        if (nome && email) {
            setUsuarios([...usuarios, { nome, email }]);
            setNome('');
            setEmail('');
        }
    }
    return (
        <div className='container'>
            <h2>Adicionar Usuario</h2>
            <form onSubmit={handleAdicionarUsuario}>
                <input
                    type="text"
                    placeholder="Nome"
                    value={nome}
                    onChange={(e) => setNome(e.target.value)}
                />
                <input
                    type="email"
                    placeholder="Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />
                <button type="submit">Adicionar</button>
            </form>
            <hr />
            <h3>Usuario Adicionados</h3>
            <ul>
                {usuarios.map((usuario, index) => (
                    <li key={index}>
                        {usuario.nome} - {usuario.email}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default AdicionarUsuario;
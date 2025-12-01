// projeto\src\components\InfoAluno\index.jsx
import { useState } from 'react';
import './style.css';

function InfoAluno() {
    // const nome = "João";
    // const idade = 20;
    // const curso = "Desenvolvimento de Sistemas";

    const[nome, setNome] = useState("João");
    const[idade, setIdade] = useState(20);
    const[curso, setCurso] = useState("Desenvolvimento de Sistemas");

    return(
        <div className='info-aluno'>
            <h2>Informações do Aluno:</h2>
            <p>Nome: {nome} </p>
            <p>Idade: {idade} </p>
            <p>Curso: {curso}</p>
        </div>
    )
}

export default InfoAluno;
// projeto\src\components\InfoCurso\index.jsx
import { useState } from 'react';
import './style.css';

function InfoCurso() {
    const[nome, setNome] = useState("Desenvolvimento de Sistemas");
    const[cargaHoraria, setCargaHoraria] = useState(200);
    const[local, setLocal] = useState("Rua: uou, Bairro: muito foda");
    const[dataInicio, setDataInicio] = useState("10/08/2010");
    const[dataTermino, setDataTermino] = useState("20/05/2025");

    return(
        <div className='info-curso'>
            <h2>Informações do Curso:</h2>
            <p>Nome do Curso: {nome} </p>
            <p>Carga Horária: {cargaHoraria} horas</p>
            <p>Local: {local}</p>
            <p>Data de Início: {dataInicio}</p>
            <p>Data de Término: {dataTermino}</p>
        </div>
    )
}

export default InfoCurso;
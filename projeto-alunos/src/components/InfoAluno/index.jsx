// projeto-alunos\src\components\InfoAluno\index.jsx
import './style.css'
import { useState } from 'react'

function InfoAluno() {
    const [nome, setNome] = useState("João Silva")
    const [idade, setIdade] = useState(21)
    const [peso, setPeso] = useState(70.2)
    const [altura, setAltura] = useState(1.75)
    const [turma, setTurma] = useState("DS2025")
    const [turno, setTurno] = useState("Matutino")
    const [disciplina, setDisciplina] = useState("Desenvolvimento Web")

    return (
        <div className='info-aluno'>
            <h2>Informações do Aluno:</h2>
            <p>Nome: {nome}</p>
            <p>Idade: {idade} anos</p>
            <p>Peso: {peso} kg</p>
            <p>Altura: {altura} m</p>
            <p>Turma: {turma}</p>
            <p>Turno: {turno}</p>
            <p>Disciplina: {disciplina}</p>
        </div>
    )
}

export default InfoAluno
import { useEffect, useState } from 'react';
import './style.css';
import api from '../../services/api';
import { toast } from 'react-toastify';

function ListaUsuariosPage() {
    const [usuarios, setUsuarios] = useState([]);
    const [carregando, setCarregando] = useState(true);

    useEffect(() => {
        async function buscarUsuarios() {
            try{
                const response = await api.get('/usuarios');
                setUsuarios(response.data);
                setCarregando(false);
            } catch(error) {
                console.error('Erro ao buscar usuários:', error);
                const mensagemError = error?.response?.data?.mensagem || 'Erro ao buscar usuário';
                toast.error(mensagemError);
                setCarregando(false)
            }
        }
        buscarUsuarios();
    }, []);

    if(carregando) {
        return <div><h2>Carregando...</h2></div>;
    }

    return (
        <div className="lsita-usuarios-container">
            <h1>Lista de Usuários</h1>
            {usuarios.length === 0 ? (
                <p>Nenhum usuário encontrado.</p>
            ) : (
                <table className='tabelaUsuario'> 
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Email</th>
                        </tr>
                    </thead>
                    <tbody>
                        {usuarios.map(usuario => (
                            <tr key={usuario.email}>
                                <td>{usuario.nome}</td>
                                <td>{usuario.email}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            )}
        </div>
    );
}

export default ListaUsuariosPage;
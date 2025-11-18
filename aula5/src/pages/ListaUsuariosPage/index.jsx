import { useEffect, useState } from 'react';
import './style.css';
import api from '../../services/api';
import { toast } from 'react-toastify';

function ListaUsuariosPage() {
    const [usuarios, setUsuarios] = useState([]);
    const [carregando, setCarregando] = useState(true);

    useEffect(() => {
        async function buscarUsuario() {
            try{
                const resposta = await api.get('/usuarios');
                setUsuarios(resposta.data);
            } catch(error) {
                console.error('Erro ao buscra usuários:', error);
                const mensagemError = error.response?.data?.mensagem || 'Erro ao buscar usuário';
                toast.error(mensagemError);
            } finally {
                setCarregando
            }
        }
        buscarUsuario();
    }, []);

    if(carregando) {
        return <div>Carregando...</div>;
    }

    return [
        <div className="lsita-usuarios-container">
            <h1>Lista de Usuários</h1>
            {usuarios.length === 0 ? (
                <p>Nenhum usuário encontrado.</p>
            ) : (
                <ul>
                    {usuarios.map(usuario => (
                        <li key={usuario.id}>{usuario.nome}</li>
                    ))}
                </ul>
            )}
        </div>
    ];
}

export default ListaUsuariosPage;
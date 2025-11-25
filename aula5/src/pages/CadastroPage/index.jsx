import { useForm } from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from 'yup';
import api from '../../services/api';
import { toast } from 'react-toastify';
import './style.css';

const esquemaDeCadastro = yup.object({
    nome: yup.string().required('O nome é obrigatorio'),
    email: yup.string().required('O email é obrigatorio').email('Email inválido'),
    senha: yup.string().min(3, 'A senha deve ter pelo menos 3 caracteres')
        .required('A senha é obrigatoria'),
    confirmarSenha: yup.string().oneOf([yup.ref('senha'), null], 'As senhas devem ser iguais')
        .required('A confirmação da senha é obrigatoria'),
});

function CadastroPage() {
    // Hook useForm para gerenciar o formulario de cadastro
    const {
        register: registrarCampo,
        handleSubmit: lidarComEnviosDoFormulario,
        formState: { errors: errosDoFormulario, isSubmitting: estaEnviando },
        setError: definirErroNoCampo,
        reset: limparCampoDoFormulario,
    } = useForm({
        resolver: yupResolver(esquemaDeCadastro),
        defaultValues: {
            nome: '',
            email: '',
            senha: '',
            confirmarSenha: '',
        },
    });

    async function enviarDados(dadosDoFormulario) {
        const dadosParaApi = {
            nome: dadosDoFormulario.nome,
            email: dadosDoFormulario.email,
            senha: dadosDoFormulario.senha,
        };

        try {
            const resposta = await api.post('/usuarios', dadosParaApi);
            toast.success(resposta.data.mensagem || 'Cadastro realizado com sucesso!');
            limparCampoDoFormulario();
        } catch (error) {
            const codigoDeStatus = error?.response?.status;
            const mensagemDoServidor = error?.response?.data?.mensagem || 'Erro ao cadastrar usuário';
            if (codigoDeStatus === 409) {
                definirErroNoCampo('email', {
                    type: 'server',
                    message: mensagemDoServidor,
                });
            }
            toast.error(mensagemDoServidor);
            console.error('Erro ao cadastrar usuário:', error);
        }
    }

    return (
        <div className="cadastro-container">
            <h1>Cadastro de Usuário</h1>
            <form noValidate onSubmit={lidarComEnviosDoFormulario(enviarDados)}>
                <div className="form-group">
                    <label htmlFor="campo-nome">Nome:</label>
                    <input
                        id='campo-nome'
                        type="text"
                        placeholder='Ex.: Maria Silva'
                        {...registrarCampo('nome')}
                    />
                </div>
                {errosDoFormulario.nome && (
                    <p className='error-message'>{errosDoFormulario.nome.message}</p>
                )}
                <div className="form-group">
                    <label htmlFor="campo-email">Email:</label>
                    <input
                        id='campo-email'
                        type="email"
                        placeholder='Ex.: Maria@email.com'
                        {...registrarCampo('email')}
                    />
                </div>
                {errosDoFormulario.email && (
                    <p className='error-message'>{errosDoFormulario.email.message}</p>
                )}
                <div className="form-group">
                    <label htmlFor="campo-senha">Senha:</label>
                    <input
                        id='campo-senha'
                        type="password"
                        placeholder='Digíte sua senha'
                        {...registrarCampo('senha')}
                    />
                </div>
                {errosDoFormulario.senha && (
                    <p className='error-message'>{errosDoFormulario.senha.message}</p>
                )}
                <div className="form-group">
                    <label htmlFor="campo-confirmar-senha">Confirmar Senha:</label>
                    <input
                        id='campo-confirmar-senha'
                        type="password"
                        placeholder='Confirme sua senha'
                        {...registrarCampo('confirmarSenha')}
                    />
                </div>
                {errosDoFormulario.confirmarSenha && (
                    <p className='error'>{errosDoFormulario.confirmarSenha.message}</p>
                )}
                <button type='submit' disabled={estaEnviando}>
                    {estaEnviando ? 'Cadastrando...' : 'Cadastrar'}
                </button>
            </form>
        </div>
    );
}

export default CadastroPage;
package main.java.com.gestaoPatrimonio.model.service;

import java.util.List;
import java.util.Optional;

import main.java.com.gestaoPatrimonio.model.entity.Bem;
import main.java.com.gestaoPatrimonio.model.entity.Setor;
import main.java.com.gestaoPatrimonio.model.entity.Usuario;
import main.java.com.gestaoPatrimonio.model.repository.BemRepository;
import main.java.com.gestaoPatrimonio.model.repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private BemRepository bemRepository;

    // Construtor que recebe as dependências
    public UsuarioService(UsuarioRepository usuarioRepository, BemRepository bemRepository) {
        this.usuarioRepository = usuarioRepository;
        this.bemRepository = bemRepository;
    }

    // Adiciona um novo usuário
    public void addUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    // Encontra um usuário pelo ID
    public Optional<Usuario> getUsuarioById(int id) {
        return usuarioRepository.findById(id);
    }

    // Encontra todos os usuários
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Remove um usuário pelo ID
    public void removeUsuarioById(int id) {
        usuarioRepository.deleteById(id);
    }

    // Encontra um usuário pelo login
    public Optional<Usuario> getUsuarioByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    // Autentica um usuário
    public boolean autenticarUsuario(String login, String senha) {
        Optional<Usuario> usuario = usuarioRepository.findByLogin(login);
        if (usuario.isPresent() && usuario.get().getSenha().equals(senha)) {
            return true;
        } else {
            System.out.println("Falha na autenticação: Login ou senha incorretos.");
            return false;
        }
    }

    // Método para registrar um bem para um usuário
    public void registrarBem(Usuario usuario, Bem bem) {
        bem.setResponsavel(usuario);
        bem.setSetor(usuario.getSetor());
        bemRepository.save(bem);
    }

    // Método para atualizar um bem de um usuário
    public void atualizarBem(Usuario usuario, Bem bem) {
        bemRepository.update(bem);
    }

    // Método para transferir um bem de um usuário para outro setor
    public void transferirBem(Usuario usuario, Bem bem, Setor novoSetor) {
        bem.setSetor(novoSetor); // Atualiza o setor do bem
        bemRepository.update(bem); // Atualiza o bem no repositório
    }
}

package main.java.com.gestaoPatrimonio.model.service;


import java.util.List;
import java.util.Optional;

import main.java.com.gestaoPatrimonio.model.entity.Usuario;
import main.java.com.gestaoPatrimonio.model.repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
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
        return usuario.isPresent() && usuario.get().getSenha().equals(senha);
    }
}

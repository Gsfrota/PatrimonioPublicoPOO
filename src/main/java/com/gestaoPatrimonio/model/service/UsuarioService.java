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

    public UsuarioService(UsuarioRepository usuarioRepository, BemRepository bemRepository) {
        this.usuarioRepository = usuarioRepository;
        this.bemRepository = bemRepository;
    }

    public void addUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Optional<Usuario> getUsuarioById(int id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public void removeUsuarioById(int id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> getUsuarioByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public boolean autenticarUsuario(String login, String senha) {
        Optional<Usuario> usuario = usuarioRepository.findByLogin(login);
        if (usuario.isPresent() && usuario.get().getSenha().equals(senha)) {
            return true;
        } else {
            System.out.println("Falha na autenticação: Login ou senha incorretos.");
            return false;
        }
    }

    public void registrarBem(Usuario usuario, Bem bem) {
        bem.setResponsavel(usuario);
        bem.setSetor(usuario.getSetor());
        bemRepository.save(bem);
    }

    public void atualizarBem(Usuario usuario, Bem bem) {
        bemRepository.update(bem);
    }

    public void transferirBem(Usuario usuario, Bem bem, Setor novoSetor) {
        bem.setSetor(novoSetor);
        bemRepository.update(bem);
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public BemRepository getBemRepository() {
        return bemRepository;
    }

    public void setBemRepository(BemRepository bemRepository) {
        this.bemRepository = bemRepository;
    }
}

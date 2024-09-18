package main.java.com.gestaoPatrimonio.model.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import main.java.com.gestaoPatrimonio.model.entity.Setor;
import main.java.com.gestaoPatrimonio.model.entity.Usuario;

public class UsuarioRepository {

    private List<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario(String login, String senha, String nome, Setor setor) {
        Usuario novoUsuario = new Usuario(nome, login, senha, setor);
        save(novoUsuario);  // Salva o usuário na lista
    }

    public void save(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Optional<Usuario> findById(int id) {
        return usuarios.stream()
                       .filter(usuario -> usuario.getId() == id)
                       .findFirst();
    }

    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios);
    }

    public void deleteById(int id) {
        usuarios.removeIf(usuario -> usuario.getId() == id);
    }

    public Optional<Usuario> findByLogin(String login) {
        return usuarios.stream()
                       .filter(usuario -> usuario.getLogin().equalsIgnoreCase(login))
                       .findFirst();
    }

}



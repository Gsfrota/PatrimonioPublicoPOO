package main.java.com.gestaoPatrimonio.model.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import main.java.com.gestaoPatrimonio.model.entity.Setor;
import main.java.com.gestaoPatrimonio.model.entity.Usuario;

public class UsuarioRepository {

    private List<Usuario> usuarios = new ArrayList<>();

    // Método para cadastrar um novo usuário
    public void cadastrarUsuario(String login, String senha, String nome, Setor setor) {
        Usuario novoUsuario = new Usuario(nome, login, senha, setor);
        save(novoUsuario);  // Salva o usuário na lista
    }

    // Adiciona um usuário ao repositório
    public void save(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Encontra um usuário pelo ID
    public Optional<Usuario> findById(int id) {
        return usuarios.stream()
                       .filter(usuario -> usuario.getId() == id)
                       .findFirst();
    }

    // Encontra todos os usuários
    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios);
    }

    // Remove um usuário pelo ID
    public void deleteById(int id) {
        usuarios.removeIf(usuario -> usuario.getId() == id);
    }

    // Encontra usuários pelo login
    public Optional<Usuario> findByLogin(String login) {
        return usuarios.stream()
                       .filter(usuario -> usuario.getLogin().equalsIgnoreCase(login))
                       .findFirst();
    }

}



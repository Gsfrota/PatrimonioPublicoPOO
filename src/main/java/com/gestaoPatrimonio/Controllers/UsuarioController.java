import java.util.List;

public class UsuarioController {
    private UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void criarUsuario(String nome, String login, String senha, String perfil, Setor setor) {
        if (nome == null || nome.trim().isEmpty() || login == null || login.trim().isEmpty() || senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome, login e senha são obrigatórios");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha); // Nota: Na prática, a senha deve ser criptografada antes de ser armazenada
        usuario.setPerfil(perfil);
        usuario.setSetor(setor);

        repository.save(usuario);
    }

    public Usuario buscarUsuario(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void atualizarUsuario(int id, String nome, String login, String senha, String perfil, Setor setor) {
        Usuario usuario = buscarUsuario(id);

        if (nome != null && !nome.trim().isEmpty()) {
            usuario.setNome(nome);
        }
        if (login != null && !login.trim().isEmpty()) {
            usuario.setLogin(login);
        }
        if (senha != null && !senha.trim().isEmpty()) {
            usuario.setSenha(senha); // Nota: Na prática, a senha deve ser criptografada antes de ser armazenada
        }
        usuario.setPerfil(perfil);
        usuario.setSetor(setor);

        repository.update(usuario);
    }

    public void deletarUsuario(int id) {
        repository.delete(id);
    }

    public boolean autenticarUsuario(String login, String senha) {
        Usuario usuario = repository.findByLogin(login);
        if (usuario == null) {
            return false;
        }
        // Nota: Na prática, você deve comparar a senha criptografada
        return usuario.getSenha().equals(senha);
    }

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }
}
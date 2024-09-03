public class UsuarioService {
    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void criarUsuario(Usuario usuario) {
        // Validações de negócio
        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do usuário é obrigatório");
        }
        if (usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()) {
            throw new IllegalArgumentException("Login do usuário é obrigatório");
        }
        // Lógica adicional de negócio, se necessário
        // Criptografar senha
        usuario.setSenha(criptografarSenha(usuario.getSenha()));
        repository.save(usuario);
    }

    public Usuario buscarUsuario(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
    }

    public void atualizarUsuario(Usuario usuario) {
        // Validações de negócio
        if (usuario.getId() == 0) {
            throw new IllegalArgumentException("ID do usuário é obrigatório para atualização");
        }
        // Lógica adicional de negócio, se necessário
        // Se a senha foi alterada, criptografar novamente
        if (usuario.getSenha() != null && !usuario.getSenha().trim().isEmpty()) {
            usuario.setSenha(criptografarSenha(usuario.getSenha()));
        }
        repository.update(usuario);
    }

    public void deletarUsuario(int id) {
        // Verificar se o usuário pode ser deletado
        repository.delete(id);
    }

    public boolean autenticarUsuario(String login, String senha) {
        Usuario usuario = repository.findByLogin(login);
        if (usuario == null) {
            return false;
        }
        return verificarSenha(senha, usuario.getSenha());
    }

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    private String criptografarSenha(String senha) {
        // Implementar lógica de criptografia (por exemplo, usando BCrypt)
        return senha; // Placeholder
    }

    private boolean verificarSenha(String senhaDigitada, String senhaArmazenada) {
        // Implementar lógica de verificação de senha
        return senhaDigitada.equals(senhaArmazenada); // Placeholder
    }
}
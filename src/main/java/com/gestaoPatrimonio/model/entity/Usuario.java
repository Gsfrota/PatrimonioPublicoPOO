package main.java.com.gestaoPatrimonio.model.entity;

public class Usuario {

    private static int idCounter = 1;

    private int id;
    private String nome;
    private String login;
    private String senha;
    private String perfil;
    private Setor setor;

    public Usuario(String nome, String login, String senha, String perfil, Setor setor) {
        this.id = idCounter++;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
        this.setor = setor;
    }

    // Métodos
    public void acessarSistema(String login, String senha) {
        // Implementar lógica de autenticação
    }

    public void cadastrarUsuario(String login, String senha, String nome, Setor setor) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.setor = setor;
    }

    // Método para validar o login
    // private boolean validarLogin(String login) {
    //     return login != null && !login.trim().isEmpty();
    // }

    public void registrarBem(Bem bem) {
        // Implementação do método para registrar um bem
    }

    public void atualizarBem(Bem bem) {
        // Implementação do método para atualizar um bem
    }

    public void transferirBem(Bem bem, Setor setor) {
        // Implementação do método para transferir um bem
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}

package main.java.com.gestaoPatrimonio.model.entity;

public class Usuario {

    private static int idCounter = 1;

    private int id;
    private String nome;
    private String login;
    private String senha;
    private String perfil;
    private Setor setor;

    public Usuario(String nome, String login, String senha, Setor setor) {
        this.id = idCounter++;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        //this.perfil = perfil;
        this.setor = setor;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID deve ser maior que zero.");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null || login.trim().isEmpty()) {
            throw new IllegalArgumentException("Login não pode ser nulo ou vazio.");
        }
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha == null || senha.length() < 6) {
            throw new IllegalArgumentException("Senha deve ter pelo menos 6 caracteres.");
        }
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        if (perfil == null || perfil.trim().isEmpty()) {
            throw new IllegalArgumentException("Perfil não pode ser nulo ou vazio.");
        }
        this.perfil = perfil;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        if (setor == null) {
            throw new IllegalArgumentException("Setor não pode ser nulo.");
        }
        this.setor = setor;
    }
}

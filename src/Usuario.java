
public class Usuario {
    // Atributos
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String perfil;
    private Setor setor;

    // Métodos
    public void acessarSistema(String login, String senha) {
        // Implementação do método para acessar o sistema
    }

    public void registrarBem(Bem bem) {
        // Implementação do método para registrar um bem
    }

    public void atualizarBem(Bem bem) {
        // Implementação do método para atualizar um bem
    }

    public void transferirBem(Bem bem, Setor setor) {
        // Implementação do método para transferir um bem
    }

    public int getId() {
        return id;
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



}

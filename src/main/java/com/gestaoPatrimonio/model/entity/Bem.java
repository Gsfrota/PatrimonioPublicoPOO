package main.java.com.gestaoPatrimonio.model.entity;

public class Bem {
    private int id;
    private String nome;
    private String descricao;
    private String tipo;
    private float valorAquisicao;
    private String dataRegistro;
    private String situacao;
    private Usuario responsavel;
    private Setor setor;

    // Construtor
    public Bem(String nome, String descricao, String tipo, String dataRegistro) {
        this.id = (int) (Math.random() * 1000);
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.dataRegistro = dataRegistro;
        this.situacao = "Novo bem";
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(float valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    // Métodos
    public void registrarBem() {
        // Implementação do método para registrar um bem
    }

    public Bem consultarBem(int id) {
        // Implementação do método para consultar um bem
        return null; 
    }

    public void atualizarBem(Bem bem) {
        // Implementação do método para atualizar um bem
    }

    public void transferirBem(Setor setor) {
        // Implementação do método para transferir um bem
    }

    public String getNomeBem() {
        return nome;
    }

    @Override
    public String toString() {
        return String.format("Novo bem %s criado!%nTipo: %s%nID: %d%nData da aquisição: %s%nSituação: %s%nDescrição: %s%n", nome, tipo, id, dataRegistro, situacao, descricao);
    }
}

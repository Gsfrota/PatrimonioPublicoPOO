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

    public Bem(String nome, String descricao, String tipo, String dataRegistro) {
        this.id = (int) (Math.random() * 1000);
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.dataRegistro = dataRegistro;
        this.situacao = "Novo bem";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido. Deve ser maior que zero.");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia.");
        }
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("Tipo não pode ser vazio.");
        }
        this.tipo = tipo;
    }

    public float getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(float valorAquisicao) {
        if (valorAquisicao <= 0) {
            throw new IllegalArgumentException("Valor de aquisição deve ser maior que zero.");
        }
        this.valorAquisicao = valorAquisicao;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        if (dataRegistro == null || dataRegistro.trim().isEmpty()) {
            throw new IllegalArgumentException("Data de registro não pode ser vazia.");
        }
        this.dataRegistro = dataRegistro;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        if (situacao == null || situacao.trim().isEmpty()) {
            throw new IllegalArgumentException("Situação não pode ser vazia.");
        }
        this.situacao = situacao;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        if (responsavel == null) {
            throw new IllegalArgumentException("Responsável não pode ser nulo.");
        }
        this.responsavel = responsavel;
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

    public String getNomeBem() {
        return nome;
    }

    @Override
    public String toString() {
        return String.format("Novo bem %s criado!%nTipo: %s%nID: %d%nData da aquisição: %s%nSituação: %s%nDescrição: %s%n", nome, tipo, id, dataRegistro, situacao, descricao);
    }

    void setLocalizacao(String localizacao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

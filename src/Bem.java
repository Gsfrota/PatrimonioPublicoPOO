import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;

public class Bem {
    // Atributos
    private String nome;
    private int id;
    private String descricao;
    private String tipo;
    private float valorAquisicao;
    private String dataRegistro;
    private String situacao;
    private Usuario responsavel;




    public Bem(String nome, String descricao, String tipo,String dataRegistro){
        this.id = (int) (Math.random() * 1000); // Gera um ID aleatório para o bem
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.situacao = "Novo bem";
        this.dataRegistro = dataRegistro;
       

    }



   

    @Override
    public String toString(){
        return String.format("Novo bem %s criado!%nTipo: %s%nID: %d%nData da aquisição: %s%nSituação: %s%nDescrição: %s%n", nome, tipo, id, dataRegistro, situacao, descricao);
    }
    // Métodos
    public String getNomeBem() {
        return nome;
    }
    public void setNomeBem(String nomeBem) {
        this.nome = nomeBem;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public String getdataRegistro() {
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

    public void registrarBem() {
        
    }

    public Bem consultarBem(int id) {
        // Implementação do método para consultar um bem
        return null; 
    }

    public void atualizarBem(Bem bem) {
        // Implementação do método para atualizar um bem
    }

    public void transferirBem(Bem bem, Setor setor) {
        // Implementação do método para transferir um bem
    }
    

}

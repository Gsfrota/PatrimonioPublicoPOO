import java.util.List;

public class Instituicao{
    // Atributos
    private int id;
    private String nome;
    private String cnpj;
    private List<Setor> setores;
    private List<Usuario> usuarios;
    private List<Bem> bens;



    public Instituicao(String nome, String cnpj){
        this.id = (int) (Math.random() * 1000);
        this.nome = nome;
        this.cnpj = cnpj;
        
    }



    @Override
    public String toString(){
        return String.format("Instituição %s cadastrada!", nome);
    }

    
    // Métodos
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

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Setor> getSetores() {
        return setores;
    }
    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Bem> getBens() {
        return bens;
    }
    public void setBens(List<Bem> bens) {
        this.bens = bens;
    }

}
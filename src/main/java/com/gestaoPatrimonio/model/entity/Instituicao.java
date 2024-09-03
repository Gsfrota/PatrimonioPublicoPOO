import java.util.ArrayList;
import java.util.List;

public class Instituicao {
    // Atributos
    private int id;
    private String nome;
    private String cnpj;
    private List<Setores> setores;
    private List<Usuarios> usuarios;
    private List<Bens> bens = new ArrayList<>();

    public Instituicao(String nome, String cnpj) {
        this.id = (int) (Math.random() * 1000);
        this.nome = nome;
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
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


    public Bem consultarBem(int id) {
        for (Bem bem : bens) {
            if (bem.getId() == id) {
                return bem;

            }
        }
        return null;
    }

    public void atualizarBem(Bem bemAtualizado) {
        for (int i = 0; i < bens.size(); i++) {
            Bem bemExistente = bens.get(i);
            if (bemExistente.getId() == bemAtualizado.getId()) {
                bens.set(i, bemAtualizado);
                System.out.println("Bem atualizado com sucesso: " + bemAtualizado.getNomeBem());
                return;
            }
        }
    }

    public void transferirBem(Bem bem, Setor novoSetor) {
        for (Setor setor : setores) {
            if (setor.getBens().contains(bem)) {
                setor.getBens().remove(bem);
                System.out.println("Bem removido do setor: " + setor.getNome());

                break;
            }
        }
        novoSetor.receberBem(bem);
    }


}
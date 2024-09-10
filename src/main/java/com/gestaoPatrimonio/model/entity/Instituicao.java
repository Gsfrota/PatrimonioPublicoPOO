
package main.java.com.gestaoPatrimonio.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Instituicao {

    private int id;

    private String nome;

    private String cnpj;

    // Um para muitos com Setor
    private List<Setor> setores = new ArrayList<>();


    private List<Usuario> usuarios = new ArrayList<>();

    // Um para muitos com Bem
    private List<Bem> bens = new ArrayList<>();

    // Construtor vazio necessário para o JPA
    public Instituicao() {}

    public Instituicao(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
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

    // Métodos para manipulação dos bens
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

    @Override
    public String toString() {
        return String.format("Instituição %s cadastrada!", nome);
    }
}

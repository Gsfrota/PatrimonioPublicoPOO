
package main.java.com.gestaoPatrimonio.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Instituicao {
    private int id;
    private String nome;
    private String cnpj;

    private List<Setor> setores = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Bem> bens = new ArrayList<>();

    public Instituicao() {
        this.id = (int) (Math.random() * 1000);
        this.nome = nome;
        this.cnpj = cnpj;
    }

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
            throw new IllegalArgumentException("Nome não pode ser vazio ou nulo.");
        }
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if (cnpj == null || cnpj.trim().isEmpty() || cnpj.length() != 14) {
            throw new IllegalArgumentException("CNPJ inválido. Deve ter 14 dígitos.");
        }
        this.cnpj = cnpj;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        if (setores == null || setores.isEmpty()) {
            throw new IllegalArgumentException("A lista de setores não pode ser nula ou vazia.");
        }
        this.setores = setores;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        if (usuarios == null || usuarios.isEmpty()) {
        throw new IllegalArgumentException("A lista de usuários não pode ser nula ou vazia.");
    }
        this.usuarios = usuarios;
    }

    public List<Bem> getBens() {
        return bens;
    }

    public void setBens(List<Bem> bens) {
        if (bens == null || bens.isEmpty()) {
            throw new IllegalArgumentException("A lista de bens não pode ser nula ou vazia.");
        }
        this.bens = bens;
    }

    @Override
    public String toString() {
        return String.format("Instituição %s cadastrada!", nome);
    }
}

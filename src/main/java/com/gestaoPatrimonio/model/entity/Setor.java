package main.java.com.gestaoPatrimonio.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Setor {
    private int id;
    private String nome;
    private String sigla;
    private Usuario responsavel;
    private String localizacao;
    private String contato;
    private List<Bem> bens = new ArrayList<>();

    public Setor(String nome, String sigla, Usuario responsavel, String localizacao, String contato) {
        this.id = (int) (Math.random() * 1000);
        this.nome = nome;
        this.sigla = sigla;
        this.responsavel = responsavel;
        this.localizacao = localizacao;
        this.contato = contato;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        if (sigla == null || sigla.trim().isEmpty()) {
            throw new IllegalArgumentException("Sigla não pode ser vazia ou nula.");
        }
        this.sigla = sigla;
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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        if (localizacao == null || localizacao.trim().isEmpty()) {
            throw new IllegalArgumentException("Localização não pode ser vazia ou nula.");
        }
        this.localizacao = localizacao;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        if (contato == null || contato.trim().isEmpty()) {
            throw new IllegalArgumentException("Contato não pode ser vazio ou nulo.");
        }
        this.contato = contato;
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
}

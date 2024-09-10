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

    // Adiciona um bem ao setor
    public void receberBem(Bem bem) {
        bens.add(bem);
        bem.setSituacao("Recebido");
        bem.setResponsavel(this.responsavel);
        System.out.println("Bem recebido: " + bem.getDescricao());
    }

    // Remove um bem do setor
    public void devolverBem(Bem bem) {
        bens.remove(bem);
        bem.setSituacao("Devolvido");
        bem.setResponsavel(null);
        System.out.println("Bem devolvido: " + bem.getDescricao());
    }

    // Solicita a transferência de um bem para outro setor
    public void solicitarTransferenciaBem(Bem bem, Setor setor) {
        if (bens.contains(bem)) {
            bens.remove(bem);
            setor.receberBem(bem);
            System.out.println("Transferência solicitada para o bem: " + bem.getDescricao());
        } else {
            System.out.println("Bem não encontrado no setor atual.");
        }
    }

    // Gera relatórios para o setor
    public void gerarRelatorios() {
        System.out.println("Relatório do Setor: " + nome);
        for (Bem bem : bens) {
            System.out.println("ID: " + bem.getId() + ", Descrição: " + bem.getDescricao() +
                    ", Situação: " + bem.getSituacao() + ", Responsável: " +
                    (bem.getResponsavel() != null ? bem.getResponsavel().getNome() : "N/A"));
        }
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public List<Bem> getBens() {
        return bens;
    }

    public void setBens(List<Bem> bens) {
        this.bens = bens;
    }
}

package main.java.com.gestaoPatrimonio.model.repository;

import java.util.ArrayList;
import java.util.List;
import main.java.com.gestaoPatrimonio.model.entity.Bem;
import main.java.com.gestaoPatrimonio.model.entity.Setor;

public class SetorRepository {

    private List<Setor> setores = new ArrayList<>();
    private static int idCounter = 1;

    public void save(Setor setor) {
        if (setor.getId() == 0) {
            setor.setId(idCounter++);
            setores.add(setor);
        } else {
            for (int i = 0; i < setores.size(); i++) {
                if (setores.get(i).getId() == setor.getId()) {
                    setores.set(i, setor);
                    return;
                }
            }
        }
    }

    public Setor findById(int id) {
        for (Setor setor : setores) {
            if (setor.getId() == id) {
                return setor;
            }
        }
        return null;
    }

    public void delete(int id) {
        setores.removeIf(setor -> setor.getId() == id);
    }

    public void receberBem(Setor setor, Bem bem) {
        setor.getBens().add(bem);
        bem.setSituacao("Recebido");
        bem.setResponsavel(null);
        System.out.println("Bem recebido: " + bem.getDescricao());
    }

    public void devolverBem(Setor setor, Bem bem) {
        if (setor.getBens().remove(bem)) {
            bem.setSituacao("Devolvido");
            bem.setResponsavel(null);
            System.out.println("Bem devolvido: " + bem.getDescricao());
        } else {
            System.out.println("Bem não encontrado no setor.");
        }
    }

    public void solicitarTransferenciaBem(Setor setorAtual, Setor setorNovo, Bem bem) {
        if (setorAtual.getBens().remove(bem)) {
            setorNovo.getBens().add(bem);
            bem.setSetor(setorNovo);
            bem.setSituacao("Transferido");
            System.out.println("Transferência solicitada para o bem: " + bem.getDescricao());
        } else {
            System.out.println("Bem não encontrado no setor atual.");
        }
    }

    public void gerarRelatorios(Setor setor) {
        System.out.println("Relatório do Setor: " + setor.getNome());
        for (Bem bem : setor.getBens()) {
            System.out.println("ID: " + bem.getId() + ", Descrição: " + bem.getDescricao() +
                    ", Situação: " + bem.getSituacao() + ", Responsável: " +
                    (bem.getResponsavel() != null ? bem.getResponsavel().getNome() : "N/A"));
        }
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }
}

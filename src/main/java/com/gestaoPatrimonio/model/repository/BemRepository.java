package main.java.com.gestaoPatrimonio.model.repository;

import java.util.ArrayList;
import java.util.List;
import main.java.com.gestaoPatrimonio.model.entity.Bem;

public class BemRepository {
    private List<Bem> bens = new ArrayList<>();

    public void save(Bem bem) {
        bens.add(bem);
        System.out.println("Bem salvo com sucesso: " + bem.getNomeBem());
    }

    public Bem findById(int id) {
        for (Bem bem : bens) {
            if (bem.getId() == id) {
                return bem;
            }
        }
        return null;
    }

    public void update(Bem bemAtualizado) {
        for (int i = 0; i < bens.size(); i++) {
            Bem bemExistente = bens.get(i);
            if (bemExistente.getId() == bemAtualizado.getId()) {
                bens.set(i, bemAtualizado);
                System.out.println("Bem atualizado com sucesso: " + bemAtualizado.getNomeBem());
                return;
            }
        }
        System.out.println("Bem com ID " + bemAtualizado.getId() + " não encontrado para atualização.");
    }

    public void delete(int id) {
        Bem bem = findById(id);
        if (bem != null) {
            bens.remove(bem);
            System.out.println("Bem removido com sucesso: " + bem.getNomeBem());
        } else {
            System.out.println("Bem com ID " + id + " não encontrado.");
        }
    }

    public List<Bem> findAll() {
        return new ArrayList<>(bens);
    }

    public List<Bem> getBens() {
        return bens;
    }

    public void setBens(List<Bem> bens) {
        this.bens = bens;
    }
}

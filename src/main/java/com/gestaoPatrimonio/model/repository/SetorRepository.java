package main.java.com.gestaoPatrimonio.model.repository;

import java.util.ArrayList;
import java.util.List;

import main.java.com.gestaoPatrimonio.model.entity.Setor;

public class SetorRepository {

    private List<Setor> setores = new ArrayList<>();
    private static int idCounter = 1;

    // Adiciona ou atualiza um Setor
    public void save(Setor setor) {
        if (setor.getId() == 0) { // Novo registro
            setor.setId(idCounter++);
            setores.add(setor);
        } else {
            // Atualiza um Setor existente
            for (int i = 0; i < setores.size(); i++) {
                if (setores.get(i).getId() == setor.getId()) {
                    setores.set(i, setor);
                    return;
                }
            }
        }
    }

    // Encontra um Setor por ID
    public Setor findById(int id) {
        for (Setor setor : setores) {
            if (setor.getId() == id) {
                return setor;
            }
        }
        return null;
    }

    // Remove um Setor por ID
    public void delete(int id) {
        setores.removeIf(setor -> setor.getId() == id);
    }
}

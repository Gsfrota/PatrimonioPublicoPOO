package main.java.com.gestaoPatrimonio.model.repository;


import java.util.ArrayList;
import java.util.List;

import main.java.com.gestaoPatrimonio.model.entity.Instituicao;

public class InstituicaoRepository {
    private List<Instituicao> instituicoes = new ArrayList<>();

    // Adiciona uma nova Instituição
    public void save(Instituicao instituicao) {
        instituicoes.add(instituicao);
        System.out.println("Instituição salva com sucesso: " + instituicao.getNome());
    }

    // Encontra uma Instituição por ID
    public Instituicao findById(int id) {
        for (Instituicao instituicao : instituicoes) {
            if (instituicao.getId() == id) {
                return instituicao;
            }
        }
        return null;
    }

    // Remove uma Instituição por ID
    public void delete(int id) {
        Instituicao instituicao = findById(id);
        if (instituicao != null) {
            instituicoes.remove(instituicao);
            System.out.println("Instituição removida com sucesso: " + instituicao.getNome());
        } else {
            System.out.println("Instituição com ID " + id + " não encontrada.");
        }
    }

    // Atualiza uma Instituição existente
    public void update(Instituicao instituicaoAtualizada) {
        for (int i = 0; i < instituicoes.size(); i++) {
            Instituicao instituicaoExistente = instituicoes.get(i);
            if (instituicaoExistente.getId() == instituicaoAtualizada.getId()) {
                instituicoes.set(i, instituicaoAtualizada);
                System.out.println("Instituição atualizada com sucesso: " + instituicaoAtualizada.getNome());
                return;
            }
        }
        System.out.println("Instituição com ID " + instituicaoAtualizada.getId() + " não encontrada para atualização.");
    }

    // Encontra uma Instituição por nome
    public Instituicao findByNome(String nome) {
        for (Instituicao instituicao : instituicoes) {
            if (instituicao.getNome().equalsIgnoreCase(nome)) {
                return instituicao;
            }
        }
        return null;
    }
}

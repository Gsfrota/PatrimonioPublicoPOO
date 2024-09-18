package main.java.com.gestaoPatrimonio.model.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import main.java.com.gestaoPatrimonio.model.entity.Bem;
import main.java.com.gestaoPatrimonio.model.entity.Instituicao;
import main.java.com.gestaoPatrimonio.model.entity.Setor;

public class InstituicaoRepository {
    private List<Instituicao> instituicoes = new ArrayList<>();
    private SetorRepository SetorRepository;

    public InstituicaoRepository(SetorRepository setorRepository) {
        this.SetorRepository = setorRepository;
    }

    public void save(Instituicao instituicao) {
        instituicoes.add(instituicao);
        System.out.println("Instituição salva com sucesso: " + instituicao.getNome());
    }

    public Instituicao findById(int id) {
        for (Instituicao instituicao : instituicoes) {
            if (instituicao.getId() == id) {
                return instituicao;
            }
        }
        return null;
    }

    public void delete(int id) {
        Instituicao instituicao = findById(id);
        if (instituicao != null) {
            instituicoes.remove(instituicao);
            System.out.println("Instituição removida com sucesso: " + instituicao.getNome());
        } else {
            System.out.println("Instituição com ID " + id + " não encontrada.");
        }
    }

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

    public Instituicao findByNome(String nome) {
        for (Instituicao instituicao : instituicoes) {
            if (instituicao.getNome().equalsIgnoreCase(nome)) {
                return instituicao;
            }
        }
        return null;
    }

    public Bem consultarBem(int id) {
        for (Instituicao instituicao : instituicoes) {
            for (Setor setor : instituicao.getSetores()) {
                Optional<Bem> bemEncontrado = setor.getBens().stream()
                        .filter(bem -> bem.getId() == id)
                        .findFirst();
                if (bemEncontrado.isPresent()) {
                    return bemEncontrado.get();
                }
            }
        }
        return null;
    }

    public void atualizarBem(Bem bemAtualizado) {
        for (Instituicao instituicao : instituicoes) {
            for (Setor setor : instituicao.getSetores()) {
                for (int i = 0; i < setor.getBens().size(); i++) {
                    Bem bemExistente = setor.getBens().get(i);
                    if (bemExistente.getId() == bemAtualizado.getId()) {
                        setor.getBens().set(i, bemAtualizado);
                        return;
                    }
                }
            }
        }
    }

    public void transferirBem(Bem bem, Setor novoSetor) {
        for (Instituicao instituicao : instituicoes) {
            for (Setor setor : instituicao.getSetores()) {
                if (setor.getBens().contains(bem)) {
                    SetorRepository.devolverBem(setor, bem);
                    SetorRepository.receberBem(novoSetor, bem);
                    return;
                }
            }
        }
    }

    public List<Instituicao> getInstituicoes() {
        return instituicoes;
    }

    public void setInstituicoes(List<Instituicao> instituicoes) {
        this.instituicoes = instituicoes;
    }

    public SetorRepository getSetorRepository() {
        return SetorRepository;
    }

    public void setSetorRepository(SetorRepository SetorRepository) {
        this.SetorRepository = SetorRepository;
    }
}

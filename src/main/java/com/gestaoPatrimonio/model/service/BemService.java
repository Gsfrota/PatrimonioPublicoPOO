package main.java.com.gestaoPatrimonio.model.service;

import java.util.List;
import main.java.com.gestaoPatrimonio.model.entity.Bem;
import main.java.com.gestaoPatrimonio.model.entity.Setor;
import main.java.com.gestaoPatrimonio.model.repository.BemRepository;
import main.java.com.gestaoPatrimonio.model.repository.SetorRepository;

public class BemService {
    private BemRepository bemRepository;
    private SetorRepository setorRepository;

    public BemService(BemRepository bemRepository, SetorRepository setorRepository) {
        this.bemRepository = bemRepository;
        this.setorRepository = setorRepository;
    }

    public void adicionarBem(Bem bem) {
        bemRepository.save(bem);
    }

    public void atualizarBem(Bem bemAtualizado) {
        bemRepository.update(bemAtualizado);
    }

    public void removerBem(int id) {
        bemRepository.delete(id);
    }

    public Bem obterBemPorId(int id) {
        return bemRepository.findById(id);
    }

    public List<Bem> listarTodosBens() {
        return bemRepository.findAll();
    }

    public void transferirBem(int idBem, int idNovoSetor) {
        Bem bem = obterBemPorId(idBem);
        Setor novoSetor = setorRepository.findById(idNovoSetor);

        if (bem != null && novoSetor != null) {
            Setor setorAtual = bem.getSetor();
            if (setorAtual != null) {
                setorRepository.devolverBem(setorAtual, bem);
            }
            setorRepository.solicitarTransferenciaBem(setorAtual, novoSetor, bem);
            bem.setSetor(novoSetor);
            atualizarBem(bem);
        } else {
            if (bem == null) {
                System.out.println("Bem com ID " + idBem + " não encontrado.");
            }
            if (novoSetor == null) {
                System.out.println("Setor com ID " + idNovoSetor + " não encontrado.");
            }
        }
    }

    public BemRepository getBemRepository() {
        return bemRepository;
    }

    public void setBemRepository(BemRepository bemRepository) {
        this.bemRepository = bemRepository;
    }

    public SetorRepository getSetorRepository() {
        return setorRepository;
    }

    public void setSetorRepository(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }
}

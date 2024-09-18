package main.java.com.gestaoPatrimonio.model.service;

import main.java.com.gestaoPatrimonio.model.entity.Bem;
import main.java.com.gestaoPatrimonio.model.entity.Setor;
import main.java.com.gestaoPatrimonio.model.repository.SetorRepository;

public class SetorService {
    private SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    public void gerarRelatoriosSetor(int idSetor) {
        Setor setor = setorRepository.findById(idSetor);
        if (setor != null) {
            setorRepository.gerarRelatorios(setor);
        } else {
            System.out.println("Setor com ID " + idSetor + " não encontrado.");
        }
    }

    public void receberBem(int idSetor, Bem bem) {
        Setor setor = setorRepository.findById(idSetor);
        if (setor != null) {
            setorRepository.receberBem(setor, bem);
        } else {
            System.out.println("Setor com ID " + idSetor + " não encontrado.");
        }
    }

    public void devolverBem(int idSetor, Bem bem) {
        Setor setor = setorRepository.findById(idSetor);
        if (setor != null) {
            setorRepository.devolverBem(setor, bem);
        } else {
            System.out.println("Setor com ID " + idSetor + " não encontrado.");
        }
    }

    public void solicitarTransferenciaBem(int idSetorOrigem, int idSetorDestino, Bem bem) {
        Setor setorOrigem = setorRepository.findById(idSetorOrigem);
        Setor setorDestino = setorRepository.findById(idSetorDestino);
        if (setorOrigem != null && setorDestino != null) {
            setorRepository.solicitarTransferenciaBem(setorOrigem, setorDestino, bem);
        } else {
            System.out.println("Um ou ambos os setores não foram encontrados.");
        }
    }

    public SetorRepository getSetorRepository() {
        return setorRepository;
    }

    public void setSetorRepository(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }
}

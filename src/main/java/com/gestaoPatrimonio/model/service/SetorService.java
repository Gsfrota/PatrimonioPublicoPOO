package main.java.com.gestaoPatrimonio.model.service;

import main.java.com.gestaoPatrimonio.model.entity.Bem;
import main.java.com.gestaoPatrimonio.model.entity.Setor;
import main.java.com.gestaoPatrimonio.model.repository.SetorRepository;

public class SetorService {
    private SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    //Método parar gerar relatorio
    public void gerarRelatoriosSetor(int idSetor) {
        Setor setor = setorRepository.findById(idSetor);
        if (setor != null) {
            setorRepository.gerarRelatorios(setor);
        } else {
            System.out.println("Setor com ID " + idSetor + " não encontrado.");
        }
    }

    // Método para receber um bem
    public void receberBem(int idSetor, Bem bem) {
        Setor setor = setorRepository.findById(idSetor);
        if (setor != null) {
            setorRepository.receberBem(setor, bem);
        } else {
            System.out.println("Setor com ID " + idSetor + " não encontrado.");
        }
    }

    // Método para devolver um bem
    public void devolverBem(int idSetor, Bem bem) {
        Setor setor = setorRepository.findById(idSetor);
        if (setor != null) {
            setorRepository.devolverBem(setor, bem);
        } else {
            System.out.println("Setor com ID " + idSetor + " não encontrado.");
        }
    }

    // Método para solicitar a transferência de um bem
    public void solicitarTransferenciaBem(int idSetorOrigem, int idSetorDestino, Bem bem) {
        Setor setorOrigem = setorRepository.findById(idSetorOrigem);
        Setor setorDestino = setorRepository.findById(idSetorDestino);
        if (setorOrigem != null && setorDestino != null) {
            setorRepository.solicitarTransferenciaBem(setorOrigem, setorDestino, bem);
        } else {
            System.out.println("Um ou ambos os setores não foram encontrados.");
        }
    }
    
}

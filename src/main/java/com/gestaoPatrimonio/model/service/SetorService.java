package main.java.com.gestaoPatrimonio.model.service;

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
            setor.gerarRelatorios();
        } else {
            System.out.println("Setor com ID " + idSetor + " não encontrado.");
        }
    }
}

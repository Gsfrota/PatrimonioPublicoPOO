package main.java.com.gestaoPatrimonio.model.service;

import java.util.List;

import main.java.com.gestaoPatrimonio.model.entity.Bem;
import main.java.com.gestaoPatrimonio.model.entity.Setor;
import main.java.com.gestaoPatrimonio.model.repository.BemRepository;

public class BemService {
    private BemRepository bemRepository;

    public BemService(BemRepository bemRepository) {
        this.bemRepository = bemRepository;
    }

    // Adiciona um novo bem
    public void adicionarBem(Bem bem) {
        bemRepository.save(bem);
    }

    // Atualiza um bem existente
    public void atualizarBem(Bem bemAtualizado) {
        bemRepository.update(bemAtualizado);
    }

    // Remove um bem por ID
    public void removerBem(int id) {
        bemRepository.delete(id);
    }

    // Consulta um bem por ID
    public Bem obterBemPorId(int id) {
        return bemRepository.findById(id);
    }

    // Obtém todos os bens
    public List<Bem> listarTodosBens() {
        return bemRepository.findAll();
    }

    // Transfere um bem para outro setor
    public void transferirBem(int idBem, Setor novoSetor) {
        Bem bem = obterBemPorId(idBem);
        if (bem != null) {
            bem.getSetor().solicitarTransferenciaBem(bem, novoSetor);
            bem.setSetor(novoSetor);  // Atualiza o setor do bem
            atualizarBem(bem);        // Atualiza o bem no repositório
        } else {
            System.out.println("Bem com ID " + idBem + " não encontrado.");
        }
    }
}

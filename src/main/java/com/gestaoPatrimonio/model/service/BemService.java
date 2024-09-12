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
    public void transferirBem(int idBem, int idNovoSetor) {
        Bem bem = obterBemPorId(idBem);
        Setor novoSetor = setorRepository.findById(idNovoSetor);

        if (bem != null && novoSetor != null) {
            Setor setorAtual = bem.getSetor();
            if (setorAtual != null) {
                setorRepository.devolverBem(setorAtual, bem); // Devolve o bem do setor atual
            }
            setorRepository.solicitarTransferenciaBem(setorAtual, novoSetor, bem); // Solicita a transferência para o novo setor
            bem.setSetor(novoSetor);  // Atualiza o setor do bem
            atualizarBem(bem);        // Atualiza o bem no repositório
        } else {
            if (bem == null) {
                System.out.println("Bem com ID " + idBem + " não encontrado.");
            }
            if (novoSetor == null) {
                System.out.println("Setor com ID " + idNovoSetor + " não encontrado.");
            }
        }
    }


}

package main.java.com.gestaoPatrimonio.model.service;

import main.java.com.gestaoPatrimonio.model.entity.Bem;
import main.java.com.gestaoPatrimonio.model.entity.Instituicao;
import main.java.com.gestaoPatrimonio.model.entity.Setor;
import main.java.com.gestaoPatrimonio.model.repository.InstituicaoRepository;

public class InstituicaoService {
    private InstituicaoRepository instituicaoRepository;

    public InstituicaoService(InstituicaoRepository instituicaoRepository) {
        this.instituicaoRepository = instituicaoRepository;
    }

    public void adicionarInstituicao(Instituicao instituicao) {
        instituicaoRepository.save(instituicao);
    }

    public void removerInstituicao(int id) {
        instituicaoRepository.delete(id);
    }

    public void atualizarInstituicao(Instituicao instituicao) {
        instituicaoRepository.update(instituicao);
    }

    public Instituicao obterInstituicaoPorId(int id) {
        return instituicaoRepository.findById(id);
    }

    public Instituicao obterInstituicaoPorNome(String nome) {
        return instituicaoRepository.findByNome(nome);
    }

    // Consulta um bem pelo ID na instituição
    public Bem consultarBem(int id) {
        return instituicaoRepository.consultarBem(id);
    }

    // Atualiza um bem na instituição
    public void atualizarBem(Bem bemAtualizado) {
        instituicaoRepository.atualizarBem(bemAtualizado);
    }

    // Transfere um bem para outro setor na instituição
    public void transferirBem(Bem bem, Setor novoSetor) {
        instituicaoRepository.transferirBem(bem, novoSetor);
    }

}

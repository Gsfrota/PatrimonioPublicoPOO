package main.java.com.gestaoPatrimonio.model.service;

import main.java.com.gestaoPatrimonio.model.entity.Instituicao;
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
}

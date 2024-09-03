public class InstituicaoService {
    private InstituicaoRepository repository;

    public InstituicaoService(InstituicaoRepository repository) {
        this.repository = repository;
    }

    public void criarInstituicao(Instituicao instituicao) {
        // Validações de negócio
        if (instituicao.getNome() == null || instituicao.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da instituição é obrigatório");
        }
        if (instituicao.getCnpj() == null || instituicao.getCnpj().trim().isEmpty()) {
            throw new IllegalArgumentException("CNPJ da instituição é obrigatório");
        }
        // Lógica adicional de negócio, se necessário
        repository.save(instituicao);
    }

    public Instituicao buscarInstituicao(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Instituição não encontrada"));
    }

    public void atualizarInstituicao(Instituicao instituicao) {
        // Validações de negócio
        if (instituicao.getId() == 0) {
            throw new IllegalArgumentException("ID da instituição é obrigatório para atualização");
        }
        // Lógica adicional de negócio, se necessário
        repository.update(instituicao);
    }

    public void deletarInstituicao(int id) {
        // Verificar se a instituição pode ser deletada (por exemplo, se não tem setores associados)
        repository.delete(id);
    }

    public List<Instituicao> listarInstituicoes() {
        return repository.findAll();
    }
}

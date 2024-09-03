public class SetorService {
    private SetorRepository repository;
    private BemRepository bemRepository;

    public SetorService(SetorRepository repository, BemRepository bemRepository) {
        this.repository = repository;
        this.bemRepository = bemRepository;
    }

    public void criarSetor(Setor setor) {
        // Validações de negócio
        if (setor.getNome() == null || setor.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do setor é obrigatório");
        }
        // Lógica adicional de negócio, se necessário
        repository.save(setor);
    }

    public Setor buscarSetor(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Setor não encontrado"));
    }

    public void atualizarSetor(Setor setor) {
        // Validações de negócio
        if (setor.getId() == 0) {
            throw new IllegalArgumentException("ID do setor é obrigatório para atualização");
        }
        // Lógica adicional de negócio, se necessário
        repository.update(setor);
    }

    public void deletarSetor(int id) {
        // Verificar se o setor pode ser deletado (por exemplo, se não tem bens associados)
        repository.delete(id);
    }

    public void transferirBem(int bemId, int setorOrigemId, int setorDestinoId) {
        Bem bem = bemRepository.findById(bemId)
                .orElseThrow(() -> new EntityNotFoundException("Bem não encontrado"));
        Setor setorOrigem = buscarSetor(setorOrigemId);
        Setor setorDestino = buscarSetor(setorDestinoId);

        // Lógica de negócio para transferência
        setorOrigem.removerBem(bem);
        setorDestino.adicionarBem(bem);
        bem.setSetor(setorDestino);

        bemRepository.update(bem);
        repository.update(setorOrigem);
        repository.update(setorDestino);
    }

    public List<Setor> listarSetores() {
        return repository.findAll();
    }
}

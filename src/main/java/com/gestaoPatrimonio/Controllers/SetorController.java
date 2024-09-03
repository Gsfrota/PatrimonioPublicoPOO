import java.util.List;

public class SetorController {
    private SetorRepository repository;
    private BemRepository bemRepository;

    public SetorController(SetorRepository repository, BemRepository bemRepository) {
        this.repository = repository;
        this.bemRepository = bemRepository;
    }

    public void criarSetor(String nome, String sigla, Usuario responsavel, String localizacao, String contato) {
        if (nome == null || nome.trim().isEmpty() || sigla == null || sigla.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome e sigla são obrigatórios");
        }

        Setor setor = new Setor();
        setor.setNome(nome);
        setor.setSigla(sigla);
        setor.setResponsavel(responsavel);
        setor.setLocalizacao(localizacao);
        setor.setContato(contato);

        repository.save(setor);
    }

    public Setor buscarSetor(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));
    }

    public void atualizarSetor(int id, String nome, String sigla, Usuario responsavel, String localizacao, String contato) {
        Setor setor = buscarSetor(id);

        if (nome != null && !nome.trim().isEmpty()) {
            setor.setNome(nome);
        }
        if (sigla != null && !sigla.trim().isEmpty()) {
            setor.setSigla(sigla);
        }
        setor.setResponsavel(responsavel);
        setor.setLocalizacao(localizacao);
        setor.setContato(contato);

        repository.update(setor);
    }

    public void deletarSetor(int id) {
        repository.delete(id);
    }

    public void transferirBem(int bemId, int setorOrigemId, int setorDestinoId) {
        Bem bem = bemRepository.findById(bemId)
                .orElseThrow(() -> new RuntimeException("Bem não encontrado"));
        Setor setorOrigem = buscarSetor(setorOrigemId);
        Setor setorDestino = buscarSetor(setorDestinoId);

        setorOrigem.devolverBem(bem);
        setorDestino.receberBem(bem);

        bemRepository.update(bem);
        repository.update(setorOrigem);
        repository.update(setorDestino);
    }

    public List<Setor> listarSetores() {
        return repository.findAll();
    }
}
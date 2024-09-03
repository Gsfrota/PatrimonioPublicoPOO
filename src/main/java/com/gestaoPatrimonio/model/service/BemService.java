import java.util.List;

public class BemService {
    private BemRepository repository;

    public BemService(BemRepository repository) {
        this.repository = repository;
    }

    public void registrarBem(Bem bem) {
        // Temos que colocar aqui Validações adicionais podem ser feitas aqui
        repository.save(bem);
    }

    public Bem consultarBem(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bem não encontrado"));
    }

    public void atualizarBem(Bem bem) {
        repository.update(bem);
    }

    public void deletarBem(int id) {
        repository.delete(id);
    }

    public List<Bem> listarBens() {
        return repository.findAll();
    }

    public void transferirBem(Bem bem, Setor novoSetor) {
        bem.setSetor(novoSetor);
        repository.update(bem);
    }

    public List<Bem> listarBensPorSetor(Setor setor) {
        return repository.findBySetor(setor);
    }
}
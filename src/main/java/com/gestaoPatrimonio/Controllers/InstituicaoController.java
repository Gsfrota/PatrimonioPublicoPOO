import java.util.List;

public class InstituicaoController {
    private InstituicaoRepository repository;

    public InstituicaoController(InstituicaoRepository repository) {
        this.repository = repository;
    }

    public void criarInstituicao(String nome, String cnpj) {
        if (nome == null || nome.trim().isEmpty() || cnpj == null || cnpj.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome e CNPJ são obrigatórios");
        }

        Instituicao instituicao = new Instituicao();
        instituicao.setNome(nome);
        instituicao.setCnpj(cnpj);

        repository.save(instituicao);
    }

    public Instituicao buscarInstituicao(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instituição não encontrada"));
    }

    public void atualizarInstituicao(int id, String nome, String cnpj) {
        Instituicao instituicao = buscarInstituicao(id);

        if (nome != null && !nome.trim().isEmpty()) {
            instituicao.setNome(nome);
        }
        if (cnpj != null && !cnpj.trim().isEmpty()) {
            instituicao.setCnpj(cnpj);
        }

        repository.update(instituicao);
    }

    public void deletarInstituicao(int id) {
        repository.delete(id);
    }

    public List<Instituicao> listarInstituicoes() {
        return repository.findAll();
    }
}
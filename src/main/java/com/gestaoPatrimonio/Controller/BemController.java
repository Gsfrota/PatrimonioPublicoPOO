import java.util.Date;
import java.util.List;

public class BemController {
    private BemRepository repository;

    public BemController(BemRepository repository) {
        this.repository = repository;
    }

    public void registrarBem(String descricao, String tipo, float valorAquisicao, Date dataAquisicao, String situacao, Usuario responsavel) {
        if (descricao == null || descricao.trim().isEmpty() || tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição e tipo são obrigatórios");
        }
        
        Bem bem = new Bem();
        bem.setDescricao(descricao);
        bem.setTipo(tipo);
        bem.setValorAquisicao(valorAquisicao);
        bem.setDataAquisicao(dataAquisicao);
        bem.setSituacao(situacao);
        bem.setResponsavel(responsavel);
        
        repository.save(bem);
    }

    public Bem consultarBem(int id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Bem não encontrado"));
    }

    public void atualizarBem(int id, String descricao, String tipo, float valorAquisicao, Date dataAquisicao, String situacao, Usuario responsavel) {
        Bem bem = consultarBem(id);
        
        if (descricao != null && !descricao.trim().isEmpty()) {
            bem.setDescricao(descricao);
        }
        if (tipo != null && !tipo.trim().isEmpty()) {
            bem.setTipo(tipo);
        }
        bem.setValorAquisicao(valorAquisicao);
        bem.setDataAquisicao(dataAquisicao);
        bem.setSituacao(situacao);
        bem.setResponsavel(responsavel);
        
        repository.update(bem);
    }

    public void deletarBem(int id) {
        repository.delete(id);
    }

    public List<Bem> listarBens() {
        return repository.findAll();
    }
}
import java.util.List;

public class Setor extends Instituicao{
    // Atributos
    private int id;
    private String nome;
    private String sigla;
    private Usuario responsavel;
    private String localizacao;
    private String contato;

    // Métodos
    public void receberBem(Bem bem) {
        // Implementação do método para receber um bem
        bens.add(bem);
        bem.setSituacao("Recebido");
        bem.setResponsavel(this.responsavel);
        System.out.println("Bem recebido: " + bem.getDescricao());
    }

    public void devolverBem(Bem bem) {
        // Implementação do método para devolver um bem
        bens.remove(bem);
        bem.setSituacao("Devolvido");
        bem.setResponsavel(null);
        System.out.println("Bem devolvido: " + bem.getDescricao());
    }

    public void solicitarTransferenciaBem(Bem bem, Setor setor) {
        // Implementação do método para solicitar transferência de um bem
        if (bens.contains(bem)) {
            bens.remove(bem);
            setor.receberBem(bem);
            System.out.println("Transferência solicitada para o bem: " + bem.getDescricao());
        } else {
            System.out.println("Bem não encontrado no setor atual.");
        }
    }

    public void gerarRelatorios(Setor setor) {
        // Implementação do método para gerar relatórios
        System.out.println("Relatório do Setor: " + setor.getNome());
        for (Bem bem : setor.getBens()) {
            System.out.println("ID: " + bem.getId() + ", Descrição: " + bem.getDescricao() +
                    ", Situação: " + bem.getSituacao() + ", Responsável: " +
                    (bem.getResponsavel() != null ? bem.getResponsavel().getNome() : "N/A"));
        }
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }
    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }


}

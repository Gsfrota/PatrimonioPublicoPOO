import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Bem {
    private int id;
    private String nome;
    private String descricao;
    private String tipo;
    private float valorAquisicao;
    private LocalDate dataRegistro;
    private String situacao;
    private Usuario responsavel;
    private Setor setor;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Bem(String nome, String descricao, String tipo, String dataRegistro) {
        this.id = (int) (Math.random() * 1000); // Gera um ID aleatório para o bem
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.situacao = "Novo bem";
        setDataRegistro(dataRegistro);
    }

    // Getters e setters existentes...

    public void setDataRegistro(String dataRegistro) {
        try {
            this.dataRegistro = LocalDate.parse(dataRegistro, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data inválido. Use dd/MM/yyyy.");
        }
    }

    public String getDataRegistro() {
        return dataRegistro.format(DATE_FORMATTER);
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return String.format("Bem: %s (ID: %d)%nTipo: %s%nData de registro: %s%nSituação: %s%nDescrição: %s",
                nome, id, tipo, getDataRegistro(), situacao, descricao);
    }
}
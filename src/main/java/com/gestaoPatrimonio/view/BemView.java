import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class BemView extends GridPane {
    private TextField nomeField = new TextField();
    private TextField descricaoField = new TextField();
    private TextField tipoField = new TextField();
    private TextField dataRegistroField = new TextField();
    private Button salvarButton = new Button("Salvar");
    private Button consultarButton = new Button("Consultar");
    private Button atualizarButton = new Button("Atualizar");
    private Button deletarButton = new Button("Deletar");
    private TextArea resultadoArea = new TextArea();

    public BemView() {
        setPadding(new Insets(10, 10, 10, 10));
        setVgap(5);
        setHgap(5);

        add(new Label("Nome:"), 0, 0);
        add(nomeField, 1, 0);
        add(new Label("Descrição:"), 0, 1);
        add(descricaoField, 1, 1);
        add(new Label("Tipo:"), 0, 2);
        add(tipoField, 1, 2);
        add(new Label("Data de Registro:"), 0, 3);
        add(dataRegistroField, 1, 3);
        add(salvarButton, 0, 4);
        add(consultarButton, 1, 4);
        add(atualizarButton, 0, 5);
        add(deletarButton, 1, 5);
        add(resultadoArea, 0, 6, 2, 1);

        resultadoArea.setEditable(false);
    }

    // Getters para os campos e botões
    public TextField getNomeField() {
        return nomeField;
    }

    public TextField getDescricaoField() {
        return descricaoField;
    }

    public TextField getTipoField() {
        return tipoField;
    }

    public TextField getDataRegistroField() {
        return dataRegistroField;
    }

    public Button getSalvarButton() {
        return salvarButton;
    }

    public Button getConsultarButton() {
        return consultarButton;
    }

    public Button getAtualizarButton() {
        return atualizarButton;
    }

    public Button getDeletarButton() {
        return deletarButton;
    }

    public TextArea getResultadoArea() {
        return resultadoArea;
    }
}
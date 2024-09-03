import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BemController {
    private BemView view;
    private BemService service;

    public BemController(BemView view, BemService service) {
        this.view = view;
        this.service = service;
        initListeners();
    }

    private void initListeners() {
        view.getSalvarButton().setOnAction(e -> registrarBem());
        view.getConsultarButton().setOnAction(e -> consultarBem());
        view.getAtualizarButton().setOnAction(e -> atualizarBem());
        view.getDeletarButton().setOnAction(e -> deletarBem());
    }

    private void registrarBem() {
        try {
            Bem bem = new Bem(
                    view.getNomeField().getText(),
                    view.getDescricaoField().getText(),
                    view.getTipoField().getText(),
                    view.getDataRegistroField().getText()
            );
            service.registrarBem(bem);
            mostrarMensagem("Bem registrado com sucesso!", AlertType.INFORMATION);
            limparCampos();
        } catch (Exception ex) {
            mostrarMensagem("Erro ao registrar bem: " + ex.getMessage(), AlertType.ERROR);
        }
    }

    private void consultarBem() {
        try {
            int id = Integer.parseInt(view.getNomeField().getText());
            Bem bem = service.consultarBem(id);
            view.getResultadoArea().setText(bem.toString());
        } catch (Exception ex) {
            mostrarMensagem("Erro ao consultar bem: " + ex.getMessage(), AlertType.ERROR);
        }
    }

    private void atualizarBem() {
        try {
            int id = Integer.parseInt(view.getNomeField().getText());
            Bem bem = service.consultarBem(id);
            bem.setDescricao(view.getDescricaoField().getText());
            bem.setTipo(view.getTipoField().getText());
            bem.setDataRegistro(view.getDataRegistroField().getText());
            service.atualizarBem(bem);
            mostrarMensagem("Bem atualizado com sucesso!", AlertType.INFORMATION);
        } catch (Exception ex) {
            mostrarMensagem("Erro ao atualizar bem: " + ex.getMessage(), AlertType.ERROR);
        }
    }

    private void deletarBem() {
        try {
            int id = Integer.parseInt(view.getNomeField().getText());
            service.deletarBem(id);
            mostrarMensagem("Bem deletado com sucesso!", AlertType.INFORMATION);
            limparCampos();
        } catch (Exception ex) {
            mostrarMensagem("Erro ao deletar bem: " + ex.getMessage(), AlertType.ERROR);
        }
    }

    private void limparCampos() {
        view.getNomeField().clear();
        view.getDescricaoField().clear();
        view.getTipoField().clear();
        view.getDataRegistroField().clear();
        view.getResultadoArea().clear();
    }

    private void mostrarMensagem(String mensagem, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
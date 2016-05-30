package br.com.manutencao.produtividade.view;

import br.com.manutencao.produtividade.ProdutividadeTools;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class RootLayoutController {

    // Reference to the main application
    private ProdutividadeTools mainApp;

    public void setMainApp(ProdutividadeTools mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleShowProdutividadeRecursoMesStatistics() {
    	mainApp.showProdutividadeRecursoMesStatistics();
    }

    @FXML
    private void handleAbout() {
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Ferramente de Produtividade");
        alert.setHeaderText("Sobre");
        alert.setContentText("Autor: Tiago Arrosi\n Github: https://github.com/tiago-arrosi");

        alert.showAndWait();
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
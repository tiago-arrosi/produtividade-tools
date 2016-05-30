package br.com.manutencao.produtividade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import br.com.manutencao.produtividade.data.LiberacaoChamadoData;
import br.com.manutencao.produtividade.excel.LoadDataExcelFile;
import br.com.manutencao.produtividade.grafico.GraficoProdutividadeRecursoMes;
import br.com.manutencao.produtividade.view.BirthdayStatisticsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProdutividadeTools extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();
    }
	
    /**
     * Inicializa o root layout (layout base).
     */
    public void initRootLayout() {
        try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ProdutividadeTools.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Mostra a scene (cena) contendo oroot layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Abre uma janela para mostrar as estatísticas de aniversário.
     */
    public void showProdutividadeRecursoMesStatistics() {
        try {
            // Carrega o arquivo fxml e cria um novo palco para o popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ProdutividadeTools.class.getResource("view/ProdutividadeRecursoMesStatistics.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Birthday Statistics");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Define a pessoa dentro do controller.
            BirthdayStatisticsController controller = loader.getController();
            
            List<LiberacaoChamadoData> listaChamados = new LoadDataExcelFile().carregaDados(LoadDataExcelFile.EXCEL_FILE_PATH);
            controller.setChamadosData(listaChamados);

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	/**
     * Retorna o palco principal.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
	
	public static void main(String[] args) {
		//new ProdutividadeTools().run();
		launch();
	}
	
	private void run() {
		try {
			List<LiberacaoChamadoData> listaChamados = new LoadDataExcelFile().carregaDados(LoadDataExcelFile.EXCEL_FILE_PATH);
			
			for (LiberacaoChamadoData liberacaoChamadoData : listaChamados) {
				System.out.println("Chamado: " + liberacaoChamadoData.getChamado() + " - Recurso: " + liberacaoChamadoData.getRecurso().getNome());
			}
			
			new  GraficoProdutividadeRecursoMes().show(listaChamados);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} 
	}
	
}

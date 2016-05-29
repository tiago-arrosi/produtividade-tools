package br.com.manutencao.produtividade.grafico;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.manutencao.produtividade.data.LiberacaoChamadoData;
import br.com.manutencao.produtividade.data.MonthlyProductivityData;
import br.com.manutencao.produtividade.data.TransformData;
import br.com.manutencao.produtividade.enumeration.TeamEnum;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class GraficoProdutividadeRecursoMes extends Application {
	
	private List<LiberacaoChamadoData> listaChamados;
	
	public GraficoProdutividadeRecursoMes() {
		
	}
	
	public void show(List<LiberacaoChamadoData> listaChamados) {
		this.listaChamados = listaChamados;
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Produtividade Entrega Chamados 2016");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Mês");
        
        final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
       
        lineChart.setTitle("Produtividade Entrega Chamados 2016");
                          
        Scene scene  = new Scene(lineChart,800,600);       
        lineChart.getData().addAll(loadData());
       
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	private List<XYChart.Series<String,Number>> loadData() {
		Map<TeamEnum, MonthlyProductivityData> data = TransformData.transformDataTeamMonthlyProductivity(this.listaChamados);
		List<XYChart.Series<String,Number>> chartList = new ArrayList<XYChart.Series<String,Number>>();
		
		for (MonthlyProductivityData monthlyData : data.values()) {
			XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
	        series1.setName(monthlyData.getPerson().getNome());
	        
	        for (Map.Entry<Month, Integer> monthMap : monthlyData.getMonthQuantity().entrySet()) {
	        	series1.getData().add(new XYChart.Data<String,Number>(monthMap.getKey().toString(), monthMap.getValue()));
			}
	        
	        chartList.add(series1);
		}
        
        return chartList;
	}

}

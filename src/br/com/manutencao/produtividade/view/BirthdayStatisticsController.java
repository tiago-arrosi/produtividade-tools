package br.com.manutencao.produtividade.view;

import java.time.Month;
import java.util.List;
import java.util.Map;

import br.com.manutencao.produtividade.data.LiberacaoChamadoData;
import br.com.manutencao.produtividade.data.MonthlyProductivityData;
import br.com.manutencao.produtividade.data.TransformData;
import br.com.manutencao.produtividade.enumeration.MonthEnum;
import br.com.manutencao.produtividade.enumeration.TeamEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class BirthdayStatisticsController {

    @FXML
    private LineChart<String, Integer> lineChart;

    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> monthNames = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        MonthEnum[] months = MonthEnum.values();
        
        for (MonthEnum monthEnum : months) {
        	monthNames.addAll(monthEnum.getNome());
		}
        
        xAxis.setCategories(monthNames);
    }

    public void setChamadosData( List<LiberacaoChamadoData> listaChamados) {
    	Map<TeamEnum, MonthlyProductivityData> data = TransformData.transformDataTeamMonthlyProductivity(listaChamados);
    	
		for (MonthlyProductivityData monthlyData : data.values()) {
			XYChart.Series<String,Integer> series = new XYChart.Series<String,Integer>();
	        series.setName(monthlyData.getPerson().getNome());
	        
	        for (Map.Entry<Month, Integer> monthMap : monthlyData.getMonthQuantity().entrySet()) {
	        	series.getData().add(new XYChart.Data<String,Integer>(monthMap.getKey().toString(), monthMap.getValue()));
			}
	        
	        lineChart.getData().add(series);
		}
    }
}
package br.com.manutencao.produtividade.view;

import java.text.DateFormatSymbols;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import br.com.manutencao.produtividade.data.LiberacaoChamadoData;
import br.com.manutencao.produtividade.data.MonthlyProductivityData;
import br.com.manutencao.produtividade.data.TransformData;
import br.com.manutencao.produtividade.enumeration.TeamEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
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
        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
        monthNames.addAll(Arrays.asList(months));
        xAxis.setCategories(monthNames);
    }

    public void setChamadosData( List<LiberacaoChamadoData> listaChamados) {
    	Map<TeamEnum, MonthlyProductivityData> data = TransformData.transformDataTeamMonthlyProductivity(listaChamados);
    	
		List<XYChart.Series<String,Integer>> chartList = new ArrayList<XYChart.Series<String,Integer>>();
		
		for (MonthlyProductivityData monthlyData : data.values()) {
			XYChart.Series<String,Integer> series1 = new XYChart.Series<String,Integer>();
	        series1.setName(monthlyData.getPerson().getNome());
	        
	        for (Map.Entry<Month, Integer> monthMap : monthlyData.getMonthQuantity().entrySet()) {
	        	series1.getData().add(new XYChart.Data<String,Integer>(monthMap.getKey().toString(), monthMap.getValue()));
			}
	        
	        chartList.add(series1);
		}
        
        //return chartList;
        lineChart.getData().addAll(chartList);
    	
    	/*
        int[] monthCounter = new int[12];
        
        for (Person p : persons) {
            int month = p.getBirthday().getMonthValue() - 1;
            monthCounter[month]++;
        }

        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
        for (int i = 0; i < monthCounter.length; i++) {
        	series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
        }
        
        barChart.getData().add(series);
        */
    }
}
package br.com.manutencao.produtividade.data;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.manutencao.produtividade.enumeration.TeamEnum;

public class TransformData {

	public static Map<TeamEnum, MonthlyProductivityData> transformDataTeamMonthlyProductivity(List<LiberacaoChamadoData> enterList) {
		Map<TeamEnum, MonthlyProductivityData> monthlyProductivityMap = new HashMap<TeamEnum, MonthlyProductivityData>();
		
		for (LiberacaoChamadoData chamadoData : enterList) {
			if (!monthlyProductivityMap.containsKey(chamadoData.getRecurso())) {
				monthlyProductivityMap.put(chamadoData.getRecurso(), new MonthlyProductivityData(chamadoData.getRecurso()));
			}
			
			monthlyProductivityMap.get(chamadoData.getRecurso()).increaseMonthQuantity(Month.of(chamadoData.getDataLiberacao().getMonthOfYear()));
		}
		
		return monthlyProductivityMap;
	}
}

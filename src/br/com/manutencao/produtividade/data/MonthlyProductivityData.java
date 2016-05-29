package br.com.manutencao.produtividade.data;

import java.time.Month;
import java.util.Map;

import br.com.manutencao.produtividade.enumeration.TeamEnum;

public class MonthlyProductivityData {
	
	private TeamEnum person;
	private Map<Month, Integer> monthQuantity;
	
	public MonthlyProductivityData(TeamEnum person) {
		super();
		this.person = person;
	}

	public TeamEnum getPerson() {
		return person;
	}
	
	public Integer getQuantity(Month mounth) {
		if (this.monthQuantity.containsKey(mounth)) {
			return this.monthQuantity.get(mounth);
		}
		
		return 0;
	}

	public void increaseMonthQuantity(Month mounth) {
		if (!this.monthQuantity.containsKey(mounth)) {
			this.monthQuantity.put(mounth, 0);
		}
		
		this.monthQuantity.put(mounth, getQuantity(mounth) + 1);
	}

	public Map<Month, Integer> getMonthQuantity() {
		return monthQuantity;
	}
}

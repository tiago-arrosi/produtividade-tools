package br.com.manutencao.produtividade.enumeration;

public enum MonthEnum {
	
	JAN(1, "Janeiro"),
	FEB(2, "Fevereiro"),
	MAR(3, "Março"),
	APR(4, "Abril"),
	MAI(5, "Maio"),
	JUN(6, "Junho"),
	JUL(7, "Julho"),
	AUG(8, "Agosto"),
	SEP(9, "Setembro"),
	OCT(10, "Outubro"),
	NOV(11, "Novembro"),
	DEC(12, "Dezembro");
	
	private String nome;
	private int monthNumber;
	
	private MonthEnum(int number, String nome) {
		this.nome = nome;
		this.monthNumber = monthNumber;
	}

	public String getNome() {
		return nome;
	}
	
	public int getMonthNumber() {
		return monthNumber;
	}

}

package br.com.manutencao.produtividade.enumeration;

public enum MonthEnum {
	
	JAN(1, "JANUARY"),
	FEB(2, "FEBRUARY"),
	MAR(3, "MARCH"),
	APR(4, "APRIL"),
	MAI(5, "MAY"),
	JUN(6, "JUNE"),
	JUL(7, "JULY"),
	AUG(8, "AUGUST"),
	SEP(9, "SEPTEMBER"),
	OCT(10, "OCTOBER"),
	NOV(11, "NOVEMBER"),
	DEC(12, "DECEMBER");
	
	private String nome;
	private int monthNumber;
	
	private MonthEnum(int number, String nome) {
		this.nome = nome;
		this.monthNumber = number;
	}

	public String getNome() {
		return nome;
	}
	
	public int getMonthNumber() {
		return monthNumber;
	}

}

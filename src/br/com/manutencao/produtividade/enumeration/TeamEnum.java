package br.com.manutencao.produtividade.enumeration;

public enum TeamEnum {

	TFR1BL("Tiago Arrosi"), 
	T01218("Marcelo Menegat"),
	T05099("Jean Marks"),
	SI0963("Angelo Silva"),
	T06618("Cleiton Pasquali"),
	T01172("Rafael Stoffels"),
	T03466("Rogerio Guimaraes"),
	T05342("Felipe Golin"),
	T109CJ("Peter Rizzon"),
	T109X5("Daniane Gomes");
	
	private String nome;
	
	private TeamEnum(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}

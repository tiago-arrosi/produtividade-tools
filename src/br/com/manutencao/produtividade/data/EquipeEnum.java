package br.com.manutencao.produtividade.data;

public enum EquipeEnum {

	TFR1BL("Tiago Arrosi"), 
	T01218("Marcelo Menegat"),
	T05099("Jean Marks"),
	SI0963("Angelo Silva"),
	T06618("Cleiton Pasquali"),
	T01172("Rafael Stoffels"),
	T03466("Rog�rio Guimar�es"),
	T05342("Felipe Golin"),
	T109CJ("Peter Rizzon"),
	T109X5("Daniane Gomes");
	
	private String nome;
	
	private EquipeEnum(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}

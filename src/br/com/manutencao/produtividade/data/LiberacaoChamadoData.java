package br.com.manutencao.produtividade.data;

import org.joda.time.DateTime;

import br.com.manutencao.produtividade.enumeration.TeamEnum;

public class LiberacaoChamadoData {

	private TeamEnum recurso;
	private String chamado;
	private DateTime dataLiberacao;
	private DateTime dataSLA;
	private DateTime dataFNC;
	
	public LiberacaoChamadoData(TeamEnum recurso, String chamado, DateTime dataLiberacao, DateTime dataSLA,
			DateTime dataFNC) {
		this.recurso = recurso;
		this.chamado = chamado;
		this.dataLiberacao = dataLiberacao;
		this.dataSLA = dataSLA;
		this.dataFNC = dataFNC;
	}

	public LiberacaoChamadoData() {
	}

	public TeamEnum getRecurso() {
		return recurso;
	}


	public void setRecurso(TeamEnum recurso) {
		this.recurso = recurso;
	}


	public String getChamado() {
		return chamado;
	}


	public void setChamado(String chamado) {
		this.chamado = chamado;
	}


	public DateTime getDataLiberacao() {
		return dataLiberacao;
	}


	public void setDataLiberacao(DateTime dataLiberacao) {
		this.dataLiberacao = dataLiberacao;
	}


	public DateTime getDataSLA() {
		return dataSLA;
	}


	public void setDataSLA(DateTime dataSLA) {
		this.dataSLA = dataSLA;
	}


	public DateTime getDataFNC() {
		return dataFNC;
	}


	public void setDataFNC(DateTime dataFNC) {
		this.dataFNC = dataFNC;
	}
	
	
}

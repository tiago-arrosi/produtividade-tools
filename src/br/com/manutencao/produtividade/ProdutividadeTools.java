package br.com.manutencao.produtividade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import br.com.manutencao.produtividade.data.LiberacaoChamadoData;
import br.com.manutencao.produtividade.excel.LoadDataExcelFile;
import br.com.manutencao.produtividade.grafico.GraficoProdutividadeRecursoMes;

public class ProdutividadeTools {

	public static void main(String[] args) {
		new ProdutividadeTools().run();
	}
	
	private void run() {
		try {
			List<LiberacaoChamadoData> listaChamados = new LoadDataExcelFile().carregaDados(LoadDataExcelFile.EXCEL_FILE_PATH);
			
			for (LiberacaoChamadoData liberacaoChamadoData : listaChamados) {
				System.out.println("Chamado: " + liberacaoChamadoData.getChamado() + " - Recurso: " + liberacaoChamadoData.getRecurso().getNome());
			}
			
			new  GraficoProdutividadeRecursoMes().show(listaChamados);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} 
	}
	
}

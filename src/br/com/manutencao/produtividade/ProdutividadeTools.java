package br.com.manutencao.produtividade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import br.com.manutencao.produtividade.data.LiberacaoChamadoData;
import br.com.manutencao.produtividade.excel.CarregaDadosPlanilha;

public class ProdutividadeTools {

	public static void main(String[] args) {
		new ProdutividadeTools().run();
	}
	
	private void run() {
		try {
			List<LiberacaoChamadoData> listaChamados = new CarregaDadosPlanilha().carregaDados(CarregaDadosPlanilha.EXCEL_FILE_PATH);
			
			for (LiberacaoChamadoData liberacaoChamadoData : listaChamados) {
				System.out.println("Chamado: " + liberacaoChamadoData.getChamado() + " - Recurso: " + liberacaoChamadoData.getRecurso().getNome());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

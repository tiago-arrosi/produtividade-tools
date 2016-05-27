package br.com.manutencao.produtividade.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;

import br.com.manutencao.produtividade.data.EquipeEnum;
import br.com.manutencao.produtividade.data.LiberacaoChamadoData;

public class CarregaDadosPlanilha {

	private static final String EXCEL_FILE_PATH = "K:/Home/Manuten��o/INDICADORES/Controles_Gerias_Manuten��o.xlsx";
	
	public static void main(String[] args) throws IOException {
		List<LiberacaoChamadoData> listaChamados = new CarregaDadosPlanilha().lePlanilha(EXCEL_FILE_PATH);
		
		for (LiberacaoChamadoData liberacaoChamadoData : listaChamados) {
			System.out.println("Chamado: " + liberacaoChamadoData.getChamado() + " - Recurso: " + liberacaoChamadoData.getRecurso().getNome());
		}
    }

	private List<LiberacaoChamadoData> lePlanilha(String excelFilePath) throws FileNotFoundException, IOException {
		List<LiberacaoChamadoData> listaChamados = new ArrayList<LiberacaoChamadoData>();
		
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
         
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        iterator.next(); //pula linha do cabe�alho
         
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            LiberacaoChamadoData chamadoData = leLinha(nextRow);
            
            if (chamadoData != null) {
            	listaChamados.add(chamadoData);
            }
        }
         
        workbook.close();
        inputStream.close();
        
        return listaChamados;
	}

	private LiberacaoChamadoData leLinha(Row nextRow) {
		if (!getCellValue(nextRow.getCell(0)).equals("")) {
			LiberacaoChamadoData chamadoData = new LiberacaoChamadoData();
			
			chamadoData.setChamado((String) getCellValue(nextRow.getCell(0)));
			chamadoData.setRecurso(EquipeEnum.valueOf((String) getCellValue(nextRow.getCell(1))));
			
			try {
				chamadoData.setDataFNC(new DateTime(getCellValue(nextRow.getCell(4))));
			} catch (Exception e) {
			}
			
			try {
				chamadoData.setDataSLA(new DateTime(getCellValue(nextRow.getCell(5))));
			} catch (Exception e) {
			}
			
			try {
				chamadoData.setDataLiberacao(new DateTime(getCellValue(nextRow.getCell(6))));
			} catch (Exception e) {
			}
			
			return chamadoData;
		}
		
		return null;
	}	
	
	private Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
	        case Cell.CELL_TYPE_STRING:
	            return cell.getStringCellValue();
	        case Cell.CELL_TYPE_NUMERIC:
	            return cell.getDateCellValue();
	    }
		
		return "";
	}
}
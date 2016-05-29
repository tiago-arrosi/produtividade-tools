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

import br.com.manutencao.produtividade.data.LiberacaoChamadoData;
import br.com.manutencao.produtividade.enumeration.TeamEnum;

public class LoadDataExcelFile {

	public static final String EXCEL_FILE_PATH = "files/Carga-Dados.xlsx";
	
	public List<LiberacaoChamadoData> carregaDados(String pathPlanilha) throws FileNotFoundException, IOException {
		return lePlanilha(pathPlanilha);
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
			chamadoData.setRecurso(TeamEnum.valueOf((String) getCellValue(nextRow.getCell(1))));
			
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

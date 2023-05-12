package Game;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class writeData {
	
	public static void addData(Player player,int totalPoint){
		String fp="D:\\Java\\Java Projects\\Assesment\\src\\GameData\\GameData.xls"; 
		try {
			FileInputStream excelFilePath= new FileInputStream(fp);
			Workbook wb = null;
			try {
				wb = WorkbookFactory.create(excelFilePath);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Sheet sheet=wb.getSheetAt(0);
			int lastRowCount=sheet.getLastRowNum();
//			System.out.println("last row count"+lastRowCount);
			
			Row r= sheet.createRow(++lastRowCount);
			int i=0;
			r.createCell(i++).setCellValue(player.name);
			r.createCell(i++).setCellValue(player.age);
			r.createCell(i++).setCellValue(totalPoint);
			r.createCell(i++).setCellValue(player.strategy*20);
			r.createCell(i++).setCellValue(player.eyefordetail*20);
			r.createCell(i++).setCellValue(player.resilience*20);
			r.createCell(i++).setCellValue(player.puzzlesSolved);
			r.createCell(i++).setCellValue(player.enemiesDefeated);
			r.createCell(i++).setCellValue(player.xp);
			r.createCell(i++).setCellValue(player.gold);
			//turning off the file input stream;
			try {
				excelFilePath.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//filling the values in the excel sheet;
			FileOutputStream fos= new FileOutputStream(fp);
			try {
				wb.write(fos);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

	}

}

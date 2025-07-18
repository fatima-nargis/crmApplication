package com.comcast.crm_generic_fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getStringDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testData/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();	
		return data;
	}
	public int getIntDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testData/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int data = (int)wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();	
		return data;
	}
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount =wb.getSheet(sheetName).getLastRowNum();
		return rowCount;

	}
	public void setDataIntoExcel(String sheetName, int rowNum,Integer celNum, String data) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./testData/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		
		FileOutputStream fos = new FileOutputStream("./testData/Book1.xlsx");
		wb.write(fos);
		wb.close();
	}

}

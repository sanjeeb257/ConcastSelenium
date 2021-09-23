package com.vtiger.Altern.GenericUtilities;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This file having the genric method to read and write the date from excel sheets.
 * @author sanje
 *
 */

public class ExcelFileUtility {
/**
 * ths method will read data from excel sheet wrt to row number and cell number
 * @throws IOException 
 * @throws EncryptedDocumentException 
 */
	public String getExcelData(String SheetName, int rownum, int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream(IPathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(SheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
	    String value = cell.getStringCellValue();
	    
		
		return value;
		
	}
	/**
	 * this method will read the data from excel sheet wrt to row and cell number .
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] getExcelData(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream(IPathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(SheetName);
		int lastrow = sheet.getLastRowNum();
		int lastcell = sheet.getRow(0).getLastCellNum();
	   
	Object[][] data=new Object[lastrow][lastcell];
	    
		
		return data;
		
	}
}



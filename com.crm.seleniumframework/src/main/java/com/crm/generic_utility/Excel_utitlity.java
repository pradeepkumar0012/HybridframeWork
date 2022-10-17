package com.crm.generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this method is used to fetch the data from excel sheet
 * @author Lenovo
 *
 */

public class Excel_utitlity {
	public String getExcelData(String sheetname,int Rownum,int cellnum) throws Throwable, IOException {
		//FileInputStream fis1= new FileInputStream("./Book1.xlsx");
		FileInputStream fis1=new FileInputStream(ipathConstant.Excel_path);
		Workbook book= WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet(sheetname);
		Row row = sh.getRow(Rownum);
		Cell cell = row.getCell(cellnum);
		
		String data = cell.getStringCellValue();
		return data;
		
		

	}
	/*public String fetchData(String Sheetname,int Rownum,int cellnum) throws Throwable {
		FileInputStream fis1= new FileInputStream("./Book1.xlsx");
		Workbook book= WorkbookFactory.create(fis1);
		DataFormatter format=new DataFormatter();
		
		return format.formatCellValue(book.getSheet(Sheetname).getRow(Rownum).getCell(cellnum));
		
	}*/
	public String getExceldata2(String sheetname,int Rownum,int cellnum) throws Throwable
	{
		//FileInputStream fis2= new FileInputStream("./Campaign.xlsx");
		FileInputStream fis2=new FileInputStream(ipathConstant.Excel_path1);
		Workbook book1= WorkbookFactory.create(fis2);
		Sheet sheet1 = book1.getSheet(sheetname);
		Row row1 = sheet1.getRow(Rownum);
		Cell cell1 = row1.getCell(cellnum);
		String value= cell1.getStringCellValue();
		return value;
	}

}


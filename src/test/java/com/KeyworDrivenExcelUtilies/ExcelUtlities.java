package com.KeyworDrivenExcelUtilies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtlities {
	static FileInputStream file;
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;
	static XSSFCell cell;
	public static String locatorName;
	public static String locatorValue;
	public static String locatorCloumnValue;
	public static String keywordCloumnValue;
	public static String dataCloumnValue;

	public static void main(String[] args) throws IOException {
		readExcel();
		

	}
	
	// unused main method
	public static void readExcel() throws IOException{
		
//				FileInputStream file = new FileInputStream("D://Rajesh//Selenium Projects//ProjectKewWordDriven//Resources//TestCoreSheet.xlsx");
//				
//				//WorkBook
//			    XSSFWorkbook workBook=new XSSFWorkbook(file);
//			    XSSFSheet sheet=workBook.getSheet("Sheet1");
//			    XSSFCell cell=sheet.getRow(0).getCell(0);
//			    String cellValue =cell.getStringCellValue();
//			    System.out.println(cellValue);
	}
	//"D://Rajesh//Selenium Projects//ProjectKewWordDriven//Resources//TestCoreSheet.xlsx"
	
	// Reading file and reading Sheet
	public static void readFileLocation(String location) throws IOException{
		// File location
		file = new FileInputStream(location);
		
		//WorkBook
	    workBook=new XSSFWorkbook(file);
	    
	    //Sheet
	    sheet=workBook.getSheet("Sheet1");
	}
	
	// Reading row and cell value from sheet
	public static void readExcelValues(int rowNum ,int locatorColoumn,int keywordCloumn,int dataCloumn){
		
		locatorCloumnValue=sheet.getRow(rowNum).getCell(locatorColoumn).toString();
		//System.out.println(locatorCloumn);
		//String[] locatorCloumnValue=locatorCloumn.split("=");
		
		// Locator value is splited and stored as locator name and locator value which is used in locators class and Engine class
		// Splits the value if not value is NA
		if(!locatorCloumnValue.equals("NA")){
		locatorName=locatorCloumnValue.split("=")[0].trim();
		locatorValue=locatorCloumnValue.split("=")[1].trim();
		//System.out.println(locatorName+" "+locatorValue);
		
		}else
		{
			locatorName="NA";
			locatorValue="NA";
		}
		
		// Fetched the keyWord name from Excel Sheet
		keywordCloumnValue=sheet.getRow(rowNum).getCell(keywordCloumn).toString();
		
		// Fetched the dataValue from Excel Sheet
		dataCloumnValue=sheet.getRow(rowNum).getCell(dataCloumn).toString();
		
		System.out.println(locatorName+" : "+locatorValue+"  "+"Keyword"+" : "+keywordCloumnValue+"  "+"dataCloumn"+" : "+dataCloumnValue);
		// cell=sheet.getRow(rowNum).getCell(ColoumnNum);
		// String cellValue =cell.getStringCellValue();
		// System.out.println(cellValue);
		 //return cellValue;
	}
	
	
	

}

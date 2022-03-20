package com.CoreKeywordFile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;

import com.KeyworDrivenExcelUtilies.ExcelUtlities;
import com.KeyworDrivenExcelUtilies.Locators;

import actionsClass.OrangeHRM;

public class Engine {
	static OrangeHRM mainMethods;
	static Method[] allMethods;
	//static String keyWord;
	public static By locators;

	// Application URL
	static String URL="D://Rajesh//Selenium Projects//ProjectKewWordDriven//Resources//TestCoreSheet.xlsx";

	//***********************************************************reading and comparing keyword using Java reflection API***************************************//	

	public static void getKeyWordNamesFromMainActionClass(){
		// Create Object for Main Class where all action Methods are created
		mainMethods=new OrangeHRM();

		// Get all methods from main class using reflection API and store it in method Array
		allMethods=mainMethods.getClass().getMethods();
	}

	// Executing the Method if keyword from Excel matches the All methods from Main class
	public static void executeKeywordNames() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		// Looping throuh all methods
		for (int i = 0; i < allMethods.length; i++) {
            
			if(allMethods[i].getName().equalsIgnoreCase(ExcelUtlities.keywordCloumnValue)){

				// invoke method to call the particular function and run
				allMethods[i].invoke(mainMethods);
			}

		}
	}
    // identify the locator name in switch and add particular locator value which is captured from excelfile
	public static void findWebElementsToBeUsed(){


		switch(ExcelUtlities.locatorName){

		case "id":
			locators=Locators.getID(ExcelUtlities.locatorValue);
			break;
		case "name":
			locators=Locators.getName(ExcelUtlities.locatorValue);
			break;
		case "xpath":
			locators=Locators.getXpath(ExcelUtlities.locatorValue);
			break;
		case "linkText":
			locators=Locators.getLinkText(ExcelUtlities.locatorValue);
			break;
		case "classname":
			locators=Locators.getClassName(ExcelUtlities.locatorValue);
			break;

		}



	}

	// Main Class where Methods are called
	public static void main(String[] args) throws Exception {

		// Reading file using File location
		ExcelUtlities.readFileLocation(URL);

		// Calling getKeyWordNamesFromMainActionClass to get Keyword Names from Main class and storing it Method Array
		getKeyWordNamesFromMainActionClass();

		//Iterate until rows
		int locatorColoumn=3;
		int keywordCoumn=locatorColoumn+1;
		int dataCloumn=locatorColoumn+2;
		for (int row= 1; row <=5; row++) {


			//keyWord=ExcelUtlities.readExcelValues(row, locatorColoumn,keywordCoumn,dataCloumn);
			ExcelUtlities.readExcelValues(row, locatorColoumn,keywordCoumn,dataCloumn);
			
			// execute and finds all the webElements
			Engine.findWebElementsToBeUsed();
			
			// Calling executeKeywordNames to execute keyword if matches the keyword from excel and Main class
			executeKeywordNames();

			//*******************************************************below are replaced by Java reflection API***********************************************************//

			//		if(keyWord.equalsIgnoreCase("openBrowser")){
			//			OrangeHRM.openBrowser();
			//		}
			//		else if(keyWord.equalsIgnoreCase("enterURL")){
			//			OrangeHRM.enterURL();
			//		}
			//		else if(keyWord.equalsIgnoreCase("enterUserName")){
			//			OrangeHRM.enterUserName();
			//		}
			//		else if(keyWord.equalsIgnoreCase("enterPassword")){
			//			OrangeHRM.enterPassword();
			//		}
			//		else if(keyWord.equalsIgnoreCase("clickLogin")){
			//			OrangeHRM.clickLogin();
			//		}
			//		else{
			//			System.out.println("KeyWord doesnt match");
			//		}
			//		
		}

	}

}

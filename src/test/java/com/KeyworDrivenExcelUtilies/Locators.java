package com.KeyworDrivenExcelUtilies;

import org.openqa.selenium.By;

public class Locators {
	
	
	
	// Creating all locators By value so that according to locatorName which is called in Engine class and added 
	public static By getID(String locatorValue){
		return By.id(locatorValue);
	}
	
	public static By getName(String locatorValue){
		return By.name(locatorValue);
	}
   public static By getClassName(String locatorValue){
	   return By.className(locatorValue);
	}
   public static By getXpath(String locatorValue){
	   return By.xpath(locatorValue);
	}
   public static By getLinkText(String locatorValue){
	   return By.linkText(locatorValue);
	}

}

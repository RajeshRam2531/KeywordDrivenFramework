package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.CoreKeywordFile.Engine;
import com.KeyworDrivenExcelUtilies.ExcelUtlities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	static WebDriver driver;
	public static void main(String[] args) {


	}

	// Open Browser Method
	public static void openBrowser(){

		//		if(ExcelUtlities.dataCloumnValue.equalsIgnoreCase("chrome")){
		//		WebDriverManager.chromedriver().setup();
		//		
		//		driver=new ChromeDriver();
		//		}
		//		
		//		if(ExcelUtlities.dataCloumnValue.equalsIgnoreCase("ie")){
		//			WebDriverManager.iedriver().setup();
		//			
		//			driver=new InternetExplorerDriver();
		//			}
		//		if(ExcelUtlities.dataCloumnValue.equalsIgnoreCase("Edge")){
		//			WebDriverManager.edgedriver().setup();
		//			
		//			driver= new EdgeDriver();
		//			}

		// Open Browser from switch case which is read from excek sheet
		switch(ExcelUtlities.dataCloumnValue){
		case "chrome" :
			WebDriverManager.chromedriver().setup();

			driver=new ChromeDriver();
			break;

		case "ie" :
			WebDriverManager.iedriver().setup();

			driver=new InternetExplorerDriver();
			break;
		case "Firefox" :
			WebDriverManager.firefoxdriver().setup();

			driver=new FirefoxDriver();
			break;

		case "Edge" :
			WebDriverManager.edgedriver().setup();

			driver=new EdgeDriver();
			break;

		}

	}

	public static void enterURL(){
		driver.get(ExcelUtlities.dataCloumnValue);
		driver.manage().window().maximize();

	}

	public static void enterUserName(){
		WebElement username=driver.findElement(Engine.locators);
		username.sendKeys(ExcelUtlities.dataCloumnValue);

	}
	public static void enterPassword(){
		WebElement password=driver.findElement(Engine.locators);
		password.sendKeys(ExcelUtlities.dataCloumnValue);

	}

	public static void click(){
		WebElement loginButton=driver.findElement(Engine.locators);
		//loginButton.click();
		//driver.close();

	}



}

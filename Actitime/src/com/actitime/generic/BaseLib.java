package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {
	
	public WebDriver driver;
	
	@BeforeMethod
	@Parameters("browser")
	
	public void setUp(String browserName ){
browserName = GenericLib.getValue("browser");
		 if(browserName.equalsIgnoreCase("firefox"))
		  {
			driver= new FirefoxDriver();
			Reporter.log("firefox launched",true);
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log("chrome launched",true);
		}
		driver.manage().window().maximize();
		WaitStatementLib.iWaitForSecond(driver, 5);
		driver.get(GenericLib.getValue("testurl"));
		Reporter.log("Navigate to url", true);
	}
	
	@AfterMethod
	
	public void tearDown( ITestResult result )
	{
		if (result.isSuccess()){
			
			System.out.println("result is pass");
			}
		else{
			
		String fileName = result.getMethod().getMethodName();
		ScreenshotLib slib = new ScreenshotLib();
		slib.takeScreenshot(driver, fileName);
		Reporter.log("Screenshot has been taken", true);
		
	}
		driver.close();
		Reporter.log("Browser closed" ,true);
	}
		
		
	}
	
	
	
	
	
	
	
	
	



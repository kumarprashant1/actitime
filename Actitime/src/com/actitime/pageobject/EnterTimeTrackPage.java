package com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;



public class EnterTimeTrackPage extends BasePage {

	WebDriver driver;
	
	public EnterTimeTrackPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}
	public void verifyHPTitle(){
	String expTitle ="actiTIME - Enter Time-Track"	;
	String actTitle =driver.getTitle();
	Assert.assertEquals(actTitle, expTitle);
	Reporter.log("Home page titile should be verified", true);

		
		
	}
	
	

}

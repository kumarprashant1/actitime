package com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public  abstract class BasePage 

{
	@FindBy(xpath="//img[contains(@src,'default-logo.png')]")
	private WebElement logo;
	@FindBy(xpath="//div[text()='Tasks']")
	private WebElement Tasks;
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	
	
	public BasePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
	public void clickOnLogoutLink(){
		logoutLink.click();
	}
	public void verifyHPlogo(){
		Assert.assertTrue(logo.isDisplayed());
		Reporter.log("home page should be displayed",true);
		
	}
	public void clickOnTasks(){
		Tasks.click();
	}
	
}



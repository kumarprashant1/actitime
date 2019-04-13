package com.actitime.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class ActiveProjAndCustoPage extends BasePage{
	@FindBy(css="Input[value='Create New Customer']")
   private WebElement createNewCustBtn;
	@FindBy(className ="successmsg")
	private WebElement successMsg;
	@FindBy(name="selectedCustomer") 
	private  WebElement custDrpDwn; 
	@FindBy(css="input[value*='Show']")
	private WebElement showBtn;
	
	@FindBy(xpath="//td[starts-with(@id,'customerNameCell')]//a[contains(@href,'customerId')]")
	private List<WebElement>   custNameLink;
	private Object customerName;
	
	public  ActiveProjAndCustoPage(WebDriver driver){
		
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCreateNewCustBtn(){
		createNewCustBtn.click();
		}
	public void verifyCreateCustMsg(String customerName){
	Assert.assertTrue(successMsg.isDisplayed());
	Reporter.log("create customer message is displayed", true);
	Assert.assertTrue(successMsg.getText().contains(customerName));
	Reporter.log(successMsg.getText(), true);
	}
public void showCustomer(String customerName){
	Select sel = new Select(custDrpDwn);
	sel.deselectByVisibleText(customerName);
	showBtn.click();
	}
public void clickOnCustNameLink(){
	
	if(custNameLink.isEmpty()){ //true 
	System.out.println("Customer does not exist");
	}
	else{
	int customerCount = custNameLink.size();
		System.out.println(customerCount);
		if(custNameLink.get(0).getText().equals(customerName))
		{
			custNameLink.get(0).click();
		}
		
	}
}
public void verifyDeleteCustMsg(){
	 String expmsg = "Customer has been successfully deleted"; 
	 String actMsg = successMsg.getText();
	 Assert.assertEquals(actMsg, expmsg);
	 Reporter.log(successMsg.getText(),true);
	
}
}
package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.pageobject.ActiveProjAndCustoPage;
import com.actitime.pageobject.CreateNewCustPage;
import com.actitime.pageobject.EditCustInfoPage;
import com.actitime.pageobject.EnterTimeTrackPage;
import com.actitime.pageobject.LoginPage;
import com.actitime.pageobject.OpenTasksPage;

public class TasksTest extends BaseLib {
	
  @Test
  public void CreateCustomer() {
	  String username = ExcelUtilities.readData("Sheet1", 3, 1);
	  String password = ExcelUtilities.readData("Sheet1", 3, 2);
	  
	  LoginPage lp=new LoginPage(driver);
	  lp.login(username, password);
	  
	  EnterTimeTrackPage ettp = new EnterTimeTrackPage(driver); 
	  ettp.clickOnTasks();
	  
	  
	  OpenTasksPage otp = new OpenTasksPage(driver);
	  otp.clickOnProjAndCustLink();
	  
	  
	ActiveProjAndCustoPage apcp = new  ActiveProjAndCustoPage(driver);
	  apcp.clickOnCreateNewCustBtn();
	  
	String customerName = ExcelUtilities.readData("sheet1", 3, 3);
    CreateNewCustPage cncp = new CreateNewCustPage(driver);
    cncp.createCustomer(customerName);
    
    
    apcp.verifyCreateCustMsg(customerName);
	apcp.clickOnLogoutLink();  
 
  }
  

@Test(dependsOnMethods={"CreateCustomer"})
public void deleteCustomer(){
String userName = ExcelUtilities.readData("Sheet1", 4, 1);
String password = ExcelUtilities.readData("Sheet1", 4, 2);
LoginPage lp = new LoginPage(driver);
lp.login(userName,password);
EnterTimeTrackPage ettp = new EnterTimeTrackPage(driver);
ettp.clickOnTasks();
OpenTasksPage otp = new OpenTasksPage(driver);
otp.clickOnProjAndCustLink();

String customerName = ExcelUtilities.readData("sheet1", 4, 3);
ActiveProjAndCustoPage apcp = new ActiveProjAndCustoPage(driver);
apcp.showCustomer(customerName);
apcp.clickOnCustNameLink();

EditCustInfoPage ecip = new EditCustInfoPage(driver);
ecip.deleeteCustomer();
apcp.verifyDeleteCustMsg();
apcp.clickOnLogoutLink();

}

}

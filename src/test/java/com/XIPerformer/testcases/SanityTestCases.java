package com.XIPerformer.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.XIPerformer.actiondrivers.DataProviderClass;
import com.XIPerformer.pageobject.HomePage;
import com.XIPerformer.pageobject.LoginPage;
import com.automation.base.BaseClass;

public class SanityTestCases extends BaseClass {
	
	LoginPage login;
	HomePage home;

	
	@BeforeClass
	public void setup() {
		initialization();
		login =new LoginPage();
		home =new HomePage();

		
	}
	

	@Test(priority = 1, enabled =true)
	public void loginjourney() throws InterruptedException {
	
		login.Login(prop.getProperty("username"), prop.getProperty("password"));

		
		
	}
	
	@Test(priority = 2, enabled = true, dataProvider = "ExeciseData", dataProviderClass = DataProviderClass.class)
	public void journey(String exercise, String categoryValue, String typeValue, String unitValue,
	                    String[] focusAreaValue, String instructionValue, String keyTipsValue,
	                    String uploadImageValue, String uploadVideoValue) throws InterruptedException {

	    home.PageHome(exercise, categoryValue, typeValue, unitValue, focusAreaValue,
	                  instructionValue, keyTipsValue, uploadImageValue, uploadVideoValue);
	}
	
	@Test(priority = 3, enabled =true)
	public void downloadExecise() throws InterruptedException {
		
		home.downloadExeciseList();


}

	
	

	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}

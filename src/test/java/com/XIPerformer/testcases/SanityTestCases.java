package com.XIPerformer.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.XIPerformer.actiondrivers.DataProviderClass;
import com.XIPerformer.pageobject.CombinationMasterPage;
import com.XIPerformer.pageobject.HomePage;
import com.XIPerformer.pageobject.LoginPage;
import com.automation.base.BaseClass;

public class SanityTestCases extends BaseClass {
	
	LoginPage login;
	HomePage home;
	CombinationMasterPage combinationMaster;

	
	@BeforeClass
	public void setup() {
		initialization();
		login =new LoginPage();
		home =new HomePage();
		combinationMaster = new CombinationMasterPage();

		
	}
	

	@Test(priority = 1, enabled =true)
	public void loginjourney() throws InterruptedException {
	
		login.Login(prop.getProperty("username"), prop.getProperty("password"));

		
		
	}
	
	@Test(priority = 2, enabled = false, dataProvider = "ExeciseData", dataProviderClass = DataProviderClass.class)
	public void execisejourney(String exercise, String categoryValue, String typeValue, String unitValue,
	                    String[] focusAreaValue, String instructionValue, String keyTipsValue,
	                    String uploadImageValue, String uploadVideoValue) throws InterruptedException {

	    home.PageHome(exercise, categoryValue, typeValue, unitValue, focusAreaValue,
	                  instructionValue, keyTipsValue, uploadImageValue, uploadVideoValue);
	}
	
	@Test(priority = 3, enabled =false)
	public void downloadExecise() throws InterruptedException {
		
		home.downloadExeciseList();


}

@Test(priority = 4, enabled = true)

public void combinationmasterClick() throws InterruptedException {
		
	combinationMaster.combinationmasterClick();


}

	@Test(priority = 5, enabled = true, dataProvider = "CombinationData", dataProviderClass = DataProviderClass.class)
	public void combinationMaster(String Combinationname, String Activity, String Privacy, String workoutname, String Techique, String images, String sets, String Rep, String time, String Reset, String recovery) throws InterruptedException {
		
		
		combinationMaster.cpmbinationMaster(Combinationname,Activity,Privacy,workoutname,Techique, images, sets, Rep,time,Reset, recovery );

	}
	
	@Test(priority = 6, enabled = true)

	public void submitButton() throws InterruptedException {
			
		combinationMaster.sumbitClick();


	}
	
	

	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}

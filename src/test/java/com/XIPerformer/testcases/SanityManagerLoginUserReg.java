package com.XIPerformer.testcases;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.XIPerformer.actiondrivers.DataProviderClass;
import com.XIPerformer.pageobject.LoginPage;
import com.XIPerformer.pageobject.UserRegister;
import com.XIPerformer.pageobject.UserRegisterNew;
import com.XIPerformer.util.ExtentTestManager;
import com.automation.base.BaseClass;



public class SanityManagerLoginUserReg  extends BaseClass {
	
	LoginPage login;
	UserRegisterNew userRegNew;

	

	@BeforeClass
	public void setup() {
		initialization();
		login = new LoginPage();
		userRegNew = new UserRegisterNew();
	}
	
	

	@Test(priority = 1, enabled = true)
	public void loginjourney() throws InterruptedException {

		login.Login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@Test(priority = 2, enabled = true, dataProvider = "UserRegCoachData",  dataProviderClass = DataProviderClass.class)
	public void userRegisterDetailsForCoach(Map<String, String> coachdata) throws InterruptedException {

	    ExtentTestManager.getTest().info("===== Input Data =====");

	    for (String key : coachdata.keySet()) {
	        ExtentTestManager.getTest().info(key + " : " + coachdata.get(key));
	    }

	    userRegNew.userCoachDetails(coachdata);
	}

	
	@Test(priority = 3, enabled = true, dataProvider = "UserRegPlayerData",  dataProviderClass = DataProviderClass.class)
	public void userRegisterDetailsForPlayer(Map<String, String> playerdata) throws InterruptedException {

	    ExtentTestManager.getTest().info("===== Input Data =====");

	    for (String key : playerdata.keySet()) {
	        ExtentTestManager.getTest().info(key + " : " + playerdata.get(key));
	    }

	    userRegNew.userPlayerDetails(playerdata);
	}
	
	
	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}

package com.XIPerformer.testcases;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.XIPerformer.actiondrivers.DataProviderClass;
import com.XIPerformer.pageobject.LoginPage;
import com.XIPerformer.pageobject.UserRegisterNew;
import com.XIPerformer.util.ExtentTestManager;
import com.automation.base.BaseClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class SanityManagerLoginUserReg  extends BaseClass {
	
	LoginPage login;
	UserRegisterNew userRegNew;
	private static final Logger log = LogManager.getLogger(SanityManagerLoginUserReg.class);

	

	@BeforeClass
	public void setup() {
		initialization();
		login = new LoginPage();
		userRegNew = new UserRegisterNew();
	}
	
	

	@Test(priority = 1, enabled = true)
	public void loginjourney() throws InterruptedException {
        log.info("Starting login test");
		login.Login(prop.getProperty("username"), prop.getProperty("password"));
        log.info("Completed login test");


	}
	
	@Test(priority = 2, enabled = true, dataProvider = "UserRegCoachData",  dataProviderClass = DataProviderClass.class)
	public void userRegisterDetailsForCoach(Map<String, String> coachdata) throws InterruptedException {

        log.info("Starting User Registration for Coach test");

	    ExtentTestManager.getTest().info("===== Input Data =====");

	    for (String key : coachdata.keySet()) {
	        ExtentTestManager.getTest().info(key + " : " + coachdata.get(key));
	    }

	    userRegNew.userCoachDetails(coachdata);
	    log.info("completed User Registration for Coach test");

	}
	

	
	@Test(priority = 3, enabled = true, dataProvider = "UserRegPlayerData",  dataProviderClass = DataProviderClass.class)
	public void userRegisterDetailsForPlayer(Map<String, String> playerdata) throws InterruptedException {

        log.info("Starting User Registration for Player test");
 
		ExtentTestManager.getTest().info("===== Input Data =====");

	    for (String key : playerdata.keySet()) {
	        ExtentTestManager.getTest().info(key + " : " + playerdata.get(key));
	    }

	    userRegNew.userPlayerDetails(playerdata);
	    log.info("completed User Registration for Player test");

	}
	
	
	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
        log.info("Browser closed");

	}

}

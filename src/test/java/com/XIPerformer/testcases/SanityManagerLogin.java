package com.XIPerformer.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.XIPerformer.actiondrivers.DataProviderClass;
import com.XIPerformer.pageobject.LoginPage;
import com.XIPerformer.pageobject.UserRegister;
import com.XIPerformer.util.ExtentTestManager;
import com.automation.base.BaseClass;



public class SanityManagerLogin  extends BaseClass {
	
	LoginPage login;
	UserRegister userRegister;

	

	@BeforeClass
	public void setup() {
		initialization();
		login = new LoginPage();
		userRegister = new UserRegister();
	}
	
	

	@Test(priority = 1, enabled = true)
	public void loginjourney() throws InterruptedException {

		login.Login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@Test(priority = 2, enabled = false, dataProvider = "UserCoachData", dataProviderClass = DataProviderClass.class)
	public void userRegisterDetailsForCoach(String fname, String lname, String gender, String bloodgroup, String email, String mobilenumber, String username, String password, String country, String state, String Address, String Role,String dob, String Degree, String Certification, String Event, String EventType, String SubEvent, String[] headers ) throws InterruptedException {
		Object[] values = new Object[]{
	            fname, lname, gender, bloodgroup, email, mobilenumber,
	            username, password, country, state, Address, Role,
	            dob, Degree, Certification, Event, EventType, SubEvent
	    };

	    ExtentTestManager.getTest().info("===== Input Data =====");

	    for (int i = 0; i < headers.length; i++) {
	        ExtentTestManager.getTest().info(headers[i] + " : " + values[i]);
	    }
		
		userRegister.userCoachDetails(fname, lname, gender, bloodgroup, email, mobilenumber,
	            username, password, country, state, Address, Role,
	            dob, Degree, Certification, Event, EventType, SubEvent);
	
	}
	
	
	@Test(priority = 3, enabled = false, dataProvider = "UserPlayerData", dataProviderClass = DataProviderClass.class) 
	public void userRegisterDetailsForPlayer(String fname, String lname, String gender, String bloodgroup, String email, String mobilenumber, String username, String password, String country, String state, String Address, String Role,String dob, String Relationship, String Parentname, String parentmobilrnum, String Education, String Edegree, String Height, String Weight, String coachname, String Event, String EventType, String SubEvent, String[] headers) throws InterruptedException {
		Object[] values = new Object[]{
				fname,lname,gender,bloodgroup,email,mobilenumber, username, password, country,state, 
				Address,Role,dob, Relationship,Parentname,parentmobilrnum,Education,Edegree, Height, 
				Weight, coachname, Event,EventType,SubEvent 
	    };

	    ExtentTestManager.getTest().info("===== Input Data =====");

	    for (int i = 0; i < headers.length; i++) {
	        ExtentTestManager.getTest().info(headers[i] + " : " + values[i]);
	    }
		
		userRegister.userPlayerDetails(fname,lname,gender,bloodgroup,email,mobilenumber, username, password, country,
				state, Address,Role,dob, Relationship,Parentname,parentmobilrnum,Education,Edegree, 
				Height, Weight, coachname, Event,EventType,SubEvent);
		
	}
	
	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}

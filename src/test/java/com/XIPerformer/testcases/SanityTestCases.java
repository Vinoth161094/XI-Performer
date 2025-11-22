package com.XIPerformer.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.XIPerformer.actiondrivers.DataProviderClass;
import com.XIPerformer.pageobject.CombinationMasterPage;
import com.XIPerformer.pageobject.HomePage;
import com.XIPerformer.pageobject.LoginPage;
import com.XIPerformer.pageobject.NewPreparationPage;
import com.automation.base.BaseClass;

public class SanityTestCases extends BaseClass {

	LoginPage login;
	HomePage home;
	CombinationMasterPage combinationMaster;
	NewPreparationPage newPreparationPage;

	@BeforeClass
	public void setup() {
		initialization();
		login = new LoginPage();
		home = new HomePage();
		combinationMaster = new CombinationMasterPage();
		newPreparationPage = new NewPreparationPage();

	}

	@Test(priority = 1, enabled = true)
	public void loginjourney() throws InterruptedException {

		login.Login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@Test(priority = 2, enabled = true)
	public void ExerciseMaster() throws InterruptedException {

		home.ExerciseMaster();

	}

	@Test(priority = 3, enabled = true, dataProvider = "ExeciseData", dataProviderClass = DataProviderClass.class)
	public void execisejourney(String exercise, String categoryValue, String typeValue, String unitValue,
			String[] focusAreaValue, String instructionValue, String keyTipsValue, String uploadImageValue,
			String uploadVideoValue) throws InterruptedException {

		home.PageHome(exercise, categoryValue, typeValue, unitValue, focusAreaValue, instructionValue, keyTipsValue,
				uploadImageValue, uploadVideoValue);
	}

	@Test(priority = 4, enabled = true)
	public void downloadExecise() throws InterruptedException {

		home.downloadExeciseList();

	}

	@Test(priority = 5, enabled = true)

	public void combinationmasterClick() throws InterruptedException {

		combinationMaster.combinationmasterClick();

	}

	@Test(priority = 6, enabled = true, dataProvider = "CombinationData", dataProviderClass = DataProviderClass.class)
	public void combinationMaster(String Combinationname, String Activity, String Privacy, String workoutname,
			String Techique, String images, String sets, String Rep, String time, String Reset, String recovery)
			throws InterruptedException {

		combinationMaster.cpmbinationMaster(Combinationname, Activity, Privacy, workoutname, Techique, images, sets,
				Rep, time, Reset, recovery);

	}

	@Test(priority = 7, enabled = true)

	public void submitButton() throws InterruptedException {

		combinationMaster.sumbitClick();

	}

	@Test(priority = 8, enabled = false, dataProvider = "NewPreparationData", dataProviderClass = DataProviderClass.class)

	public void newPreparation(String startDate, String endDate, String playerList, String session, String activity,
			String Combination, String workoutname, String Techique, String sets, String Rep, String time, String Reset,
			String covery) throws InterruptedException {

		newPreparationPage.newPreparation();
		newPreparationPage.assignPreparation(startDate, endDate, playerList, session, activity, Combination,
				workoutname, Techique, sets, Rep, time, Reset, covery);
	}

	@Test(priority = 9, enabled = false)

	public void assignButton() throws InterruptedException {

		newPreparationPage.assign();

	}

	@Test(priority = 10, enabled = false, dataProvider = "NewPreparationData", dataProviderClass = DataProviderClass.class)

	public void newPreparationwithdata(String startDate, String endDate, String playerList, String session,
			String activity, String Combination, String workoutname, String Techique, String sets, String Rep,
			String time, String Reset, String covery) throws InterruptedException {

		newPreparationPage.newPreparation();
		newPreparationPage.assignPreparationwithdataEdit(startDate, endDate, playerList, session, activity, Combination,
				workoutname, Techique, sets, Rep, time, Reset, covery);
	}

	@Test(priority = 11, enabled = false, dataProvider = "NewPreparationEditData", dataProviderClass = DataProviderClass.class)

	public void newPreparationwithdataEdit(String data1, String sets) throws InterruptedException {

		newPreparationPage.tableDataEdit(data1, sets);
	}
	
	@Test(priority = 12, enabled = false)

	public void assignButtonEdit() throws InterruptedException {

		newPreparationPage.assign();

	}


	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}

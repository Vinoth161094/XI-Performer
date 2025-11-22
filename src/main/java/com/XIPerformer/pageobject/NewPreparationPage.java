package com.XIPerformer.pageobject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.base.BaseClass;

public class NewPreparationPage extends BaseClass {

	public NewPreparationPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'New Preparation')]")
	WebElement newPreparation;

	@FindBy(name = "startDate")
	WebElement startDate;

	@FindBy(name = "endDate")
	WebElement endDate;

	@FindBy(id = "tags-standard")
	WebElement playerList;

	@FindBy(xpath = "	//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall MuiInputBase-inputAdornedEnd MuiAutocomplete-input MuiAutocomplete-inputFocused css-b52kj1']")
	WebElement inputPlayerList;

	@FindBy(xpath = "//label[@class='_formLabel_vrom6_259']/div[contains(text(),'Session')]/following::div/div[@aria-controls=':r2v:']")
	WebElement session;

	@FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li")
	List<WebElement> ListValue;

	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall  css-61ay9p']/div[@id='mui-component-select-activityId']")
	WebElement activity;

	@FindBy(xpath = "//label[@class='_formLabel_vrom6_259']/div[contains(text(),'Combination')]/following::div[@id='mui-component-select-name']")
	WebElement combination;

	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall  css-61ay9p']/div[@id='mui-component-select-workoutName']")
	WebElement workoutName;

	@FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li")
	List<WebElement> workoutNameListValue;

	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall  css-61ay9p']/div[@id='mui-component-select-technique']")
	WebElement Techinque;

	@FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li")
	List<WebElement> TechinqueListValue;

	@FindBy(name = "numberOfSets")
	WebElement set;

	@FindBy(name = "numberOfRepetitions")
	WebElement reps;

	@FindBy(name = "timePerSetTime")
	WebElement times;

	@FindBy(name = "restSet")
	WebElement reset;

	@FindBy(xpath = "//ul[@aria-label='Select hours']/li")
	List<WebElement> hoursListValue;

	@FindBy(xpath = "//ul[@aria-label='Select minutes']/li")
	List<WebElement> minutesListValue;

	@FindBy(xpath = "//ul[@aria-label='Select seconds']/li")
	List<WebElement> secondsListValue;

	@FindBy(name = "recovery")
	WebElement recovery;

	@FindBy(xpath = "//button[@aria-label='Add']")
	WebElement addButton;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement sumbitButton;

	@FindBy(xpath = "//button[@title ='Clear']")
	WebElement clearButton;
	
	@FindBy(xpath = "//div[@class='swal2-html-container']")
	WebElement Message;

	public void newPreparation() throws InterruptedException {

		Thread.sleep(10000);

		newPreparation.click();
	}

	public void assignPreparation(String StartDate, String EndDate, String PlayerList, String Session, String Activity,
			String Combination, String workoutname, String Techique, String sets, String Rep, String time, String Reset,
			String covery) throws InterruptedException {

		startDate.click();

		startDate.clear();
		startDate.sendKeys(StartDate);

		endDate.click();
		endDate.clear();

		endDate.sendKeys(EndDate);

		playerList.click();

		String[] players = PlayerList.split(",");

		for (String player : players) {

			playerList.sendKeys(player);

			playerList.sendKeys(Keys.ARROW_DOWN);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(d -> playerList.getAttribute("aria-activedescendant") != null);

			String activeId = playerList.getAttribute("aria-activedescendant");
			System.out.println(activeId);

			WebElement option = driver.findElement(By.id(activeId));
			option.click();

		}

		session.click();

		dropdownClick(ListValue, Session);

		activity.click();

		dropdownClick(ListValue, Activity);

		combination.click();

		dropdownClick(ListValue, Combination);

		if (workoutname != null && !workoutname.trim().isEmpty()) {

			workoutName.click();
			dropdownClick(workoutNameListValue, workoutname);

		} else {

			if (Techique != null && !Techique.trim().isEmpty()) {
				Techinque.click();
				dropdownClick(TechinqueListValue, Techique);
			}
		}

		set.click();
		set.sendKeys(Keys.CONTROL + "a");
		set.sendKeys(Keys.DELETE);

		set.sendKeys(sets);

		reps.click();
		reps.sendKeys(Keys.CONTROL + "a");
		reps.sendKeys(Keys.DELETE);

		reps.sendKeys(Rep);

		times.click();

		String[] split = time.split(":");

		dropdownClick(hoursListValue, split[0]);

		dropdownClick(minutesListValue, split[1]);

		dropdownClick(secondsListValue, split[2]);

		reset.click();

		Thread.sleep(3000);

		String[] resetspllit = Reset.split(":");

		dropdownClick(hoursListValue, resetspllit[0]);

		Thread.sleep(2000);

		dropdownClick(minutesListValue, resetspllit[1]);

		dropdownClick(secondsListValue, resetspllit[2]);

		recovery.click();

		String[] coverysplit = covery.split(":");

		Thread.sleep(3000);

		dropdownClick(hoursListValue, coverysplit[0]);

		dropdownClick(minutesListValue, coverysplit[1]);

		dropdownClick(secondsListValue, coverysplit[2]);

		addButton.click();

		Thread.sleep(2000);

		playerList.click();

		clearButton.click();

	}

	public void assignPreparationwithdataEdit(String StartDate, String EndDate, String PlayerList, String Session,
			String Activity, String Combination, String workoutname, String Techique, String sets, String Rep,
			String time, String Reset, String covery) throws InterruptedException {

		startDate.click();

		startDate.clear();
		startDate.sendKeys(StartDate);

		endDate.click();
		endDate.clear();

		endDate.sendKeys(EndDate);

		playerList.click();

		String[] players = PlayerList.split(",");

		for (String player : players) {
			
			System.out.println(player);

			playerList.sendKeys(player);
			
			Thread.sleep(2000);


			playerList.sendKeys(Keys.ARROW_DOWN);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(d -> playerList.getAttribute("aria-activedescendant") != null);

			String activeId = playerList.getAttribute("aria-activedescendant");
			System.out.println(activeId);

			WebElement option = driver.findElement(By.id(activeId));

			option.click();

		}
		
		Thread.sleep(3000);


		session.click();

		dropdownClick(ListValue, Session);

		activity.click();

		dropdownClick(ListValue, Activity);

		combination.click();

		dropdownClick(ListValue, Combination);

		if (workoutname != null && !workoutname.trim().isEmpty()) {

			workoutName.click();
			dropdownClick(workoutNameListValue, workoutname);

		} else {

			if (Techique != null && !Techique.trim().isEmpty()) {
				Techinque.click();
				dropdownClick(TechinqueListValue, Techique);
			}
		}
		
		Thread.sleep(1000);


		set.click();
		set.sendKeys(Keys.CONTROL + "a");
		set.sendKeys(Keys.DELETE);

		set.sendKeys(sets);

		reps.click();
		reps.sendKeys(Keys.CONTROL + "a");
		reps.sendKeys(Keys.DELETE);

		reps.sendKeys(Rep);

		times.click();

		String[] split = time.split(":");

		dropdownClick(hoursListValue, split[0]);

		dropdownClick(minutesListValue, split[1]);

		dropdownClick(secondsListValue, split[2]);

		reset.click();

		Thread.sleep(3000);

		String[] resetspllit = Reset.split(":");

		dropdownClick(hoursListValue, resetspllit[0]);

		Thread.sleep(2000);

		dropdownClick(minutesListValue, resetspllit[1]);

		dropdownClick(secondsListValue, resetspllit[2]);

		recovery.click();

		String[] coverysplit = covery.split(":");

		Thread.sleep(3000);

		dropdownClick(hoursListValue, coverysplit[0]);

		dropdownClick(minutesListValue, coverysplit[1]);

		dropdownClick(secondsListValue, coverysplit[2]);

		addButton.click();

		Thread.sleep(2000);

	}

	public void tableDataEdit(String exname, String sets) throws InterruptedException {

		WebElement webtable = driver
				.findElement(By.xpath("//table[@class='MuiTable-root MuiTable-stickyHeader css-lkld8c']/tbody"));

		List<WebElement> rows = webtable.findElements(By.tagName("tr"));

		System.out.println("rsize " + rows.size());

		for (int i = 0; i < rows.size(); i++) {

			List<WebElement> column = rows.get(i).findElements(By.tagName("td"));

			System.out.println("csize " + column.size());

			for (int j = 0; j < column.size(); j++) {

			}
			System.out.println("Execisee name " + column.get(1).getText());
			System.out.println("Techique " + column.get(2).getText());

			String execrisename = column.get(1).getText();
			if (execrisename.equals(exname)) {

				WebElement edit = driver.findElement(By.xpath(
						"//table[@class='MuiTable-root MuiTable-stickyHeader css-lkld8c']/tbody//button[@type='button']"));
				edit.click();

				set.click();
				set.sendKeys(Keys.CONTROL + "a");
				set.sendKeys(Keys.DELETE);

				set.sendKeys(sets);

				Thread.sleep(9000);

				addButton.click();

			}

		}

	}

	public void assign() throws InterruptedException {
		
		Thread.sleep(3000);

		sumbitButton.click();
		Thread.sleep(2000);

		String successText = Message.getText();
		System.out.println(successText);

		if (successText.equals("All Preparations Have Been Created Successfully!")) {
			System.out.println("Preparations created successfully!");
		} else {
			System.out.println("Preparations not created — it may already exist!");
		}


	}

}

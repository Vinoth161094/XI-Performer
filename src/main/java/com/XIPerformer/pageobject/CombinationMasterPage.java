package com.XIPerformer.pageobject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.XIPerformer.util.Commonmethods;
import com.automation.base.BaseClass;

public class CombinationMasterPage extends BaseClass {
	
	Commonmethods c = new Commonmethods();

	public CombinationMasterPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[contains(text(),'Combination Master')]")
	WebElement combinationMaster;

	@FindBy(xpath = "(//button[@type='button']/span[@class='MuiButton-icon MuiButton-startIcon MuiButton-iconSizeMedium css-6xugel'])[3]")
	WebElement newButton;

	@FindBy(xpath = "//input[@name ='exercisePlanName']")
	WebElement combinationname;

	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall  css-61ay9p']/div[@id='mui-component-select-activityId']")
	WebElement activity;

	@FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li")
	List<WebElement> activityListValue;

	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall  css-61ay9p']/div[@id='mui-component-select-isPublic']")
	WebElement privacy;

	@FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li")
	List<WebElement> privacyListValue;

	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall  css-61ay9p']/div[@id='mui-component-select-workoutName']")
	WebElement workoutName;

	@FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li")
	List<WebElement> workoutNameListValue;

	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall  css-61ay9p']/div[@id='mui-component-select-technique']")
	WebElement Techinque;

	@FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li")
	List<WebElement> TechinqueListValue;

	@FindBy(xpath = "//input[@type='file']")
	WebElement uploadImage;

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
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement okButton;

	public void combinationmasterClick() throws InterruptedException {

		Thread.sleep(15000);

		combinationMaster.click();
		
		newButton.click();



	}

	public void cpmbinationMaster(String Combinationname, String Activity, String Privacy, String workoutname,
			String Techique, String images, String sets, String Rep, String time, String Reset, String covery)
			throws InterruptedException {
		


		Thread.sleep(5000);

		if (Combinationname != null && !Combinationname.trim().isEmpty()) {

			combinationname.sendKeys(Combinationname);
		}

		if (Activity != null && !Activity.trim().isEmpty()) {

			activity.click();
			c.dropdownClick(activityListValue, Activity);

		}

		privacy.click();
		c.dropdownClick(privacyListValue, Privacy);

		if (workoutname != null && !workoutname.trim().isEmpty()) {

			workoutName.click();
			c.dropdownClick(workoutNameListValue, workoutname);

		} else {

			if (Techique != null && !Techique.trim().isEmpty()) {
				Techinque.click();
				c.dropdownClick(TechinqueListValue, Techique);
			}
		}

		if (images != null && !images.trim().isEmpty()) {

			uploadImage.sendKeys(images);

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

		c.dropdownClick(hoursListValue, split[0]);

		c.dropdownClick(minutesListValue, split[1]);

		c.dropdownClick(secondsListValue, split[2]);

		reset.click();

		Thread.sleep(3000);

		String[] resetspllit = Reset.split(":");

		c.dropdownClick(hoursListValue, resetspllit[0]);

		Thread.sleep(2000);

		c.dropdownClick(minutesListValue, resetspllit[1]);

		c.dropdownClick(secondsListValue, resetspllit[2]);

		recovery.click();

		String[] coverysplit = covery.split(":");

		Thread.sleep(3000);

		c.dropdownClick(hoursListValue, coverysplit[0]);
		Thread.sleep(3000);

		c.dropdownClick(minutesListValue, coverysplit[1]);

		c.dropdownClick(secondsListValue, coverysplit[2]);

		addButton.click();

	}

	public void sumbitClick() throws InterruptedException {

		Thread.sleep(3000);

		sumbitButton.click();
		
		Thread.sleep(3000);

		
		okButton.click();


	}

}

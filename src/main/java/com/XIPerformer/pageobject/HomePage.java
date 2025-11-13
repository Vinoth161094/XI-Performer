package com.XIPerformer.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.BaseClass;



public class HomePage extends BaseClass {
	

	
	public HomePage() {
		PageFactory.initElements(driver, this);
		}
	
	
@FindBy(xpath = "//p[contains(text(),'Exercise & Tech Master')]")
WebElement exercise;

@FindBy(xpath = "//button[contains(text(),'Add')]")
WebElement addButton;

@FindBy(xpath = "//input[@name='exerciseName']")
WebElement exercisename;

@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall  css-61ay9p']/div[@aria-controls=':r31:']")
WebElement category;
	

@FindBy(xpath = "//ul[@role='listbox']/li")
List<WebElement> categorylist;


@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall  css-61ay9p']/div[@id='mui-component-select-typeOfExercise']")
WebElement type;

@FindBy(xpath = "	//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li")
List<WebElement> typeListValue;


@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall  css-61ay9p']/div[@id='mui-component-select-unitOfMeasurement']")
WebElement unit;

@FindBy(xpath = "	//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li")
List<WebElement> unitListValue;


@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall  css-61ay9p']/div[@aria-controls=':r34:']")
WebElement focusArea;

@FindBy(xpath = "	//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li")
List<WebElement> focusAreaListValue;


@FindBy(xpath = "//button[@aria-label='Add Focus']")
WebElement addFocus;


@FindBy(xpath = "//textarea[@name='instructions.execution']")
WebElement instruction;


@FindBy(xpath = "//textarea[@name='instructions.keyTips']")
WebElement keyTips;

@FindBy(xpath = "//input[@type='file']")
WebElement uploadImage;

@FindBy(xpath = "//input[@name='instructions.videoReference']")
WebElement uploadVideo;

@FindBy(xpath = "//button[@type='submit']")
WebElement submitButton;

@FindBy(xpath = "//button[contains(text(),'OK')]")
WebElement okButton;

@FindBy(xpath = "//button[@aria-label='Download Exercise List']")
WebElement downloadExeciseButton;

@FindBy(xpath = "//div[contains(text(),'An Exercise With The Same Details Already Exists. Please Try Again.')]")
WebElement ErrorMsg;

@FindBy(xpath = "//div[@class='swal2-html-container']")
WebElement Message;



public void PageHome(String exerciseName, String categoryValue, String typeValue,
        String unitValue, String[] focusAreaValue, String instructionValue,
        String keyTipsValue, String uploadImageValue, String uploadVideoValue)
        throws InterruptedException {

	exercise.click();
	addButton.click();
    exercisename.sendKeys(exerciseName);

       category.click();
       dropdownClick(categorylist, categoryValue);

       type.click();
  dropdownClick(typeListValue, typeValue);


  unit.click();
  dropdownClick(unitListValue, unitValue);

  Thread.sleep(3000);

   for (int i = 1; i < focusAreaValue.length; i++) {
	 focusArea.click();
	 dropdownClick(focusAreaListValue, focusAreaValue[i]);
   addFocus.click();
     Thread.sleep(500);
}

instruction.sendKeys(instructionValue);
keyTips.sendKeys(keyTipsValue);
uploadImage.sendKeys(uploadImageValue);
uploadVideo.sendKeys(uploadVideoValue);

     submitButton.click();
    Thread.sleep(5000);
    
    String successText = Message.getText();
    System.out.println(successText);

    if (successText.equals("The Exercise has been created successfully!")) {
    System.out.println("Exercise created successfully!");
} else {
	System.out.println("Exercise not created — it may already exist!");
    }

    
    

     okButton.click();
     Thread.sleep(3000);
     


}

public void downloadExeciseList() {
	
	downloadExeciseButton.click();
	
}
}
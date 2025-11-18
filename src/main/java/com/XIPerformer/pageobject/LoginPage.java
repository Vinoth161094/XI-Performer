package com.XIPerformer.pageobject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automation.base.BaseClass;


public class LoginPage extends BaseClass{

	
	public LoginPage() {
	PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[contains(text(),'Log In')]")
	WebElement signinbutton;

	
	
	public String validatetitle() {
		return driver.getTitle();
	}
	
	
	public HomePage Login(String un, String pwd) throws InterruptedException {
		
		String HomepageTitle = validatetitle();
		System.out.println(HomepageTitle);
		
		Thread.sleep(3000);
		username.sendKeys(un);
		password.sendKeys(pwd);
		signinbutton.click();
		return new HomePage();
		
	}
	
	
	

}

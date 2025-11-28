package com.XIPerformer.util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.base.BaseClass;

public class Commonmethods extends BaseClass  {
	
	
	public void scrollToTop() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, 20);");
	}
	
	
	public void scrollDownBy() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 500);");
	}
	
	public void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    
    public void waitForElementtobeClikable(By option) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(option));
    }

    public void jsClick(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
            System.out.println("Clicked successfully using JavaScript: " + element);
        } catch (Exception e) {
            System.out.println("Unable to click using JavaScript: " + e.getMessage());
        }
    }

public void dropdownClick(List<WebElement> options, String value ) {
		
		for (WebElement option : options) {
		    if (option.getText().equalsIgnoreCase(value)) {
		        option.click();
		        break;
		    }
		}
	} 

public void clearField(WebElement element) {
    element.click();
    String text = element.getAttribute("value");
    System.out.println(text);

    for (int i = 0; i < text.length(); i++) {
     //   element.sendKeys(Keys.BACK_SPACE);
    }
}


}

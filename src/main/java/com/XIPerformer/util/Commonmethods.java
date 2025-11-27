package com.XIPerformer.util;

import org.openqa.selenium.JavascriptExecutor;

import com.automation.base.BaseClass;

public class Commonmethods extends BaseClass  {
	
	
	public void scrollToTop() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, 20);");
	}


}

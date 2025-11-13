package com.XIPerformer.actiondrivers;

import java.util.List;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.XIPerformer.util.json_data;
import com.automation.base.BaseClass;

public class action  extends BaseClass {
	
	public static WebDriver driver;
	json_data js = new json_data();
	JSONObject jobj = new JSONObject();
	
	public static  void sendKey(String element, String value) {
		try {
			driver.findElement(By.xpath(element)).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void paymentdetails(String filename, int i) {
		js.getdatafile(filename, i);
		
		String fn = jobj.get("firsrname").toString();
		String ln = jobj.get("lastname").toString();
		String email = jobj.get("firsrname").toString();
		String cardnumber = jobj.get("Cardnumber").toString();

		

}
	public void Login() {
	
	
	}
	

}



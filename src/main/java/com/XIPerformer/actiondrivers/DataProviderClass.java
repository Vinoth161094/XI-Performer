package com.XIPerformer.actiondrivers;

import org.testng.annotations.DataProvider;

import com.XIPerformer.util.ExcelUtil;

public class DataProviderClass {
	
	 @DataProvider(name = "ExeciseData")
	    public Object[][] getData() throws Exception {
	        String filePath = System.getProperty("user.dir") + "\\Test Data\\ExeciseData.xlsx";
	        return ExcelUtil.getExcelData(filePath, "Sheet1");
	    }
	}



package com.XIPerformer.actiondrivers;

import org.testng.annotations.DataProvider;

import com.XIPerformer.util.ExcelUtil;

public class DataProviderClass {
	
	 @DataProvider(name = "ExeciseData")
	    public Object[][] getData() throws Exception {
	        String filePath = System.getProperty("user.dir") + "\\Test Data\\ExeciseData.xlsx";
	        return ExcelUtil.getExcelData(filePath, "Sheet1");
	    }
	 
	 @DataProvider(name = "CombinationData")
	    public Object[][] getComData() throws Exception {
	        String filePath = System.getProperty("user.dir") + "\\Test Data\\CombinationMasterTD.xlsx";
	        return ExcelUtil.getExcelData1(filePath, "Sheet2");
	    }
	 
	 @DataProvider(name = "NewPreparationData")
	    public Object[][] getNewPreparationData() throws Exception {
	        String filePath = System.getProperty("user.dir") + "\\Test Data\\CombinationMasterTD.xlsx";
	        return ExcelUtil.getExcelDate(filePath, "Sheet4");
	    }
	 
	 @DataProvider(name = "NewPreparationEditData")
	    public Object[][] getNewPreparationEditData() throws Exception {
	        String filePath = System.getProperty("user.dir") + "\\Test Data\\CombinationMasterTD.xlsx";
	        return ExcelUtil.getExcelDate(filePath, "Sheet5");
	    }
	}



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
	 
	 @DataProvider(name = "UserCoachData")
	 public Object[][] getusercoachData() throws Exception {

	     String filePath = System.getProperty("user.dir") + "\\Test Data\\UserDetail.xlsx";
	     String sheetName = "Coach";

	     String[] headers = ExcelUtil.getExcelHeaders(filePath, sheetName);
	     Object[][] data = ExcelUtil.getExcelDateuser(filePath, sheetName);

	     Object[][] finalData = new Object[data.length][data[0].length + 1];

	     for (int i = 0; i < data.length; i++) {
	         System.arraycopy(data[i], 0, finalData[i], 0, data[i].length);
	         finalData[i][data[0].length] = headers;
	     }

	     return finalData;
	 }
	 
	 @DataProvider(name = "UserPlayerData")
	   public Object[][] getuserplayerData() throws Exception {
	 String filePath = System.getProperty("user.dir") + "\\Test Data\\UserDetail.xlsx";
     String sheetName = "Player";

     String[] headers = ExcelUtil.getExcelHeaders(filePath, sheetName);
     Object[][] data = ExcelUtil.getExcelDateuser(filePath, sheetName);

     Object[][] finalData = new Object[data.length][data[0].length + 1];

     for (int i = 0; i < data.length; i++) {
         System.arraycopy(data[i], 0, finalData[i], 0, data[i].length);
         finalData[i][data[0].length] = headers;
     }

     return finalData;
 }
	 
	 
	 @DataProvider(name = "UserRegCoachData")
	 public Object[][] getUserCoachData() throws Exception {

	     String filePath = System.getProperty("user.dir") + "\\Test Data\\UserDetail.xlsx";
	     String sheetName = "Sheet1";

	     return ExcelUtil.getData(filePath, sheetName);
	 }
	 
	 @DataProvider(name = "UserRegPlayerData")
	 public Object[][] getUserPlayerData() throws Exception {

	     String filePath = System.getProperty("user.dir") + "\\Test Data\\UserDetail.xlsx";
	     String sheetName = "Sheet2";

	     return ExcelUtil.getData(filePath, sheetName);
	 }
}

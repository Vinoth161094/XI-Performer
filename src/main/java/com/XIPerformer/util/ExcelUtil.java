package com.XIPerformer.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {

	    FileInputStream fis = new FileInputStream(filePath);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    Sheet sheet = workbook.getSheet(sheetName);

	    int rowCount = sheet.getPhysicalNumberOfRows();
	    int colCount = sheet.getRow(0).getLastCellNum();

	    Object[][] data = new Object[rowCount - 1][colCount];

	    for (int i = 1; i < rowCount; i++) {
	        Row row = sheet.getRow(i);
	        for (int j = 0; j < colCount; j++) {
	            Cell cell = (row == null) ? null : row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	            Object cellValue = getCellValue(cell);

	            if (j == 4) { 
	                String value = cellValue.toString()
	                        .replace("[", "")
	                        .replace("]", "")
	                        .replace("\"", "")
	                        .trim();
	                String[] focusArray = value.split(",");
	                for (int k = 0; k < focusArray.length; k++) {
	                    focusArray[k] = focusArray[k].trim();
	                }
	                data[i - 1][j] = focusArray;
	            } else {
	                data[i - 1][j] = cellValue;
	            }
	        }
	    }

	    workbook.close();
	    fis.close();
	    return data;
	}
	
	public static Object[][] getExcelData1(String filePath, String sheetName) throws IOException {

	    FileInputStream fis = new FileInputStream(filePath);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    Sheet sheet = workbook.getSheet(sheetName);

	    int rowCount = sheet.getPhysicalNumberOfRows();
	    int colCount = sheet.getRow(0).getPhysicalNumberOfCells();  
	    
	    System.out.println("Column Count = " + colCount);

	    System.out.println("Row Count = " + rowCount);

	    Object[][] data = new Object[rowCount - 1][colCount];

	    for (int i = 1; i < rowCount; i++) {
	        Row row = sheet.getRow(i);

	        for (int j = 0; j < colCount; j++) {
	            Cell cell = (row == null) ? null : row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	            Object cellValue = getCellValue1(cell);
	            data[i - 1][j] = cellValue;
	        }
	    }

	    workbook.close();
	    fis.close();
	    return data;
	}





	private static Object getCellValue(Cell cell) {
	    if (cell == null) return "";

	    switch (cell.getCellType()) {
	        case STRING:
	            return cell.getStringCellValue().trim();

	        case NUMERIC:
	            if (DateUtil.isCellDateFormatted(cell)) {
	                return cell.getDateCellValue();
	            } else {
	                double numericValue = cell.getNumericCellValue();
	                if (numericValue == Math.floor(numericValue)) {
	                    return String.valueOf((long) numericValue);
	                }
	                return String.valueOf(numericValue);
	            }

	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());

	        case FORMULA:
	            try {
	                FormulaEvaluator evaluator = cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
	                CellValue evaluatedValue = evaluator.evaluate(cell);
	                switch (evaluatedValue.getCellType()) {
	                    case STRING:
	                        return evaluatedValue.getStringValue();
	                    case NUMERIC:
	                        return String.valueOf(evaluatedValue.getNumberValue());
	                    case BOOLEAN:
	                        return String.valueOf(evaluatedValue.getBooleanValue());
	                    default:
	                        return "";
	                }
	            } catch (Exception e) {
	                return cell.getCellFormula();
	            }

	        default:
	            return "";
	    }
	}
	
	private static Object getCellValue1(Cell cell) {

	    if (cell == null) return "";

	    switch (cell.getCellType()) {

	        case STRING:
	            return cell.getStringCellValue().trim();

	        case NUMERIC:
	            if (DateUtil.isCellDateFormatted(cell)) {
	                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	                return sdf.format(cell.getDateCellValue());
	            } else {
	                double num = cell.getNumericCellValue();
	                if (num == (long) num) {
	                    return String.valueOf((long) num);
	                }
	                return String.valueOf(num);
	            }

	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());

	        case FORMULA:
	            return cell.toString();

	        default:
	            return "";
	    }
	}
	
	public static Object[][] getExcelDate(String filePath, String sheetName) throws IOException {

	    FileInputStream fis = new FileInputStream(filePath);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    Sheet sheet = workbook.getSheet(sheetName);

	    int rowCount = sheet.getPhysicalNumberOfRows();
	    int colCount = sheet.getRow(0).getPhysicalNumberOfCells();  
	    
	    System.out.println("Column Count = " + colCount);

	    System.out.println("Row Count = " + rowCount);

	    Object[][] data = new Object[rowCount - 1][colCount];

	    for (int i = 1; i < rowCount; i++) {
	        Row row = sheet.getRow(i);

	        for (int j = 0; j < colCount; j++) {
	            Cell cell = (row == null) ? null : row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	            Object cellValue = getCellValueDate(cell);
	            data[i - 1][j] = cellValue;
	        }
	    }

	    workbook.close();
	    fis.close();
	    return data;
	}





	
	
	private static Object getCellValueDate(Cell cell) {

	    if (cell == null) return "";

	    switch (cell.getCellType()) {

	        case STRING:
	            return cell.getStringCellValue().trim();

	        case NUMERIC:
	            if (DateUtil.isCellDateFormatted(cell)) {

	                String excelFormat = cell.getCellStyle().getDataFormatString();

	                if (excelFormat.contains("h") || excelFormat.contains("H")) {
	                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	                    return timeFormat.format(cell.getDateCellValue());
	                }

	                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	                return dateFormat.format(cell.getDateCellValue());
	            }

	            double num = cell.getNumericCellValue();
	            return (num == (long) num) ? String.valueOf((long) num) : String.valueOf(num);

	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());

	        case FORMULA:
	            return cell.toString();

	        default:
	            return "";
	    }
	}



}

package com.XIPerformer.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
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

	public static Object[][] getExcelDateuser(String filePath, String sheetName) throws IOException {

	    FileInputStream fis = new FileInputStream(filePath);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    Sheet sheet = workbook.getSheet(sheetName);

	    int actualRowCount = 0;
	    for (int i = 0; i <= sheet.getLastRowNum(); i++) {
	        Row row = sheet.getRow(i);
	        if (!isRowEmpty(row)) {
	            actualRowCount++;
	        }
	    }

	    int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

	    System.out.println("Column Count = " + colCount);
	    System.out.println("Row Count = " + actualRowCount);

	    Object[][] data = new Object[actualRowCount - 1][colCount];

	    int index = 0;

	    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	        Row row = sheet.getRow(i);

	        if (isRowEmpty(row)) continue;

	        for (int j = 0; j < colCount; j++) {
	            Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	            data[index][j] = getCellValueDateUser(cell);
	        }
	        index++;
	    }

	    workbook.close();
	    fis.close();
	    return data;
	}



	private static boolean isRowEmpty(Row row) {

	    if (row == null) return true;

	    for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
	        Cell cell = row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

	        if (cell != null && cell.getCellType() != CellType.BLANK) {
	            if (!cell.toString().trim().isEmpty()) {
	                return false; 
	            }
	        }
	    }
	    return true; 
	}


	
	private static Object getCellValueDateUser(Cell cell) {

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
	
	public static String[] getExcelHeaders(String filePath, String sheetName) throws IOException {

	    FileInputStream fis = new FileInputStream(filePath);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    Sheet sheet = workbook.getSheet(sheetName);

	    Row headerRow = sheet.getRow(0);
	    int colCount = headerRow.getPhysicalNumberOfCells();

	    String[] headers = new String[colCount];

	    for (int i = 0; i < colCount; i++) {
	        headers[i] = headerRow.getCell(i).getStringCellValue().trim();
	    }

	    workbook.close();
	    fis.close();

	    return headers;
	}

	public static Object[][] getData(String filePath, String sheetName) throws Exception {

        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        Row headerRow = sheet.getRow(0);
        Map<String, Integer> headerIndex = new LinkedHashMap<>();

        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            Cell cell = headerRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            headerIndex.put(cell.toString().trim(), i);
        }

        List<Map<String, String>> list = new ArrayList<>();

        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;

            Map<String, String> rowMap = new LinkedHashMap<>();

            for (String header : headerIndex.keySet()) {
                int colIndex = headerIndex.get(header);
                Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                String value = "";

                switch (cell.getCellType()) {

                    case STRING:
                        value = cell.getStringCellValue().trim();
                        break;

                    case NUMERIC:
                        value = new BigDecimal(cell.getNumericCellValue())
                                .toPlainString()
                                .trim();
                        break;

                    case BOOLEAN:
                        value = String.valueOf(cell.getBooleanCellValue()).trim();
                        break;

                    case FORMULA:
                        try {
                            value = new BigDecimal(cell.getNumericCellValue())
                                    .toPlainString();
                        } catch (Exception e) {
                            value = cell.getStringCellValue();
                        }
                        value = value.trim();
                        break;

                    case BLANK:
                    default:
                        value = "";
                }

                rowMap.put(header, value);
            }

            list.add(rowMap);
        }

        workbook.close();
        fis.close();

        Object[][] finalData = new Object[list.size()][1];

        for (int i = 0; i < list.size(); i++) {
            finalData[i][0] = list.get(i);
        }

        return finalData;
    }
}



package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static String getCellValue(int rowNum, int colNum) throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\testData.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("testdata");
		String value = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;
	}

//	public static void main(String[] args) throws IOException {
//		getCellValue(1, 1);
//	}

}

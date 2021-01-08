package maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDriven {
	public static void main(String[] args) throws IOException {
		
	//to update the value in excel
		File file = new File("C:\\Users\\marag\\eclipse-workspace\\maven\\Excelsheet\\Arun.xlsx");
FileInputStream fin=new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fin);
		Sheet sheet = w.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String value=cell.getStringCellValue();
		if (value.equals("java")) {
			cell.setCellValue("selenium");
			
		}
		FileOutputStream fout = new FileOutputStream(file);
		w.write(fout);
		System.out.println("done successfully");
		// int cellType = cell.getCellType();
		// String value = " ";
		// if (cellType == 1) {
		// value = cell.getStringCellValue();
		// } else if (DateUtil.isCellDateFormatted(cell)) {
		// Date d = cell.getDateCellValue();
		// SimpleDateFormat s = new SimpleDateFormat("dd-M-yyy");
		// value = s.format(d);
		// } else {
		// double dd = cell.getNumericCellValue();
		// long l = (long) dd;// typecating
		// value = String.valueOf(l);
		// }
		// System.out.println(value);
		// return value;
	}
}



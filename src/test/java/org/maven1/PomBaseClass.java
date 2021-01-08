package org.maven1;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PomBaseClass {
	public static WebDriver driver;
	public static Actions acc;
	public static Robot r;
	public static Alert al;
	public static Select s;

	// 1.to load browser
	public static WebDriver loadBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\marag\\eclipse-workspace\\maven\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;

	}

	// 2.to launch browser
	public static void launchUrl(String url) {
		driver.get(url);

	}

	// 3. to get title
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 4. to get current url
	public static void currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

	}

	// 5. to find loacators and pass values
	public static void fill(WebElement element, String text) {
		element.sendKeys(text);

	}

	// 6. to click the button
	public static void btnClick(WebElement element) {
		element.click();
	}

	// 7. to close browser
	public static void closebrowser() {
		driver.quit();
	}

	// 8.to maximize the window
	public static void maxwindow() {
		driver.manage().window().maximize();
	}

	public static String excelRead(int rowNo, int cellNo) throws IOException {
		File file = new File("C:\\Users\\marag\\eclipse-workspace\\maven\\Excelsheet\\Arun.xlsx");
		FileInputStream fin = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fin);
		Sheet sheet = w.getSheet("Sheet1");
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int cellType = cell.getCellType();
		String value = " ";
		if (cellType == 1) {
			value = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date d = cell.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat("dd/MM/yy");
			value = s.format(d);

		} else {
			double dd = cell.getNumericCellValue();
			long l = (long) dd;
			value = String.valueOf(l);
		}
		return value;

	}

}

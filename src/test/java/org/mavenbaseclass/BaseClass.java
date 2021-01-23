package org.mavenbaseclass;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver driver;
	public static Actions acc;
	public static Robot r;
	public static Alert al;
	public static Select s;

	// 1.to load browser
	public static void loadBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\marag\\eclipse-workspace\\maven\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

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

	// 9.Actions--------drag and drop
	public static void dragDrop(WebElement src, WebElement des) {
		acc = new Actions(driver);

		acc.dragAndDrop(src, des).perform();

	}

	// 10.move to element
	public static void moveToElement(WebElement des) {
		acc = new Actions(driver);
		acc.moveToElement(des);

	}

	// 11.right click
	public static void rightClick(WebElement element) {
		acc = new Actions(driver);
		acc.contextClick(element);
	}

	// 12.double click
	public static void doubleClick(WebElement element) {
		acc = new Actions(driver);
		acc.doubleClick(element);
	}

	// 13.without using capslock
	public static void capsLock(WebElement element, String text) {
		acc = new Actions(driver);
		acc.keyDown(element, Keys.SHIFT).sendKeys(text).keyUp(element, Keys.SHIFT).build().perform();

	}

	// 13.Alert-------to handle alertaccept
	public static void alertAccept() {
		al = driver.switchTo().alert();
		al.accept();
	}

	// 14.to dismiss alert
	public static void alertDissmiss() {
		al = driver.switchTo().alert();
		al.dismiss();

	}

	// 16.to get text in alert
	public static void alertGetText() {
		al = driver.switchTo().alert();
		al.getText();
	}

	// 17.to pass the values in alert---accept
	public static void passValuesaccept(String text) {
		al = driver.switchTo().alert();
		al.sendKeys(text);
		al.accept();

	}

	// 18.to pass the vaules in alert----dismiss
	public static void passValuesDismiss(String text) {
		al = driver.switchTo().alert();
		al.sendKeys(text);
		al.dismiss();
	}

	// 18.to handle frame using id or name
	public static void frameText(String text) {
		driver.switchTo().frame(text);

	}

	// 19.frame using webElement reference
	public static void frameRef(WebElement ref) {
		driver.switchTo().frame(ref);

	}

	// 20.frame using index
	public static void frameIndex(int index) {
		driver.switchTo().frame(index);

	}

	// 21.dropdown in selectbyvalue
	public static void selectValue(String text, String text1) {
		WebElement loc = driver.findElement(By.id(text));
		Select s = new Select(loc);
		s.selectByValue(text1);
	}

	// 22.select by visible text
	public static void selectText(String text) {
		s.selectByVisibleText(text);

	}

	// 23.select by index
	public static void selectIndex(int index) {
		s.selectByIndex(index);

	}

	// 24.deselect by value
	public static void deselectvalue(String text) {
		s.deselectByValue(text);
	}

	// 25.deselect by visible text
	public static void deselectText(String text) {
		s.deselectByVisibleText(text);

	}

	// 26.deselect by index
	public static void deselectIndex(int index) {
		s.deselectByIndex(index);

	}

	// 27.deselect all
	public static void deselectAll() {
		s.deselectAll();
	}

	// 28.get options
	public static void getOptions() {
		List<WebElement> allopt = s.getOptions();
		for (int i = 0; i < allopt.size(); i++) {
			WebElement eachopt = allopt.get(i);
			String name = eachopt.getText();
			System.out.println(name);

		}
	}

	// 29.get all the selected options
	public static void selectedOptions() {
		List<WebElement> selectedopt = s.getAllSelectedOptions();
		for (int i = 0; i < selectedopt.size(); i++) {
			WebElement eachOpt = selectedopt.get(i);
			System.out.println(eachOpt.getText());
		}

	}

	// 30.get the first selected options
	public static void firstSelectedoption() {
		WebElement firstSelect = s.getFirstSelectedOption();
		System.out.println(firstSelect.getText());
		System.out.println(firstSelect.getAttribute("value"));

	}

	// 31. check whether we select multiple options or not
	public static void multiple() {
		s.isMultiple();

	}

	// 32.windows handling----to get parent window id
	public static void parentwindow() {
		String parentwind = driver.getWindowHandle();
		System.out.println(parentwind);
	}

	// 33.to switch over new window
	public static void childwind() {
		String parentwind = driver.getWindowHandle();
		Set<String> allwind = driver.getWindowHandles();
		System.out.println(allwind);
		System.out.println(parentwind);
		for (String x : allwind) {
			if (!parentwind.equals(x)) {
				driver.switchTo().window(x);

			}

		}

	}

	// 34.switch to new window using id
	public static void windowId(String id) {

		driver.switchTo().window(id);

	}

	// 35.switch to new window using url
	public static void windowUrl(String Url) {
		driver.switchTo().window(Url);

	}

	// 36.switch to new window using title
	public static void windowTitle(String title) {
		driver.switchTo().window(title);

	}

	// 37.javascript executer------- scrollup and scrooldown
	public static void scrollDown(WebElement element, boolean scroll) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollintoView(scroll)", element);

	}

	// 38.to pass the value---------sendkeys
	public static void setAttribute(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setattribute('value,'text')", element);

	}

	// 39.to click the value------click
	public static void Click(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}

	// 40.to get the value that user entered-------get attribute
	public static void getAttribute(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object obj = js.executeScript("return arguments[0].getAttribute('value')", element);
		System.out.println(obj);

	}

	// 41.screen shot
	public static void screenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\marag\\OneDrive\\Pictures\\Saved Pictures");
		FileUtils.copyFile(src, des);

	}

	// 42.webtable--------to find the no. of tables in webpage
	public static void tableCount(WebElement element, String text) {
		List<WebElement> allTable = driver.findElements(By.tagName(text));
		int tab = allTable.size();
		System.out.println(tab);

	}

	// 43.to fetch all the data from webtable
	public static void singleTable(WebElement element, String text) {
		WebElement table = driver.findElement(By.id(text));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		int a = allRows.size();
		System.out.println(a);
		for (WebElement eachRow : allRows) {
			List<WebElement> allData = eachRow.findElements(By.tagName("td"));
			for (WebElement data : allData) {
				System.out.println(data.getText());

			}

		}
	}

	// 45.to read the data from excel sheet
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
			SimpleDateFormat s = new SimpleDateFormat("dd/mm/yyyy");
			value = s.format(d);

		} else {
			double dd = cell.getNumericCellValue();
			long l = (long) dd;
			value = String.valueOf(l);
		}
		return value;
	}

	// to write into excel
	public static void excelWrite(int rowNo, int cellNo, String insertvalue) throws IOException {
		File file = new File("C:\\Users\\marag\\eclipse-workspace\\maven\\Excelsheet\\Arun.xlsx");
		FileInputStream fin = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Sheet1");
		s.getRow(rowNo).createCell(cellNo).setCellValue(insertvalue);
		FileOutputStream fout = new FileOutputStream(file);
		w.write(fout);
		System.out.println("done successfully");

	}

	// 46.gettext
	public static String getText1(WebElement element) {
		String text = element.getText();

		return text;
	}

	// 47.getAtrribute
	public static String getAttri(String id) {

		WebElement ref = driver.findElement(By.id(id));

		String attribute = ref.getAttribute("value");
		System.out.println(attribute);
		return attribute;

	}
	// 48.findElement
	// public static void findElement1(WebElement element,String text) {
	// WebElement ref=driver.findElement(By.xpath(WebElementpath));
	// ref.sendKeys(text);
	// }

	// 48.findElement
	public static void findElementIdNormal(String WebElement) {
		WebElement ref = driver.findElement(By.id(WebElement));
	}

	public static void findElementXpath(String WebElement, String text) {
		WebElement ref = driver.findElement(By.xpath(WebElement));
		ref.sendKeys(text);
	}

	public static void findElementId(String WebElement, String text) {
		WebElement ref = driver.findElement(By.id(WebElement));
		ref.sendKeys(text);
	}

	public static void findElementTag(String WebElement, String text) {
		WebElement ref = driver.findElement(By.tagName(WebElement));
		ref.sendKeys(text);
	}

	public static void findElementName(String WebElement, String text) {
		WebElement ref = driver.findElement(By.name(WebElement));
		ref.sendKeys(text);
	}

	public static void findElementClass(String WebElement, String text) {
		WebElement ref = driver.findElement(By.className(WebElement));
		ref.sendKeys(text);
	}

	// click webElement using xpath
	public static void findElementClickXpath(String WebElement, String text) {
		WebElement ref = driver.findElement(By.xpath(WebElement));
		ref.click();
	}

	public static void findElementClickId(String WebElement, String text) {
		WebElement ref = driver.findElement(By.id(WebElement));
		ref.click();
	}

	public static void findElementClickTag(String WebElement, String text) {
		WebElement ref = driver.findElement(By.tagName(WebElement));
		ref.click();
	}

	public static void findElementClickName(String WebElement, String text) {
		WebElement ref = driver.findElement(By.name(WebElement));
		ref.click();
	}

	public static void findElementClickClass(String WebElement, String text) {
		WebElement ref = driver.findElement(By.className(WebElement));
		ref.click();
	}

}

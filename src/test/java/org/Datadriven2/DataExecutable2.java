package org.Datadriven2;

import java.awt.AWTException;
import java.io.IOException;

import org.mavenbaseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DataExecutable2 extends BaseClass {
public static void main(String[] args) throws IOException, InterruptedException, AWTException  {
		
		loadBrowser();
		
		
		launchUrl("https://www.adactin.com/HotelApp");
		maxwindow();
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='username']"));
fill(txtEmail, excelRead(0,0));
WebElement txtPass=driver.findElement(By.xpath("//input[@id='password']"));
fill(txtPass,excelRead(0, 1));
WebElement btnLogin=driver.findElement(By.name("login"));
btnClick(btnLogin);
Thread.sleep(2000);
//WebElement location=driver.findElement(By.xpath("//select[@name='location']"));
selectValue("location","Sydney");
selectValue("hotels", "Hotel Sunshine");
selectValue("room_type","Double");
selectValue("room_nos","2");
//WebElement date=driver.findElement(By.xpath("//input[@name='datepick_in']"));
//btnClick(date);
//Robot r=new Robot();
//r.keyPress(KeyEvent.VK_CONTROL);
//r.keyPress(KeyEvent.VK_A);
//r.keyRelease(KeyEvent.VK_CONTROL);
//r.keyRelease(KeyEvent.VK_A);
//r.keyPress(KeyEvent.VK_DELETE);
//r.keyRelease(KeyEvent.VK_DELETE);
//
//fill(date, excelRead(0,0));
//WebElement returnDate=driver.findElement(By.xpath("//input[@id='datepick_out']"));
//btnClick(returnDate);
//
//r.keyPress(KeyEvent.VK_CONTROL);
//r.keyPress(KeyEvent.VK_A);
//r.keyRelease(KeyEvent.VK_CONTROL);
//r.keyRelease(KeyEvent.VK_A);
//r.keyPress(KeyEvent.VK_DELETE);
//r.keyRelease(KeyEvent.VK_DELETE);
//
//
//fill(returnDate, excelRead(1,0));
//
selectValue("adult_room", "2");
selectValue("child_room", "1");

WebElement btnSearch=driver.findElement(By.xpath("//input[@id='Submit']"));
btnClick(btnSearch);

WebElement btnHotel=driver.findElement(By.xpath("//input[@id='radiobutton_0']"));
btnClick(btnHotel);

WebElement btnCont=driver.findElement(By.xpath("//input[@id='continue']"));
btnClick(btnCont);

WebElement txtName=driver.findElement(By.xpath("//input[@id='first_name']"));
fill(txtName,excelRead(0, 8));

WebElement txtLastname=driver.findElement(By.xpath("//input[@id='last_name']"));
fill(txtLastname,excelRead(0, 9));

WebElement txtAddress=driver.findElement(By.xpath("//textarea[@id='address']"));
fill(txtAddress,excelRead(0, 10));


WebElement txtcc=driver.findElement(By.xpath("//input[@id='cc_num']"));
fill(txtcc,excelRead(0, 11));

selectValue("cc_type","MAST");
selectValue("cc_exp_month","2");
selectValue("cc_exp_year","2022");

WebElement txtCvv=driver.findElement(By.xpath("//input[@id='cc_cvv']"));
fill(txtCvv,excelRead(0, 15));

WebElement btnBook=driver.findElement(By.xpath("//input[@id='book_now']"));
btnClick(btnBook);



Thread.sleep(10000);
//String attri =
 getAttri("order_no");
//System.out.println(attri);




}
}


package org.Datadriven1;

import java.io.IOException;

import org.mavenbaseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DataExecutable1 extends BaseClass {
public static void main(String[] args) throws IOException  {
		
		loadBrowser();
		
		
		launchUrl("https://www.facebook.com/");
		maxwindow();
		WebElement txtEmail = driver.findElement(By.id("email"));
		fill(txtEmail, excelRead(0,0));
		WebElement txtPass=driver.findElement(By.id("pass"));
		fill(txtPass,excelRead(0, 1 ));
		WebElement btnLogin=driver.findElement(By.name("login"));
		btnClick(btnLogin);
		WebElement msg=driver.findElement(By.xpath("//div[contains(text(),'incorrect')]"));
		String text1 = getText1(msg);
		System.out.println(text1);
		
		

//String text1 = getText1(msg);
//System.out.println(text1);
//String attri = getAttri(msg);
//System.out.println(attri);

	

}
}
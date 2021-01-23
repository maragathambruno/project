package org.Datadriven;

import java.io.IOException;

import org.mavenbaseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DataExecutable extends BaseClass {
	public static void main(String[] args) throws IOException {

		loadBrowser();

		launchUrl("https://www.facebook.com/");
		maxwindow();
		WebElement txtEmail = driver.findElement(By.id("email"));
		fill(txtEmail, excelRead(0, 0));
		WebElement txtPass = driver.findElement(By.id("pass"));
		fill(txtPass, excelRead(1, 0));
		WebElement btnLogin = driver.findElement(By.name("login"));
		btnClick(btnLogin);
		System.out.println("done successfully");
		closebrowser();
	}

}

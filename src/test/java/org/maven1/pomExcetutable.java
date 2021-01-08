package org.maven1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class pomExcetutable extends PomBaseClass {
	public static void main(String[] args) throws IOException {
		WebDriver d=loadBrowser();
		launchUrl("https://www.facebook.com/");
		maxwindow();
		String title = getTitle();
		System.out.println(title);
		currentUrl();
		/*PomLoginPojo l=new PomLoginPojo();
		fill(l.get, excelRead(0,0));
		fill(l.getTxtPass(),excelRead(1,0));
		btnClick(l.getBtnLogin());
		closebrowser();*/
		
		
	}

}

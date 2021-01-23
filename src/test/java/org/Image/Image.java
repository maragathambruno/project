package org.Image;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Image {
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com/");
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
		List<WebElement> images = driver.findElements(By.tagName("img"));
		int size = images.size();
		System.out.println(size);
		int count = 0;
		for (WebElement x : images) {
			String a = x.getAttribute("src");
			// System.out.println(a);
			URL u = new URL(a);
			URLConnection open = u.openConnection();
			HttpURLConnection http = (HttpURLConnection) open;
			int responsecode = http.getResponseCode();
			if (responsecode != 200 || responsecode != 201) {
				System.out.println(a);
				count++;
			}

		}
		System.out.println(count);

	}

}

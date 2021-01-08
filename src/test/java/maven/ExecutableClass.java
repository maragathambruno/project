package maven;

import javax.servlet.ServletContextAttributeEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExecutableClass extends BaseClass {
	public static void main(String[] args) {
	WebElement ref=driver.findElement(By.id("pass"));
scrollDown(ref, true);	

}


}

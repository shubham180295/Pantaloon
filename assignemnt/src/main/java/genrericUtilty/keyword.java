package genrericUtilty;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class keyword {

	public void elementClick(WebDriver driver, WebElement element) {
		try {
		element.click();
	}
		catch(WebDriverException e) {
			JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		}
}}

package genrericUtilty;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtilty {
WebDriver driver ;
	
	public void rightClick(WebDriver driver, WebElement element) {
		Actions a =new Actions(driver);
		a.contextClick(element).perform();
	
}
	
	public void switchToFrame( int index) {
		driver.switchTo().frame(index);
	}

	public void implcitWait(int time) {
		
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
//	
//	public void explictWait(WebDriver driver ,int time,String path) {
//		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(time));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
//		
	
	public void scrollWindow(WebDriver driver, WebElement element) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("document.window scroolTO(0,0)", element);
	}
 public void performAction(WebDriver driver,WebElement element) {
	Actions a =new Actions(driver);
	a.moveToElement(element).perform();
	}
 
 public void elementToBeClickable(WebDriver driver,int time, WebElement webElement) {
	 WebDriverWait wb =new WebDriverWait(driver,time);
	 wb.until(ExpectedConditions.elementToBeClickable(webElement));
	
 }
}
package genrericUtilty;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ObjectRepository.MyAccount;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClss {

fileInput f =new fileInput();
public static  WebDriver driver;

@BeforeMethod
public void configBrowser() throws IOException {
	String Browser = f.propertiesFile("Browser");
	if(Browser.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
	String Url = f.propertiesFile("url");
	driver.get(Url);
	MyAccount ma =new MyAccount(driver);
	ma.getNothankstxt().click();
}


@AfterMethod
	public void closeBrowser() {
	driver.close();

}
//	@AfterClass
//	public void  configBrowser1() {
//	driver.quit();
	
}




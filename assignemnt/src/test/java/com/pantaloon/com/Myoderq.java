package com.pantaloon.com;


	

	import java.util.regex.Pattern;
	import java.util.concurrent.TimeUnit;
	import org.testng.annotations.*;

import genrericUtilty.BaseClss;

import static org.testng.Assert.*;
	import org.openqa.selenium.*;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import java.io.File;
	import org.apache.commons.io.FileUtils;

	public class Myoderq extends BaseClss{
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private JavascriptExecutor js;

	//  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    System.setProperty("webdriver.chrome.driver", "");
	    driver = new ChromeDriver();
	    baseUrl = "https://www.google.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    js = (JavascriptExecutor) driver;
	  }

	  @Test
	  public void testUntitledTestCase() throws Exception {
	    driver.get("https://www.google.com/search?q=pantaloons&rlz=1C1CHBF_enIN959IN959&oq=pa&aqs=chrome.0.69i59j69i57j35i39j0i67i131i433l2j0i67j46i67i199i465j0i67i131i433j46i67i199i291i433j0i67i131i433.1180j0j15&sourceid=chrome&ie=UTF-8");
	    driver.findElement(By.xpath("//div[@id='tads']/div/div/div/div/div/a/div/span")).click();
	    driver.get("https://www.pantaloons.com/?utm_source=google&utm_medium=search&utm_campaign=google_pure_brand_exact&gclid=CjwKCAjwzeqVBhAoEiwAOrEmzXGAkaX2PjfizuGhCxoM9sHYgdZRrbOr_MqIwi2OUyEUWhdjx9BcZBoCpt0QAvD_BwE");
	    driver.findElement(By.xpath("//input[@type='text']")).click();
	    driver.findElement(By.xpath("//input[@type='text']")).clear();
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tops");
	    driver.findElement(By.cssSelector(".active")).submit();
	    driver.get("https://www.pantaloons.com/c/search?search_query=tops");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='SORT BY'])[1]/following::span[1]")).click();
	    driver.get("https://www.pantaloons.com/p/pink-textured-top-507851.html");
	    driver.findElement(By.xpath("//div[@id='size_M']/span")).click();
	    driver.findElement(By.xpath("//div[@id='__next']/main/div[2]/div/div[2]/section/div[5]/div[2]/div/button/span")).click();
	    driver.findElement(By.xpath("//div[@id='__next']/header/div[2]")).click();
	    //ERROR: Caught exception [ERROR: Unsupported command [doubleClick | xpath=//div[@id='__next']/header/div[2] | ]]
	    driver.findElement(By.xpath("//div[@id='__next']/header/div/div[3]/div/div/div/div/div[3]/div[4]/div/div/div/div[2]/div[2]/div[2]/div[2]/button/span")).click();
	    driver.get("https://www.pantaloons.com/cart");
	    driver.findElement(By.xpath("//div[@id='__next']/main/div/div/div[2]/div/div[3]/div[2]/div[2]/div/div[4]/button")).click();
	    driver.get("https://www.pantaloons.com/checkout?page=shipping&step=2");
	    driver.get("https://www.pantaloons.com/checkout?page=shipping&step=1");
	    driver.findElement(By.id("fname")).click();
	    driver.findElement(By.id("lname")).click();
	    driver.findElement(By.xpath("//div[@id='__next']/main/div")).click();
	    driver.findElement(By.xpath("//div[@id='__next']/main/div/div/div[2]/div[2]/div/div/div/div[2]/button/span")).click();
	    driver.findElement(By.xpath("//div[@id='__next']/main/div/div/div[2]/div[2]/div/div/div/div[2]/button/span")).click();
	    driver.findElement(By.id("postcode")).click();
	    driver.findElement(By.id("postcode")).click();
	    driver.findElement(By.id("postcode")).clear();
	    driver.findElement(By.id("postcode")).sendKeys("560076");
	    driver.findElement(By.id("building")).click();
	    driver.findElement(By.id("building")).clear();
	    driver.findElement(By.id("building")).sendKeys("shri sai pg");
	    driver.findElement(By.xpath("//form[@id='address']/div[6]/button/span")).click();
	    driver.findElement(By.xpath("//div[@id='__next']/main/div/div/div[2]/div[2]/div/div/div/div[2]/button/span")).click();
	    driver.get("https://www.pantaloons.com/checkout?page=shipping&step=2");
	    driver.findElement(By.xpath("//div[@id='panel2d-content']/div/div/div[2]/button/span")).click();
	    driver.get("https://www.pantaloons.com/checkout?page=shipping&step=3");
	  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}



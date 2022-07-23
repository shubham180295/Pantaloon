package com.pantaloon.com;

import java.awt.RenderingHints.Key;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;

import ObjectRepository.MyAccount;
import ObjectRepository.SearchPagefor;
import genrericUtilty.BaseClss;
import net.bytebuddy.asm.Advice.Enter;

public class CreateAccount extends BaseClss {
	
	
//@Test
public void MyOrder() throws InterruptedException {
MyAccount my =new MyAccount(driver);
my.getAccountTxt().click();
my.getEnterusername().sendKeys("9977141550");
my.getOtp().click();
Thread.sleep(50000);
my.getStartshopping().click();
WebElement ele = driver.findElement(By.xpath("//a[@title='My Account']"));
Actions   a =new Actions(driver);
a.moveToElement(ele).perform();
driver.findElement(By.xpath("//li[.='ORDERS']")).click();

}
	@Test
	public void myOrder() throws InterruptedException {
		MyAccount my =new MyAccount(driver);
		my.getSearchproduct().sendKeys("tops"+Keys.ENTER);
Thread.sleep(3000);
driver.findElement(By.xpath("(//span[@class=' lazy-load-image-background blur lazy-load-image-loaded'])[1]")).click();
		// driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='SORT BY'])[1]/following::span[1]")).click();
		driver.findElement(By.id("size_M")).click();
		driver.findElement(By.xpath("//span[.='ADD TO BAG']")).click();
		driver.findElement(By.linkText("#bag")).click();
		WebElement ele = driver.findElement(By.xpath("//button[.='CHECKOUT']"));
		ele.click();
	}
	@Test
	public void mouseHourOnSearchIcon() {
		SearchPagefor sea=new SearchPagefor(driver);
		
	}
	//

}

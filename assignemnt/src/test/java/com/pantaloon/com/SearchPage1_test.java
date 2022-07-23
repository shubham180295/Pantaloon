package com.pantaloon.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ObjectRepository.MyAccount;
import ObjectRepository.SearchPagefor;
import genrericUtilty.BaseClss;
import genrericUtilty.ExcelUtility;
import genrericUtilty.WebDriverUtilty;
import genrericUtilty.keyword;

public class SearchPage1_test extends BaseClss{

	WebDriverUtilty web = new WebDriverUtilty();
ExcelUtility excel=new ExcelUtility();
keyword key =new keyword();
	

@Test
public void  verifyErrorMessageTest() throws EncryptedDocumentException, IOException {
	SearchPagefor sea =new SearchPagefor(driver);
	sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 1, 2));
	key.elementClick(driver, sea.getSearchbutton());
	String expectedResult = excel.getExcelData("Search", 1, 4);
	String actualResult = sea.getErrormessage().getText();
	Assert.assertTrue(actualResult.contains(expectedResult));
	
	
}

@Test
public void  verifyErrorMessageWithMultipleItemTest() throws EncryptedDocumentException, IOException {
	SearchPagefor sea =new SearchPagefor(driver);
	sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 1, 3));
	key.elementClick(driver, sea.getSearchbutton());
	String expectedResult = excel.getExcelData("Search", 1, 5);
	String actualResult = sea.getErrormessage().getText();
	Assert.assertTrue( actualResult.contains(expectedResult));
}

	@Test//
	public void verifySearchTextfromBlankSpaceTest() throws EncryptedDocumentException, IOException, InterruptedException {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys(" ");
		key.elementClick(driver, sea.getSearchbutton());
		String expectedResult = "Sorry we couldn't find q.";
		String actualResult = sea.getErrormessage().getText();
Assert.assertTrue(actualResult.contains(expectedResult));

}
	@Test
	public void verifySearchWithoutTextTest() {
		SearchPagefor sea =new SearchPagefor(driver);
	sea.getSearchproduct().sendKeys("");
	if(sea.getSearchproduct().isEnabled()) {
		web.elementToBeClickable(driver, 10, sea.getSearchbutton());
		System.out.println("searchButton is clickable");
	}
	else {
		System.out.println("SearchButton is not clickble");
	}}


@Test
public void verifyTheOutStockItemIsNotDisplayTest() throws EncryptedDocumentException, IOException {
	SearchPagefor sea =new SearchPagefor(driver);
	sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 1, 0));
	key.elementClick(driver, sea.getSearchbutton());
	String actualResult = sea.getErrormessage().getText();
	String expecteResult = excel.getExcelData("Search", 1, 1);
	Assert.assertTrue(actualResult.contains(expecteResult));
	System.out.println(actualResult);}
	@Test
	public void verifyClearOptionTest() {
		MyAccount my = new MyAccount(driver);
		SearchPagefor sea = new SearchPagefor(driver);
		my.getSearchproduct().sendKeys("shirts");
		sea.getClearbutton().click();
		boolean empty = my.getSearchproduct().isDisplayed();
		AssertJUnit.assertEquals(empty, true);
		System.out.println("it is clear all the input ");
	}

	@Test
	public void verifyClearAllOptionTest() {
		MyAccount my = new MyAccount(driver);
		SearchPagefor sea = new SearchPagefor(driver);
		my.getSearchproduct().click();
		driver.findElement(By.xpath("//a[.='Clear All']")).click();
		AssertJUnit.assertEquals(my.getSearchproduct(), true);
		System.out.println("it clear all the recent suggestion");

	}

	@Test
	public void verifySearchfieldAfterClickOnClearButtonTest() throws EncryptedDocumentException, IOException {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 1, 11));
		key.elementClick(driver, sea.getClearbutton());
		String searchfield = sea.getSearchproduct().getAttribute("placeholder");
		AssertJUnit.assertTrue(searchfield.contains(excel.getExcelData("Search", 0, 8)));
		System.out.println("search for products and more... is displayed ");
		Reporter.log("search for products and more... is displayed ");
	}

	@Test
	public void verifyClearOPtionIsAvailableOrNotTest() {
		SearchPagefor sea =new SearchPagefor(driver);
		WebElement check = sea.getSearchproduct();
		boolean element = sea.getClearbutton().isDisplayed();
		AssertJUnit.assertEquals(element, false);
	}
	@Test//21
	public void verifyCutAndCopyTestTest() throws AWTException, EncryptedDocumentException, IOException {
		MyAccount my =new MyAccount(driver);
		SearchPagefor sea=new SearchPagefor(driver);
		my.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 0));
		Robot r =new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);	
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_CONTROL);	
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		String actualResult = driver.findElement(By.xpath("//div[@class=\"autoSuggestions_autosuggestion-container__3kD4t\"]")).getText();
		AssertJUnit.assertTrue(actualResult.contains(excel.getExcelData("Search", 0, 0)));
	}

	@Test // 23
	public void verifyMouseHourOnSearchFieldTest() {
		SearchPagefor sea = new SearchPagefor(driver);
		web.implcitWait(10);
		web.performAction(driver, sea.getSearchproduct());

	}


	@Test // 24
	public void verifyMouseHourOnSearchIconTest() throws InterruptedException {
		SearchPagefor sea = new SearchPagefor(driver);
		web.performAction(driver, sea.getSearchbutton());
	}

	@Test // 25
	public void verifyTradingSuggestionTest() throws EncryptedDocumentException, IOException {
		SearchPagefor sea = new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 1, 7));
		boolean Trading = driver.findElement(By.xpath("//li[.='Trending']")).isDisplayed();
		AssertJUnit.assertEquals(Trading, true);
		System.out.println("Trading is Displayed");
	}
	@Test
	public void verifySearchWithMultipleCharacterTest() {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys("Shoe Socks");
		sea.getSearchbutton().click();
		boolean relatedSuggestion = driver.findElement(By.xpath("//span[@class=\" lazy-load-image-background blur lazy-load-image-loaded\"]")).isDisplayed();
		if(relatedSuggestion) {
			AssertJUnit.assertEquals(relatedSuggestion, true);
			System.out.println("it wil print related suggestion");
		}
		else {
			String errorMessage = driver.findElement(By.xpath("//div[@class='Search_search-no-result-text-content__2mSHp']")).getText();
			System.out.println(errorMessage);
		}}

	@Test
	public void verifySearchWithRelatedBrandTest() {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys("People");
		sea.getSearchbutton().click();
		String brandName = driver.findElement(By.xpath("//img[@alt='People Green Regular T-shirt']")).getAttribute("title");
		AssertJUnit.assertTrue(brandName.contains("People"));
		System.out.println(brandName);
	}

	@Test
	public void verifySearchWithMultipleBrandTest() {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys("People Honey");
		sea.getSearchbutton().click();
		String errorMessage = driver.findElement(By.xpath("//div[@class='Search_search-no-result-text-content__2mSHp']")).getText();
		AssertJUnit.assertTrue(errorMessage.contains("Sorry we couldn't find people honey."));
		System.out.println(errorMessage);

	}

	@Test
	public void verifySearchWithMultipleBrandsTest() {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys("People or Honey");
		sea.getSearchbutton().click();
		String relatedMessage1 = driver.findElement(By.xpath("//div[@class=\"Search_search-no-result-text-content__2mSHp\"]")).getText();
		System.out.println(relatedMessage1);
		AssertJUnit.assertTrue(relatedMessage1.contains("Sorry we couldn't find people or honey"));
		driver.navigate().back();
		sea.getSearchproduct().clear();
		sea.getSearchproduct().sendKeys("People And Honey");
		sea.getSearchbutton().click();
		String relatedMessage2 = driver.findElement(By.xpath("//div[@class=\"Search_search-no-result-text-content__2mSHp\"]")).getText();
		System.out.println(relatedMessage2);
		AssertJUnit.assertTrue(relatedMessage2.contains("Sorry we couldn't find people and honey"));
		System.out.println(relatedMessage2);
}
	@Test
	public void verifySearchWithFitTypeTest() throws InterruptedException, EncryptedDocumentException, IOException {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 12));
		Thread.sleep(3000);
		key.elementClick(driver, sea.getSearchbutton());
		WebElement element = driver.findElement(By.xpath("(//div[@class=\"MuiCardContent-root PlpWeb_product-card-content__3OX6s\"])[1]"));
		web.elementToBeClickable(driver, 10, element);
		key.elementClick(driver, element);
		String result = driver.findElement(By.xpath("//div[@class=\"MuiAccordionDetails-root accordion-details\"]/descendant::li[5]")).getText();
		AssertJUnit.assertTrue(result.contains(excel.getExcelData("Search", 0, 12)));
		System.out.println(result);

	}

	@Test
	public void verifyPriceTest() {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys("between -10000");
		sea.getSearchbutton().click();
		String relatedMessage = sea.getErrormessage().getText();
		AssertJUnit.assertTrue( relatedMessage.contains("Sorry we couldn't find between 1000"));
		System.out.println(relatedMessage);
	}
	@Test
	public void verifySearchByProductMaterialTest() throws EncryptedDocumentException, IOException, InterruptedException {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 1, 9));
		Thread.sleep(3000);
		key.elementClick(driver, sea.getSearchbutton());
		WebElement element = driver.findElement(By.xpath("(//div[@class=\"MuiCardContent-root PlpWeb_product-card-content__3OX6s\"])[1]"));
		web.elementToBeClickable(driver, 10, element);
		key.elementClick(driver, element);
		String result = driver.findElement(By.xpath("//div[@class=\"MuiAccordionDetails-root accordion-details\"]/descendant::li[6]")).getText();
		System.out.println(result);
		AssertJUnit.assertTrue(result.contains(excel.getExcelData("Search", 1, 9)));

	}

	@Test
	public void verifySearchByLengthTest() throws InterruptedException, EncryptedDocumentException, IOException {
		SearchPagefor  sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 1, 6));
		Thread.sleep(3000);
		key.elementClick(driver, sea.getSearchbutton()); 
		WebElement element = driver.findElement(By.xpath("(//div[@class=\"MuiCardContent-root PlpWeb_product-card-content__3OX6s\"])[1]"));
		web.elementToBeClickable(driver, 10, element);
		key.elementClick(driver, element);
		String actualResult = driver.findElement(By.xpath("//div[@class=\"MuiAccordionDetails-root accordion-details\"]/descendant::li[7]")).getText();
		System.out.println(actualResult);
		AssertJUnit.assertTrue(actualResult.contains(excel.getExcelData("Search", 1, 6)));
	}
	
	@Test
	public void enterAlphaNumericTest() throws EncryptedDocumentException, IOException {
		MyAccount my = new MyAccount(driver);
		my.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 3));
		SearchPagefor sea = new SearchPagefor(driver);
		key.elementClick(driver, sea.getSearchbutton());
		String result = sea.getErrormessage().getText();
		AssertJUnit.assertTrue(result.contains(excel.getExcelData("Search", 0, 4)));
		System.out.println(result);
		System.out.println("it is not showing error");
	}
	
	@Test
	public void verifyMouseHourOnClearButtonTest() throws EncryptedDocumentException, IOException {
		MyAccount my = new MyAccount(driver);
		my.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 6));
		SearchPagefor sea = new SearchPagefor(driver);
		web.performAction(driver, sea.getClearbutton());
		String tooltip = sea.getClearbutton().getAttribute("title");
		AssertJUnit.assertTrue(tooltip.contains("Clear"));
		System.out.println("tooltip is displayed");
	}

	@Test
	public void verifyMouseHouseOnSearchIconTest() throws EncryptedDocumentException, IOException  {
		MyAccount my = new MyAccount(driver);
		my.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 6));
		SearchPagefor sea = new SearchPagefor(driver);
		web.performAction(driver, sea.getSearchbutton());
		String tooltip = sea.getSearchbutton().getAttribute("class");
		AssertJUnit.assertEquals(tooltip, excel.getExcelData("Search", 0, 7));
		System.out.println("tooltip is not displayed");
//}}
}}


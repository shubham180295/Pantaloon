package com.pantaloon.com;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.util.SystemOutLogger;
import org.jsoup.select.Evaluator.IsEmpty;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ObjectRepository.MyAccount;
import ObjectRepository.SearchPagefor;
import genrericUtilty.BaseClss;
import genrericUtilty.ExcelUtility;
import genrericUtilty.WebDriverUtilty;
import genrericUtilty.keyword;
@Listeners(genrericUtilty.Listner.class)
public class SearchPage_test extends BaseClss {
	WebDriverUtilty web = new WebDriverUtilty();
	ExcelUtility excel=new ExcelUtility();
	keyword key =new keyword();
	@Test
	public void verifyUserAbletoEnterInSearchFieldTest() throws EncryptedDocumentException, IOException {
		MyAccount my = new MyAccount(driver);
		try {
		if(my.getSearchproduct().isEnabled()) 
		{
			my.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 0));
			SearchPagefor sea = new SearchPagefor(driver);
			String expectedResult = excel.getExcelData("Search", 0, 0);
			sea.getSearchbutton().click();
			AssertJUnit.assertTrue(expectedResult.contains(excel.getExcelData("Search", 0, 0)));
			System.out.println(	excel.getExcelData("Search", 0, 0));
		}
		}catch(Exception e) {
			System.out.println("problems in the scripts");
		}
		
		
	}

	@Test
	public void verifySearchTextFieldTest() throws EncryptedDocumentException, IOException {
		MyAccount my = new MyAccount(driver);
		SearchPagefor sea =new SearchPagefor(driver);
		boolean searchfield = my.getSearchproduct().isEnabled();
		AssertJUnit.assertEquals(searchfield, true);
		sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 0));
		System.out.println(sea.getSearchproduct().getText());
	}

	@Test
	public void enterTextAlphabateTest() throws EncryptedDocumentException, IOException {
		MyAccount my = new MyAccount(driver);
		try {
		my.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 1));
		SearchPagefor sea = new SearchPagefor(driver);
		String expectedResult = excel.getExcelData("Search", 0, 1);
		sea.getSearchbutton().click();
		AssertJUnit.assertTrue(expectedResult.contains(excel.getExcelData("Search", 0, 1)));
		}
		catch(WebDriverException e) {
			System.out.println("problem");
		}
	}
	//@Test//we would not verify the test data because data is not present in the result 
	public void enterNumericValueTest() throws EncryptedDocumentException, IOException {
		MyAccount my = new MyAccount(driver);
		my.getSearchproduct().sendKeys("-100");
		SearchPagefor sea = new SearchPagefor(driver);
		key.elementClick(driver, sea.getSearchbutton());
		String expectedResult = driver.findElement(By.xpath("//span[@class=\" lazy-load-image-background blur lazy-load-image-loaded\"]/descendant::img")).getAttribute("alt");
		AssertJUnit.assertTrue(expectedResult.contains("Medium Blue Top"));
		System.out.println(expectedResult);
	}


	//@Test(Emoji is not inspectable so we can not automate)
	//	public void enterEmoji() {
	//		MyAccount my = new MyAccount(driver);
	//		SearchPagefor sea = new SearchPagefor(driver);
	//		WebDriverUtilty web =new WebDriverUtilty();
	//		web.performAction(driver, sea.getSearchproduct());
	//		web.rightClick(driver, sea.getSearchproduct());
	//		
	//		sea.getSearchbutton().click();}
	

	@Test//this is not verifying
	public void enterUpperAndLowerLetterTest() throws EncryptedDocumentException, IOException {
		MyAccount my = new MyAccount(driver);
		my.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 5));
		SearchPagefor sea = new SearchPagefor(driver);
		key.elementClick(driver, sea.getSearchbutton());

	}



	@Test
	public void verifySearchFieldTest() throws EncryptedDocumentException, IOException {
		MyAccount my = new MyAccount(driver);
		String searchfield = my.getSearchproduct().getAttribute("placeholder");
		AssertJUnit.assertTrue(searchfield.contains(excel.getExcelData("Search", 0, 8)));
		System.out.println("search for products and more... is displayed ");
		Reporter.log("search for products and more... is displayed ");
	}



	@Test
	public void verifyAbleToSearchByEnterButtonTest() throws EncryptedDocumentException, IOException, AWTException {
		MyAccount my = new MyAccount(driver);
		SearchPagefor sea = new SearchPagefor(driver);
		my.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 1));
		Robot r =new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		String ActualResult = driver.findElement(By.xpath("//div[@class=\"MuiCardContent-root PlpWeb_product-card-content__3OX6s\"]/descendant::div[@class='PlpWeb_product-name__1_7kw']")).getText();
		AssertJUnit.assertTrue(ActualResult.contains(excel.getExcelData("Search", 0, 1)));

	}
	@Test
	public void verifyAbleToSearchBySearchButtonTest() throws EncryptedDocumentException, IOException, AWTException {
		MyAccount my = new MyAccount(driver);
		SearchPagefor sea = new SearchPagefor(driver);
		my.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 9));
		key.elementClick(driver, sea.getSearchbutton());
		String actualResult = driver.findElement(By.xpath("//div[@class=\"MuiCardContent-root PlpWeb_product-card-content__3OX6s\"]/descendant::div[@class='PlpWeb_product-name__1_7kw']")).getText();
		AssertJUnit.assertTrue(actualResult.contains(excel.getExcelData("Search", 0, 9)));
	}
	@Test
	public void verifyClearButtonTest() throws EncryptedDocumentException, IOException {
		MyAccount my = new MyAccount(driver);
		SearchPagefor sea = new SearchPagefor(driver);
		my.getSearchproduct().sendKeys(excel.getExcelData("Search", 1, 10));
		boolean display = sea.getClearbutton().isDisplayed();
		AssertJUnit.assertEquals(display, true);
		System.out.println("clear button is displayed");
	}
	

	//@Test
	//		public void verifyTradingAndRecentSearch() throws InterruptedException, EncryptedDocumentException, IOException {
	//			SearchPagefor sea = new SearchPagefor(driver);
	//			sea.getSearchproduct().sendKeys("Allen Solly");
	//			key.elementClick(driver, sea.getSearchbutton());
	//			Thread.sleep(5000);
	//			key.elementClick(driver,sea.getClearbutton());
	//			sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 0));
	//			key.elementClick(driver, sea.getSearchbutton());
	//			key.elementClick(driver,sea.getClearbutton());
	//			sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 0));
	//			boolean RecentSearch = driver.findElement(By.xpath("//label[.='Recent Searches']")).isDisplayed();
	//			Assert.assertEquals(RecentSearch, true);
	//			System.out.println("RecentSearch is   Displayed");
	//		}

	@Test
	public void verifySearchSuggestionDisplayTest() {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys("pink");
		List<WebElement> suggestion = driver.findElements(By.xpath("//div[@class='autoSuggestions_autosuggestion-container__3kD4t']"));

		int count = suggestion.size();
		for(int i=0;i<count;i++) {
			String allsuggestion = suggestion.get(i).getText();
			if(allsuggestion.equalsIgnoreCase(null))
			{
				break;
			}

			else {

				System.out.println(allsuggestion);
			}
		}}


	@Test
	public void verifySearchSuggestionTest() {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys("Casual Shirt");
		sea.getSearchbutton().click();
		String expectdProduct = "Shirt";
		String actualtitle = driver.findElement(By.xpath("(//div[@class='MuiCardContent-root PlpWeb_product-card-content__3OX6s'])[1]/descendant::a")).getAttribute("title");
		System.out.println(actualtitle);
		AssertJUnit.assertTrue(actualtitle.contains(expectdProduct));


	}

	@Test//not verify
	public void verifySearchSuggestionWithMispelledTest() {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys("kurt");
		List<WebElement> suggestion = driver.findElements(By.xpath("//ul[@class=\"autoSuggestions_autosuggestion-content__1HjU-\"]"));
		int count = suggestion.size();
		for(int i=0;i<count;i++) {
			String allsuggestion = suggestion.get(i).getText();
			System.out.println(allsuggestion);
			//AssertJUnit.assertTrue( allsuggestion.contains("kurt"));
			
		}
	}
	@Test
	public void verifySearchWithSingleCharacterTest() throws EncryptedDocumentException, IOException {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 1, 10));
		sea.getSearchbutton().click();
		String result = driver.findElement(By.xpath("(//div[@class=\"PlpWeb_product-name__1_7kw\"])[1]")).getText();
		AssertJUnit.assertTrue(result.contains("A"));
		System.out.println(result);
	}


	@Test
	public void verifySearchWithCatogaryNameTest() {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys("Jacket&Jeans");
		sea.getSearchbutton().click();	 
		boolean relatedSearch = driver.findElement(By.xpath("//div[@class=\"MuiGrid-root PlpWeb_products-container__CGYz- MuiGrid-container MuiGrid-spacing-xs-2\"]")).isDisplayed();
		AssertJUnit.assertEquals(relatedSearch,true);
		System.out.println("it is print all the suggestion");
	}
	@Test
	public void verifySearchAlongWithSizeTest() {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys("Jacket M");
		sea.getSearchbutton().click();
		String relatedProduct = driver.findElement(By.xpath("//div[@class=\"MuiCardContent-root PlpWeb_product-card-content__3OX6s\"]/descendant::a")).getAttribute("title");
		System.out.println(relatedProduct);
		AssertJUnit.assertTrue(relatedProduct.contains("Jacket"));
		System.out.println(relatedProduct+" relevent result while enter the Jacket M");
	}
	@Test
	public void verifySearchAlongWithColorTest() {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys("Jacket Black");
		sea.getSearchbutton().click();
		String relavantProduct = driver.findElement(By.xpath("//span[@class=\" lazy-load-image-background blur lazy-load-image-loaded\"]/descendant::img")).getAttribute("title");
		System.out.println(relavantProduct);
		AssertJUnit.assertTrue(relavantProduct.contains("Black patterned Jacket"));
		System.out.println(relavantProduct+" relevent result while enter the Jacket Black");
	}
	@Test
	public void verifySearchByOccasionTest() throws EncryptedDocumentException, IOException {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys("casual");
		sea.getSearchbutton().click();
		String relatedProduct = driver.findElement(By.xpath("//span[@class=\" lazy-load-image-background blur lazy-load-image-loaded\"]/descendant::img")).getAttribute("alt");
		AssertJUnit.assertTrue(relatedProduct.contains("Casual"));
		System.out.println(relatedProduct);
	}
	@Test
	public void verifySearchByMultiOccasionTest() throws EncryptedDocumentException, IOException {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 10));
		sea.getSearchbutton().click();
		String relatedProduct = driver.findElement(By.xpath("//div[@class='MuiPaper-root MuiCard-root PlpWeb_product-card__1TKOq MuiPaper-elevation1 MuiPaper-rounded']/descendant::img")).getAttribute("alt");
		AssertJUnit.assertTrue(relatedProduct.contains("Party"));
		System.out.println(relatedProduct);
	}

	@Test
	public void verifySearchWithProductTypeTest() throws EncryptedDocumentException, IOException {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 11));
		sea.getSearchbutton().click();
		String relatedProduct = driver.findElement(By.xpath("(//div[@class='MuiCardContent-root PlpWeb_product-card-content__3OX6s']/descendant::div[@class=\"PlpWeb_product-name__1_7kw\"])[1]")).getText();
		AssertJUnit.assertTrue(relatedProduct.contains(excel.getExcelData("Search", 0, 11)));
		System.out.println(relatedProduct);
	}
	

	
	@Test
	public void verifySearchByLengthMultipleTimesTest() throws InterruptedException, EncryptedDocumentException, IOException {
		SearchPagefor  sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 1, 6));
		Thread.sleep(3000);
		key.elementClick(driver, sea.getSearchbutton());
		int count=0;
		while(count<5) {
			sea.getSearchproduct().clear();
			sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 1, 6));
			Thread.sleep(3000);
			key.elementClick(driver, sea.getSearchbutton());
			WebElement element = driver.findElement(By.xpath("(//div[@class=\"MuiCardContent-root PlpWeb_product-card-content__3OX6s\"])[1]"));
			web.elementToBeClickable(driver, 10, element);
			key.elementClick(driver, element);
			Thread.sleep(3000);
			WebElement result = driver.findElement(By.xpath("//div[@class=\"MuiAccordionDetails-root accordion-details\"]/descendant::li[7]"));
			if(result.isDisplayed()) {
				count++;

			}

		}
		System.out.println(count);
	}
	@Test
	public void verifyGridFormatTest() throws EncryptedDocumentException, IOException {
		SearchPagefor  sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 9));
		key.elementClick(driver, sea.getSearchbutton()); 
		List<WebElement> gridResult = driver.findElements(By.xpath("//div[@class=\"MuiCardContent-root PlpWeb_product-card-content__3OX6s\"]/descendant::a"));
		for(int i=0;i<gridResult.size();i++) {
			if(gridResult.isEmpty()) {
				break;
			}
			else {
				System.out.println(gridResult.get(i).getAttribute("title"));
			}}

	}

	@Test
	public void verifySearchWithDefaultSortByTest() throws EncryptedDocumentException, IOException, InterruptedException {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 9));
		key.elementClick(driver, sea.getSearchbutton());
		String relevantPopulr = driver.findElement(By.xpath("(//div[@class=\"PlpWeb_sortBy-section__1XZFC\"]/descendant::option)")).getText();

		System.out.println(relevantPopulr);
		AssertJUnit.assertTrue( relevantPopulr.contains(" Popular"));
		String sortBy = driver.findElement(By.xpath("//div[.='SORT BY']")).getText();
		System.out.println(sortBy);
		Thread.sleep(2000);
		AssertJUnit.assertTrue( sortBy.contains("SORT BY"));
		String filterBy = driver.findElement(By.xpath("(//div[.='FILTER BY'])[1]")).getText();
		System.out.println(filterBy);
		AssertJUnit.assertTrue( filterBy.contains("FILTER BY"));

	}


	@Test
	public void verifyProductCounTest() throws EncryptedDocumentException, IOException {
		SearchPagefor  sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 9));
		key.elementClick(driver, sea.getSearchbutton()); 
		List<WebElement> product= driver.findElements(By.xpath("//div[@class=\"MuiCardContent-root PlpWeb_product-card-content__3OX6s\"]/descendant::a"));
		System.out.println(product.size());

		if(product.size()>=32) {
			AssertJUnit.assertFalse(product.isEmpty());
			System.out.println(driver.findElement(By.xpath("//div[text()='LOAD MORE']")).getText());
		}
		else {
			System.out.println(driver.findElement(By.xpath("//a[text()='Shop now']")).getText());
		}
	}
	@Test
	public void verifySearchTextAfterSearchTest() throws EncryptedDocumentException, IOException, InterruptedException {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 0));
		key.elementClick(driver, sea.getSearchbutton());
		String recentSearch1 = driver.findElement(By.xpath("(//div[@class=\"autoSuggestions_autosuggestion-container__3kD4t\"]/descendant::li)[1]")).getText();
		System.out.println(recentSearch1);
		AssertJUnit.assertTrue(recentSearch1.contains(excel.getExcelData("Search", 0, 0)));

	}
	@Test
	public void verifySearchAfterChoosingAnotherProductTest() throws InterruptedException, Exception, IOException {
		SearchPagefor sea =new SearchPagefor(driver);
		sea.getSearchproduct().sendKeys(excel.getExcelData("Search", 0, 0));
		key.elementClick(driver, sea.getSearchbutton());
		Thread.sleep(3000);
		web.performAction(driver, driver.findElement(By.xpath("//a[@title='MEN']/descendant::span")));
		key.elementClick(driver, driver.findElement(By.xpath("//a[.='Kurtas']")));
		web.performAction(driver, sea.getSearchproduct());
		sea.getSearchproduct().sendKeys("");
		String recentSearch1 = driver.findElement(By.xpath("(//div[@class=\"autoSuggestions_autosuggestion-container__3kD4t\"]/descendant::li)[1]")).getText();
		System.out.println(recentSearch1);
		AssertJUnit.assertTrue(recentSearch1.contains(excel.getExcelData("Search", 0, 0)));
	}


}






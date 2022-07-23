package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount  {
	WebDriver driver;
	
 public MyAccount(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//a[@title='My Account']")
private	WebElement accountTxt;
	
	@FindBy(xpath="//input [@placeholder='Search for products and more...']")
	private WebElement searchproduct;
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement enterphone;
	
	@FindBy(xpath="//span[.='Get OTP']")
	private WebElement otp;
	
	@FindBy(xpath="//span[text()='Start Shopping']")
	private WebElement startshopping;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSearchproduct() {
		return searchproduct;
	}

	public void setSearchproduct(WebElement searchproduct) {
		this.searchproduct = searchproduct;
	}

	public WebElement getEnterphone() {
		return enterphone;
	}

	public void setEnterphone(WebElement enterphone) {
		this.enterphone = enterphone;
	}

	public void setOtp(WebElement otp) {
		this.otp = otp;
	}

	@FindBy(xpath="//button[@class='No thanks']")
	WebElement nothankstxt;
	public WebElement getNothankstxt() {
		return nothankstxt;
	}

	public void setNothankstxt(WebElement nothankstxt) {
		this.nothankstxt = nothankstxt;
	}

	public WebElement getStartshopping() {
		return startshopping;
	}

	public void setStartshopping(WebElement startshopping) {
		this.startshopping = startshopping;
	}

	public WebElement getAccountTxt() {
		return accountTxt;
	}

	public void setAccountTxt(WebElement accountTxt) {
		this.accountTxt = accountTxt;
	}

	public WebElement getEnterusername() {
		return enterphone;
	}


	

	public WebElement getOtp() {
		return otp;
	}
}

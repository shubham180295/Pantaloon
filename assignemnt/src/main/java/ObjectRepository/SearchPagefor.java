package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPagefor {
WebDriver driver;
	public SearchPagefor(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	public WebElement getSearchbutton() {
		return searchbutton;
	}
	public void setSearchbutton(WebElement searchbutton) {
		this.searchbutton = searchbutton;
	}
	@FindBy(xpath="//div[@class='search-bar-content-textSearch-icon']")
	private WebElement searchbutton;
	
	@FindBy(xpath = "//input[@placeholder='Search for products and more...']")
	private WebElement searchproduct;
	
	@FindBy(xpath="//div[@class='Search_search-no-result-text-content__2mSHp']")
	private WebElement errormessage;
	
	@FindBy(xpath="(//img[@alt=\"White Printed Casual Shirt\"])[1]")
	private WebElement ActualProduct;
	
	public WebElement getActualProduct() {
		return ActualProduct;
	}
	public void setActualProduct(WebElement actualProduct) {
		ActualProduct = actualProduct;
	}
	public WebElement getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(WebElement errormessage) {
		this.errormessage = errormessage;
	}
	@FindBy(xpath="//div[@class=\"MuiGrid-root PlpWeb_products-container__CGYz- MuiGrid-container MuiGrid-spacing-xs-2\"]")
	private WebElement allJacket;
	
	public WebElement getAllJacket() {
		return allJacket;
	}
	public void setAllJacket(WebElement allJacket) {
		this.allJacket = allJacket;
	}
	public WebElement getSearchproduct() {
		return searchproduct;
	}
	public void setSearchproduct(WebElement searchproduct) {
		this.searchproduct = searchproduct;
	}
	@FindBy(xpath="//a[.='Clear']")
	private WebElement clearbutton;
	
	public WebElement getClearbutton() {
		return clearbutton;
	}
	public void setClearbutton(WebElement clearbutton) {
		this.clearbutton = clearbutton;
	}
}

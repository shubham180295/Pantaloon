package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
public LoginPage(WebDriver rdriver) {
	this.ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}
@FindBy(xpath="//div[.='Login']")
private WebElement loginbutton;

@FindBy(xpath="//input[@data-testid=\"user-mobileno-input-box\"]")
private WebElement usernametxt;

@FindBy(xpath="//input[@data-testid=\"password-input-box-cta\"]")
private WebElement passwordtxt;

public WebElement getLoginbutton() {
	return loginbutton;
}

public void setLoginbutton(WebElement loginbutton) {
	this.loginbutton = loginbutton;
}

public WebElement getUsernametxt() {
	return usernametxt;
}

public void setUsernametxt(WebElement usernametxt) {
	this.usernametxt = usernametxt;
}

public WebElement getPasswordtxt() {
	return passwordtxt;
}

public void setPasswordtxt(WebElement passwordtxt) {
	this.passwordtxt = passwordtxt;
}


}

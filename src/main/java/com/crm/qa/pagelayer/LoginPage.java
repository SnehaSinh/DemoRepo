package com.crm.qa.pagelayer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclass.BaseClassInitialization;

public class LoginPage extends BaseClassInitialization {

	// PageFactory
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement logInBtn;
	@FindBy(name = "email")
	WebElement userName;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement SignUp;

	public LoginPage() throws IOException {
		// super();
		PageFactory.initElements(driver, this);

	}

	public HomePage Login(String un, String pwd) throws IOException {
		userName.sendKeys(un);
		password.sendKeys(pwd);
		logInBtn.click();
		return new HomePage();
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public boolean SignUpBtn() {
		return SignUp.isEnabled();
	}
}

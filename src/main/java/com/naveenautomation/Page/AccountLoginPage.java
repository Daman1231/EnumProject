package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class AccountLoginPage extends TestBase {

	public AccountLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#input-email")
	WebElement EmailId;

	@FindBy(css = "#input-password")
	WebElement password;

	@FindBy(css = "input.btn")
	WebElement loginBtn;

	private void inputEmail(String email) {
		EmailId.sendKeys(email);
	}

	private void inputPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public String getAccountLoginPageTitle() {
		
		return driver.getTitle();
	}
	

	public MyAccountPage clickLoginBtn(String email, String password) {
		inputEmail(email);
		inputPassword(password);
		loginBtn.click();
		return new MyAccountPage();
	}

}

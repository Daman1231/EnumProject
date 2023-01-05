package com.Week18Assignment.EnumPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLoginPage extends com.Week18Assignment.EnumBase.TestBase {

	public AccountLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#input-email")
	WebElement EmailId;

	@FindBy(css = "#input-password")
	WebElement password;

	@FindBy(css = "input.btn")
	WebElement loginBtn;

	public void inputEmail(String email) {
		EmailId.sendKeys(email);
	}

	public void inputPassword(String pass) {
		password.sendKeys(pass);
	}

	public YourStoreLaptopNoteBookPage clickLoginBtn(String email, String password) {
		inputEmail(email);
		inputPassword(password);
		loginBtn.click();
		return new YourStoreLaptopNoteBookPage();
	}

}

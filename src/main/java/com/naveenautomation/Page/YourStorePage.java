package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourStorePage extends com.naveenautomation.Base.TestBase {
	public YourStorePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "li.dropdown span:first-of-type")
	WebElement myAccount;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement login;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement register;

	private void clickRegister() {
		register.click();
	}

	private void clickMyAccount() {
		myAccount.click();
	}

	private void clickLogin() {
		login.click();
	}

	public RegisterAccountPage clickRegisterBtn() {
		clickMyAccount();
		clickRegister();
		return new RegisterAccountPage();
	}

	public AccountLoginPage clickLoginBtn() {
		clickMyAccount();
		clickLogin();
		return new AccountLoginPage();
	}

}

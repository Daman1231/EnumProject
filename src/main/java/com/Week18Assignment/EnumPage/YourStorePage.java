package com.Week18Assignment.EnumPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourStorePage extends com.Week18Assignment.EnumBase.TestBase {
	public YourStorePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "li.dropdown span:first-of-type")
	WebElement myAccount;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement login;

	private void clickMyAccount() {
		myAccount.click();
	}

	private void clickLogin() {
		login.click();
	}

	public AccountLoginPage clickLoginBtn() {
		clickMyAccount();
		clickLogin();
		return new AccountLoginPage();
	}

}

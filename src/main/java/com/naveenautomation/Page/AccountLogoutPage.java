package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLogoutPage extends com.naveenautomation.Base.TestBase {
	public AccountLogoutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h1")
	WebElement accountLogOut;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement logoutContinueBtn;

	public String AccountLogoutText() {
		return accountLogOut.getText();
	}

	public YourStorePage accountLogoutContinueBtn() {
		AccountLogoutText();
		logoutContinueBtn.click();
		return new YourStorePage();
	}

}

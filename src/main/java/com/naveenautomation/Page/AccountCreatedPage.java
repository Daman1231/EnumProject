package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage extends com.naveenautomation.Base.TestBase{

	public AccountCreatedPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h1")
	WebElement accountCreatedSuccesfull;

	public String accountCreatedSuccessFullPage() {
		return accountCreatedSuccesfull.getText();
	}

}

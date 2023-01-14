package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsLetterSubscriptionPage extends com.naveenautomation.Base.TestBase {
	public NewsLetterSubscriptionPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "label.radio-inline:first-of-type input")
	WebElement yesRadioButton;

	@FindBy(css = "input.btn")
	WebElement clickContinue;

	private void newsLetterSubscription() {
		yesRadioButton.click();
	}

	public MyAccountPage clickContinueBtn() {
		newsLetterSubscription();
		clickContinue.click();
		return new MyAccountPage();
	}
}

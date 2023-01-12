package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends  com.naveenautomation.Base.TestBase{

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()=\"Edit your account information\"]")
	WebElement editYourAccountInfo;

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement succesTextForMyAccount;

	public String getMyAccountText() {
		return succesTextForMyAccount.getText();
	}
	
	public MyAccountInformationPage editYourAccountInformation() {
		editYourAccountInfo.click();
		return new MyAccountInformationPage();
	}
}

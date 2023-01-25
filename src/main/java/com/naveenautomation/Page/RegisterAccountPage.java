package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage extends com.naveenautomation.Base.TestBase {

	public RegisterAccountPage() {
		PageFactory.initElements(local.get(), this);
	}

	@FindBy(css = "#input-firstname")
	WebElement firstName;

	@FindBy(css = "#input-lastname")
	WebElement lastName;

	@FindBy(css = "#input-email")
	WebElement email;

	@FindBy(css = "#input-telephone")
	WebElement telephone;

	@FindBy(css = "#input-password")
	WebElement password;

	@FindBy(css = "#input-confirm")
	WebElement confirmPassword;

	@FindBy(css = "input[type='checkbox']")
	WebElement privacyPolicycheckBox;

	@FindBy(css = "input.btn")
	WebElement continueBtn;

	private void fName(String fName) {
		firstName.sendKeys(fName);
	}

	private void lName(String lName) {
		lastName.sendKeys(lName);
	}

	private void email(String emailId) {
		email.sendKeys(emailId);
	}

	private void telephone(String mobile) {
		telephone.sendKeys(mobile);
	}

	private void password(String pass) {
		password.sendKeys(pass);
	}

	private void confirmPassword(String cPassword) {
		confirmPassword.sendKeys(cPassword);
	}

	private void clickPrivacyPolicy() {
		privacyPolicycheckBox.click();
	}

	public AccountCreatedPage signUpAccount(String first, String last, String email, String mobile, String pass,
			String confirmPass) {
		fName(first);
		lName(last);
		email(email);
		telephone(mobile);
		password(pass);
		confirmPassword(confirmPass);
		clickPrivacyPolicy();
		continueBtn.submit();
		return new AccountCreatedPage();

	}
}

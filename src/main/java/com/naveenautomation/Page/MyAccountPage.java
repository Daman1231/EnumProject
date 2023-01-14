package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends com.naveenautomation.Base.TestBase {

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=\"Edit your account information\"]")
	WebElement editYourAccountInfo;

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement succesTextForMyAccount;

	@FindBy(css = "#content h2:first-of-type")
	WebElement myAccountSuccessfull;

	@FindBy(css = "#content ul.list-unstyled:nth-of-type(4) a")
	WebElement subscribeUnsubscribe;

	@FindBy(css = "div.alert-success")
	WebElement newsletterSubscriptionAlertSuccess;

	@FindBy(css = "div.list-group a:last-of-type")
	WebElement logOutLink;

	@FindBy(css = "#menu>div:last-of-type>ul>li:nth-of-type(2)>a")
	WebElement laptopAndNoteBook;

	@FindBy(xpath = "//a[text()='Show All Laptops & Notebooks']")
	WebElement showAllLaptopsAndNoteBooks;

	@FindBy(css = "div.list-group a:nth-of-type(4)")
	WebElement addressBookLink;

	private void clickLaptopAndNotebook() {
		laptopAndNoteBook.click();
	}

	public String getMyAccountText() {
		return succesTextForMyAccount.getText();
	}

	public String accountLoginSuccesfullPage() {
		return myAccountSuccessfull.getText();
	}

	public MyAccountInformationPage clickEditAccountInfo() {
		editYourAccountInfo.click();
		return new MyAccountInformationPage();
	}

	public String successAlertMessage() {
		return newsletterSubscriptionAlertSuccess.getText();
	}

	public AccountLogoutPage clickLogoutLink() {
		logOutLink.click();
		return new AccountLogoutPage();
	}

	public NewsLetterSubscriptionPage subscribeUnsubscribeNewsLetter() {
		subscribeUnsubscribe.click();
		return new NewsLetterSubscriptionPage();
	}

	public MyAccountInformationPage editYourAccountInformation() {
		editYourAccountInfo.click();
		return new MyAccountInformationPage();
	}

	public AddressBookPage clickAddressBook() {
		addressBookLink.click();
		return new AddressBookPage();
	}

	public LaptopsAndNotebooksPage clickShowLaptopsAndNotebooks() {
		clickLaptopAndNotebook();
		showAllLaptopsAndNoteBooks.click();
		return new LaptopsAndNotebooksPage();
	}
}

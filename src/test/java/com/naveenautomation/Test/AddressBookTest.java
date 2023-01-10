package com.naveenautomation.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Page.AccountLoginPage;
import com.naveenautomation.Page.AddressBookPage;
import com.naveenautomation.Page.YourStoreLaptopNoteBookPage;
import com.naveenautomation.Page.YourStorePage;

public class AddressBookTest extends TestBase {

	YourStorePage yourStoreLoginPage;
	AccountLoginPage accountLoginPage;
	YourStoreLaptopNoteBookPage yourStoreLaptopNoteBookPage;
	SoftAssert sf;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		yourStoreLoginPage = new YourStorePage();
		accountLoginPage = yourStoreLoginPage.clickLoginBtn();
		yourStoreLaptopNoteBookPage = accountLoginPage.clickLoginBtn("daman@gmail.com", "Daman1231");
		sf = new SoftAssert();
	}

	@Test
	public void verifyUSerIsAbleToEditAddress() {
		AddressBookPage addressBookPage = yourStoreLaptopNoteBookPage.clickAddressBook();
		addressBookPage.editAddressBook("M6V 4P5");
		sf.assertEquals(addressBookPage.addressAlertSuccessText(), "Your address has been successfully updated",
				"Address Change Unsuccesfull...");

	}

	@AfterMethod
	public void tearDown() {
//		quitBrowser();
	}
}

package com.naveenautomation.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Page.AccountLoginPage;
import com.naveenautomation.Page.AddressBookPage;
import com.naveenautomation.Page.MyAccountInformationPage;
import com.naveenautomation.Page.MyAccountPage;
import com.naveenautomation.Page.YourStorePage;
import com.naveenautomation.Utils.ExcelUtils;

public class AccountLoginTest extends TestBase {
	YourStorePage yourStoreLoginPage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	SoftAssert sf;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		yourStoreLoginPage = new YourStorePage();
		accountLoginPage = yourStoreLoginPage.clickLoginBtn();
		
		sf = new SoftAssert();
	}

	@Test
	public void verifyLogin() {
		myAccountPage = accountLoginPage.clickLoginButton("daman@gmail.com", "Daman1231");
		sf.assertEquals(myAccountPage.getMyAccountText(), "My Account", "Login failed");
	}

	@Test
	public void verifyAlertBannerCredential() {
		myAccountPage = accountLoginPage.clickLoginButton("daman@gmail.com", "Daman1231");
		sf.assertEquals(accountLoginPage.verifyalertTextBanner(),
				" Warning: No match for E-Mail Address and/or Password.", "Alert text does'nt match");
	}

	@Test
	public void verifyUSerIsAbleToEditAddress() {
		myAccountPage = accountLoginPage.clickLoginButton("daman@gmail.com", "Daman1231");
		AddressBookPage addressBookPage = myAccountPage.clickAddressBook();
		addressBookPage.editAddressBook("L6S 1R3");
		sf.assertEquals(addressBookPage.addressAlertSuccessText(), "Your address has been successfully updated",
				"Address Change Unsuccesfull...");

	}

	@Test(dataProvider = "LoginDataProvider")
	public void loginVerify(String userName, String password, String fName, String lName, String emailId,
			String telephone) {
		YourStorePage yourStorePage = new YourStorePage();
		AccountLoginPage accountLoginPage = yourStorePage.clickLoginBtn();
		sf.assertEquals(accountLoginPage.getAccountLoginPageTitle(), "Account Login", "Invalid Page!");
		MyAccountPage myAccountPage = accountLoginPage.clickLoginButton(userName, password);
		sf.assertEquals(myAccountPage.getMyAccountText(), "My Account", "Login Failed!");
		MyAccountInformationPage accountInformation = myAccountPage.editYourAccountInformation();
		sf.assertEquals(accountInformation.getMyAccountInformationText(), "My Account Information",
				"My Account Information Failed...");
		sf.assertEquals(accountInformation.getFirstName(), fName, "First Name did not matched");
		sf.assertEquals(accountInformation.getLastName(), lName, "Last Name did not matched");
		sf.assertEquals(accountInformation.getEmail(), emailId, "Email did not matched");
		sf.assertEquals(accountInformation.getTelephone(), telephone, "Telephone did not matched");
		sf.assertAll();
	}

	@Test
	public void testSomething() {
		local.get().get("https://www.bing.com/");
		Assert.assertTrue(false);

	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] provideLoginData() throws IOException {
		String pathOfFile = "./TestData\\LoginDetails.xlsx";
		int rowCount = ExcelUtils.getRowCount(pathOfFile, "Sheet1");
		int columnCount = ExcelUtils.getColumnCount(pathOfFile, "Sheet1", rowCount);
		String[][] loginData = new String[rowCount][columnCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellValue(pathOfFile, "Sheet1", i, j);
			}
		}
		return loginData;
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();

	}
}

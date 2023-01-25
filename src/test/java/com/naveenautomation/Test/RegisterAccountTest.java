package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterAccountTest extends com.naveenautomation.Base.TestBase {

	com.naveenautomation.Page.YourStorePage yourStoreloginPage;
	com.naveenautomation.Page.AccountLoginPage accountLoginPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		yourStoreloginPage = new com.naveenautomation.Page.YourStorePage();

	}

	@Test
	public void verifyUserIsAbleToRegisterIntoWebsite() {
		com.naveenautomation.Page.RegisterAccountPage registerAccountPage = yourStoreloginPage.clickRegisterBtn();
		com.naveenautomation.Page.AccountCreatedPage accountCreated = registerAccountPage.signUpAccount("Daman", "Singh", "daman05@gmail.com",
				"6474020546", "Daman1231", "Daman1231");
		Assert.assertEquals(accountCreated.accountCreatedSuccessFullPage(), "Your Account Has Been Created!",
				"Account not Created...");

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}

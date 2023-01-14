package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountLogoutTest extends com.naveenautomation.Base.TestBase {

	com.naveenautomation.Page.YourStorePage loginPage;
	com.naveenautomation.Page.AccountLoginPage accountLogin;
	com.naveenautomation.Page.MyAccountPage myAccount;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		loginPage = new com.naveenautomation.Page.YourStorePage();
		accountLogin = loginPage.clickLoginBtn();
		myAccount = accountLogin.clickLoginButton("daman@gmail.com", "Daman1231");
	}

	@Test
	public void verifyUserIsAbleToLogoutSuccesfully() {
		com.naveenautomation.Page.AccountLogoutPage logoutPage = myAccount.clickLogoutLink();
		String accountLogOutText = logoutPage.AccountLogoutText();
		Assert.assertEquals(accountLogOutText, "Account Logout", "Account Logout Unsuccesfull");
		logoutPage.accountLogoutContinueBtn();
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}

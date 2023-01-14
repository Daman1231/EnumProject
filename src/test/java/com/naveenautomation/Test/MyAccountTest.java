package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTest extends com.naveenautomation.Base.TestBase {

	com.naveenautomation.Page.YourStorePage yourStoreloginPage;
	com.naveenautomation.Page.AccountLoginPage accountLoginPage;
	com.naveenautomation.Page.MyAccountPage myAccountPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		yourStoreloginPage = new com.naveenautomation.Page.YourStorePage();
		accountLoginPage = yourStoreloginPage.clickLoginBtn();
		myAccountPage = accountLoginPage.clickLoginButton("daman@gmail.com", "Daman1231");
	}

	@Test
	public void verifyUserIsAbleToLoginWithValidUsernamePassword() {
		Assert.assertEquals(myAccountPage.accountLoginSuccesfullPage(), "My Account", "Login Unsuccesfull...");
	}

	@Test
	public void verifyUserIsAbleToChangePhoneNumberOnceLoggedIn() {
		com.naveenautomation.Page.MyAccountInformationPage myAccountInfo = myAccountPage.clickEditAccountInfo();
		myAccountPage = myAccountInfo.clickContinueBtn("6474020540");
		Assert.assertEquals(myAccountPage.successAlertMessage(), "Success: Your account has been successfully updated.",
				"Phone Number change unsuccesfull...");
	}

	@Test
	public void verifyUserIsAbleToSubscribeUnsubscribeToNewsLetter() {
		com.naveenautomation.Page.NewsLetterSubscriptionPage newsletterSubscription = myAccountPage
				.subscribeUnsubscribeNewsLetter();
		myAccountPage = newsletterSubscription.clickContinueBtn();
		String alertSuccess = myAccountPage.successAlertMessage();
		Assert.assertEquals(alertSuccess, "Success: Your newsletter subscription has been successfully updated!",
				"NewsLetter Subscription Unsuccesfull...");
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}

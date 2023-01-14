package com.naveenautomation.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Page.MyAccountPage;

public class MyWishListTest extends TestBase {

	com.naveenautomation.Page.YourStorePage yourStoreLoginPage;
	com.naveenautomation.Page.AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	SoftAssert sf;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		yourStoreLoginPage = new com.naveenautomation.Page.YourStorePage();
		accountLoginPage = yourStoreLoginPage.clickLoginBtn();
		myAccountPage = accountLoginPage.clickLoginButton("daman@gmail.com", "Daman1231");
		sf = new SoftAssert();
	}

	@Test
	public void verifyUserIsAbleToAddProductsToWishList() {
		sf.assertEquals(myAccountPage.getMyAccountText(), "My Account", "Login Unsuccesfull");
		com.naveenautomation.Page.LaptopsAndNotebooksPage laptopsAndNotebooksPage = myAccountPage
				.clickShowLaptopsAndNotebooks();
		laptopsAndNotebooksPage.clickRatingHighest();
		laptopsAndNotebooksPage.addProductsToCart();

		// validate success text for addwishlist

		String wishListAddedAlert = laptopsAndNotebooksPage.wishListAddedAlert();
		sf.assertEquals(wishListAddedAlert, "Success: You have added MacBook Air to your wish list!\n×",
				"Items not added.....");
		com.naveenautomation.Page.MyWishListPage myWishList = laptopsAndNotebooksPage.clickWishListLink();
		// validate table using web tables.
		String firstProductName = myWishList
				.getElementFromTheTable("MacBook Air", com.naveenautomation.Page.MyWishListPage.MyWishList.PRODUCTNAME)
				.getText();
		String secondProductName = myWishList
				.getElementFromTheTable("MacBook Pro", com.naveenautomation.Page.MyWishListPage.MyWishList.PRODUCTNAME)
				.getText();
		String thirdProductName = myWishList
				.getElementFromTheTable("Sony VAIO", com.naveenautomation.Page.MyWishListPage.MyWishList.PRODUCTNAME)
				.getText();
		String firstProductPrice = myWishList
				.getElementFromTheTable("MacBook Air", com.naveenautomation.Page.MyWishListPage.MyWishList.UNITPRICE)
				.getText();
		String secondProductPrice = myWishList
				.getElementFromTheTable("MacBook Pro", com.naveenautomation.Page.MyWishListPage.MyWishList.UNITPRICE)
				.getText();
		String thirdProductPrice = myWishList
				.getElementFromTheTable("Sony VAIO", com.naveenautomation.Page.MyWishListPage.MyWishList.UNITPRICE)
				.getText();
		sf.assertEquals(firstProductName, "MacBook Air", "Device does not match");
		sf.assertEquals(secondProductName, "MacBook Pro", "Device does not match");
		sf.assertEquals(thirdProductName, "Sony VAIO", "Device does not match");
		sf.assertEquals(firstProductPrice, "$1,202.00", "Device does not match");
		sf.assertEquals(secondProductPrice, "$2,000.00", "Device does not match");
		sf.assertEquals(thirdProductPrice, "$1,202.00", "Device does not match");
		myWishList.clickDeleteButton();
		String wishListText = myWishList.MyWishListText();
		sf.assertEquals(wishListText, "My Wish List", "My Wish List not opened...");
		String wishListSuccesText = myWishList.WishListSuccesText();
		sf.assertEquals(wishListSuccesText, "Success: You have modified your wish list!\n×",
				"Wish List Modified Unsuccesful..");

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}

package com.naveenautomation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.naveenautomation.Page.AccountLoginPage;
import com.naveenautomation.Page.LaptopsAndNotebooksPage;
import com.naveenautomation.Page.MyWishListPage;
import com.naveenautomation.Page.YourStoreLaptopNoteBookPage;
import com.naveenautomation.Page.YourStorePage;
import com.naveenautomation.Page.MyWishListPage.MyWishList;

public class MyWishListTest extends TestBase {

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
	public void testSomething() {
		Assert.assertTrue(false);
	}

	@Test
	public void verifyUserIsAbleToAddProductsToWishList() {
		sf.assertEquals(yourStoreLaptopNoteBookPage.myAccountSuccesfullText(), "My Account", "Login Unsuccesfull");
		LaptopsAndNotebooksPage laptopsAndNotebooksPage = yourStoreLaptopNoteBookPage.clickShowLaptopsAndNotebooks();
		laptopsAndNotebooksPage.clickRatingHighest();
		laptopsAndNotebooksPage.addProductsToCart();

		// validate success text for addwishlist

		String wishListAddedAlert = laptopsAndNotebooksPage.wishListAddedAlert();
		sf.assertEquals(wishListAddedAlert, "Success: You have added MacBook Air to your wish list!\n×",
				"Items not added.....");
		MyWishListPage myWishList = laptopsAndNotebooksPage.clickWishListLink();
		// validate table using web tables.
		String firstProductName = myWishList.getElementFromTheTable("MacBook Air", MyWishList.PRODUCTNAME).getText();
		String secondProductName = myWishList.getElementFromTheTable("MacBook Pro", MyWishList.PRODUCTNAME).getText();
		String thirdProductName = myWishList.getElementFromTheTable("Sony VAIO", MyWishList.PRODUCTNAME).getText();
		String firstProductPrice = myWishList.getElementFromTheTable("MacBook Air", MyWishList.UNITPRICE).getText();
		String secondProductPrice = myWishList.getElementFromTheTable("MacBook Pro", MyWishList.UNITPRICE).getText();
		String thirdProductPrice = myWishList.getElementFromTheTable("Sony VAIO", MyWishList.UNITPRICE).getText();
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

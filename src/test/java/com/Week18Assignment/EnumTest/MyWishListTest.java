package com.Week18Assignment.EnumTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Week18Assignment.EnumBase.TestBase;
import com.Week18Assignment.EnumPage.AccountLoginPage;
import com.Week18Assignment.EnumPage.LaptopsAndNotebooksPage;
import com.Week18Assignment.EnumPage.MyWishListPage;
import com.Week18Assignment.EnumPage.MyWishListPage.MyWishList;
import com.Week18Assignment.EnumPage.YourStoreLaptopNoteBookPage;
import com.Week18Assignment.EnumPage.YourStorePage;

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
	public void verifyUserIsAbleToAddProductsToWishList() {
		Assert.assertEquals(yourStoreLaptopNoteBookPage.myAccountSuccesfullText(), "My Account", "Login Unsuccesfull");
		LaptopsAndNotebooksPage laptopsAndNotebooksPage = yourStoreLaptopNoteBookPage.clickShowLaptopsAndNotebooks();
		laptopsAndNotebooksPage.clickRatingHighest();
		laptopsAndNotebooksPage.addProductsToCart();

		// validate success text for addwishlist

		String wishListAddedAlert = laptopsAndNotebooksPage.wishListAddedAlert();
		Assert.assertEquals(wishListAddedAlert, "Success: You have added MacBook Air to your wish list!\n×",
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
		Assert.assertEquals(wishListText, "My Wish List", "My Wish List not opened...");
		String wishListSuccesText = myWishList.WishListSuccesText();
		Assert.assertEquals(wishListSuccesText, "Success: You have modified your wish list!\n×",
				"Wish List Modified Unsuccesful..");

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}

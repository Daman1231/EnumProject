package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class LaptopsAndNotebooksPage extends TestBase {

	public LaptopsAndNotebooksPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#input-sort")
	WebElement sortBy;

	@FindBy(xpath = "//option[text()='Rating (Highest)']")
	WebElement ratingHighest;

	@FindBy(css = "button[onclick=\"wishlist.add('46');\"]")
	WebElement addToWishListSonyvaio;

	@FindBy(css = "button[onclick=\"wishlist.add('45');\"]")
	WebElement addToWishListMacbookPro;

	@FindBy(css = "button[onclick=\"wishlist.add('44');\"]")
	WebElement addToWishListMacbookAir;

	@FindBy(css = "div.alert a:last-of-type")
	WebElement wishListLink;

	@FindBy(css = "div.alert")
	WebElement wishListAddedALertText;

	private void clickSortBy() {
		sortBy.click();
	}

	public void clickRatingHighest() {
		clickSortBy();
		ratingHighest.click();
	}

	private void clickSonyVaioWishList() {
		addToWishListSonyvaio.click();
	}

	private void clickMacbookProWishList() {
		addToWishListMacbookPro.click();
	}

	private void clickMacbookAirWishList() {
		addToWishListMacbookAir.click();
	}

	public MyWishListPage clickWishListLink() {
		wishListLink.click();
		return new MyWishListPage();

	}

	public void addProductsToCart() {
		clickSonyVaioWishList();
		clickMacbookProWishList();
		clickMacbookAirWishList();
		sleep(2000);
	}

	public String wishListAddedAlert() {
		return wishListAddedALertText.getText();
	}

	public void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package com.Week18Assignment.EnumPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Week18Assignment.EnumBase.TestBase;

public class MyWishListPage extends TestBase {

	public MyWishListPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h2")
	WebElement myWishListTitle;

	@FindBy(css = "a[href$='remove=46']")
	WebElement deleteButton;

	@FindBy(css = "div.alert")
	WebElement successText;

	public String MyWishListText() {
		return myWishListTitle.getText();
	}

	public void clickDeleteButton() {
		deleteButton.click();
	}

	public String WishListSuccesText() {
		return successText.getText();
	}
	
	public WebElement getElementFromTheTable(String ProductName, MyWishList column) {
		int columnIndex = getIndexForColumn(column);
		List<WebElement> rowsInTable = driver.findElements(By.cssSelector("table.table tbody tr"));
		for (WebElement webElement : rowsInTable) {
			List<WebElement> cells = webElement.findElements(By.cssSelector("td"));
			String ProductNameText = cells.get(1).getText();
			if (ProductNameText.equals(ProductName)) {
				return cells.get(columnIndex);
			}
		}
		System.out.println("Column name was not found!!!");
		return null;
	}

	public int getIndexForColumn(MyWishList column) {
		List<WebElement> tableHeaders = driver.findElements(By.cssSelector("table.table thead tr td"));
		for (WebElement webElement : tableHeaders) {
			if (webElement.getText().equals(column.getName())) {
				return tableHeaders.indexOf(webElement);
			}
		}
		System.out.println("column does not exist");
		return -1;
	}

	public enum MyWishList {
		IMAGE("Image"),
		PRODUCTNAME("Product Name"),
		MODEL("Model"),
		STOCK("Stock"),
		UNITPRICE("Unit Price"),
		ACTION("Action");

		String name;

		private MyWishList(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}

	
}

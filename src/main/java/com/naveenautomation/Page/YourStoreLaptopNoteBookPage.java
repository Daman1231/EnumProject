package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class YourStoreLaptopNoteBookPage extends TestBase {

	public YourStoreLaptopNoteBookPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h2:first-of-type")
	WebElement myAccountSuccesfull;

	@FindBy(css = "#menu>div:last-of-type>ul>li:nth-of-type(2)>a")
	WebElement laptopAndNoteBook;

	@FindBy(xpath = "//a[text()='Show All Laptops & Notebooks']")
	WebElement showAllLaptopsAndNoteBooks;

	@FindBy(css = "div.list-group a:nth-of-type(4)")
	WebElement addressBookLink;

	public String myAccountSuccesfullText() {
		return myAccountSuccesfull.getText();
	}

	private void clickLaptopAndNotebook() {
		laptopAndNoteBook.click();
	}

	public AddressBookPage clickAddressBook() {
		addressBookLink.click();
		return new AddressBookPage();
	}

	public LaptopsAndNotebooksPage clickShowLaptopsAndNotebooks() {
		clickLaptopAndNotebook();
		showAllLaptopsAndNoteBooks.click();
		return new LaptopsAndNotebooksPage();
	}
}

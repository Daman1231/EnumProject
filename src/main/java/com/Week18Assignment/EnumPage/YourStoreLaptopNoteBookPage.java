package com.Week18Assignment.EnumPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Week18Assignment.EnumBase.TestBase;

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

	public String myAccountSuccesfullText() {
		return myAccountSuccesfull.getText();
	}

	private void clickLaptopAndNotebook() {
		laptopAndNoteBook.click();
	}

	public LaptopsAndNotebooksPage clickShowLaptopsAndNotebooks() {
		clickLaptopAndNotebook();
		showAllLaptopsAndNoteBooks.click();
		return new LaptopsAndNotebooksPage();
	}
}

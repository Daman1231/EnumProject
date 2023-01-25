package com.naveenautomation.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class AddressBookPage extends TestBase {
	public AddressBookPage() {
		PageFactory.initElements(local.get(), this);
	}

	@FindBy(css = ("div.alert"))
	WebElement sucessAlert;

	@FindBy(id = ("input-firstname"))
	WebElement firstName;

	@FindBy(id = ("input-lastname"))
	WebElement lastName;

	@FindBy(id = ("input-address-1"))
	WebElement address;

	@FindBy(id = ("input-city"))
	WebElement city;

	@FindBy(id = ("input-postcode"))
	WebElement postalCode;

	@FindBy(id = ("input-country"))
	WebElement country;

	@FindBy(id = ("input-zone"))
	WebElement province;

	@FindBy(css = ("input[value='Continue']"))
	WebElement continueBtn;

	@FindBy(css = "div.alert")
	WebElement addressSuccesAlert;

	private void firstName() {
		firstName.clear();
		firstName.sendKeys("Satveer");
	}

	private void lastName() {
		lastName.clear();
		lastName.sendKeys("Singh");
	}

	private void address() {
		address.clear();
		address.sendKeys("67 Humber College Blvd");
	}

	private void city() {
		city.clear();
		city.sendKeys("Etobicoke");
	}

	private void postalCode() {
		postalCode.clear();
		postalCode.sendKeys("M9V 1P8");
	}

	private void country() {
		selectByVisibleText(country, "Canada");
	}

	private void region() {
		selectByVisibleText(province, "Ontario");
	}

	public String addressAlertSuccessText() {
		return addressSuccesAlert.getText();
	}

	public void editAddressBook(String postalCode) {
		getEditButton(postalCode).click();
		firstName();
		lastName();
		address();
		city();
		postalCode();
		country();
		region();
		continueBtn.click();

	}

	public WebElement getEditButton(String postalCode) {
		List<WebElement> rowsInTable = local.get().findElements(By.cssSelector("tbody tr"));
		for (int i = 0; i < rowsInTable.size(); i++) {
			List<WebElement> cellsInEachRow = rowsInTable.get(i).findElements(By.cssSelector("td"));
			String address = cellsInEachRow.get(0).getText();
			if (address.contains(postalCode)) {
				return cellsInEachRow.get(1).findElement(By.cssSelector("a:first-of-type"));

			}
		}
		return null;
	}

	public void selectByVisibleText(WebElement webElement, String text) {
		org.openqa.selenium.support.ui.Select sc = new org.openqa.selenium.support.ui.Select(webElement);
		sc.selectByVisibleText(text);
	}

}

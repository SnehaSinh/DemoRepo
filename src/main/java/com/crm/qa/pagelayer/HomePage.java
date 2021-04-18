package com.crm.qa.pagelayer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclass.BaseClassInitialization;

public class HomePage extends BaseClassInitialization {

	// PageFactory
	@FindBy(xpath = "//div[@class='header item']")
	WebElement headerLabel;
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsDetails;
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement deals;
	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasks;

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public boolean LabelCheck() {
		return headerLabel.isDisplayed();
	}

	public ContactsPage ContactsClick() throws IOException {
		contactsDetails.click();
		return new ContactsPage();
	}

	public DealsPage DealsClick() throws IOException {
		deals.click();
		return new DealsPage();
	}

	public TasksPage TasksClick() throws IOException {
		tasks.click();
		return new TasksPage();
	}
}

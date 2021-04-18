package com.crm.qa.testlayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.BaseClassInitialization;
import com.crm.qa.pagelayer.ContactsPage;
import com.crm.qa.pagelayer.HomePage;
import com.crm.qa.pagelayer.LoginPage;

public class HomePageTest extends BaseClassInitialization {
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;

	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod

	public void setup() throws IOException {
		InitializationMethod();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void ValidateLabel() {

		boolean flag = homepage.LabelCheck();
		Assert.assertEquals(flag, true, "Label present");
	}

	@Test(priority = 2)
	public void TitleTest() {
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "CRM PRO", "Title does not match");
	}

	@Test(priority = 3)
	public void ContactClick() throws IOException {
		contactspage=homepage.ContactsClick();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}

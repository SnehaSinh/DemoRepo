package com.crm.qa.testlayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.BaseClassInitialization;
import com.crm.qa.pagelayer.HomePage;
import com.crm.qa.pagelayer.LoginPage;

public class LoginPageTest extends BaseClassInitialization {
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException {

		InitializationMethod();
		loginpage = new LoginPage();

	}

	@Test(priority=1)
	public void TitleTest()
	{
		String title = loginpage.getPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	@Test(priority=2)
	public void SignUpTest()
	{
		boolean flag = loginpage.SignUpBtn();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() throws IOException
	{
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod

	public void teardown() {
		driver.close();

	}

}

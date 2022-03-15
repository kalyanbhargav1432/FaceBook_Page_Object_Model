package com.bridgelabz;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bridgelabz.base.BaseClass;
import com.bridgelabz.pages.HomePage;
import com.bridgelabz.pages.LoginPage;
import com.bridgelabz.utility.UtilityClass;

public class LoginPageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homepage;
	String sheetName = "Login Page";

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		loginPage = new LoginPage();
		String loginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up", loginPageTitle);
	}

	@Test(priority = 2)
	public void loginTest() {
		loginPage = new LoginPage();
		homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
	}

	@DataProvider
	public Object[][] getLoginTestdata() {
		return UtilityClass.getTestData(sheetName);
	}

	@Test(priority = 3, dataProvider = "getLoginTestdata")
	public void loginTest(String username, String password) {
		loginPage = new LoginPage();
		homepage = loginPage.login(username, password);
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

}
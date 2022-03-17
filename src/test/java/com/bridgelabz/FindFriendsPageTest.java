package com.bridgelabz;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.base.BaseClass;
import com.bridgelabz.pages.FriendsPage;
import com.bridgelabz.pages.HomePage;
import com.bridgelabz.pages.LoginPage;

public class FindFriendsPageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	FriendsPage friendsPage;

	public FindFriendsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		friendsPage = homePage.clickOnFindFriendsLink();
	}

	@Test(priority = 1)
	public void verifyFriendsPageTitleTest() {
		friendsPage.verifyFriendsPageTitle();
	}

	@Test(priority = 2)
	public void ClickOnFriendRequestLinkTest() {
		friendsPage.clickOnFriendRequestLink();
	}

	@Test(priority = 3)
	public void ClickOnSuggestionsLinkTest() {
		friendsPage.clickOnSuggestionsLink();
	}

	@Test(priority = 4)
	public void ClickOnBirthdayLinkTest() {
		friendsPage.clickOnBirthdayLink();
	}

	@Test(priority = 5)
	public void ClickOnCustomListsLinkTest() {
		friendsPage.clickCustomListsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

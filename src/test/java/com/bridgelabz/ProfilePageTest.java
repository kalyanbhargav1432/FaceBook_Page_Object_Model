package com.bridgelabz;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.base.BaseClass;
import com.bridgelabz.pages.AboutPage;
import com.bridgelabz.pages.FriendsPage;
import com.bridgelabz.pages.HomePage;
import com.bridgelabz.pages.LoginPage;
import com.bridgelabz.pages.PhotosPage;
import com.bridgelabz.pages.PostsPage;
import com.bridgelabz.pages.ProfilePage;
import com.bridgelabz.pages.VideosPage;

public class ProfilePageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	PostsPage postPage;
	AboutPage aboutPage;
	PhotosPage photosPage;
	VideosPage videosPage;
	FriendsPage friendsPage;

	public ProfilePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		profilePage = homePage.clickOnProfile();
	}

	@Test(priority = 1)
	public void verifyProfilePageTitleTest() {
		profilePage.verifyProfilePageTitle();
	}

	@Test(priority = 2)
	public void ClickOnPostsLinkTest() {
		postPage = profilePage.clickOnPostsLink();
	}

	@Test(priority = 3)
	public void ClickOnAboutLinkTest() {
		aboutPage = profilePage.clickOnAboutLink();
	}

	@Test(priority = 4)
	public void ClickOnFriendsLinkTest() {
		friendsPage = profilePage.clickOnFriendsLink();
	}

	@Test(priority = 5)
	public void ClickOnPhotosdLinkTest() {
		photosPage = profilePage.clickOnPhotosLink();
	}

	@Test(priority = 6)
	public void ClickOnVideosLinkTest() {
		videosPage = profilePage.clickOnVideosLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

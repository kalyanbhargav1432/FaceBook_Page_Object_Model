package com.bridgelabz;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.base.BaseClass;
import com.bridgelabz.pages.AboutPage;
import com.bridgelabz.pages.HomePage;
import com.bridgelabz.pages.LoginPage;
import com.bridgelabz.pages.ProfilePage;

public class AboutPageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	AboutPage aboutPage;

	public AboutPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		profilePage = homePage.clickOnProfile();
		aboutPage = profilePage.clickOnAboutLink();
	}

	@Test(priority = 1)
	public void ClickOnAboutLinkTest() {
		aboutPage.clickOnAboutLink();
	}

	@Test(priority = 2)
	public void ClickOnOverviewLinkTest() {
		aboutPage.clickOnOverviewLink();
	}

	@Test(priority = 3)
	public void ClickOnWorkAndEducationLinkTest() {
		aboutPage.clickOnWorkAndEducationLink();
	}

	@Test(priority = 4)
	public void ClickOnPlacesLivedLinkTest() {
		aboutPage.clickOnPlacesLivedLink();
	}

	@Test(priority = 5)
	public void ClickOnContactAndBasicInformationLinkTest() {
		aboutPage.clickOnContactAndBasicInfoLink();
	}

	@Test(priority = 6)
	public void ClickOnFamilyAndRelationshipsLinkTest() {
		aboutPage.clickOnFamilyAndRelationshipsLink();
	}

	@Test(priority = 7)
	public void ClickOnDetailsAboutYouLinkTest() {
		aboutPage.clickOnDetailsAboutYouLink();
	}

	@Test(priority = 8)
	public void ClickOnLifeEventsLinkTest() {
		aboutPage.clickOnLifeEventsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

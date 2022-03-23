package com.bridgelabz.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.base.BaseClass;

public class AboutPage extends BaseClass {
	@FindBy(xpath = "//span[contains(text(),'About')]")
	WebElement aboutLink;

	@FindBy(xpath = "//span[contains(text(),'Overview')]")
	WebElement overviewLink;

	@FindBy(xpath = "//span[contains(text(),'Work and education')]")
	WebElement workAndEducationLink;

	@FindBy(xpath = "//span[contains(text(),'Places lived')]")
	WebElement placesLivedLink;

	@FindBy(xpath = "//span[contains(text(),'Contact and basic info')]")
	WebElement contactAndBasicInformationLink;

	@FindBy(xpath = "//span[contains(text(),'Family and relationships')]")
	WebElement familyAndRelationshipsLink;

	@FindBy(xpath = "//span[contains(text(),'Details about you')]")
	WebElement detailsAboutYouLink;

	@FindBy(xpath = "//span[contains(text(),'Life events')]")
	WebElement lifeEventsLink;

	// Initializing the Page Objects:
	public AboutPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyAboutPageTitle() {
		return driver.getTitle();
	}

	public AboutPage clickOnAboutLink() {
		aboutLink.click();
		return new AboutPage();
	}

	public OverviewPage clickOnOverviewLink() {
		overviewLink.click();
		return new OverviewPage();
	}

	public WorkAndEducationPage clickOnWorkAndEducationLink() {
		workAndEducationLink.click();
		return new WorkAndEducationPage();
	}

	public PlacesLivedPage clickOnPlacesLivedLink() {
		placesLivedLink.click();
		return new PlacesLivedPage();
	}

	public ContactAndBasicInformationPage clickOnContactAndBasicInfoLink() {
		contactAndBasicInformationLink.click();
		return new ContactAndBasicInformationPage();
	}

	public FamilyAndRelationshipsPage clickOnFamilyAndRelationshipsLink() {
		familyAndRelationshipsLink.click();
		return new FamilyAndRelationshipsPage();
	}

	public DetailsAboutYouPage clickOnDetailsAboutYouLink() {
		detailsAboutYouLink.click();
		return new DetailsAboutYouPage();
	}

	public LifeEventsPage clickOnLifeEventsLink() {
		lifeEventsLink.click();
		return new LifeEventsPage();
	}

}
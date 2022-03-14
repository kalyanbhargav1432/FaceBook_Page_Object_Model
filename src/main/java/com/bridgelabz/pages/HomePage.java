package com.bridgelabz.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.base.BaseClass;

public class HomePage extends BaseClass {
	@FindBy(xpath = "//span[contains(text(),'Kalyan Kalyan')]")
	WebElement userProfileLink;

	@FindBy(xpath = "//span[contains(text(),'Friends')]")
	WebElement friendsLink;

	@FindBy(xpath = "//span[contains(text(),'Saved')]")
	WebElement savedLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ProfilePage clickOnProfile() {
		userProfileLink.click();
		return new ProfilePage();
	}

	public FriendsPage clickOnFriendsLink() {
		friendsLink.click();
		return new FriendsPage();
	}

	public SavedPage clickOnSavedLink() {
		savedLink.click();
		return new SavedPage();
	}
}

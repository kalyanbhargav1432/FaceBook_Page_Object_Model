package com.bridgelabz.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.base.BaseClass;

public class ProfilePage extends BaseClass {
	@FindBy(xpath = "//span[contains(text(),'Posts')]")
	WebElement postsLink;

	@FindBy(xpath = "//span[contains(text(),'About')]")
	WebElement aboutLink;

	@FindBy(xpath = "//div[@class = 'bp9cbjyn rq0escxv j83agx80 pfnyh3mw frgo5egb l9j0dhe7 cb02d2ww hv4rvrfc dati1w0a']//span[contains(text(),'Friends')]")
	WebElement friendsLink;

	@FindBy(xpath = "//div[@class = 'bp9cbjyn rq0escxv j83agx80 pfnyh3mw frgo5egb l9j0dhe7 cb02d2ww hv4rvrfc dati1w0a']//span[contains(text(),'Photos')]")
	WebElement photosLink;

	@FindBy(xpath = "//span[contains(text(),'Videos')]")
	WebElement videosLink;

	@FindBy(xpath = "//span[contains(text(),'Check-ins')]")
	WebElement check_insLink;

	// Initializing the Page Objects:
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyProfilePageTitle() {
		return driver.getTitle();
	}

	public AboutPage clickOnAboutLink() {
		aboutLink.click();
		return new AboutPage();
	}

	public PostsPage clickOnPostsLink() {
		postsLink.click();
		return new PostsPage();
	}

	public FriendsPage clickOnFriendsLink() {
		friendsLink.click();
		return new FriendsPage();
	}

	public PhotosPage clickOnPhotosLink() {
		photosLink.click();
		return new PhotosPage();
	}

	public VideosPage clickOnVideosLink() {
		videosLink.click();
		return new VideosPage();
	}
}
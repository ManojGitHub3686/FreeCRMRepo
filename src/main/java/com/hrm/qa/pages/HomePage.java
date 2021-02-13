package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class HomePage extends TestBase {

	
	//Page Factory
	
	@FindBy(xpath = "//span[contains(text(),'Manoj Bhagwat')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//body/div[@id='ui']/div[1]/div[1]/div[3]/button[1]/i[1]")
	WebElement createContactLink;
	
	//Initialize the page objects
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean correctUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
		
	}
	
	public void clickOnNewContactLink() {
		
		createContactLink.click();
		
	}
	
	public DealsPage clickDealsLink() {
		dealsLink.click();
		return new DealsPage();
		
	}
	
	
}

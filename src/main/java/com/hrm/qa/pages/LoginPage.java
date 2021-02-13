package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - Object Repository
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text(), 'Forgot your password?')]")
	WebElement forgotPassLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
	WebElement signUpLink;
	
	
	//Initializing the page Object by creating the constructor of LoginPage() class
	public LoginPage() {
		
		PageFactory.initElements(driver, this); //Initialize elements with driver with this (current class)
		
	}
	//Actions:
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean validateSignUpLink() {
		return signUpLink.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
		
	}

	

}

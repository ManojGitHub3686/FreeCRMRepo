package com.hrm.qa.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.util.TestUtil;

public class ContactsPage extends TestBase {
	
	//Page Factory
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLink;

	
	@FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	WebElement contactsLabel;
	
	@FindBy(name = "first_name")
	WebElement fName;

	@FindBy(name = "last_name")
	WebElement lName;

	@FindBy(xpath = "//span[@class='text']/parent::div[@name='category']")
	WebElement category;
	
	@FindBy(xpath = "//i[@class='save icon']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[2]/a[1]/div[1]")
	WebElement verifyEmail;
	//Initialize Page Factory
	
	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
		
	public boolean contactsTitle() {
		return contactsLabel.isDisplayed();
	}
	
	
	public void selectContactsByName(String name) {
		
		
//		driver.findElement(By.xpath("//a[contains(text(), 'Manoj Bhagwat')]/parent::td"
//				+ "//preceding-sibling::td//input[@name='id']")).click();
		
		WebElement  ele = driver.findElement(By.xpath("//a[contains(text(), '"+name+"')]/parent::td"
				+ "//preceding-sibling::td//input[@name='id']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ele);
		
		Assert.assertTrue(ele.isSelected(), "Checkbox Not Selected");
	}

	public void createNewContact(String firstName, String lastName, String email, String cateGory) {
		
		new Actions(driver).moveToElement(fName).click().build().perform(); 
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='value']")).sendKeys(email);
		driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[4]/div[2]/div[1]/div[1]")).click();
		List <WebElement> cat = driver.findElements(By.xpath("//div[@name='category']//span[@class='text']"));
		
		System.out.println(cat.size());
		
		for(int i=0; i<cat.size(); i++) {
			if(cat.get(i).getText().equals(cateGory)) {
				cat.get(i).click();
				break;
			}
		}
		saveBtn.click();
		// explicit wait - to wait for the compose button to be click-able
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[2]/a[1]/div[1]"
		 * )));
		 * 
		 * boolean b1 = verifyEmail.isDisplayed();
		 * 
		 * Assert.assertEquals(b1, true, "Not matched");;
		 */		
		
	}





}

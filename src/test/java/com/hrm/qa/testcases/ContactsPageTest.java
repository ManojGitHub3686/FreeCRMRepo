package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.ContactsPage;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.util.TestUtil;


public class ContactsPageTest extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
		
		
		
	}
	
	@Test (priority = 1)
	public void verifyContactsLabelTest() {
		
		boolean flag = contactsPage.contactsTitle();
		Assert.assertTrue(flag, "Title not matched");
	}
	
	@Test (priority = 2)
	public void selectSingleContactsByNameTest() {
		
		//driver.navigate().refresh();
		contactsPage.selectContactsByName("Manoj Bhagwat");
	}
	
	@Test (priority = 3)
	public void selectMultipleContactsByNameTest() {
		
		//driver.navigate().refresh();
		contactsPage.selectContactsByName("Manoj Bhagwat");
		contactsPage.selectContactsByName("test test2");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test (priority = 4, dataProvider= "getCRMTestData")
	public void createNewContactTest(String fsname, String ltname, String e_mail, String cat) {
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Tom", "Peter", "test@test3.com", "Contact");
		contactsPage.createNewContact(fsname, ltname, e_mail, cat);
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}


}

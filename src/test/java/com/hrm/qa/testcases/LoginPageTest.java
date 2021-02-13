package com.hrm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization(); //initialization() method from TestBase class
		loginPage = new LoginPage();
	}
	
	@Test (priority=1)
	public void loginPageTitleTest() {
		
		String title = loginPage.validateLoginPageTitle();
//		WebDriverWait wait = new WebDriverWait(driver, TestUtil.IMPLICIT_WAIT);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img//parent::div")));
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test (priority =2)
	public void signUpLinkTest() {
		boolean flag = loginPage.validateSignUpLink();
//		WebDriverWait wait = new WebDriverWait(driver, TestUtil.IMPLICIT_WAIT);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img//parent::div")));
		Assert.assertTrue(flag);
	}
	
	@Test (priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		WebDriverWait wait = new WebDriverWait(driver, TestUtil.PAGE_LOAD_TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Manoj Bhagwat')]")));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

package com.hrm.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.hrm.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigating to: '" + url + "'");
	}
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the: " + element.toString()
		+ " before any changes made");
	}
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString()
		+ " before any changes made");
	}
	
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
	}
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
	}
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}
	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Execution occured: " + error);
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void beforeFindBy(By by,WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By :" + by.toString());
	}
	public void afterFindBy(By by,WebElement element, WebDriver driver) {
		System.out.println("Found Element By :" + by.toString());
	}
	/*
	 * Non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
	}
	public void afterScript(String script, WebDriver driver) {
	}
	public void beforeAlertAccept(WebDriver driver) {
	}
	public void afterAlertAccept(WebDriver driver) {
	}
	public void beforeAlertDismiss(WebDriver driver) {
	}
	public void afterAlertDismiss(WebDriver driver) {
	}
	public void beforeNavigateRefresh(WebDriver driver) {
	}
	public void afterNavigateRefresh(WebDriver driver) {
	}
	public void beforeChangeValueOf(WebDriver driver) {
	}
	public void afterChangeValueOf(WebDriver driver) {
	}
	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}
	
	
}
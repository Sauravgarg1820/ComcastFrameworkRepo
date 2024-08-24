package com.comcast.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	
	  public void waitForPageToload(WebDriver driver) {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  
	  }
	 
	
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabonTitle(WebDriver driver, String partialTitle) {
		Set<String> allid = driver.getWindowHandles();
		Iterator<String> it = allid.iterator();
		while(it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String actualurl = driver.getTitle();	
		if (actualurl.contains(partialTitle))	{
			break;
		}
	  }
	}
	public void switchToTabonUrl(WebDriver driver, String partialUrl) {
		Set<String> allid = driver.getWindowHandles();
		Iterator<String> it = allid.iterator();
		while(it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String actualurl = driver.getTitle();	
		if (actualurl.contains(partialUrl))	{
			break;
		}
	  }
	}
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
		 
	}
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	
	public void switchToalertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToalertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	
	public void selectbyvisibletext(WebElement element, String text) {
		Select select= new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectbyindex(WebElement element, int index) {
		Select select= new Select(element);
		select.selectByIndex(index);
	}
	
	
	public void mousemoveOnElement(WebDriver driver, WebElement element) {
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void doubleclick(WebDriver driver, WebElement element) {
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
	}
}

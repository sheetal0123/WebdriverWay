package com.adv;

import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.DriverRepo;

public class RightClick {

	WebDriver driver;

	@BeforeClass
	public void init() {
		// driver = DriverRepo.FIREFOX.getDriver();
		driver = DriverRepo.CHROME.getDriver();
	}

	@AfterClass
	public void tearDown() {
		 driver.quit();
	}

	@Test
	public void testRightClick() throws InterruptedException {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		By locator = By.xpath("/html/body/div[1]/section/div/div/div/p/span");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		rightClick(element);
		
		Thread.sleep(3000);
		
		WebElement elementEdit = driver.findElement(By.xpath("html/body/ul/li[4]"));
		elementEdit.click();
		Alert alert = driver.switchTo().alert();
		String textEdit = alert.getText();
		Assert.assertEquals(textEdit, "clicked: edit", "Failed to click on Edit link");

	}

	public void rightClick(WebElement element) {
		try {
			Actions action = new Actions(driver).contextClick(element);
			action.build().perform();

			System.out.println("Sucessfully Right clicked on the element");
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + element + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element " + element + " was not clickable " + e.getStackTrace());
		}
	}

}

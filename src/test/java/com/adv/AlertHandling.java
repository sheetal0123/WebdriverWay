package com.adv;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.DriverRepo;

/**
 * Simple Alert: Contains only OK button Confirmation Alert: Contains Ok/ Cancel
 * button Prompt Alert: accepts some text in it
 */
public class AlertHandling {

	WebDriver driver;

	@BeforeClass
	public void init() {
		driver = DriverRepo.FIREFOX.getDriver();
		// driver = DriverRepo.CHROME.getDriver();
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

	// @Test
	public void testSimpleAlert() throws InterruptedException {
		driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
		driver.findElement(By.xpath("//*[@id='content']/p[4]/button")).click();

		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		System.out.println("Alert text is " + alertText);

		Thread.sleep(2000);
		simpleAlert.accept();
	}

	// @Test
	public void testConfirmationAlert() throws InterruptedException {
		driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
		driver.findElement(By.xpath(".//*[@id='content']/p[8]/button")).click();

		Alert confirmationAlert = driver.switchTo().alert();
		String alertText = confirmationAlert.getText();
		System.out.println("Alert text is " + alertText);

		Thread.sleep(2000);
		confirmationAlert.dismiss();
	}

	@Test
	public void testPromptAlert() throws InterruptedException {
		driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
		// WebElement element = driver.findElement(By.xpath("//*[@id='content']/p[11]/button"));
		// ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		driver.findElement(By.xpath("//*[@id='content']/p[11]/button")).click();

		Alert confirmationAlert = driver.switchTo().alert();
		String alertText = confirmationAlert.getText();
		System.out.println("Alert text is " + alertText);

		Thread.sleep(2000);
		confirmationAlert.dismiss();
	}

}

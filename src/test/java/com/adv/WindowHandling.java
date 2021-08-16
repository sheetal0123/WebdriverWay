package com.adv;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.helper.DriverRepo;

public class WindowHandling {

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

	@Test
	public void testWindow() throws InterruptedException {
		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);

		driver.findElement(By.id("button1")).click();
		Thread.sleep(2000);
		
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String handle : allWindowHandles) {
			if(!handle.equals(parentWindowHandle)) {
				System.out.println("Switching to window - > " + handle);
				driver.switchTo().window(handle); 
				System.out.println("Child Window Title:"+driver.getTitle());
			}
		}
		Thread.sleep(2000);
		driver.switchTo().window(parentWindowHandle);
		System.out.println("Parent URL:"+driver.getTitle());
	}

}

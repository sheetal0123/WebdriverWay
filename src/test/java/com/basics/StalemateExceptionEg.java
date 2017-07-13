package com.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.DriverRepo;

public class StalemateExceptionEg {

	WebDriver driver;

	@BeforeClass
	public void init() {
		driver = DriverRepo.FIREFOX.getDriver();
	}

	@AfterClass
	public void tearDown() {
		//driver.quit();
	}


	@Test
	public void testStalemate() throws InterruptedException {
		driver.get("https://in.yahoo.com/");
		WebElement searchBox = driver.findElement(By.id("uh-search-box"));

		driver.navigate().refresh();

		searchBox.sendKeys("hello");

	}

}

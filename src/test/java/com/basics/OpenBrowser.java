package com.basics;

import java.time.Instant;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.helper.DriverRepo;

public class OpenBrowser {

	WebDriver driver;

	@BeforeClass
	public void init() {
		driver = DriverRepo.FIREFOX.getDriver();
		//driver = DriverRepo.CHROME.getDriver();
	}

	@AfterClass
	public void tearDown() {
		Instant.now().plusSeconds(1L);
		driver.quit();
	}

	@Test
	public void testBrowser() {
		driver.get("https://www.selenium.dev/about/");
		System.out.println("Page Title: "+ driver.getTitle());
	}
		

}

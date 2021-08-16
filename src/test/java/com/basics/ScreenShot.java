package com.basics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.helper.DriverRepo;

public class ScreenShot {
	WebDriver driver;

	public ScreenShot() {
		driver = DriverRepo.FIREFOX.getDriver();
		// driver = DriverRepo.CHROME.getDriver();
	}

	public void takeScreenShot() throws IOException {
		driver.get("https://www.google.in/");
		try {
			driver.findElement(By.id("invalid-id")).click();
		} catch (Exception e) {
			getScreenShot();
		}
	}

	public void tearDown() {
		driver.quit();
	}

	public void getScreenShot() throws IOException {
		System.out.println("--");
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(
				"/home/xebia/Pictures/webdriver-screenshot.png"));
	}

	public static void main(String[] args) throws IOException {
		ScreenShot obj = new ScreenShot();
		obj.takeScreenShot();
		obj.tearDown();
	}
}
package com.basics;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.DriverRepo;

public class ScreenshotFirefox {

	WebDriver driver;

	@BeforeClass
	public void init() {
		driver = DriverRepo.FIREFOX.getDriver();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testFirefoxScreenshot() throws InterruptedException, IOException {
		//driver.get("http://www.bbc.com/");
		driver.get("https://www.meritnation.com/");
		Thread.sleep(3000);
		String path = getScreenshot("ScreenshotFirefox", "testFirefoxScreenshot");
		System.out.println("Firefox screenshot captured at: " + path);
	}

	/**
	 * method will take screenshot and return screenshot path
	 */
	public String getScreenshot(String testclass, String testname) throws IOException {

		String filePath = "./src/test/resources/screenshots/";
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String path = filePath + testclass + "_" + testname + "_" + timestamp + ".png";

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path + ".png";
	}

}

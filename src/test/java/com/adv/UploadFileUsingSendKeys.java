package com.adv;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.helper.DriverRepo;

/*
 html code: <input type="file" name="img">
 file can be uploaded using three ways: sendKeys, AutoIT and Robot framework
 refer: http://seleniumeasy.com/selenium-tutorials/uploading-file-with-selenium-webdriver
 */
public class UploadFileUsingSendKeys {

	WebDriver driver;

	@BeforeTest
	public void setup() throws Exception {
		driver = DriverRepo.FIREFOX.getDriver();
		// driver = DriverRepo.CHROME.getDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		// driver.quit(); // closes all opened browser instances
	}

	@Test
	public void testUpload() throws InterruptedException {
		driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
		driver.findElement(By.name("img")).sendKeys(
				"/home/xebia/Documents/qa/selenium/webdriver.txt");
		System.out.println("Title:" + driver.getTitle());
	}

	/*
	 * <input type="file" style="display:none;"> input is hidden here, so we
	 * block the css property style.display and then used send keys
	 */
	public void testUploadUsingJavaScript() {
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.display= 'block';", element);
		element.sendKeys("C:\\Users\\sheetalsingh\\Pictures\\Cucumber2.png");
	}

}
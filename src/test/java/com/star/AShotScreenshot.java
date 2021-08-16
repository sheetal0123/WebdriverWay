package com.star;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helper.DriverRepo;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

/**
 * to take screenshot of entire page rather view port 
 * 
 * http://test-able.blogspot.in/2015/10/take-entire-page-screenshots-in-selenium-webdriver-scripts.html
 * http://blog.xebia.in/index.php/2015/07/04/capture-full-page-screenshot-for-chrome-browser-in-selenium-webdriver/
 */
public class AShotScreenshot {

	static WebDriver driver;
	
	
	public static void main(String[] args) throws Exception {

		//driver =	 DriverRepo.CHROME.getDriver();
		driver =	 DriverRepo.FIREFOX.getDriver();
		driver.manage().window().maximize();

		driver.get("http://www.bbc.com");
		

		Thread.sleep(5000);
		(new WebDriverWait(driver, 60)).until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver newDriver) {
				return newDriver.findElement(By.xpath(".//*[@id='orb-aside']/div/div/ul/li[1]/a"));
			}
		});

		//scroll and take screenshot of every view port
		final Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	
		//merge all the screenshot
		final BufferedImage image = screenshot.getImage();
		
		//write complete screenshot
		ImageIO.write(image, "PNG", new File("./src/test/resources/screenshots/" + "AShot_BBC_Entire1.png"));

		driver.quit();
	}
}

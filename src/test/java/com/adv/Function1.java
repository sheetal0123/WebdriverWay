package com.adv;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.DriverRepo;

public class Function1 {

	WebDriver driver;

	public Function1() {
		driver = DriverRepo.FIREFOX.getDriver();
		// driver = DriverRepo.CHROME.getDriver();
	}

	public void hoverFeature() {
		driver.get("http://www.magicbricks.com");

		Actions act = new Actions(driver);
		act.moveToElement(
				driver.findElement(By.xpath("//a[@class='allIndiaDD']")))
				.perform();

		String noida = "/html/body/div[1]/div/div[2]/div[1]/div/ul/li/div/div/div/div[2]/div[1]/ul/li[2]/a";
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath(noida))));
		driver.findElement(By.xpath(noida)).click();
	}

	public void doubleClickFeature() {
		Actions act = new Actions(driver);
		act.doubleClick(driver.findElement(By.id("testid")));
	}
	
	public void iframe(){
		driver.get("http://www.magicbricks.com");
//		driver.switchTo().frame(10);  // iframe count from top
		driver.switchTo().frame("wkStorageFrame");  // iframe's id
		System.out.println(driver.findElement(By.xpath("/html/body")).getText());  // o/p: This is the storage Frame
		driver.switchTo().defaultContent(); // to bring back from iframe to main
											// window
	}

	public void rightClickFeature() {
		driver.get("http://www.google.com");
		driver.manage().window().maximize();

		WebElement gmail = driver.findElement(By.linkText("Gmail"));
		Actions action = new Actions(driver);
		action.contextClick(gmail).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build()
				.perform();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// driver.close(); //Only close browser where driver has focus
		driver.quit(); // Close both opened browser
	}
	public static void main(String[] args) {
		Function1 obj = new Function1();
//		obj.hoverFeature();
//		obj.doubleClickFeature();
		// obj.iframe();
		obj.rightClickFeature();
	}


}

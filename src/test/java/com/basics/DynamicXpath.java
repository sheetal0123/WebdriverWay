package com.basics;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.helper.DriverRepo;

/*
 * Dynamic means on every refresh id of elements are changing
 */
public class DynamicXpath {

	WebDriver driver;

	/*
	 * We can use both starts-with and contains method for dynamic xpath
	 */
	public void dynamicXpathEg() {
		driver = DriverRepo.FIREFOX.getDriver();
		// driver = DriverRepo.CHROME.getDriver();

		driver.get("https://in.yahoo.com/?p=us");
		driver.findElement(By.id("UHSearchBox")).sendKeys("selenium");
		// List<WebElement> list =
		// driver.findElements(By.xpath("//*[starts-with(@id,'yui_3_12_0_1_144585')]/a"));
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(@id,'ui_3_12_0_1_144585')]/a"));
		System.out.println(list.size());
		list.get(1).click();
	}

	public static void main(String[] args) {
		DynamicXpath obj = new DynamicXpath();
		obj.dynamicXpathEg();
	}

}

package com.basics;

import org.openqa.selenium.WebDriver;

import com.helper.DriverRepo;

public class Test {

	
	
	// @org.testng.annotations.Test
	// public void abc(){
	// System.out.println("testng");
	// }
	//

	public static void main(String[] args) {
		WebDriver driver = DriverRepo.FIREFOX.getDriver();
		// driver = DriverRepo.CHROME.getDriver();
		driver.get("http://www.bizrate.com");
		System.out.println(driver.getTitle());
		
		
//		System.out.println(">"+System.getProperty("os.name"));
	}
}

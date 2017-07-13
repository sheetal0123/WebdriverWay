package com.adv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class is to show that selenium can work perfectly with local html files
 * @author sheetalsingh
 */
public class WorkingWithLocalHtmlFile {
	
	WebDriver driver;
	String path = "file:///Users/sheetalsingh/Documents/qa/selenium/Yahoo.html";
//	String path = "https://in.yahoo.com/";
	
	public WorkingWithLocalHtmlFile(){
		driver = new FirefoxDriver();
	}
	
	
	public void readAndInteractWithLocalFile(){
		driver.get(path);
		System.out.println("h1 count: "+driver.findElements(By.tagName("h1")).size());
		System.out.println("div count: "+driver.findElements(By.tagName("div")).size());

	}
	
	public static void main(String [] args){
		WorkingWithLocalHtmlFile obj = new WorkingWithLocalHtmlFile();
		obj.readAndInteractWithLocalFile();
	}

}

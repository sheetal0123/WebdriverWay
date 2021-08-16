package com.adv;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.helper.DriverRepo;

/*
 * AutoIT: 3rd party tool used to handle Window specific UI
 * html code: <input type="file" name="img">
 */
public class UploadFileUsingAutoIT {
	WebDriver driver;

	@BeforeTest
	public void setup() throws Exception {
		driver = DriverRepo.FIREFOX.getDriver();
		// driver = DriverRepo.CHROME.getDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void uploadTest() throws IOException, InterruptedException {
		driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("img")).click();
		Runtime.getRuntime().exec("F:\\softwares\\autoit\\autoit_upload.exe");
		System.out.println("Title:" + driver.getTitle());
	}

	@Test
	public void downloadFile() throws IOException, InterruptedException {
		driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Download Text File")).click();
		Runtime.getRuntime().exec("F:\\softwares\\autoit\\autoit_download.exe");
		System.out.println("Title:" + driver.getTitle());
	}
}
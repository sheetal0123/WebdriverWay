package com.adv;

import java.util.concurrent.TimeUnit;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.helper.DriverRepo;

/*
 * Robot class is a java class which take control of Mouse and Keyboard
 * html code: <input type="file" name="img">
 */
public class UploadFileUsingRobotFramework {
	WebDriver driver;

	@BeforeTest
	public void setup() throws Exception {
		driver = DriverRepo.FIREFOX.getDriver();
		// driver = DriverRepo.CHROME.getDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void uploadTest() throws InterruptedException {
		driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("img")).click();
		robotFunc("F:\\softwares\\autoit\\testupload.txt");
		Thread.sleep(4000);
		System.out.println("Title: " + driver.getTitle());
		
	}

	/*
	 * This method will copy file path to system's clip-board.
	 */
	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste
		// operations
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard()
				.setContents(stringSelection, null);
	}

	public static void robotFunc(String fileLocation) {
		try {
			setClipboardData(fileLocation);
			Robot robot = new Robot();

			// paste path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// press enter
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

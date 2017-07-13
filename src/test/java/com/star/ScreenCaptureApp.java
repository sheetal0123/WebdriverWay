package com.star;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * http://blog.xebia.in/index.php/2012/03/25/java-robot-replacing-human-intervention-for-capturing-screenshots/
 */
public class ScreenCaptureApp {
	private static int delay = 10000;

	public static void main(String[] argv) throws InterruptedException {
		ScreenCaptureApp screenCaptureApp = new ScreenCaptureApp();
		ScreenCaptureApp.captureScreenShots();
	}

	static boolean captureScreenShots() throws InterruptedException {
		boolean isSuccesfol = false;
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		boolean isSuccesful = false;
		try {
			Robot robot = new Robot();
			BufferedImage[] screenshots = new BufferedImage[20];
			Rectangle bounds = new Rectangle(0, 0, (int) size.getWidth(), (int) size.getHeight());
			for (int i = 1; i < screenshots.length; i++) {
				System.out.println("Running");
				screenshots[i] = robot.createScreenCapture(bounds);
				Thread.sleep(delay);
				try {
					ImageIO.write(screenshots[i], "jpeg", new File("./src/test/resources/screenshots/" + i
							+ ".jpeg")); 
					
			
				} catch (IOException e) {
					e.printStackTrace();
					isSuccesful = false;
				}
			}
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		return isSuccesful;
	}

}

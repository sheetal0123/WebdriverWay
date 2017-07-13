package com.star;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.DriverRepo;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

/**
 * 
 * To take screenshot of a particular web element
 * 
 * todo: correct element not coming
 * http://blog.xebia.in/index.php/2012/03/25/java-robot-replacing-human-intervention-for-capturing-screenshots/
 */
public class AShotScreenshotOfWebElement {

    public static void main(String[] args) throws Exception {

    		WebDriver driver = DriverRepo.CHROME.getDriver();
        driver.manage().window().maximize();

        driver.get("https://www.meritnation.com/");
        
        //
        Thread.sleep(5000);
        (new WebDriverWait(driver, 60))
                .until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver newDriver) {
                        return newDriver.findElement(By.xpath(".//*[@id='mnapp']/div[1]/div[4]"));
                    }
                });
        
       
        //hide the fixed header from webpage so it would not affect the view port while taking screenshot
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("$('#wrap header').hide();");
        
        
        //element for screenshot
        Thread.sleep(500);
        WebElement element = driver.findElement(By.xpath(".//*[@id='mnapp']/div[1]/div[4]"));
        
        
        final Screenshot screenshot = new AShot()
                .shootingStrategy(new ViewportPastingStrategy(1500))
                .takeScreenshot(driver, element);
        
        final BufferedImage image = screenshot.getImage();
        
        ImageIO.write(image, "PNG", new File(
                "./src/test/resources/screenshots/"
                        + "AShot_MN_WebElement.png"));

        driver.quit();
    }
}

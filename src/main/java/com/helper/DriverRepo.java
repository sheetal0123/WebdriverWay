package com.helper;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import lombok.extern.java.Log;


@Log
public enum DriverRepo {

	FIREFOX {
		public WebDriver getDriver() {
			String current_os = System.getProperty("os.name");
			log.info("##Current OS: " + current_os);
			if (current_os.contains("Mac")) {
				log.info("MAC: Initializing FireFox...");
				System.setProperty("webdriver.gecko.driver", getCommonPath("geckodriver.exe"));
				return new FirefoxDriver();
			} else if (current_os.contains("Windows")) {
				log.info("WINDOW: Initializing FireFox...");
				System.setProperty("webdriver.gecko.driver", getCommonPath("geckodriver.exe"));
				return new FirefoxDriver();
			} else {
				throw new RuntimeException("Invalid OS for Firefox");
			}
		}

	},
	CHROME {
		public WebDriver getDriver() {
			String current_os = System.getProperty("os.name");
			log.info("##Current OS: " + current_os);

			if (current_os.contains("Mac")) {
				log.info("MAC: Initializing Chrome...");
				System.setProperty("webdriver.chrome.driver", getCommonPath("chromedriver.exe"));
				return new ChromeDriver();	
			} else if (current_os.contains("Window")) {
				log.info("### WINDOW: Initializing Chrome...");
				System.setProperty("webdriver.chrome.driver", getCommonPath("chromedriver_92.exe"));
				return new ChromeDriver();	
			} else {
				throw new RuntimeException("Invalid OS for chrome");
			}
		}
	};

	WebDriver driver;

	DriverRepo(WebDriver drv) {
		this.driver = drv;
	}

	DriverRepo() {
	}

	public WebDriver getDriver() {
		return driver;
	}

	
	public String getCommonPath(String driver) {
		Path currentRelativePath = Paths.get("");
		String absPath = currentRelativePath.toAbsolutePath().toString();

		//current project path
		System.out.println("Absolute Path: " + absPath); 
		String fileToBeRead = absPath + "\\src\\test\\resources\\drivers\\"+driver;
		System.out.println("Driver path: " + fileToBeRead);
		
		//Backslash for windows + fwd slash for Linux(jenkin) will be handled automatically
		String fileToBeReadConverted = FilenameUtils.separatorsToSystem(fileToBeRead);
		System.out.println("Driver Final Path: "+ fileToBeReadConverted);
		return fileToBeReadConverted;
	}
}

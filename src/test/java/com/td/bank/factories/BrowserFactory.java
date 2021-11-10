package com.td.bank.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.td.bank.testcases.BaseTest;

/*
 * This class can do the following"
 * - To create required Webdriver
 * - To maintain an instance of a Webdriver
 */
public class BrowserFactory extends BaseTest {
	// public static WebDriver driver;

	public WebDriver getBrowser(String browserName) {
		if (browserName.equals("Firefox")) {
			if (driver == null) {

				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "//src//main//java//com//td//bank//exe//geckodriver.exe");

				driver = new FirefoxDriver();

			} else {
				return driver;
			}
		} else if (browserName.equals("Chrome")) {
			if (driver == null) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "//src//main//java//com//td//bank//exe//chromedriver.exe");

				driver = new ChromeDriver();

			} else {
				return driver;
			}
		} else if (browserName.equals("InternetExplorer")) {
			if (driver == null) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "//src//main//java//com//td//bank//exe//IEDriverServer.exe");

				driver = new InternetExplorerDriver();

			} else {
				return driver;
			}
		} else if (browserName.equals("Edge")) {
			if (driver == null) {

				// System.setProperty("webdriver.edge.driver", "D://msedgedriver.exe");
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + "//src//main//java//com//td//bank//exe//msedgedriver.exe");

				driver = new EdgeDriver();

			} else {
				return driver;
			}
		}

		driver.manage().window().maximize();
		return driver;
	}

}

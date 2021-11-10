package com.td.bank.pageobjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BasePage {

	public WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;

	}

	// -----------------Wait-----------------------

	protected void waitForSeconds(double time) {
		try {
			Thread.sleep((long) (time * 1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ----------------Verify Text----------------

	public void verifyText(WebElement object, String data) {

		String expected = data.trim();
		try {
			if (object.isDisplayed()) {
				String actual = object.getText();

				System.out.println("actual text displayed:" + actual);
				if (actual.toLowerCase().equals(expected.toLowerCase())
						|| actual.toLowerCase().contains(expected.toLowerCase())) {
					System.out.println("Verified the Text ");
					Assert.assertEquals(true, true, "'" + data + ": text is verified");
				} else {
					Assert.fail("'" + data + ": text is not verified");
					System.out.println(" Verify Text Function Failed");
				}
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Assert.fail("'" + data + ": unable to verify text");
		}
	}

}

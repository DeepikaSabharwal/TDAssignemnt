package com.td.bank.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.XPATH, using = "(//a[@aria-label='Open Menu']//following::i[1])[1]/..")
	private WebElement menuElement;

	@FindBy(how = How.XPATH, using = "(//div[text()='digital content and devices'])[1]")
	private WebElement digitalContentAndDevicesLabelElement;

	@FindBy(how = How.XPATH, using = "(//div[text()='digital content and devices'])[1]//following::div[text()='Kindle']")
	private WebElement kindleArrowButtonElement;

	@FindBy(how = How.XPATH, using = "(//div[text()='kindle e-readers'])[1]")
	private WebElement kindleEReadersLabelElement;

	@FindBy(how = How.XPATH, using = "(//div[text()='kindle e-readers'])[1]//following::a[text()='Kindle']")
	private WebElement kindleButtonElement;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Sign-In')]")
	private WebElement signInPageLabelElement;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'E-mail address or mobile phone number')]")
	private WebElement emailOrPhoneLabelElement;

	public boolean waitForElementToBeVisible(final WebElement element, int time) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)

				.withTimeout(time, TimeUnit.SECONDS)

				.pollingEvery(5, TimeUnit.SECONDS)

				.ignoring(NoSuchElementException.class);

		Boolean isVisible = wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				if (element.isDisplayed()) {
					return true;
				} else {
					return false;
				}
			}
		});
		return isVisible;
	}

	public void verifyBuyNowButton() {

		waitForSeconds(5);
		Boolean var;
		try {

			var = driver.findElement(By.xpath("//input[@name='submit.buy-now']")).isDisplayed();

			waitForSeconds(2);

		} catch (Exception e) {
			// TODO: handle exception
			var = false;
		}

		if (var.equals(true)) {
			waitForSeconds(2);
			driver.findElement(By.xpath("//input[@name='submit.buy-now']")).click();

		} else {
			return;
		}
		waitForSeconds(3);

		try {

			waitForElementToBeVisible(getSignInPageLabelElement(), 50);
			verifyText(getSignInPageLabelElement(), "Sign-In");
			waitForElementToBeVisible(getEmailOrPhoneLabelElement(), 50);
			verifyText(getEmailOrPhoneLabelElement(), "E-mail address or mobile phone number");

		} catch (Exception e) {
			System.out.println("Unable to signIn");
			e.printStackTrace();
		}

	}

	public WebElement getMenuElement() {
		// TODO Auto-generated method stub
		return menuElement;
	}

	public WebElement getDigitalContentAndDevicesLabelElement() {
		// TODO Auto-generated method stub
		return digitalContentAndDevicesLabelElement;
	}

	public WebElement getKindleButtonElement() {
		// TODO Auto-generated method stub
		return kindleButtonElement;
	}

	public WebElement getKindleArrowButtonElement() {
		// TODO Auto-generated method stub
		return kindleArrowButtonElement;
	}

	public WebElement getKindleEReadersLabelElement() {
		// TODO Auto-generated method stub
		return kindleEReadersLabelElement;
	}

	public WebElement getEmailOrPhoneLabelElement() {
		// TODO Auto-generated method stub
		return emailOrPhoneLabelElement;
	}

	public WebElement getSignInPageLabelElement() {
		// TODO Auto-generated method stub
		return signInPageLabelElement;
	}
}

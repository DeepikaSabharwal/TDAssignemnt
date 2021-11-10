package com.td.bank.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.td.bank.factories.BrowserFactory;
import com.td.bank.factories.DataProviderFactory;
import com.td.bank.pageobjects.HomePage;


public class AmazonWebAutomationTest extends BaseTest {
	
	BrowserFactory factory = new BrowserFactory();
	HomePage homePage;
	
	@Parameters({"browserName"})
	@BeforeClass(groups = {"tests"})
	public void setUp(String browserName) 
	{
		
		driver = factory.getBrowser(browserName);
		driver.get(DataProviderFactory.getConfigurationDataProvider().getBaseURL());
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		homePage = PageFactory.initElements(driver, HomePage.class);   
		
	}
	
	@Test(groups = {"tests"})
	public void amazonTest() throws Exception
	{
		System.out.println(driver.getCurrentUrl());
		
		Assert.assertEquals(waitForElementToBeVisible(homePage.getMenuElement(),time),true);
		clickElement(homePage.getMenuElement());
		Assert.assertEquals(waitForElementToBeVisible(homePage.getDigitalContentAndDevicesLabelElement(),time), true);
		Assert.assertEquals(waitForElementToBeEnabled(homePage.getDigitalContentAndDevicesLabelElement(),time), true);
		clickElement(homePage.getKindleArrowButtonElement());
		Assert.assertEquals(waitForElementToBeVisible(homePage.getKindleEReadersLabelElement(),time), true);
		Assert.assertEquals(waitForElementToBeEnabled(homePage.getKindleEReadersLabelElement(),time), true);
		clickElement(homePage.getKindleButtonElement());
		Thread.sleep(3);
		homePage.verifyBuyNowButton();

//		Assert.assertEquals(waitForElementToBeVisible(homePage.getSignInPageLabelElement(),time), true);
//		Assert.assertEquals(waitForElementToBeVisible(homePage.getEmailOrPhoneLabelElement(),time), true);
		
		
		
	}
	
	@AfterClass(groups = {"tests"})
    public void tearDown()
	{ 
		try
		{
			driver.close();
		}
		
		catch(Exception e)
		{
			driver.manage().deleteAllCookies();
			driver=null;
		}
		
	}

}

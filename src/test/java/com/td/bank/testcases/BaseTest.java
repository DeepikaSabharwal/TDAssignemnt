package com.td.bank.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.td.bank.factories.DataProviderFactory;

public class BaseTest 
{
	//WebDriver driver = BrowserFactory.getBrowser();
	public static WebDriver driver;
	
	public static WebDriverWait wait;
	public int time = Integer.parseInt(DataProviderFactory.getConfigurationDataProvider().getWaitTime());
	public WebDriver getDriver() {
		return driver;
	}
	

	//---------------------function for clicking the particular element------------------//
	
	public void clickElement(WebElement element)
	{
		
			element.click();
				 
	}

	
	//---------------------function for checking visibility of the element------------------//
	
	
	public boolean waitForElementToBeVisible(final WebElement element,int time) throws InterruptedException
	{
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		 
		    .withTimeout(time, TimeUnit.SECONDS)
		 
		    .pollingEvery(5, TimeUnit.SECONDS)
		 
		    .ignoring(NoSuchElementException.class);
		 
		Boolean isVisible = wait.until(new Function<WebDriver, Boolean>() 
		{
		  public Boolean apply(WebDriver driver) {
		    if(element.isDisplayed())
		    {
			  return true;
		    }
		    else
		    {
		    	return false;
		    }
		}
		});
		return isVisible;
		}
	

	
	public boolean waitForElementToBeEnabled(final WebElement element,int time) throws InterruptedException
	{
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		 
		    .withTimeout(time, TimeUnit.SECONDS)
		 
		    .pollingEvery(5, TimeUnit.SECONDS)
		 
		    .ignoring(NoSuchElementException.class);
		 
		Boolean isVisible = wait.until(new Function<WebDriver, Boolean>() 
		{
		  public Boolean apply(WebDriver driver) {
		    if(element.isEnabled())
		    {
			  return true;
		    }
		    else
		    {
		    	return false;
		    }
		}
		});
		return isVisible;
	}


		
	//---------------------method for validation------------------//
	

	
	public boolean validateLabel(WebElement e,String label)
	{
		System.out.println(e.getText());
		if(e.getText().trim().contains(label))

		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
}



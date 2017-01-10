package PageObjects;

import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import testHelpers.EnvironmentXmlHandler;

public abstract class BasePageObject {
	
	WebDriver driver;
	
	String url;
	String title;
	
	public BasePageObject(WebDriver driver, String url, String title)
	{
		this.driver = driver;
		this.url = url;
		this.title = title;
	}
	
	public void gotoPage()
	{
		driver.get(EnvironmentXmlHandler.getEnvironmentBaseURL() + url);
	}
	
	public void assertOnPage()
	{
		Assert.assertEquals(title, driver.getTitle());
		Assert.assertEquals(EnvironmentXmlHandler.getEnvironmentBaseURL() + url, driver.getCurrentUrl());
	}
}

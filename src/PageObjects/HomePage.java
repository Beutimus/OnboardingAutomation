package PageObjects;

import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import testHelpers.EnvironmentXmlHandler;

public class HomePage {
	
	WebDriver driver;
	
	public static final String url = "";
	public static final String title = "";

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void gotoHomePage()
	{
		driver.get(EnvironmentXmlHandler.getEnvironmentBaseURL() + url);
	}

	public void assertOnHomePage()
	{
		Assert.assertEquals(title, driver.getTitle());
	}
}

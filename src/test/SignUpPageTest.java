package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import junit.framework.Assert;
import testHelpers.EnvironmentXmlHandler;

public class SignUpPageTest {
	
	// TODO: Delete this test when it is running correctly
	@Test
	public void nullTest()
	{
		System.out.println(EnvironmentXmlHandler.getEnvironmentBaseURL());
		
		WebDriver driver = new FirefoxDriver();
		
		HomePage homepage = new HomePage(driver);
		
		//driver.get("https://www.msn.com");
	}
	
	@Test
	public void homePageTest()
	{
		WebDriver driver = new FirefoxDriver();
		
		HomePage page = new HomePage(driver);
		page.gotoHomePage();
		page.assertOnHomePage();
	}

}

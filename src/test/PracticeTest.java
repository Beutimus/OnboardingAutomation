package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import testHelpers.EnvironmentXmlHandler;

public class PracticeTest {
	
	// TODO: Delete this test when it is running correctly
	@Test
	public void nullTest()
	{
		System.out.println(EnvironmentXmlHandler.getEnvironmentBaseURL());
		
		System.out.println(EnvironmentXmlHandler.databaseURL());
		
		System.out.println(EnvironmentXmlHandler.databaseUserName());

		System.out.println(EnvironmentXmlHandler.databasePassword());
		
		WebDriver driver = new FirefoxDriver();
		
		HomePage homepage = new HomePage(driver);
		
		//driver.get("https://www.msn.com");
	}
	
	@Test
	public void homePageTest()
	{
		WebDriver driver = new FirefoxDriver();
		
		HomePage page = new HomePage(driver);
		page.gotoPage();
		page.assertOnPage();
	}

}

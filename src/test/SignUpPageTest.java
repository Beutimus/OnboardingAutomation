package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import testHelpers.EnvironmentXmlHandler;

public class SignUpPageTest {
	
	// TODO: Delete this test when it is running correctly
	@Test
	public void nullTest()
	{
		EnvironmentXmlHandler.getEnvironmentBaseURL();
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.msn.com");
		
		
	}

}

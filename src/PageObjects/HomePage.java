package PageObjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver, "#/home", "OnboardApp");
	}
}

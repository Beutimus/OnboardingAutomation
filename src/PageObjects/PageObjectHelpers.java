package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class PageObjectHelpers {
	
	/***
	 * Clears out a text field and types in it
	 * 
	 * @param element WebElement to clear and type
	 */
	public static void clearAndType(WebElement element, String string)
	{
		element.sendKeys(Keys.chord(Keys.CONTROL + "a") + Keys.DELETE);
		element.sendKeys(string);
	}

}

package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// This page represents the task template edit page
public class TaskTemplateEditPage extends BasePageObject {
	
	By taskBy = By.tagName("h2");
	By titleFieldBy = By.id("title");
	By descriptionFieldBy = By.id("description");
	By idBy = By.xpath("//label[contains(.,'ID:')]/..");
	By saveButtonBy = By.tagName("button");
	
	private String baseXPath = "//div[contains(.,'##') and @class='ng-binding']";

	public TaskTemplateEditPage(WebDriver driver) {
		super(driver, "#/admin/templates/", "OnboardApp");
	}
	
	public String getTask()
	{
		return driver.findElement(taskBy).getText().trim();
	}
	
	// ID is structured a bit differently from the other fields
	public String getID()
	{
		String text = driver.findElement(idBy).getText();
		
		return text.substring(text.indexOf(':') + 1).trim();
	}
	
	public String getCategory()
	{
		return genericGet("Category");
	}
	
	public String getPosition()
	{
		return genericGet("Position");
	}
	
	public String getPractice()
	{
		return genericGet("Practice");
	}

	public String genericGet(String var)
	{
		String xpath = baseXPath.replace("##", var);
		
		WebElement element = driver.findElement(By.xpath(xpath));
		
		String value = element.getText();
		
		return value.substring(value.indexOf(':') + 1).trim();
	}
	
	// Dynamic page URL assertion
	public void assertOnPage()
	{
		url = "#/admin/templates/" + getID();
		super.assertOnPage();
	}

	public String getTitle() {
		return driver.findElement(titleFieldBy).getAttribute("value");
	}

	public void typeNewTitle(String string) {
		PageObjectHelpers.clearAndType(driver.findElement(titleFieldBy), string);
	}
	
	public void typeNewDescription(String string) {
		PageObjectHelpers.clearAndType(driver.findElement(descriptionFieldBy), string);
	}
	
	public String getDescription()
	{
		return driver.findElement(descriptionFieldBy).getAttribute("value");
	}

	public void clickSave() {
		driver.findElement(saveButtonBy).click();
	}

	public boolean isSaveButtonEnabled() {
		return driver.findElement(saveButtonBy).isEnabled();
	}
}

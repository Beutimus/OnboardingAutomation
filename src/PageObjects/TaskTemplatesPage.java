package PageObjects;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testHelpers.TemplateFE;

public class TaskTemplatesPage extends BasePageObject {

	public TaskTemplatesPage(WebDriver driver) {
		super(driver, "#/admin/templates", "OnboardApp");
	}

	public List<WebElement> getTemplateLinks() {
		
		return driver.findElements(By.xpath("//span[contains(@ng-click,'editTemplate')]"));
	}
	
	public List<TemplateFE> scrapePage()
	{
		By xpath = By.xpath("//tr[contains(@ng-repeat,'template')]");
		
		List<WebElement> templateNodes = driver.findElements(xpath);
		List<TemplateFE> templateFE = new LinkedList<TemplateFE>();
		
		for(WebElement templateNode : templateNodes)
		{
			List<WebElement> data = templateNode.findElements(By.tagName("td"));
			
			String title = data.get(0).getText();
			String category = data.get(1).getText();
			String position = data.get(2).getText();
			String practice = data.get(3).getText();
			
			templateFE.add(new TemplateFE(title, category, position, practice));
		}
		
		return templateFE;
	}
	
	public void gotoPage()
	{
		super.gotoPage();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

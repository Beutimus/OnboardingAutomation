package test;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import PageObjects.*;
import testHelpers.TemplateFE;

public class TaskTemplateEditTest {
		WebDriver driver;
		TaskTemplatesPage templateListPage;
	    
	    @BeforeMethod
	    public void setup()
	    {
	    	driver = new FirefoxDriver();
	    	templateListPage = new TaskTemplatesPage(driver);
	    	templateListPage.gotoPage();
	    }
	    
	    @AfterMethod
	    public void teardown()
	    {
	    	driver.close();
	    }
	    
	    @Test
	    public void verifyNavigation()
	    {
	    	// First we pull all the templates and links from the page
	    	List<WebElement> templateLinks = templateListPage.getTemplateLinks();
	    	List<TemplateFE> templates = templateListPage.scrapePage();
	    	
	    	int max = templateLinks.size();
	    	
	    	Random rand = new Random();
	    	
	    	int index = rand.nextInt(max);
	    	
	    	WebElement link = templateLinks.get(index);
	    	TemplateFE template = templates.get(index);
	    	
	    	link.click();
	    	
	    	TaskTemplateEditPage edit = new TaskTemplateEditPage(driver);
	    	
	    	edit.assertOnPage();
	    	
	    	// Verify template values
	    	Assert.assertEquals(edit.getTitle(), template.getTitle());
	    	Assert.assertEquals(edit.getCategory(), template.getCategory());
	    	Assert.assertEquals(edit.getPosition(), template.getPosition());
	    	Assert.assertEquals(edit.getPractice(), template.getPractice());
	    }
	    
	    @Test
	    public void verifyEditTitle()
	    {
	    	List<WebElement> templateLinks = templateListPage.getTemplateLinks();
	    	List<TemplateFE> templates = templateListPage.scrapePage();
	    	
	    	int max = templateLinks.size();
	    	
	    	Random rand = new Random();
	    	
	    	int index = rand.nextInt(max);
	    	
	    	WebElement link = templateLinks.get(index);
	    	TemplateFE template = templates.get(index);
	    	
	    	link.click();
	    	
	    	TaskTemplateEditPage edit = new TaskTemplateEditPage(driver);
	    	
	    	String oldTitle = template.getTitle();
	    	
	    	edit.typeNewTitle(oldTitle + "test");
	    	
	    	edit.clickSave();
	    	
	    	templateListPage.gotoPage();
	    	
	    	templateLinks = templateListPage.getTemplateLinks();
	    	link = templateLinks.get(index);
	    	
	    	link.click();
	    	
	    	Assert.assertEquals(edit.getTitle(), oldTitle + "test");
	    	
	    	edit.typeNewTitle(oldTitle);
	    }
	    
	    @Test
	    public void verifyEditDescription()
	    {
	    	List<WebElement> templateLinks = templateListPage.getTemplateLinks();
	    	
	    	int max = templateLinks.size();
	    	
	    	Random rand = new Random();
	    	
	    	int index = rand.nextInt(max);
	    	
	    	WebElement link = templateLinks.get(index);
	    	
	    	link.click();
	    	
	    	TaskTemplateEditPage edit = new TaskTemplateEditPage(driver);
	    	
	    	String oldDescription = edit.getDescription();
	    	
	    	edit.typeNewDescription(oldDescription + "test");
	    	
	    	edit.clickSave();
	    	
	    	templateListPage.gotoPage();
	    	
	    	templateLinks = templateListPage.getTemplateLinks();
	    	link = templateLinks.get(index);
	    	
	    	link.click();
	    	
	    	Assert.assertEquals(edit.getDescription(), oldDescription + "test");
	    	
	    	edit.typeNewDescription(oldDescription);
	    }
}

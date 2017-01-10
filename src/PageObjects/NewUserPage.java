package PageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import testHelpers.GenerateDate;
import testHelpers.GeneratePractice;
import testHelpers.GenerateUserData;

/**
 * Created by bill.witt on 11/1/2016.
 */
public class NewUserPage extends BasePageObject {

	By firstNameFieldElemBy = By.id("firstname");
	By lastNameFieldElemBy = By.id("lastname");
	By positionChoiceElemBy = By.id("inputPosition");
	By practiceChoiceElemBy = By.id("inputPractice");
	By emailFieldElemBy = By.id("inputEmail3");
	By dateFieldElemBy = By.className("md-datepicker-input");
	By addUserBtnElemBy = By.id("submitbutton");
	By successMessage = By.xpath("//div[text()='Success!']");

	public NewUserPage(WebDriver driver)
	{
		super(driver, "#/addUser", "OnboardApp");
	}

	public List<WebElement> randomizeInputFields() {
		List<WebElement> randomElements = new ArrayList<>();
		List<WebElement> elements = new ArrayList<>();
		elements.add(driver.findElement(firstNameFieldElemBy));
		elements.add(driver.findElement(lastNameFieldElemBy));
		elements.add(driver.findElement(emailFieldElemBy));
		elements.add(driver.findElement(dateFieldElemBy));

		Random random = new Random();
		for(int i = 0; i <3; i++) {
			int randomInt = random.nextInt(4);
			if (!randomElements.contains(elements.get(randomInt))) {
				randomElements.add(elements.get(randomInt));
			}
		}
		return randomElements;
	}

	public List<String> createRandomizedNewUser() {
		/* TODO: Put all user data form elements into the userData array */
		// List userData contains randomly generated first and last names, and email address
		List<String> userData = GenerateUserData.generateData();
		String firstName = userData.get(0);
		String lastName = userData.get(1);
		String practice = GeneratePractice.randomPractice();
		String email = userData.get(2);

		driver.findElement(firstNameFieldElemBy).sendKeys(firstName);
		driver.findElement(lastNameFieldElemBy).sendKeys(lastName);
		selectPosition("Contractor");
		selectPractice(practice);
		driver.findElement(emailFieldElemBy).sendKeys(email);
		driver.findElement(dateFieldElemBy).sendKeys(GenerateDate.todaysDate());
		driver.findElement(addUserBtnElemBy).click();

		return userData;
	}

	public void typeFirstName(String keys)
	{
		driver.findElement(firstNameFieldElemBy).sendKeys(keys);
	}

	public void typeLastName(String keys)
	{
		driver.findElement(lastNameFieldElemBy).sendKeys(keys);
	}

	public void typeEmail(String keys)
	{
		driver.findElement(emailFieldElemBy).sendKeys(keys);
	}

	public void typeDate(String keys)
	{
		driver.findElement(dateFieldElemBy).sendKeys(keys);
	}

	public void clickAddUserButton() {
		driver.findElement(addUserBtnElemBy).click();
	}

	public void selectPosition(String string) {
		Select position = new Select(driver.findElement(positionChoiceElemBy));
		position.selectByVisibleText(string);

	}

	public void selectPractice(String string) {
		Select practice = new Select(driver.findElement(practiceChoiceElemBy));
		practice.selectByVisibleText(string);
	}

	public boolean isAddButtonEnabled()
	{
		WebElement button = driver.findElement(addUserBtnElemBy);

		return button.isEnabled();
	}

	public WebElement getSuccessMesssage()
	{
		return driver.findElement(successMessage);
	}
}

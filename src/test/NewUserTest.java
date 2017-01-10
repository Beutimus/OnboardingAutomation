package test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import PageObjects.NewUserPage;
import testHelpers.ConnectToDatabase;
import testHelpers.GenerateDate;
import testHelpers.GeneratePractice;
import testHelpers.GenerateUserData;

public class NewUserTest {
	// Input values
    private String firstName = GenerateUserData.generateData().get(0);
    private String lastName = GenerateUserData.generateData().get(1);
    private String practice = GeneratePractice.randomPractice();
    private String email = GenerateUserData.generateData().get(2);
    private String date = GenerateDate.todaysDate();
    
    WebDriver driver;
    NewUserPage newUserPage;
    
    @BeforeTest
    public void test()
    {
    	driver = new FirefoxDriver();
    	newUserPage = new NewUserPage(driver);
    	newUserPage.gotoPage();
    }
    
    @AfterTest
    public void cleanup()
    {
    	driver.close();
    }


    @Test
    public void adding_user_with_no_input_failure() {
    	Assert.assertTrue(newUserPage.isAddButtonEnabled() == false, "Add Button was not disabled");
    }

    @Test
    public void adding_user_with_partial_input_failure() {
        List<WebElement> inputFields = newUserPage.randomizeInputFields();
        for (int i = 0; i < inputFields.size(); i++) {
            if (inputFields.get(i).getAttribute("id").equals("firstname"))
                inputFields.get(i).sendKeys();
            else if (inputFields.get(i).getAttribute("id").equals("lastname"))
                inputFields.get(i).sendKeys(lastName);
            else if (inputFields.get(i).getAttribute("id").equals("inputEmail3"))
                inputFields.get(i).sendKeys(email);
            else if (inputFields.get(i).getAttribute("id").equals("date"))
                inputFields.get(i).sendKeys(date);
            
            Assert.assertTrue(newUserPage.isAddButtonEnabled() == false, "Add button was not disabled");
        }
    }

    @Test
    public void adding_user_with_all_input_successful() throws Exception {
        newUserPage.typeFirstName(firstName);
        newUserPage.typeLastName(lastName);
        newUserPage.selectPosition("Contractor");
        newUserPage.selectPractice(practice);
        newUserPage.typeEmail(email);
        newUserPage.typeDate(date);
        newUserPage.clickAddUserButton();

        waitInSeconds(2);
        WebElement success = newUserPage.getSuccessMesssage();
        Assert.assertTrue(success.isDisplayed(), "Unsuccessful addition of new user.");
    }

    @Test
    public void same_user_cannot_be_added_again() {
		Assert.assertTrue(false, "Not implemented");
    }

    @Test
    public void new_user_saved_to_db() throws Exception {
        ConnectToDatabase connectToDatabase = new ConnectToDatabase();

        List<String> newUserData = newUserPage.createRandomizedNewUser();
        String email = newUserData.get(2);
        List<String> dbUserData = connectToDatabase.verifyDbData(email);

	        Assert.assertTrue(newUserData.equals(dbUserData), "New user data not found in database.");
        System.out.println("New user data matches new user in database.");
    }

    protected void waitInSeconds(int seconds) throws InterruptedException {
        int milliseconds = seconds * 1000;
        Thread.sleep(milliseconds);
    }
}

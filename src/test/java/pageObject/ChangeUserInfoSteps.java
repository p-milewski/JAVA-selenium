package pageObject;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChangeUserInfoSteps {

    private UserInfoPage userInfoPage;
    private WebDriver driver;

    @Given("User is logged in to CodersLab shop")
    public void userIsLooggedInToCodersLabShop() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("michal.dobrzycki@coderslab.pl" +
                "", "CodersLab");
    }

    @When("User goes to UserInformationPage")
    public void userGoesToInformationPage(){



    }

    @And("^User changes his birthday to \"([^\"]*)\"$")
    public void userChangesHisBirthdayTo(String date) {
        userInfoPage.setBirthdate(date);
    }


    @And("User signs up for our newsletter")
    public void userSignsUpForOurNewsletter() {
        userInfoPage.signInForNewsletter();
    }

    @And("User saves information")
    public void userSavesInformation() {
        userInfoPage.submitUserInfo();
    }

    @Then("^User sees \"([^\"]*)\"$")
    public void userSees(String message) {
        Assert.assertEquals(message, userInfoPage.getUpdateInformation());
    }
}

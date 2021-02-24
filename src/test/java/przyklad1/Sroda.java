package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;


public class Sroda {

    private WebDriver driver;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");


    }
    @Test
    public void testBingSearch() {


        //firstName
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.clear();

        firstName.sendKeys("Paweł");

        firstName.submit();






        //lastName
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.clear();

        lastName.sendKeys("Milewski");

        lastName.submit();


        //address

        WebElement address = driver.findElement(By.name("address"));
        address.clear();

        address.sendKeys("unknown");

        address.submit();

        WebElement gender = driver.findElement(By.xpath("/html/body/div/div/form/div[3]/div/div/label[1]/input"));
        gender.click();

        //birth

        WebElement birth = driver.findElement(By.name("dob"));
        birth.clear();

        birth.sendKeys("05/22/2010");

        birth.submit();


        //password
        WebElement password = driver.findElement(By.name("password"));
        password.clear();

        password.sendKeys("123123123123123");

        password.submit();

        //comment
        WebElement comment = driver.findElement(By.name("comment"));
        comment.clear();

        comment.sendKeys("COMMMMMMENT");

        comment.submit();

        //company
        WebElement company = driver.findElement(By.name("company"));
        company.clear();
        company.sendKeys("Coders Lab");
        company.submit();

        //email
        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("emaiL@email.com");
        email.submit();





    }
    @After
    public void tearDown() throws Exception {


    }
}

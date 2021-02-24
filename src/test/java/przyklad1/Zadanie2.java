package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class Zadanie2 {

    private static String[] products = {"mug", "t-shirt", "bowl", "notebook", "frame", "cushion", "poster", };

    private static String getProduct() {
        Random random = new Random();
        return products[random.nextInt(products.length - 1)];
    }
    private WebDriver driver;

    @Before
    public void przedTestem() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl");
    }
    @Test
    public void podczasTestu() {

        WebElement element = driver.findElement(By.name("s"));
        element.clear();

        element.sendKeys(getProduct());

        element.submit();
    }

    @After
    public void cleanUp() {



    }
}

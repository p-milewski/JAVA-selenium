package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;



public class PrzykladWtorek {

    private static String[] word = {"pies", "kot", "kura", "kogut", "ryba"};
    private static String getWord() {

        Random random = new Random();
        return word[random.nextInt(word.length-1)];
    }

    public WebDriver driver;


    @Before

    public void beforeTest() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
    }
    @Test

    public void duringTest(){


        WebElement element = driver.findElement(By.name("search"));
        element.clear();
        element.sendKeys(getWord());
        element.submit();

    }

    @After

    public void afterTest(){


    }



}

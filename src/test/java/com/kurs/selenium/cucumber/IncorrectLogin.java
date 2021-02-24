package com.kurs.selenium.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IncorrectLogin {

    public String keyword;
    private WebDriver driver;

    @Given("open browser with platform website")
    public void open() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qloapps.coderslab.pl/pl/");
    }
    @When("click login on the website")
    public void log() {
        WebElement log = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[7]/ul/li/a"));
        log.click();
    }
    @When("enter incorrect email")
    public void email() {
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("wrongemail@email.com");
    }
    @When("enter incorrect password")
    public void password() {
        WebElement pwrd = driver.findElement(By.name("passwd"));
        pwrd.sendKeys("wrongpassword");
    }
    @Then("click sign in with incorrect login and password")
    public void login() {
        WebElement login = driver.findElement(By.id("SubmitLogin"));
        login.click();
    }
}

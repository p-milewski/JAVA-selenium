package com.kurs.selenium.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CorrectLogin {

    public String keyword;
    private WebDriver driver;

    @Given("an open browser with platform website")
    public void openWebsite() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qloapps.coderslab.pl/pl/");
    }
    @When("click login")
    public void logIn() {
        WebElement login = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[7]/ul/li/a"));
        login.click();
    }

    @When("enter correct email")
    public void correctLogin() {
        WebElement login = driver.findElement(By.name("email"));
                login.sendKeys("asdadasdasdasdas@email.com");
    }
    @When("enter correct password")
        public void correctPw() {
        WebElement password = driver.findElement(By.name("passwd"));
                password.sendKeys("password");
        password.click();
        }

    @Then("click sign in")
        public void signIn() {
        WebElement signin = driver.findElement(By.id("SubmitLogin"));
                signin.click();
    }

}

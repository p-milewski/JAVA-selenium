package com.kurs.selenium.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class HotelRegister {

    public String keyword;
    private WebDriver driver;

    @Given("an open browser with hotel website")
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qloapps.coderslab.pl/pl/logowanie?back=my-account");

    }
    @When("email address is entered in input field")
    public void enterEmail() throws InterruptedException {
        WebElement email = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div[1]/form/div/div[2]/input"));
        email.clear();
        email.sendKeys("asdadasdasdasdas@email.com");
        email.submit();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);


    }

    @When("select first name")
    public void clickName() {

        WebElement clickName = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[1]/div[2]/input"));
        clickName.clear();
        clickName.sendKeys("Stephen");
        clickName.click();
    }
    @When("select last name")
    public void clickSurname() {

        WebElement clickSurname = driver.findElement(By.id("customer_lastname"));
        clickSurname.clear();
        clickSurname.sendKeys("King");
        clickSurname.click();
    }
    @When("select password")
    public void selectPswrd() {

        WebElement selectPswrd = driver.findElement(By.id("passwd"));
        selectPswrd.clear();
        selectPswrd.sendKeys("password");
        selectPswrd.click();
    }
    @Then("click register button")
    public void clickRegister() {

        WebElement clickRegister = driver.findElement(By.name("submitAccount"));
        clickRegister.click();

    }




}

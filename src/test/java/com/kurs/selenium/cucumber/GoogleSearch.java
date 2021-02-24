package com.kurs.selenium.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

    public String keyword;
    private WebDriver driver;

    @Given("an open browser with google.com")
    public void openGoogle() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");

    }
    @When("a keyword {string} is entered in input field")
    public void enterKeyword(String keyword) {
        WebElement search = driver.findElement(By.name("q"));
                search.sendKeys(keyword);
                search.submit();
    }
    @Then("the first one should contain {string}")
    public void checkfirstElement(String expectedString) {
        System.out.println("selenium");

    }

    @And("close browser")
    public void closeBrowser() {
        driver.quit();
    }
}

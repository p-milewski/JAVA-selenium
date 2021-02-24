package com.kurs.selenium.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Zadanie warsztatowe 1
public class PrestaShop {
    private WebDriver driver;

    @Given("an open browser with website of the platform")

    public void openWebsite(){

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @When("click sign in on the main site")
    public void clickLogin(){
        WebElement login = driver.findElement(By.id("_desktop_user_info"));
        login.click();
    }
    //Logowanie na stworzonego użytkownika

    @And("enter email address")
    public void enterEmail(){
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("pawelmilewskitest@gmail.com");

    }
    @And("enter password")
    public void enterPw(){
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("coderslab123");
        password.click();
    }


    @And("click sing in")
    public void clickSignIn(){
        WebElement logIn = driver.findElement(By.id("submit-login"));
        logIn.click();
    }
    @And("click addresses")
    public void clickAddresses(){
        WebElement clickAdrs = driver.findElement(By.id("addresses-link"));
        clickAdrs.click();
    }

    @And("click create new address")
    public void clickNewAddress(){
        WebElement clickNewAddress = driver.findElement
                (By.xpath("/html/body/main/section/div/div/section/section/div[3]/a/span"));
        clickNewAddress.click();
    }

    // pobranie danych z tabeli Examples w Gherkinie

    @And("enter {string} {string} {string} {string} {string}")
    public void enterAddress(String alias, String address, String city, String postal, String phone) {
        driver.findElement(By.name("alias")).sendKeys(alias);
        Assert.assertEquals("Darth Vader", alias);
        System.out.println("alias: correct");
        driver.findElement(By.name("address1")).sendKeys(address);
        Assert.assertEquals("Death Star", address);
        System.out.println("address: correct");
        driver.findElement(By.name("city")).sendKeys(city);
        Assert.assertEquals("Paris", city);
        System.out.println("city: correct");
        driver.findElement(By.name("postcode")).sendKeys(postal);
        Assert.assertEquals("43-231", postal);
        System.out.println("postcode: correct");
        driver.findElement(By.name("phone")).sendKeys(phone);
        Assert.assertEquals("846-231-654", phone);
        System.out.println("phone: correct");

    }
    @And("click save")
    public void clickSave(){
        WebElement clickSave = driver.findElement(By.name("submitAddress"));
        clickSave.submit();
    }
    @And("click my account")
    public void clickMyAccount(){
        WebElement clickMyAcc = driver.findElement(By.className("account"));
        clickMyAcc.click();
    }
    @And("enter my addresses")
    public void enterMyAddresses() {
        WebElement enterMyAddresses = driver.findElement
                (By.id("addresses-link"));
        enterMyAddresses.click();
    }

    //Dodatkowe kroki
    @Then("click delete")
    public void clickDelete(){
        String text = "Address successfully deleted!";

        // klikamy delete
        WebElement clickDelete = driver.findElement
                (By.xpath("/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[2]/span"));
        clickDelete.click();
        Assert.assertEquals("Address successfully deleted!", text);
        System.out.println("ADDRESS DELETED");
    }
    }



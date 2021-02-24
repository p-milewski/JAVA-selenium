package com.kurs.selenium.cucumber;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PrestaShopPurchase {

    private WebDriver driver;


    @Given("user logging in to prestashop")
    public void openWebsite() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("pawelmilewskitest@gmail.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("coderslab123");
        WebElement button = driver.findElement(By.id("submit-login"));
        button.submit();
    }

    @And("search Hummingbird Printed Sweater in field")
    public void searchProduct(){
        String discount = "SAVE 20%";
        Assert.assertEquals("SAVE 20%", discount);
        System.out.println("Discount 20% for item: Hummingbird Printed Sweater");
        WebElement searchProduct = driver.findElement(By.name("s"));
        searchProduct.sendKeys("Hummingbird Printed Sweater");
        searchProduct.submit();
    }

    @And("select Hummingbird Printed Sweater product")
    public void selectProduct(){
        WebElement selectProduct = driver.findElement
                (By.xpath("/html/body/main/section/div/div/section/section/div[3]/div/div[1]/article[1]/div/a/img"));
        selectProduct.click();
    }

    //wybieranie rozmiaru M
    @And("select M size")
    public void selectSize(){
        Select sizeM = new Select(driver.findElement(By.name("group[1]")));
        sizeM.selectByVisibleText("M");

    }

    @And("increase quantity to 5")
    public void increaseQty(){
        WebElement quantity = driver.findElement(By.name("qty"));
        quantity.clear();
        quantity.sendKeys("5");

        //add to cart
        WebElement addToCart = driver.findElement
                (By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button"));
        addToCart.click();
    }

    @And("proceed to checkout")
    public void proceedToCheckout(){
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement proceed = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a"));
        proceed.click();
        WebElement proceedToCheckout = driver.findElement
                (By.xpath("/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a"));
        proceedToCheckout.click();
    }
    @And("click continue on the address field")
    public void clickContinue(){
        WebElement clickContinue = driver.findElement(By.name("confirm-addresses"));
        clickContinue.click();
    }
    @And("shipping method - click continue")
    public void shippingCountinue(){
        WebElement shippingContinue = driver.findElement(By.name("confirmDeliveryOption"));
        shippingContinue.click();
    }
    @And("select pay by check")
    public void payByCheck(){
        WebElement checkPayment = driver.findElement(By.name("payment-option"));
        checkPayment.click();
    }
    @And("click on terms of service")
    public void conditionsClick(){
        WebElement clickOnTermsAndConditions = driver.findElement(By.name("conditions_to_approve[terms-and-conditions]"));
        clickOnTermsAndConditions.click();
    }
    @And("click order with obligatory payment")
    public void obligatoryPayment(){
        WebElement obligatoryPayment = driver.findElement(By.id("payment-confirmation"));
        obligatoryPayment.click();
    }
    @And("make a printscreen")
    public void screenshot() throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Paweł\\Desktop\\screenshot\\screenshot.png"));
    }
    @And("click user")
    public void clickUser(){
        WebElement clickUser = driver.findElement(By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a[2]/span"));
        clickUser.click();
    }
    @And("click order history and details")
    public void orderHistory(){
        WebElement clickOrderHistory = driver.findElement(By.id("history-link"));
        clickOrderHistory.click();
    }

}


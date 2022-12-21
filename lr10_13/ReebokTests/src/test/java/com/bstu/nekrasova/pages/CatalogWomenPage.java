package com.bstu.nekrasova.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogWomenPage extends AbstractPage {
    private final String BASE_URL = "https://www.reebok.com/us/women";
    Actions action = new Actions(driver);
    private final Logger logger = LogManager.getRootLogger();

    public CatalogWomenPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public CatalogWomenPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public ProductPage openProductPage(){
        WebElement logo = driver.findElement(By.xpath("//*[@data-auto-id=\"logo\"]"));
        action.moveToElement(logo);
        action.perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"grid-item\"]")));
        driver.findElement(By.xpath("//div[@class=\"grid-item\"]")).click();
        return new ProductPage(driver);
    }

    public LoginPage openLoginPage()
    {
        driver.findElement(By.xpath("//*[@manual_cm_sp=\"header-_-customerinfo-_-Login\"]")).click();
        return new LoginPage(driver);
    }

    public CatalogWomenPage fulltextSearch(){
        driver.findElement(By.xpath("//*[@name=\"q\"]")).click();
        driver.findElement(By.xpath("//*[@name=\"q\"]")).sendKeys("op");
        logger.info("Successful search");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
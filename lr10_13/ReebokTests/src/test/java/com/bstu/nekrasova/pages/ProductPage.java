package com.bstu.nekrasova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends AbstractPage {
    private final String BASE_URL = "";

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ProductPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public ProductPage addToBag() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"size-selector___2kfnl\"] //child::button")));
        driver.findElement(By.xpath("//div[@class=\"size-selector___2kfnl\"] //child::button")).click();
        driver.findElement(By.xpath("//*[@data-auto-id=\"add-to-bag\"]")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BagPage openBagPage() {
        driver.navigate().to("https://www.reebok.com/us/cart");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new BagPage(driver);
    }

}

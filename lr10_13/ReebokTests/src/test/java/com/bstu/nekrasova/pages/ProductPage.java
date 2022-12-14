package com.bstu.nekrasova.pages;

import org.openqa.selenium.By;
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
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"gl-label size___2Jnft\"]")));
        driver.findElement(By.xpath("//*[@class=\"gl-label size___2Jnft\"]")).click();
        driver.findElement(By.xpath("//*[@data-auto-id=\"add-to-bag\"]")).click();
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

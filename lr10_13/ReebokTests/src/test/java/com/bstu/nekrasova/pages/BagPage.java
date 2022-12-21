package com.bstu.nekrasova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BagPage extends AbstractPage {
    private final String BASE_URL = "https://www.reebok.com/us/cart";

    public BagPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public BagPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public BagPage changeQuantity() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"gl-dropdown-custom__list\"]")));
        WebElement quantity = driver.findElement(By.xpath("//*[@class=\"gl-dropdown-custom__list\"]"));

        return this;
    }

}
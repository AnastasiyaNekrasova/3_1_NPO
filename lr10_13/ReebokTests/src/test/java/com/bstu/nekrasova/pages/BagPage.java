package com.bstu.nekrasova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

}
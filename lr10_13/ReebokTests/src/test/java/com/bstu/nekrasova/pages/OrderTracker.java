package com.bstu.nekrasova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderTracker extends AbstractPage {
    private final String BASE_URL = "https://www.reebok.com/us/order-tracker";

    public OrderTracker(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public OrderTracker openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public OrderTracker setOrderInfo() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name=\"orderNo\"]")));
        WebElement loginField = driver.findElement(By.xpath("//*[@name=\"orderNo\"]"));
        loginField.sendKeys("AD4SGY6");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name=\"email\"]")));
        WebElement passwordField = driver.findElement(By.xpath("//*[@name=\"email\"]"));
        passwordField.sendKeys("afierycat@gmail.com");
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
        return this;
    }

}

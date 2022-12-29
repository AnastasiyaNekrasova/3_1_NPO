package com.bstu.nekrasova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"size-selector___2kfnl\"] //child::button")));
        driver.findElement(By.xpath("//div[@class=\"size-selector___2kfnl\"] //child::button")).click();
        driver.findElement(By.xpath("//*[@data-auto-id=\"add-to-bag\"]")).click();
        return this;
    }

    public WebElement findSoldOut() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"sold_out\"]")));
        WebElement soldOut = driver.findElement(By.xpath("//div[@class=\"sold_out\"]"));
        return soldOut;
    }

    public ProductPage addSoldOutToBag() {
        findSoldOut();
        addToBag();
        return this;
    }

    public ProductPage writeReview(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,10000)", "");
        driver.findElement(By.xpath("//*[text()[contains(.,\"Reviews\")]]")).click();
        driver.findElement(By.xpath("//button[text()[contains(.,\"Write a review\")]]")).click();
        return this;
    }

    public ProductPage submitReview(){
        driver.findElement(By.xpath("//*[@id=\"star-overall-4\"]")).click();
        driver.findElement(By.xpath("//button[text()[contains(.,\"Write a review\")]]")).click();
        return this;
    }

    public BagPage openBagPage() {
        driver.navigate().to("https://www.reebok.com/us/cart");
        return new BagPage(driver);
    }

}

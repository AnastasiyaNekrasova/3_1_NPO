package com.bstu.nekrasova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopLocatorPage extends AbstractPage
{
    private final String BASE_URL = "https://www.reebok.com/us/store-locator#/";

    public ShopLocatorPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ShopLocatorPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public ShopLocatorPage findStore(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"view_switcher_button\"]")));
        driver.findElement(By.xpath("//*[@class=\"view_switcher_button\"]")).click();
        driver.findElements(By.xpath("//*[@class=\"search_button\"]")).get(1).click();
        driver.findElement(By.xpath("//*[@type=\"search\"]")).sendKeys("Prospekt Pobediteley 65");
        driver.findElement(By.xpath("//*[@class=\"search\"]")).click();
        return this;
    }
}
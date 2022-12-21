package com.bstu.nekrasova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage
{
    private final String BASE_URL = "https://www.reebok.com/us";

    public MainPage(WebDriver driver)
    {
        super(driver);
        driver.manage().window().maximize();
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MainPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public CatalogWomenPage openWomenPage()
    {
        driver.findElement(By.xpath("//*[@manual_cm_sp=\"header-_-women\"]")).click();
        return new CatalogWomenPage(driver);
    }

    public LoginPage openLoginPage()
    {
        driver.findElement(By.xpath("//*[@manual_cm_sp=\"header-_-customerinfo-_-Login\"]")).click();
        return new LoginPage(driver);
    }

    public ShopLocatorPage openShopLocator(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,10000)", "");
        driver.findElement(By.xpath("//*[@manual_cm_sp=\"footer-_-support-_-store locator\"]")).click();
        return new ShopLocatorPage(driver);
    }
}
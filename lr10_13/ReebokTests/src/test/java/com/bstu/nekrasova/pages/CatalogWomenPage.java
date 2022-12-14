package com.bstu.nekrasova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogWomenPage extends AbstractPage {
    private final String BASE_URL = "https://www.reebok.com/us/women";

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
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,10000)", "");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@src=\"https://assets.reebok.com/images/w_600,f_auto,q_auto/5fd280abbb834ec7a5fbae7000968df9_9366/LX2200_Shoes_White_GW7201_01_standard.jpg\"]")));
        driver.findElement(By.xpath("//*[@src=\"https://assets.reebok.com/images/w_600,f_auto,q_auto/5fd280abbb834ec7a5fbae7000968df9_9366/LX2200_Shoes_White_GW7201_01_standard.jpg\"]")).click();
        return new ProductPage(driver);
    }

    public LoginPage openLoginPage()
    {
        driver.findElement(By.xpath("//*[@manual_cm_sp=\"header-_-customerinfo-_-Login\"]")).click();
        return new LoginPage(driver);
    }

}
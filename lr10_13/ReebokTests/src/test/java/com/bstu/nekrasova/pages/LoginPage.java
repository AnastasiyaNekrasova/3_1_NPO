package com.bstu.nekrasova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
    private final String BASE_URL = "https://www.reebok.com/us/account-login";

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public LoginPage logIn() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-email\"]")));
        WebElement loginField = driver.findElement(By.xpath("//*[@id=\"login-email\"]"));
        loginField.sendKeys("afierycat@gmail.com");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-password\"]")));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"login-password\"]"));
        passwordField.sendKeys("Pt6441774!");
        WebElement ele = driver.findElement(By.xpath("//*[@data-auto-id=\"login-form-login\"]"));
        ele.click();
        return this;
    }

    public MainPage openMainPage()
    {
        driver.findElement(By.xpath("//*[@data-auto-id=\"logo\"]")).click();
        return new MainPage(driver);
    }

    public CatalogWomenPage openWomenPage()
    {
        driver.findElement(By.xpath("//*[@manual_cm_sp=\"header-_-women\"]")).click();
        return new CatalogWomenPage(driver);
    }

    public ForumPage openForumPage()
    {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,10000)", "");
        driver.findElement(By.xpath("//*[@manual_cm_sp=\"footer-_-support-_-faqs\"]")).click();
        return new ForumPage(driver);
    }

    public ShopLocatorPage openShopLocator(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,10000)", "");
        driver.findElement(By.xpath("//*[@manual_cm_sp=\"footer-_-support-_-store locator\"]")).click();
        return new ShopLocatorPage(driver);
    }

    public OrderTracker openOrderTracker()
    {
        driver.findElement(By.xpath("//*[@data-auto-id=\"header-order-tracker-link\"]")).click();
        return new OrderTracker(driver);
    }

}
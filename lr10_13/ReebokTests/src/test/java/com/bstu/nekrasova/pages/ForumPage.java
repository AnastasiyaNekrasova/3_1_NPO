package com.bstu.nekrasova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForumPage extends AbstractPage
{
    private final String BASE_URL = "https://www.reebok.com/us/help";

    public ForumPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ForumPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public ForumPage checkForum(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"view_switcher_button\"]")));
        driver.findElement(By.xpath("//*[@class=\"view_switcher_button\"]")).click();
        driver.findElements(By.xpath("//*[@class=\"search_button\"]")).get(1).click();
        return this;
    }
}
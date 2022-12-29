package com.bstu.nekrasova.tests;

import com.bstu.nekrasova.pages.CatalogWomenPage;
import com.bstu.nekrasova.pages.MainPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests extends CommonConditions {
    @Test
    public void addToBag()
    {
        assertThat(new MainPage(driver)
                .openPage()
                .openLoginPage()
                .logIn()
                .openWomenPage()
                .openProductPage()
                .addToBag()
                .openBagPage()).isNotNull();
    }
    @Test
    public void fulltextSearch()
    {
        assertThat(new CatalogWomenPage(driver)
                .openPage()
                .fulltextSearch()).isNotNull();
    }
    @Test
    public void shopLocator()
    {
        assertThat(new MainPage(driver)
                .openLoginPage()
                .logIn()
                .openMainPage()
                .openShopLocator()
                .findStore()).isNotNull();
    }

    @Test
    public void BuySoldOut()
    {
        assertThat(new MainPage(driver)
                .openPage()
                .openWomenPage()
                .openProductPage()
                .addSoldOutToBag()).isNotNull();
    }
    @Test
    public void AddComment()
    {
        new MainPage(driver)
                .openLoginPage()
                .logIn()
                .openWomenPage()
                .openProductPage()
                .writeReview()
                .submitReview();
    }
    @Test
    public void ForumLookUp()
    {
        assertThat(new MainPage(driver)
                .openLoginPage()
                .logIn()
                .openMainPage()
                .openPage()
                .openForumPage()
                .checkForum()).isNotNull();
    }
    @Test
    public void SortTest()
    {
        assertThat(new MainPage(driver)
                .openPage()
                .openWomenPage()
                .chooseSort()).isNotNull();
    }
    @Test
    public void FilterTest()
    {
        assertThat(new MainPage(driver)
                .openPage()
                .openWomenPage()
                .chooseFilter()).isNotNull();
    }
    @Test
    public void OrderTracker()
    {
        assertThat(new MainPage(driver)
                .openLoginPage()
                .logIn()
                .openOrderTracker()
                .setOrderInfo()).isNotNull();
    }
    @Test
    public void OrderQuantityError()
    {
        assertThat(new MainPage(driver)
                .openPage()
                .openWomenPage()
                .openProductPage()
                .addToBag()
                .openBagPage()
                .changeQuantity()).isNotNull();
    }
}
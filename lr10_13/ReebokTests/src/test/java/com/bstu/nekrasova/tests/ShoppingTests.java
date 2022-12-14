package com.bstu.nekrasova.tests;

import com.bstu.nekrasova.pages.CatalogWomenPage;
import com.bstu.nekrasova.pages.MainPage;
import org.testng.annotations.Test;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingTests extends CommonConditions {
    @Test
    public void addToBag()
    {
        new MainPage(driver)
                .openPage()
                .openLoginPage()
                .logIn()
                .openWomenPage()
                .openProductPage()
                .addToBag()
                .openBagPage();
    }
}
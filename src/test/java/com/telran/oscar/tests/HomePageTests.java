package com.telran.oscar.tests;

import com.telran.oscar.pages.basket.BasketPage;
import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.pages.home.SidePanelPage;
import com.telran.oscar.product.ProductMatchingPage;
import com.telran.oscar.product.ProductPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    HomePage homePage;
    ProductPage productPage;
    SidePanelPage sidePanelPage;
    ProductMatchingPage productMatchingPage;
    BasketPage basketPage;

    @BeforeMethod
    public void pageInit() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        productPage = PageFactory.initElements(driver, ProductPage.class);
        sidePanelPage = PageFactory.initElements(driver, SidePanelPage.class);
        productMatchingPage = PageFactory.initElements(driver, ProductMatchingPage.class);
        basketPage = PageFactory.initElements(driver,BasketPage.class);
        homePage.selectLanguage("en-gb");
    }

    @Test
    public void userCanSelectItemFromMenu() {
        sidePanelPage.clickOnBooksTab();
        Assert.assertTrue(productPage.isProductPage().contains("Books"));
    }

    @Test
    public void allProductsPageTest() {
        sidePanelPage.clickOnAllProductsTab();
        Assert.assertTrue(productPage.isProductPageAllProducts().contains("All products"));
    }

    @Test
    public void clothingPageTest() {
        sidePanelPage.clickOnClothingTab();
        Assert.assertTrue(productPage.isProductPageClothing().contains("Clothing"));
    }

    @Test
    public void offersPageTest() {
        sidePanelPage.clickOnOffersTab();
        Assert.assertTrue(productPage.isProductPageOffers().contains("Offers"));
    }

    @Test
    public void searchPositiveTest() {
        homePage.typeOnSearchField("Reversing");
        Assert.assertTrue(productMatchingPage.isProductsMatching().contains("Reversing"));
    }

    @Test
    public void linksClickableTest(){
        Assert.assertTrue(homePage.pageTitleClickable());
        Assert.assertTrue(homePage.productLinkClickable());
    }

    @Test
    public void checkProductPriceInBasket() {
        homePage.clickOnAddToBasket();
        homePage.checkProductPrice();
    }
}
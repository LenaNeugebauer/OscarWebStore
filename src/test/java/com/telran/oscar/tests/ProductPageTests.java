package com.telran.oscar.tests;

import com.telran.oscar.pages.basket.BasketPage;
import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.pages.home.SidePanelPage;
import com.telran.oscar.pages.user.RegisterPage;
import com.telran.oscar.product.AllProductsPage;
import com.telran.oscar.product.BooksPage;
import com.telran.oscar.product.InformationProductPage;
import com.telran.oscar.product.Pre_OrderPage;
import com.telran.oscar.utils.DataProviders;
import com.telran.oscar.utils.PropertiesLoader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTests extends TestBase {

    HomePage homePage;
    RegisterPage registerPage;
    AllProductsPage allProductsPage;
    InformationProductPage informationProductPage;
    SidePanelPage sidePanelPage;
    BooksPage booksPage;
    Pre_OrderPage pre_orderPage;
    BasketPage basketPage;


    public static String password = PropertiesLoader.loadProperty("valid.password");
    public static String email = PropertiesLoader.loadProperty("valid.email");

    @BeforeMethod
    public void pageInit() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
        allProductsPage = PageFactory.initElements(driver, AllProductsPage.class);
        informationProductPage = PageFactory.initElements(driver, InformationProductPage.class);
        sidePanelPage = PageFactory.initElements(driver, SidePanelPage.class);
        booksPage = PageFactory.initElements(driver, BooksPage.class);
        pre_orderPage = PageFactory.initElements(driver, Pre_OrderPage.class);
        basketPage = PageFactory.initElements(driver, BasketPage.class);
        homePage.clickOnLoginAndRegisterLink();
        registerPage.fillLoginForm(email, password);
        homePage.selectLanguage("en-gb");
    }

    @Test
    public void allProductsButtonIsClickableTest() {
        homePage.clickOnAllProductsPage();
        Assert.assertTrue(allProductsPage.isAllProductsPageDisplayed());
    }

    @Test
    public void bookButtonIsClickableTest() {
        homePage.clickOnBooksTab();
        Assert.assertTrue(booksPage.isBooksPageDisplayed());
    }


    @Test
    public void paginationTest() {
        homePage.clickOnAllProductsPage();
        allProductsPage.scrollUpOrDown(500, 500);
        allProductsPage.clickOnNextBtn();
        allProductsPage.isPreviousBtnDisplayed();
        allProductsPage.clickOnPreviousBtn();
        Assert.assertEquals(allProductsPage.paginationIsDisplayed(), "1");
    }


    @Test
    public void getBrokenLinksTest() {
        allProductsPage.checkBrokenLinks();
    }


    @Test
    public void getBrokenImagesTest() {
        homePage.clickOnAllProductsPage();
        allProductsPage.checkBrokenImages();
    }

    @Test
    public void AddProductToBasketTest() {
        homePage.clickOnBooksTab();
        String productName = booksPage.getNameOfSelectedProduct(8);
        booksPage.clickOnProduct(8);
        informationProductPage.clickOnAddToBasketBtn();
        pre_orderPage.clickOnViewBasketBtn();
        Assert.assertTrue(basketPage.productAddedToBasket("Reversing"));

    }

    @Test
    public void AddProductToBasketFromInformationProductPageTest() {
        homePage.clickOnBooksTab();
        booksPage.clickOnProductName();
        informationProductPage.clickOnAddToBasketBtn();
        pre_orderPage.clickOnViewBasketBtn();
        Assert.assertTrue(basketPage.productAddedToBasket("Reversing"));
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "booksName")
    public void compareTitleProduct(String name) {
        homePage.clickOnBooksTab();
        booksPage.checkProductName(name);

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "price")
    public void comparePriceProduct(String price) {
        homePage.clickOnBooksTab();
        booksPage.checkProductPrice(price);
    }

    @Test()
    public void compareProductName() {
        homePage.clickOnAllProductsPage();
        String productName = allProductsPage.getNameOfSelectedProduct(17);
        allProductsPage.clickOnProductName(17);
        Assert.assertEquals(informationProductPage.getProductName(), productName);
    }
}

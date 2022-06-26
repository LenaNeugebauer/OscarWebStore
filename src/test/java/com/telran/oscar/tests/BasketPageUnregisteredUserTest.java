package com.telran.oscar.tests;

import com.telran.oscar.pages.account.OrderHistoryPage;
import com.telran.oscar.pages.basket.*;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.product.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasketPageUnregisteredUserTest extends TestBase {
    HomePage homePage;
    InformationProductPage informationProductPage;
    BooksPage booksPage;
    Pre_OrderPage pre_orderPage;
    BasketPage basketPage;
    NewCustomerPage newCustomerPage;
    ShippingAddressPage shippingAddressPage;
    EnterPaymentDetailsPage enterPaymentDetailsPage;
    ConformationOfOrderPage conformationOfOrderPage;
    OrderHistoryPage orderHistoryPage;
    HeaderPage headerPage;


    @BeforeMethod
    public void pageInit() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        informationProductPage = PageFactory.initElements(driver, InformationProductPage.class);
        booksPage = PageFactory.initElements(driver, BooksPage.class);
        pre_orderPage = PageFactory.initElements(driver, Pre_OrderPage.class);
        basketPage = PageFactory.initElements(driver, BasketPage.class);
        newCustomerPage = PageFactory.initElements(driver, NewCustomerPage.class);
        shippingAddressPage = PageFactory.initElements(driver, ShippingAddressPage.class);
        enterPaymentDetailsPage = PageFactory.initElements(driver, EnterPaymentDetailsPage.class);
        conformationOfOrderPage = PageFactory.initElements(driver, ConformationOfOrderPage.class);
        orderHistoryPage = PageFactory.initElements(driver, OrderHistoryPage.class);
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
    }

    @BeforeMethod
    public void preconditions() {
        homePage.selectLanguage("en-gb");
        homePage.clickOnBooksTab();
    }

    @Test
    public void placeOrderForUnregisteredUserTest() {
        booksPage.clickOnProduct(1);
        informationProductPage.clickOnAddToBasketBtn();
        pre_orderPage.clickOnViewBasketBtn();
        basketPage.clickOnProceedToCheckout();
        newCustomerPage.typeEmail("muller+999@gmail.com").typePassword("Mp1234567!").selectRadioBtn().clickOnContinueBtn();
        shippingAddressPage.typeFirstName("Peter").typeLastName("Muller").typeFirstLineOfAddress("Andersens").typeCity("Kopenhagen").typePost("0100").clickOnContinueBtn();
        enterPaymentDetailsPage.clickOnContinueBtn();
        pre_orderPage.clickOnPlaceOrderBtn();
    }

    @Test
    public void checkPriceOfProductAddedToBasket() {
        Double price = Double.parseDouble(booksPage.getPriceOfChosenProduct(2));
        booksPage.clickOnAddToBasketButton(2);
        headerPage.clickOnViewBasketBtn();
        Assert.assertEquals(basketPage.getPriceForProductName(0), price);
    }

    @Test
    public void deleteProductItemFromBasket() {
        String productName = booksPage.getNameOfSelectedProduct(1);
        booksPage.clickOnAddToBasketButton(1);
        headerPage.clickOnViewBasketBtn();
        basketPage.setQuantity("0", "0").clickOnUpdateBtn(0);
        Assert.assertFalse(basketPage.isAddedProductInBasket(productName));
    }

    @Test
    public void checkTotalSumInBasketTest() {
        booksPage.clickOnAddToBasketButton(1);
        booksPage.clickOnAddToBasketButton(2);
        headerPage.clickOnViewBasketBtn();
        Double totalPrice1 = basketPage.getTotalPrice(0);
        Double totalPrice2 = basketPage.getTotalPrice(1);
        Assert.assertEquals(totalPrice1 + totalPrice2, basketPage.getBasketTotal());
    }
}
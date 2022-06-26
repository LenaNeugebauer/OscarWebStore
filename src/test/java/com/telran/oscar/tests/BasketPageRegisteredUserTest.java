package com.telran.oscar.tests;

import com.telran.oscar.pages.account.OrderHistoryPage;
import com.telran.oscar.pages.account.AddressBookPage;
import com.telran.oscar.pages.basket.*;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.pages.home.SidePanelPage;
import com.telran.oscar.pages.user.RegisterPage;
import com.telran.oscar.product.*;
import com.telran.oscar.utils.PropertiesLoader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasketPageRegisteredUserTest extends TestBase {
    HomePage homePage;
    RegisterPage registerPage;
    AllProductsPage allProductsPage;
    InformationProductPage informationProductPage;
    SidePanelPage sidePanelPage;
    BooksPage booksPage;
    Pre_OrderPage pre_orderPage;
    BasketPage basketPage;
    NewCustomerPage newCustomerPage;
    ShippingAddressPage shippingAddressPage;
    EnterPaymentDetailsPage enterPaymentDetailsPage;
    ConformationOfOrderPage conformationOfOrderPage;
    OrderHistoryPage orderHistoryPage;
    AddressBookPage addressBookPage;
    HeaderPage headerPage;


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
        newCustomerPage = PageFactory.initElements(driver, NewCustomerPage.class);
        shippingAddressPage = PageFactory.initElements(driver, ShippingAddressPage.class);
        enterPaymentDetailsPage = PageFactory.initElements(driver, EnterPaymentDetailsPage.class);
        conformationOfOrderPage = PageFactory.initElements(driver, ConformationOfOrderPage.class);
        orderHistoryPage = PageFactory.initElements(driver, OrderHistoryPage.class);
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        headerPage = PageFactory.initElements(driver, HeaderPage.class);

    }

    @BeforeMethod
    public void preconditions() {
        homePage.clickOnLoginAndRegisterLink();
        registerPage.fillLoginForm(email, password);
        homePage.selectLanguage("en-gb");
        homePage.clickOnBooksTab();
    }

    @Test
    public void placeOrderForRegisteredUserTest() {
        booksPage.clickOnProduct(1);
        informationProductPage.clickOnAddToBasketBtn();
        pre_orderPage.clickOnViewBasketBtn();
        basketPage.clickOnProceedToCheckout();
        shippingAddressPage.clickOnShipToThisAddress();
        enterPaymentDetailsPage.clickOnContinueBtn();
        pre_orderPage.clickOnPlaceOrderBtn();
        String orderNumber = conformationOfOrderPage.getOrderNumber();
        conformationOfOrderPage.clickOnContinueShoppingBtn();
        homePage.clickOnAccountBtn();
        orderHistoryPage.clickOnOrderHistory();
        Assert.assertEquals(orderHistoryPage.getOrderNumber(), orderNumber);
    }

    @Test
    public void checkAddressBookTest() {
        booksPage.clickOnAddToBasketBtn();
        booksPage.clickOnViewBasketBtn();
        basketPage.clickOnProceedToCheckout();
        shippingAddressPage.typeFirstName("Peter").typeLastName("Muller").typeFirstLineOfAddress("Andersens").typeCity("Kopenhagen").typePost("0100").clickOnContinueBtn();
        enterPaymentDetailsPage.clickOnContinueBtn();
        String address = pre_orderPage.getAddress();
        pre_orderPage.clickOnPlaceOrderBtn();
        conformationOfOrderPage.clickOnContinueShoppingBtn();
        homePage.clickOnAccountBtn();
        addressBookPage.clickOnAddressBookBtn();
        Assert.assertEquals(addressBookPage.getAddress(), address);
    }
}

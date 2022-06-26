package com.telran.oscar.tests;

import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.pages.user.RegisterPage;
import com.telran.oscar.utils.DataProviders;
import com.telran.oscar.utils.PropertiesLoader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    HomePage homePage;
    RegisterPage registerPage;


    public static String password = PropertiesLoader.loadProperty("valid.password");
    public static String email = PropertiesLoader.loadProperty("valid.email");

    @BeforeMethod
    public void pageInit() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
        homePage.clickOnLoginAndRegisterLink();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginWithInvalidEmail")
    public void loginWithInvalidEmailTest(String email) {
        homePage.clickOnLoginAndRegisterLink();
        registerPage.fillLoginForm(email, password);
        Assert.assertTrue(homePage.isLoginErrorMessageDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginWithInvalidPassword")
    public void loginWithInvalidPasswordTest(String password) {
        homePage.clickOnLoginAndRegisterLink();
        registerPage.fillLoginForm(email, password);
        Assert.assertTrue(homePage.isLoginErrorMessageDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginPositive")
    public void loginPositiveTest(String email, String password) {
        homePage.clickOnLoginAndRegisterLink();
        registerPage.fillLoginForm(email, password);
        Assert.assertTrue(homePage.isLoginMessageDisplayed());
        homePage.clickOnLogoutButton();
        Assert.assertTrue(homePage.isLoginAndRegisterLinkPresent());
    }

}

package com.telran.oscar.tests;

import com.telran.oscar.pages.ProfilePage;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.RegisterPage;
import com.telran.oscar.utils.DataProviders;
import com.telran.oscar.utils.PropertiesLoader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    HomePage homePage;
    RegisterPage registerPage;
    ProfilePage profilePage;

    public static String password = PropertiesLoader.loadProperty("valid.password");
    public static String email = PropertiesLoader.loadProperty("valid.email");

    @BeforeMethod
    public void pageInit() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
    }

    @BeforeMethod
    public void preconditions() {
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

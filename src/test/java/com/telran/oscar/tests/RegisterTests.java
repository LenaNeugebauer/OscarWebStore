package com.telran.oscar.tests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.RegisterPage;
import com.telran.oscar.utils.DataProviders;
import com.telran.oscar.utils.PropertiesLoader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTests extends TestBase {

    HomePage homePage;
    RegisterPage registerPage;

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

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registrationWithInvalidEmail")
    public void newUserRegistrationWithInvalidEmailTest(String email) {
        homePage.clickOnLoginAndRegisterLink();
        registerPage.fillRegisterForm(email, password, password);
        Assert.assertTrue(registerPage.isRegisterFormDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registrationWithInvalidPassword")
    public void newUserRegistrationWithInvalidPasswordTest(String password) {
        homePage.clickOnLoginAndRegisterLink();
        registerPage.fillRegisterForm(email, password, password);
        Assert.assertTrue(registerPage.isRegisterFormDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registrationPositive")
    public void newUserRegistrationTest(String email, String password) {
        homePage.clickOnLoginAndRegisterLink();
        registerPage.fillRegisterForm(email, password, password);
        Assert.assertTrue(homePage.isLoginMessageDisplayed());
    }

}
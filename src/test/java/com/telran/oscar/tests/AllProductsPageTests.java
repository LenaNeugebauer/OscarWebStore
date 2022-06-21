package com.telran.oscar.tests;

import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.pages.user.RegisterPage;
import com.telran.oscar.product.*;
import com.telran.oscar.utils.PropertiesLoader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllProductsPageTests extends TestBase {


    HomePage homePage;
    RegisterPage registerPage;
    AllProductsPage allProductsPage;
    ClothingPage clothingPage;
    FictionPage fictionPage;
    ComputersInLiteraturePage computersInLiteraturePage;
    EssentialProgrammingPage essentialProgrammingPage;
    HackingPage hackingPage;


    public static String password = PropertiesLoader.loadProperty("valid.password");
    public static String email = PropertiesLoader.loadProperty("valid.email");

    @BeforeMethod
    public void pageInit() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
        allProductsPage = PageFactory.initElements(driver, AllProductsPage.class);
        clothingPage = PageFactory.initElements(driver, ClothingPage.class);
        fictionPage = PageFactory.initElements(driver, FictionPage.class);
        computersInLiteraturePage = PageFactory.initElements(driver, ComputersInLiteraturePage.class);
        essentialProgrammingPage = PageFactory.initElements(driver, EssentialProgrammingPage.class);
        hackingPage = PageFactory.initElements(driver, HackingPage.class);
        homePage.clickOnLoginAndRegisterLink();
        registerPage.fillLoginForm(email, password);
        homePage.selectLanguage("en-gb");
    }

    @Test
    public void sideClothingCategoriesTest() {
        homePage.clickOnAllProductsPage();
        allProductsPage.clickOnClothingBtn();
        Assert.assertTrue(clothingPage.isProductsPageDisplayed());
    }

    @Test
    public void sideBooksCategoriesTest() {
        homePage.clickOnAllProductsPage();
        allProductsPage.clickOnBooksBtn();
        Assert.assertTrue(clothingPage.isProductsPageDisplayed());
    }

    @Test
    public void sideFictionCategoriesTest() {
        homePage.clickOnAllProductsPage();
        allProductsPage.clickOnFictionBtn();
        Assert.assertTrue(fictionPage.isProductsPageDisplayed());
    }

    @Test
    public void sideComputersInLiteratureCategoriesTest() {
        homePage.clickOnAllProductsPage();
        allProductsPage.clickOnComputersInLiteratureBtn();
        Assert.assertTrue(computersInLiteraturePage.isProductsPageDisplayed());
    }

    @Test
    public void sideNonFictionCategoriesTest() {
        homePage.clickOnAllProductsPage();
        allProductsPage.clickOnNonFictionBtn();
        Assert.assertTrue(fictionPage.isProductsPageDisplayed());
    }

    @Test
    public void sideEssentialProgrammingCategoriesTest() {
        homePage.clickOnAllProductsPage();
        allProductsPage.clickEssentialProgrammingBtn();
        Assert.assertTrue(essentialProgrammingPage.isProductsPageDisplayed());
    }

    @Test
    public void sideHackingCategoriesTest() {
        homePage.clickOnAllProductsPage();
        allProductsPage.clickHackingBtn();
        Assert.assertTrue(hackingPage.isProductsPageDisplayed());
    }
}

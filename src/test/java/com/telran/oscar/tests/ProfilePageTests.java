package com.telran.oscar.tests;

import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.pages.user.*;
import com.telran.oscar.utils.PropertiesLoader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTests extends TestBase {
    HomePage homePage;
    RegisterPage registerPage;
    ProfilePage profilePage;
    DeleteProfilePage deleteProfilePage;
    ChangePasswordPage changePasswordPage;
    EditProfilePage editProfilePage;


    public static String password = PropertiesLoader.loadProperty("valid.password");
    public static String email = PropertiesLoader.loadProperty("valid.email");
    public static String newPassword = PropertiesLoader.loadProperty("new.password");
    public static String newLastName = PropertiesLoader.loadProperty("new.lastName");
    public static String newFirstName = PropertiesLoader.loadProperty("new.firstName");
    private static String newEmail = PropertiesLoader.loadProperty("new.email");
    private static String invalidPassword = PropertiesLoader.loadProperty("invalid.password");


    @BeforeMethod
    public void pageInit() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
        deleteProfilePage = PageFactory.initElements(driver, DeleteProfilePage.class);
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
        changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
        editProfilePage = PageFactory.initElements(driver, EditProfilePage.class);
        homePage.clickOnLoginAndRegisterLink();
        registerPage.fillLoginForm(email, password);
        homePage.selectLanguage("en-gb");
    }

    @Test
    public void deleteUserProfilePositiveTest() {
        new HomePage(driver).clickOnAccountBtn()
                .clickOnDeleteProfileBtn()
                .typePassword(password)
                .clickOnDeleteProfileConfirmBtn();
        Assert.assertTrue(new HomePage(driver).getConfirmDeleteProfileMessage().contains("Your profile has now been deleted. Thanks for using the site."));
    }

    @Test
    public void deleteUserWithInvalidPasswordNegativeTest() {
        homePage.clickOnAccountBtn();
        homePage.selectLanguage("en-gb");
        profilePage.clickOnDeleteProfileBtn();
        deleteProfilePage.typePassword(invalidPassword).clickOnDeleteProfileConfirmBtn();
        Assert.assertTrue(deleteProfilePage.getMessage().contains("Oops! We found some errors"));
    }

    @Test
    public void changePasswordPositiveTest() {
        homePage.clickOnAccountBtn();
        homePage.selectLanguage("en-gb");
        profilePage.clickOnChangePasswordBtn();
        changePasswordPage.typeOldPassword(password).typeNewPassword(newPassword).typeConfirmNewPassword(newPassword);
        changePasswordPage.clickOnSaveBtn();
        Assert.assertTrue(new ProfilePage(driver).getMessage().contains("Password updated"));

    }

    @Test
    public void editProfilePositiveTest() {
        homePage.clickOnAccountBtn();
        profilePage.clickOnEditProfileBtn();
        editProfilePage.typeNewFirstName(newFirstName).typeNewLastName(newLastName).typeNewEmailAddress(newEmail);
        editProfilePage.clickOnSaveBtn();
        Assert.assertTrue(editProfilePage.getMessage().contains("Profile updated"));

    }
}

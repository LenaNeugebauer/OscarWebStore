package com.telran.oscar.tests;

import com.telran.oscar.pages.*;
import com.telran.oscar.utils.PropertiesLoader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTests extends TestBase{
    HomePage homePage;
    RegisterPage registerPage;
    ProfilePage profilePage;
    ChangePasswordPage changePasswordPage;
    EditProfilePage editProfilePage;



    public static String password = PropertiesLoader.loadProperty("valid.password");
    public static String email = PropertiesLoader.loadProperty("valid.email");
    public static String newPassword = PropertiesLoader.loadProperty("new.password");
    public static String newLastName = PropertiesLoader.loadProperty("new.lastName");
    public static String newFirstName = PropertiesLoader.loadProperty("new.firstName");


    @BeforeMethod
    public void pageInit() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
        homePage.clickOnLoginAndRegisterLink();
        registerPage.fillLoginForm(email, password);

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
    public void changePasswordPositiveTest(){
        homePage.clickOnAccountBtn();
        profilePage.clickOnChangePasswordBtn();
        changePasswordPage.fillChangePasswordForm(password, newPassword, newPassword);
        changePasswordPage.clickOnSaveBtn();
        Assert.assertTrue(new ProfilePage(driver).getMessage().contains("Password updated"));

    }

    @Test
    public void editProfilePositiveTest(){
        homePage.clickOnAccountBtn();
        profilePage.clickOnEditProfileBtn();
        editProfilePage.fillEditForm(newFirstName, newLastName, " ");
        editProfilePage.clickOnSaveBtn();
        Assert.assertTrue(editProfilePage.getMessage().contains("Profile updated"));

    }
}

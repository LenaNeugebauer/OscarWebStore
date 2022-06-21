package com.telran.oscar.pages.user;

import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_registration-email")
    WebElement emailField;

    @FindBy(id = "id_registration-password1")
    WebElement passwordField;

    @FindBy(id = "id_registration-password2")
    WebElement confirmPassword;

    @FindBy(name = "registration_submit")
    WebElement registrationSubmit;

    public RegisterPage fillRegisterForm(String email, String password, String confirm) {
        type(emailField, email);
        type(passwordField, password);
        type(confirmPassword, confirm);
        click(registrationSubmit);
        return this;
    }

    @FindBy(id = "register_form")
    WebElement registerForm;

    public boolean isRegisterFormDisplayed() {
        return registerForm.isDisplayed();
    }

    @FindBy(id = "id_login-username")
    WebElement username;

    @FindBy(id = "id_login-password")
    WebElement loginPassword;

    @FindBy(name = "login_submit")
    WebElement loginSubmit;

    public HomePage fillLoginForm(String email, String password) {
        type(username, email);
        type(loginPassword, password);
        click(loginSubmit);
        return new HomePage(driver);
    }
}
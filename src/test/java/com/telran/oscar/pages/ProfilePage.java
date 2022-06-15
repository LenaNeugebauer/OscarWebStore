package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "delete_profile")
    WebElement deleteProfileBtn;

    @FindBy(id = "id_password")
    WebElement passwordInput;
    @FindBy(className = "btn-danger")
    WebElement deleteConfirmBtn;

    public ProfilePage clickOnDeleteProfileBtn(){
        deleteProfileBtn.click();
        return this;
    }
    public ProfilePage typePassword (String pass) {
        type(passwordInput, pass );
        return this;
    }

    public ProfilePage clickOnDeleteProfileConfirmBtn() {
        deleteConfirmBtn.click();
        return new ProfilePage(driver);
    }

    @FindBy(css = "a.btn.btn-primary:nth-child(5)")
    WebElement changePasswordBtn;
    public ChangePasswordPage clickOnChangePasswordBtn() {
        click(changePasswordBtn);
        return new ChangePasswordPage(driver);
    }


    @FindBy(css = "div.alertinner.wicon")
    WebElement message;
    public String getMessage() {
        return message.getText();
    }


    @FindBy(xpath = "//a[.='Edit profile']")
    WebElement editProfileBtn;

    public ProfilePage clickOnEditProfileBtn() {
        editProfileBtn.click();
        return this;
    }
}

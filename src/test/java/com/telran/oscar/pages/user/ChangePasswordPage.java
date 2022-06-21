package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends PageBase {
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_old_password")
    WebElement odlPasswordInput;

    @FindBy(id = "id_new_password1")
    WebElement newPasswordInput;

    @FindBy(id = "id_new_password2")
    WebElement newPasswordConfirmInput;


    public ChangePasswordPage typeOldPassword(String oldPassword) {
        type(odlPasswordInput, oldPassword);
        return this;
    }

    public ChangePasswordPage typeNewPassword(String newPassword) {
        type(newPasswordInput, newPassword);
        return this;
    }

    public ChangePasswordPage typeConfirmNewPassword(String confirmNewPassword) {
        type(newPasswordConfirmInput, confirmNewPassword);
        return this;
    }

    @FindBy(xpath = "//button[.='Save']")
    WebElement saveBtn;

    public void clickOnSaveBtn() {
        saveBtn.click();
    }
}

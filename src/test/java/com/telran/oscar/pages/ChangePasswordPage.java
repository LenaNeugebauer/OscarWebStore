package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends PageBase{
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "id_old_password")
    WebElement odlPasswordInput;

    @FindBy(id = "id_new_password1")
    WebElement newPasswordInput;

    @FindBy(id = "id_new_password2")
    WebElement newPasswordConfirmInput;



    public ChangePasswordPage fillChangePasswordForm(String oldPassword, String newPassword, String newPasswordConfirm) {
        if(oldPassword != ""){
            type(odlPasswordInput, oldPassword);
        }
        if(newPassword != ""){
            type(newPasswordInput, newPassword);
        }
        if(newPasswordConfirm != ""){
            type(newPasswordConfirmInput, newPasswordConfirm);
        }
        return this;
    }

    @FindBy(xpath = "//button[.='Save']")
    WebElement saveBtn;

    public ChangePasswordPage clickOnSaveBtn(){
        saveBtn.click();
        return this;
    }
}

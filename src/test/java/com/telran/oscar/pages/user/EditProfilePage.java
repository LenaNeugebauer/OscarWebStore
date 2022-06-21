package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends PageBase {
    public EditProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_first_name")
    WebElement editFirstNameField;

    @FindBy(id = "id_last_name")
    WebElement editLastNameField;

    @FindBy(id = "id_email")
    WebElement editEmailField;

    public EditProfilePage typeNewFirstName(String newFirstName) {
        type(editFirstNameField, newFirstName);
        return this;
    }

    public EditProfilePage typeNewLastName(String newEmail) {
        type(editLastNameField, newEmail);
        return this;
    }

    public EditProfilePage typeNewEmailAddress(String newEmail) {
        type(editEmailField, newEmail);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;

    public void clickOnSaveBtn() {
        click(saveBtn);
    }

    @FindBy(css = "div.alertinner.wicon")
    WebElement message;

    public String getMessage() {
        return message.getText();
    }
}

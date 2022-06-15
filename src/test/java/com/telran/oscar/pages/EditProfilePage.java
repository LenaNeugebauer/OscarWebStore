package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends PageBase{
    public EditProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "#id_first_name")
    WebElement editFirstNameFild;

    @FindBy(id = "#id_last_name")
    WebElement editLastNameField;

    @FindBy(id = "#id_email")
    WebElement editEmailField;
    public EditProfilePage fillEditForm(String newFirstName, String newLastName, String email) {
        if(newFirstName != "" && !newFirstName.equals(editFirstNameFild.getText())){
            type(editFirstNameFild, newFirstName);
        }
        if(newLastName != "" && !newLastName.equals(editLastNameField.getText())){
            type(editLastNameField, newLastName);
        }

        if(email !="" && !email.equals(editEmailField.getText())){
            type(editEmailField, email);
        }
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

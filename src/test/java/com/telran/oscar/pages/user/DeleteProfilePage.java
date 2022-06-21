package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteProfilePage extends PageBase {
    public DeleteProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_password")
    WebElement passwordInput;

    public DeleteProfilePage typePassword(String pass) {
        type(passwordInput, pass);
        return this;
    }

    @FindBy(className = "btn-danger")
    WebElement deleteConfirmBtn;

    public void clickOnDeleteProfileConfirmBtn() {
        click(deleteConfirmBtn);
    }

    @FindBy(css = "div.alertinner.wicon")
    WebElement message;

    public String getMessage() {
        return message.getText();
    }
}

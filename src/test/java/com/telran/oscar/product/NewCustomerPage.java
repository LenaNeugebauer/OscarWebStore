package com.telran.oscar.product;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.user.DeleteProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCustomerPage extends PageBase {
    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#id_username")
    WebElement emailAddress;
    public NewCustomerPage typeEmail(String email) {
        type(emailAddress, email);
        return this;
    }

    @FindBy(css="#id_password")
    WebElement pas;
    public NewCustomerPage typePassword(String password) {
        type(pas, password);
        return this;
    }

    @FindBy(css="#id_options_0")
    WebElement options;
    public NewCustomerPage selectRadioBtn() {
        click(options);
        return this;
    }

    @FindBy(xpath = "//button[@type='submit']")
    WebElement continueBtn;
    public void clickOnContinueBtn() {
        click(continueBtn);
    }
}

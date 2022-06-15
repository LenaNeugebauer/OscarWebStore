package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".dropdown-submenu")
    WebElement submenuBook;

    public ProductPage selectCategory() {
        click(submenuBook);
        return new ProductPage(driver);
    }

    @FindBy(id = "login_link")
    WebElement loginLink;

    public RegisterPage clickOnLoginAndRegisterLink() {
        click(loginLink);
        return new RegisterPage(driver);
    }

    @FindBy(css = "div.alert.alert-danger:nth-child(4)")
    WebElement message;
    public boolean isLoginErrorMessageDisplayed() {
        return message.isDisplayed();
    }

    @FindBy (xpath = "//a[@id='logout_link']")
    WebElement logoutBtn;
    public HomePage clickOnLogoutButton() {
        click(logoutBtn);
        return new HomePage(driver);
    }

    @FindBy(css = "div.alertinner.wicon")
    WebElement messages;
    public boolean isLoginMessageDisplayed() {
        return messages.isDisplayed();
    }

    @FindBy(css = "#login_link")
    WebElement loginOrRegisterBtn;
    public boolean isLoginAndRegisterLinkPresent() {
        return loginOrRegisterBtn.isDisplayed();
    }

    @FindBy(css = "ul.nav.navbar-nav.navbar-right li:nth-child(1) ")
    WebElement account;
    public ProfilePage clickOnAccountBtn() {
        click(account);
        return new ProfilePage(driver);
    }

    @FindBy(css = "div.alertinner.wicon")
    WebElement confirmDeleteProfileMessage;
    public String getConfirmDeleteProfileMessage() {
        return confirmDeleteProfileMessage.getText();
    }

}


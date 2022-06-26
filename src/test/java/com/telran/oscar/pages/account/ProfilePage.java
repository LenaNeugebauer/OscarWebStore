package com.telran.oscar.pages.account;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.user.ChangePasswordPage;
import com.telran.oscar.pages.user.DeleteProfilePage;
import com.telran.oscar.pages.user.EditProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "delete_profile")
    WebElement deleteProfileBtn;

    public DeleteProfilePage clickOnDeleteProfileBtn() {
        deleteProfileBtn.click();
        return new DeleteProfilePage(driver);
    }


    @FindBy(xpath = "//*[@id='default']/div[2]/div/div/div/a[1]")
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

  //  @FindBy(xpath = "//a[.='Edit profile']")
    @FindBy(css = "a.btn.btn-primary:nth-child(6)")
    WebElement editProfileBtn;
    public EditProfilePage clickOnEditProfileBtn() {
        click(editProfileBtn);
        return new EditProfilePage(driver);

    }
}

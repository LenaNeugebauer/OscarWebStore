package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.basket.Pre_OrderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnterPaymentDetailsPage extends PageBase {
    public EnterPaymentDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@id='view_preview']")
    WebElement continueBtn;
    public Pre_OrderPage clickOnContinueBtn() {
        click(continueBtn);
        return new Pre_OrderPage(driver);
    }
}

package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class ConformationOfOrderPage extends PageBase {
    public ConformationOfOrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//strong")
    WebElement orderNumber;
    public String getOrderNumber() {
        return orderNumber.getText();
    }

    @FindBy(xpath = "//div[2]/p/a")
    WebElement continueShoppingBtn;
    public void clickOnContinueShoppingBtn() {
        click(continueShoppingBtn);
    }
}

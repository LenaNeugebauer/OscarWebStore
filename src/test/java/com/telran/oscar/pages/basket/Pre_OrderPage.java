package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.basket.BasketPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pre_OrderPage extends PageBase {
    public Pre_OrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.btn.btn-info:nth-child(1)")
    WebElement viewBasketBtn;
    public com.telran.oscar.pages.basket.BasketPage clickOnViewBasketBtn() {
        click(viewBasketBtn);
        return new BasketPage(driver);
    }

    @FindBy(css = "#place-order")
    WebElement placeOrderBtn;
    public ConformationOfOrderPage clickOnPlaceOrderBtn() {
        click(placeOrderBtn);
        return new ConformationOfOrderPage(driver);
    }

    @FindBy(xpath = "//address")
    WebElement address;
    public String getAddress() {
        return address.getText();
    }
}

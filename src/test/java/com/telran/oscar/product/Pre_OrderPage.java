package com.telran.oscar.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pre_OrderPage extends PageBase {
    public Pre_OrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.btn.btn-info:nth-child(1)")
    WebElement viewBasketBtn;
    public Pre_OrderPage clickOnViewBasketBtn() {
        click(viewBasketBtn);
        return new Pre_OrderPage(driver);
    }
}

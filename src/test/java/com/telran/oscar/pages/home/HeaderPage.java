package com.telran.oscar.pages.home;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.basket.BasketPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends PageBase {
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='btn btn-default']")
    WebElement viewBasketBtn;
    public BasketPage clickOnViewBasketBtn() {
        click(viewBasketBtn);
        return new BasketPage(driver);
    }
}

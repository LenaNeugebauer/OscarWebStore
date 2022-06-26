package com.telran.oscar.pages.account;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends PageBase {
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "td:nth-child(1)")
    WebElement orderHistoryNumber;
    public String getOrderNumber() {
        return orderHistoryNumber.getText();
    }

    @FindBy(xpath = "//aside/ul/li[2]/a")
    WebElement orderHistoryBtn;
    public OrderHistoryPage clickOnOrderHistory() {
        click(orderHistoryBtn);
        return new OrderHistoryPage(driver);
    }
}

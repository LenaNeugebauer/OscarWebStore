package com.telran.oscar.product;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.home.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends PageBase {
    public BooksPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBooksPageDisplayed() {
        return pageTitleDisplayed();
    }

    @FindBy(css = "a[title='Reversing']")
    WebElement productName;
    public InformationProductPage clickOnProductName() {
        click(productName);
        return new InformationProductPage(driver);
    }

    @FindBy(css = "a[title='Reversing']")
    WebElement itemName;

    public InformationProductPage checkProductName(String name) {
        click(itemName);
        return new InformationProductPage(driver);
    }

    @FindBy(xpath = "//article/div[2]/p")
    WebElement priceProduct;
    public InformationProductPage checkProductPrice(String price) {
        click(priceProduct);
        return new InformationProductPage(driver);
    }
}

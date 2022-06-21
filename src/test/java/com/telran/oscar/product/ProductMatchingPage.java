package com.telran.oscar.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class ProductMatchingPage extends PageBase{
    public ProductMatchingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    WebElement productsMatching;

    public String isProductsMatching() {
        return productsMatching.getText();
    }
}

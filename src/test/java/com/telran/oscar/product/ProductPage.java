package com.telran.oscar.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".page-header")
    WebElement titleBooks;

    public String isProductPage() {
        return titleBooks.getText();
    }

    @FindBy(xpath = "//h1[contains(text(),'All products')]")
    WebElement allProducts;

    public String isProductPageAllProducts() {
        return allProducts.getText();
    }


    @FindBy(css = "h1:nth-child(1)")
    WebElement clothing;

    public String isProductPageClothing() {
        return clothing.getText();
    }

    @FindBy(css = "h1:nth-child(1)")
    WebElement offers;

    public String isProductPageOffers() {
        return offers.getText();
    }
}
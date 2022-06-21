package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends PageBase {
    public BasketPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[contains(text(),'Reversing')]")
    List<WebElement> productsInBasket;

    public boolean productAddedToBasket(String productName) {
        if(productsInBasket!=null){
            for (WebElement product:productsInBasket) {

                if(product.getText().contains(productName)) {
                    return true; }
            }
        }
        return false;
    }
}

package com.telran.oscar.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;

public class ClothingPage extends PageBase {
    public ClothingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPageDisplayed() {
        return pageTitleDisplayed();
    }
}

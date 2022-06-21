package com.telran.oscar.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;

public class FictionPage extends PageBase {
    public FictionPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPageDisplayed() {
        return pageTitleDisplayed();
    }
}

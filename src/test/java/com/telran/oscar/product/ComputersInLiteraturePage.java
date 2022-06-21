package com.telran.oscar.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;

public class ComputersInLiteraturePage extends PageBase {
    public ComputersInLiteraturePage(WebDriver driver) {
        super(driver);
    }
    public boolean isProductsPageDisplayed() {
        return pageTitleDisplayed();
    }
}

package com.telran.oscar.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;

public class EssentialProgrammingPage extends PageBase {
    public EssentialProgrammingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPageDisplayed() {
        return pageTitleDisplayed();
    }
}

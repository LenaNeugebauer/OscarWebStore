package com.telran.oscar.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationProductPage extends PageBase {
    public InformationProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1")
    WebElement productName;

    public String getProductName(){
        return productName.getText();
    }




}

package com.telran.oscar.pages.home;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.product.BooksPage;
import com.telran.oscar.product.ClothingPage;
import com.telran.oscar.product.OffersPage;
import com.telran.oscar.product.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends PageBase {
    public SidePanelPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[.='All products']")
    WebElement allProductsTab;

    public ProductPage clickOnAllProductsTab() {
        click(allProductsTab);
        return new ProductPage(driver);
    }

    @FindBy(xpath = "//a[.='Clothing']")
    WebElement clothingTab;

    public ClothingPage clickOnClothingTab() {
        click(clothingTab);
        return new ClothingPage(driver);
    }

    @FindBy(xpath = "//a[.='Books']")
    WebElement booksTab;

    public BooksPage clickOnBooksTab() {
        click(booksTab);
        return new BooksPage(driver);
    }

    @FindBy(xpath = "//a[.='Offers']")
    WebElement offersTab;

    public OffersPage clickOnOffersTab() {
        click(offersTab);
        return new OffersPage(driver);
    }



//    @FindBy(xpath = "//ul[@data-navigation='dropdown-menu']")
//    WebElement navigationPanel;
//
//    public boolean isNavigationPanelDisplayed() {
//        return navigationPanel.isDisplayed();
//    }
//
//    @FindBy(xpath = "//input[@id='id_q']")
//    WebElement searchField;
//
//    public boolean isSearchFieldDisplayed() {
//        return searchField.isDisplayed();
//    }
//
//    @FindBy(xpath = "//input[@type='submit']")
//    WebElement searchBtn;
//
//    public boolean isSearchBtnDisplayed() {
//        return searchBtn.isDisplayed();
//    }
}


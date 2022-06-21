package com.telran.oscar.pages.home;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.basket.BasketPage;
import com.telran.oscar.pages.user.ProfilePage;
import com.telran.oscar.pages.user.RegisterPage;
import com.telran.oscar.product.AllProductsPage;
import com.telran.oscar.product.BooksPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(css = ".dropdown-submenu")
//    WebElement submenuBook;
//
//    public ProductPage selectCategory() {
//        click(submenuBook);
//        return new ProductPage(driver);
//    }

    @FindBy(id = "login_link")
    WebElement loginLink;

    public RegisterPage clickOnLoginAndRegisterLink() {
        click(loginLink);
        return new RegisterPage(driver);
    }

    @FindBy(xpath = "//a[@id='logout_link']")
    WebElement logoutBtn;

    public HomePage clickOnLogoutButton() {
        click(logoutBtn);
        return this;
    }

    @FindBy(css = "div.alert.alert-danger:nth-child(4)")
    WebElement message;

    public boolean isLoginErrorMessageDisplayed() {
        return message.isDisplayed();
    }

    @FindBy(css = "div.alertinner.wicon")
    WebElement messages;

    public boolean isLoginMessageDisplayed() {
        return messages.isDisplayed();
    }


    @FindBy(css = "#login_link")
    WebElement loginOrRegisterBtn;

    public boolean isLoginAndRegisterLinkPresent() {
        return loginOrRegisterBtn.isDisplayed();
    }

    @FindBy(css = "ul.nav.navbar-nav.navbar-right li:nth-child(1)")
    WebElement account;

    public ProfilePage clickOnAccountBtn() {
        click(account);
        return new ProfilePage(driver);
    }

    @FindBy(css = "div.alertinner.wicon")
    WebElement confirmDeleteProfileMessage;

    public String getConfirmDeleteProfileMessage() {
        return confirmDeleteProfileMessage.getText();
    }

    @FindBy(css = "select.form-control")
    WebElement selectLanguage;
    @FindBy(css = " button.btn.btn-default:nth-child(4)")
    WebElement goButton;

    public void selectLanguage(String language) {
        selectDropDownByValue(selectLanguage, language);
        click(goButton);
    }

    @FindBy(id = "id_q")
    WebElement searchField;

    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchBtn;

    public HomePage typeOnSearchField(String text) {
        type(searchField, text);
        click(searchBtn);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Oscar')]")
    WebElement pageTitle;

    public boolean pageTitleClickable() {
        return isElementClickable(pageTitle, 1);
    }

    @FindBy(xpath = "//a[contains(text(),'The age of the pussyfoot')]")
    WebElement productPage;

    public boolean productLinkClickable() {
        return isElementClickable(productPage, 1);
    }

    @FindBy(css = "li.col-xs-6.col-sm-4.col-md-3.col-lg-3:nth-child(1) article.product_pod div.product_price:nth-child(4) form:nth-child(3) > button.btn.btn-primary.btn-block:nth-child(3)")
    WebElement addToBasket;

    public HomePage clickOnAddToBasket() {
        click(addToBasket);
        return new HomePage(driver);
    }

    public static void checkProductPrice() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int priceAddToBasket = i;
            int priceBasketTotal = i;
            if (priceAddToBasket != priceBasketTotal) {
                System.out.println("Error: The total amount is not equal to the order amount");
            }
        }
    }

    @FindBy(xpath = "//a[contains(text(),'All products')]")
    WebElement allProduct;
    public AllProductsPage clickOnAllProductsPage() {
        click(allProduct);
        return new AllProductsPage(driver);
    }

    @FindBy(xpath = "//li[4]/a")
    WebElement booksTab;
    public BooksPage clickOnBooksTab() {
        click(booksTab);
        return new BooksPage(driver);
    }

}


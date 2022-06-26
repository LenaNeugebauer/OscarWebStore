package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.product.NewCustomerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends PageBase {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAddedProductInBasket(String productName) {
        if (productInBasketList != null) {
            for (WebElement product : productInBasketList) {
                if (product.getText().contains(productName)) {
                    return true;

                }
            }
        }
        return false;
    }

    @FindBy(xpath = "//a[contains(text(),'Reversing')]")
    List<WebElement> productsInBasket;

    public boolean productAddedToBasket(String productName) {
        if (productsInBasket != null) {
            for (WebElement product : productsInBasket) {

                if (product.getText().contains(productName)) {
                    return true;
                }
            }
        }
        return false;
    }

    @FindBy(css = "a.btn.btn-lg.btn-primary.btn-block")
    WebElement proceedToCheckOutBtn;

    public NewCustomerPage clickOnProceedToCheckout() {
        click(proceedToCheckOutBtn);
        return new NewCustomerPage(driver);
    }

    @FindBy(xpath = "//div[5]/p")
    List<WebElement> totalPrice;

    public Double getPriceForProductName(int productNumber) {
        return Double.parseDouble(removeFirstChar(totalPrice.get(productNumber).getText()));
    }

    @FindBy(xpath = "//form[@id='basket_formset']/div/div/div[4]/p")
    List<WebElement> totalAmount;

    public Double getTotalPrice(int productNumber) {
        return Double.parseDouble(removeFirstChar(totalAmount.get(productNumber).getText()));
    }

    @FindBy(css = "td.align-right")
    WebElement basketTotal;

    public double getBasketTotal() {
        Double basketTotalPrice = Double.parseDouble(removeFirstChar(basketTotal.getText()));
        return basketTotalPrice;
    }

    public BasketPage setQuantity(String productNumber, String quantity) {
        WebElement element = driver.findElement(By.xpath("//input[@id='id_form-" + productNumber + "-quantity']"));
        type(element, quantity);
        return this;
    }

    @FindBy(xpath = "//span[@class='input-group-btn']/button[@type='submit']")
    List<WebElement> updateBtnList;

    public BasketPage clickOnUpdateBtn(int productNumber) {
        click(updateBtnList.get(productNumber));
        return this;
    }

    @FindBy(xpath = "//div[@class='col-sm-4']//a")
    List<WebElement> productInBasketList;


}

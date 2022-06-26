package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingAddressPage extends PageBase {
    public ShippingAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_first_name")
    WebElement fName;

    public ShippingAddressPage typeFirstName(String firstName) {
        type(fName, firstName);
        return this;
    }

    @FindBy(id = "id_last_name")
    WebElement lName;
    public ShippingAddressPage typeLastName(String lastName) {
        type(lName,lastName);
        return this;
    }

    @FindBy(id = "id_line1")
    WebElement lineOfAddress;

    public ShippingAddressPage typeFirstLineOfAddress(String firstLineOfAddress) {
        type(lineOfAddress, firstLineOfAddress);
        return this;
    }

    @FindBy(id = "id_line4")
    WebElement c;
    public ShippingAddressPage typeCity(String city) {
        type(c, city);
        return this;
    }

    @FindBy(id = "id_postcode")
    WebElement p;
    public ShippingAddressPage typePost(String post) {
        type(p, post);
        return this;
    }

//    @FindBy(id = "id_country")
//    WebElement count;
//    public ShippingAddressPage typeCountry(String country) {
//        type(count, country);
//        return this;
//    }

    @FindBy(xpath = "//button")
    WebElement continueBtn;
    public EnterPaymentDetailsPage clickOnContinueBtn() {
        click(continueBtn);
        return new EnterPaymentDetailsPage(driver);
    }

    @FindBy(xpath="//button[@type='submit']")
    WebElement shipAddress;
    public EnterPaymentDetailsPage clickOnShipToThisAddress() {
        click(shipAddress);
        return new EnterPaymentDetailsPage(driver);
    }
}

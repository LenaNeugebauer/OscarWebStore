package com.telran.oscar.pages.account;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage extends PageBase {
    public AddressBookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Address Book')]")
    WebElement address;
    public AddressBookPage clickOnAddressBookBtn() {
        click(address);
        return new AddressBookPage(driver);
    }

    @FindBy(xpath = "//body[@id='default']/div[2]/div/div/div/table/tbody/tr[2]/td/address")
    WebElement shipAddress;
    public String getAddress() {
        return shipAddress.getText();
    }
}

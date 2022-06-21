package com.telran.oscar.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class AllProductsPage extends PageBase {


    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getNameOfSelectedProduct(int productNumber) {
        WebElement element = driver.findElement(By.xpath("//ol[@class='row']/li[" + productNumber + "]//h3"));
        return element.getText();
    }

    public void clickOnProductName(int productNumber) {
        WebElement element = driver.findElement(By.xpath("//ol[@class='row']/li[" + productNumber + "]//div[@class='image_container']"));
        click(element, 2);
    }

    public void click(WebElement element, int timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element)).click();

        } catch (WebDriverException wde) {
            System.out.println(wde);
        }
    }

    @FindBy(xpath = "//a[contains(text(),'next')]")
    WebElement nextBtn;

    public AllProductsPage clickOnNextBtn() {
        if (nextBtn.isDisplayed()) {
            clickWithAction(nextBtn, 0, 500);
            pause(500);
        }
        return this;
    }


    public AllProductsPage clickOnPreviousBtn() {
        if (previousBtn.isDisplayed()) {
            clickWithAction(previousBtn, 0, 500);
            pause(500);
        }
        return this;
    }

    @FindBy(xpath = "//a[.='previous']")
    WebElement previousBtn;

    public boolean isPreviousBtnDisplayed() {
        try {
            return previousBtn.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @FindBy(tagName = "a")
    List<WebElement> allLinks;

    public AllProductsPage checkBrokenLinks() {
        for (int i = 0; i < allLinks.size(); i++) {
            WebElement el = allLinks.get(i);
            String url = el.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    private void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.setConnectTimeout(5000);
            connect.connect();
            if (connect.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + connect.getResponseMessage() + " is a broken link");
            } else {
                System.out.println(linkUrl + " - " + connect.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " - " + e.getMessage() + " - is a broken link");
        }
    }

    @FindBy(tagName = "img")
    List<WebElement> images;

    public AllProductsPage checkBrokenImages() {
        System.out.println("We have " + images.size() + " " + "images");

        for (int index = 0; index < images.size(); index++) {
            WebElement image = this.images.get(index);
            String imageUrl = image.getAttribute("src");
            System.out.println("URL of image " + (index + 1) + " is: " + imageUrl);
            verifyLinks(imageUrl);

            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0]).naturalWidth>0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                    System.out.println("***************************************");
                } else {
                    System.out.println("DISPLAY - BROKEN");
                    System.out.println("***************************************");
                }
            }catch (Exception e) {
                System.out.println("Error Occurred");
            }
        }
        return this;
    }


    public String paginationIsDisplayed() {
        String[] pages = driver.findElement(By.xpath("//li[@class='current']")).getText().split(" ");
        return pages[1];
    }

    public boolean isAllProductsPageDisplayed() {
        return pageTitleDisplayed();
    }

    @FindBy(xpath = "//body[@id='default']/div[2]/div/div/aside/div[2]/ul/li/a")
    WebElement clothing;
    public ClothingPage clickOnClothingBtn() {
        click(clothing);
        return new ClothingPage(driver);
    }

    @FindBy(xpath = "//div[2]/ul/li[2]/a")
    WebElement books;
    public BooksPage clickOnBooksBtn() {
        click(books);
        return new BooksPage(driver);
    }

    @FindBy(xpath = "//body[@id='default']/div[2]/div/div/aside/div[2]/ul/li[2]/ul/li/a")
    WebElement fiction;
    public FictionPage clickOnFictionBtn() {
        click(fiction);
        return new FictionPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Computers in Literature')]")
    WebElement computersInLiterature;
    public ComputersInLiteraturePage clickOnComputersInLiteratureBtn() {
        click(computersInLiterature);
        return new ComputersInLiteraturePage(driver);
    }

    @FindBy(xpath = "//li[2]/ul/li[2]/a")
    WebElement nonFiction;
    public NonFictionPage clickOnNonFictionBtn() {
        click(nonFiction);
        return new NonFictionPage(driver);
    }

    @FindBy(xpath = "//li[2]/ul/li[2]/ul/li/a")
    WebElement essentialProgramming;
    public EssentialProgrammingPage clickEssentialProgrammingBtn() {
        click(essentialProgramming);
        return new EssentialProgrammingPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Hacking')]")
    WebElement hacking;
    public HackingPage clickHackingBtn() {
        click(hacking);
        return new HackingPage(driver);
    }
}

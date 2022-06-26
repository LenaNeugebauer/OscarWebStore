package com.telran.oscar.pages;

import com.google.common.io.Files;
import com.telran.oscar.product.InformationProductPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }


    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshot(String pathToFile) {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathToFile);
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scrollUpOrDown(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public boolean isElementClickable(WebElement element, int timeout) {
        WebElement elementTemp = null;
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (WebDriverException wde) {
            System.out.println(wde);
        }
        return false;
    }

    @FindBy(tagName = "h1")
    WebElement itemTitle;

    public String getBooksName() {
        return itemTitle.getText();
    }

    public void clickWithAction(WebElement elem, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + ", " + y + ")");
        elem.click();

    }

    public void clickWithJSExecutor(WebElement element, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        element.click();

    }

    public boolean pageTitleDisplayed() {
        return driver.findElement(By.cssSelector("h1")).isDisplayed();
    }

    public String getNameOfSelectedProduct(int numberOfProduct) {
        WebElement element = driver.findElement(By.xpath("//ol[@class='row']/li[" + numberOfProduct + "]//h3"));
        return element.getText();
    }

    public void clickOnProduct(int numberOfProduct) {
        WebElement element = driver.findElement(By.xpath("//ol[@class='row']/li[" + numberOfProduct + "]//div[@class='image_container']"));
        click(element);
    }

    public Screenshot takeScreenshotWithScrollDown() {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.5f), 1000)).takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(), "png", new File("screenshots/screen" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot;
    }

    @FindBy(xpath = "//div[2]/form/button")
    WebElement addToBasketBtn;

    public InformationProductPage clickOnAddToBasketBtn() {
        click(addToBasketBtn);
        return new InformationProductPage(driver);
    }


    public void clickOnAddToBasketButton(int productNumber) {
        WebElement element = driver.findElement(By.xpath("//ol[@class='row']/li[" + productNumber + "]//button[@type='submit']"));
        click(element);
    }

    public String getPriceOfChosenProduct(int numberOfProduct) {
        WebElement element = driver.findElement(By.xpath("//ol[@class='row']/li[" + numberOfProduct + "]//p[@class='price_color']"));
        return removeFirstChar(element.getText());
    }

    public String removeFirstChar(String s) {
        return s.substring(1);
    }
}
package com.telran.oscar.pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
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

    public void shouldHaveText(WebElement element, String text, int time) {
        new WebDriverWait(driver,time).until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshot(String pathToFile) {

        File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathToFile);

        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //    public String takeScreenshot() {
//
//        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");
//        try {
//            Files.copy(tmp, screenshot);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return screenshot.getAbsolutePath();
//    }

    public void should(WebElement element, int time) {
        new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollUpOrDown(int x, int y){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+ x + ","+ y + ")");
    }

    public void selectDropDownByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public boolean isElementClickable(WebElement element, int timeout){

        WebElement elementTemp = null;
        try{
            new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));
            return true;

        }catch (WebDriverException wde){
            System.out.println(wde);
        }

        return false;
    }

}
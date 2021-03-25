package com.protrack.web.selenium.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.protrack.web.selenium.tests.BaseClass.chromeDriver;


public class Waits {

    public static void waitForElement(WebDriver driver, WebElement element){

        WebDriverWait wait = new WebDriverWait(chromeDriver, 20);
        //wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void implicitWaitTime(){
        chromeDriver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyReader.getProperty("implicitWait")), TimeUnit.SECONDS);
    }



}

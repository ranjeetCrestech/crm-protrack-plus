package com.protrack.web.selenium.utility;

import org.apache.maven.plugin.logging.Log;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.protrack.web.selenium.tests.BaseClass.chromeDriver;
import static com.protrack.web.selenium.tests.StaticContext.getProjectTitle;


public class GenericMethods {


    public static void clickAndEnterText(WebElement element, String enterValue) throws InterruptedException {
        Actions actions = new Actions(chromeDriver);
        actions.moveToElement(element);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(enterValue);
        actions.sendKeys(enterValue);
        actions.pause(3000);
        actions.sendKeys(Keys.TAB);
        actions.pause(2000);
        actions.build().perform();
    }

    public static void waitForSearchResults() throws InterruptedException {
        Thread.sleep(5000);
    }

    public static void clickAndEnter(WebElement element1, WebElement element, String enterValue) throws InterruptedException {
        Actions actions = new Actions(chromeDriver);
        actions.moveToElement(element1).click().perform();
        actions.pause(3000);
        actions.moveToElement(element);
        actions.sendKeys(enterValue);
        actions.pause(2000);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.build().perform();
    }

    public static void clickAndTab(WebElement element1, WebElement element, String enterValue) throws InterruptedException {
        Actions actions = new Actions(chromeDriver);
        actions.moveToElement(element1).click().perform();
        actions.pause(3000);
        actions.moveToElement(element);
        actions.sendKeys(enterValue);
        actions.pause(2000);
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER);
        actions.sendKeys(Keys.TAB);
      //  actions.sendKeys(Keys.TAB);
        actions.build().perform();
    }

    public static void clickAndSelect(WebElement element1, WebElement element, String enterValue) throws InterruptedException {
        Actions actions = new Actions(chromeDriver);
        actions.moveToElement(element1).click().perform();
        actions.pause(3000);
      //  actions.moveToElement(element);
//        actions.sendKeys(enterValue);
//        actions.pause(2000);
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER);
        actions.sendKeys(Keys.TAB);
        //  actions.sendKeys(Keys.TAB);
        actions.build().perform();
        actions.moveToElement(element).click().sendKeys(enterValue);
    }


    public static void clickAndEnterDrpDown(WebElement element1, WebElement element, String enterValue) throws InterruptedException {
        Actions actions = new Actions(chromeDriver);
        actions.moveToElement(element1).click().perform();
        actions.pause(3000);
        actions.moveToElement(element);
        actions.sendKeys(enterValue);
        actions.pause(2000);
        actions.sendKeys(Keys.ENTER);
       // actions.sendKeys(Keys.TAB);
        actions.build().perform();
    }



   public static void choosedrpdownoptions(WebElement[] options, String value) {
     // List<WebElement> options = chromeDriver.findElements(elements);
   // List<WebElement> options = chromeDriver.findElements(By.className("k-input"));
        for (WebElement option : options) {
            if (option.getText().contains("value")) {
                option.click();
                break;
            }
        }
    }


    /* Select Text from a dropdown */
    public static void selectDropdownElementByText(WebElement element, String text) {
        System.out.println("---Start to add element: " + element);
                try {
                        Select act = new Select(element);
                         act.selectByVisibleText(text);
        } catch (Exception e) {
            System.out.println("---ERROR: Can't select element");

        }
    }

    public static void doubleClick(WebElement element){
        Actions actions = new Actions(chromeDriver);
        actions.doubleClick(element).perform();
    }



    public static void selectByIndex(WebElement element, int index) {
        Select drop = new Select(element);
        drop.selectByIndex(index);
    }

    public static void selectByText(WebElement element, String value) {
        Select drop = new Select(element);
        //drop.selectByValue(value);
        drop.selectByVisibleText(value);

    }

    public static void  scrollPageToDown() {
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    public static void  scrollPageToUp() {
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        js.executeScript("window.scrollBy(0,-300)", "");
    }

    public static void scrollPageToElement(WebElement element) throws InterruptedException {
        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) chromeDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
            }

    public static void chooseDateFromCalendar(String date) {
       List<WebElement> webElements = chromeDriver.findElements(By.cssSelector("span.glyphicon.glyphicon-calendar"));
      //  System.out.println(webElements.size());
        for (WebElement element : webElements) {
            System.out.println(element.getText());
            if (element.getText().equals(date)) {
                element.click();
                break;
            }
        }
    }


    public static void javascriptClick(WebElement element)
    {
        JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
        executor.executeScript("arguments[0]. click();", element);
    }


public static void scrollByVisibleElement(WebElement element) {

    JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
    // Scrolling down the page till the element is found
    js.executeScript("arguments[0].scrollIntoView();", element);
}




    public static boolean executescriptClick(WebElement element)
    {
        try{
            JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
            executor.executeScript("arguments[0]. click();", element);
            return true;
        }
        catch (Exception e)
        {
            System.out.println("---ERROR clicking on element" + element);
            return false;
        }
    }



    // To take screen shot
    public void screenCapture() throws IOException {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        File scrFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        String Path = "D:\\Automation\\ProtrackProject\\Screenshots\\";
        //String Path = "C:\\Users\\admin\\IdeaProjects\\test-output\\html";
       // File screenshotName = new File(Path + chromeDriver.getTitle() + DateTimeUtil.getcurrentDateTime() + ".png");
        File screenshotName = new File(PropertyReader.getProperty("path") + "Protrack" +DateTimeUtil.getcurrentDate()+"\\" + chromeDriver.getTitle() + DateTimeUtil.getcurrentDateTime() + ".png");
        System.out.println("---- Capturing Screenshot for failed cases---");
        //Now add screenshot to results by copying the file
       try {
           FileUtils.copyFile(scrFile, screenshotName);
       }
       catch (IOException e){e.printStackTrace();}
        Reporter.log("<br>  <img src='" + screenshotName + "' height='100' width='100' /><br>");
        Reporter.log("<a href=" + screenshotName + "></a>");
    }

    /* Check is an element at page. */
    public boolean isElementPresent(WebElement element) {
        try {
            // if it does not find the element throw NoSuchElementException, thus returns false.
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("---ERROR Element " + element + " isn't found" + "\n" + e.getMessage());
            return false;
        }
    }

    public static void elementClick(WebElement element) {
        try {
            element.click();
            Thread.sleep(3000);
        } catch (NoSuchElementException | InterruptedException e) {
            System.out.println("---ERROR Element " + element + " isn't clickable" + "\n" + e.getMessage());
        }
    }

    public static void validateElementTextMatches(WebElement element, String text) {
        boolean flag;
        String wholeText = element.getText();
        Assert.assertEquals(wholeText,text);

    }

    public static void validateElementSubStringText(WebElement element, String text) {
       // boolean flag;
        String wholeText = element.getText();
        System.out.println(wholeText);
        Assert.assertTrue(wholeText.contains(text));
    }

    public static void validateReadOnlyText(WebElement element, String expectedText){
       String actualText= element.getAttribute("value");
       // System.out.println("my text is:" +actualText);
        Assert.assertEquals(actualText,expectedText);
    }

    public static void  waitForElementClickable(WebElement element, int timeInSec) {
        WebDriverWait wait = new WebDriverWait(chromeDriver,timeInSec );
        System.out.println("----Starts Wait for particular element -------"+timeInSec);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void refreshPage() {
        try {
            System.out.println("---Start Refreshing Page---");
            chromeDriver.navigate().refresh();

        } catch (Exception e) {
            System.out.println("---ERROR during Refresh " + e.getMessage());
                    }
    }

    public static void mousehover(WebElement element){
        Actions action = new Actions(chromeDriver);
        action.moveToElement(element).click().build().perform();
    }

    public static void clearTextField(WebElement element){
        element.clear();
    }

    private boolean isAlertPresent() {
        try {
            chromeDriver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public static void  waitForElementStaleRemoval(WebElement element, int timeInSec) {
        WebDriverWait wait = new WebDriverWait(chromeDriver,timeInSec );
        System.out.println("----Starts Wait for particular element -------"+timeInSec);
        //wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
    }



}
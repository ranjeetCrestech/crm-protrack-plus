package com.protrack.web.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
    public static WebDriver chromeDriver;

  // @BeforeSuite
 // public void driverStart(){
   static {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SSTSL1108\\Desktop\\chromedriver_win32 (3)\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
            }

    @AfterSuite(alwaysRun = true)
    public void driverQuit(){

       //chromeDriver.quit();
    }

}

package com.protrack.web.selenium.tests;

import com.protrack.web.selenium.pages.LoginPO;
import com.protrack.web.selenium.utility.GenericMethods;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static com.protrack.web.selenium.tests.BaseClass.chromeDriver;


public class LoginPageTest extends BaseClass {
   // private static WebDriver chromeDriver=Browser.chromeDriver;
    LoginPO loginPO = new LoginPO(chromeDriver);


    @BeforeTest(alwaysRun = true)
    public void setup(){
        chromeDriver.get("https://previewweb.myprotrackplus.net/");
    }



   @Test(groups = { "Regression" },priority=0)
    public void loginWithValidCredentials()
    {
        loginPO.login();
    }

}

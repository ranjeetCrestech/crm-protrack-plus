package com.protrack.web.selenium.pages;

import com.protrack.web.selenium.utility.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPO {
    WebDriver driver;

    @FindBy(id="UserName")
    public WebElement loginEmail;

    @FindBy(id="Password")
    public WebElement loginPassword;

    @FindBy(css=".btn-login")
    public WebElement loginButton;

    public LoginPO(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void login(){
        loginEmail.sendKeys(PropertyReader.getProperty("username"));
        loginPassword.sendKeys(PropertyReader.getProperty("password"));
        loginButton.click();
    }


}

package com.protrack.web.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPagePO {
    WebDriver driver;

    public EditPagePO(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //Edit Project PO

    @FindBy(css = "a[name=\"ProjectData\"]")
    public WebElement ProjectDataTab;





}

package com.protrack.web.selenium.pages;

import com.protrack.web.selenium.utility.GenericMethods;
import com.protrack.web.selenium.utility.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.protrack.web.selenium.tests.BaseClass.chromeDriver;
import static com.protrack.web.selenium.utility.GenericMethods.elementClick;
import static com.protrack.web.selenium.utility.Waits.waitForElement;


public class HomePagePO {
    WebDriver driver;
    GenericMethods genericMethods = new GenericMethods();
    AddProjectPO addProjectPO = new AddProjectPO(chromeDriver);

    public HomePagePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


  //  @FindBy(id ="CRM")
    @FindBy(linkText = "CRM")
    public WebElement crmTab;

    @FindBy(linkText = "BRE")
   // @FindBy(css = "li.dropdown.active > #BRE")
    public WebElement breTab;

    @FindBy(linkText = "Forms")
    public WebElement breDropdownForms;

    @FindBy(css = "h3.top-title")
    public WebElement breheading;

    @FindBy(css = "h3.top-title")
    public WebElement LibofDocheading;

    @FindBy(id = "LibraryOfDocuments")
    public WebElement libraryOfDocumentsTab;

    @FindBy(css = "li.dropdown.open > ul.dropdown-menu > li > a")
    public WebElement libraryDropdownOptionMunicipalDocuments;

    @FindBy(linkText = "Reports")
    public WebElement reportsTab;

    @FindBy(linkText = "Tax Report")
    public WebElement reportsTaxReport;


    @FindBy(css = "h3.top-title")
    public WebElement TaxReportHeading;

    @FindBy(linkText = "Admin")
    public WebElement adminTab;

    @FindBy(linkText = "Mail Filters")
    public WebElement adminDropdownMailFilters;

@FindBy(linkText = "Configure Module")
public WebElement AdminConfigureModule;

    @FindBy(css = "li.dropdown-submenu > ul.dropdown-menu > li > a")
    public WebElement AdminCM_DropdownMgmt;

    @FindBy(css = "h3.top-title")
    public WebElement AdminCM_DropdownMgmtHeading;

    @FindBy(linkText = "Calendar")
    public WebElement calendarTab;

    @FindBy(css = "h3.top-title-calender")
    public WebElement CalenderHeading;

    @FindBy(css = "h3.top-title")
    public WebElement CRMHeading;

    @FindBy(xpath = "*//div[@id='tblProject_wrapper']/div[2]/div/div/table/thead/tr/th")
    public WebElement projectsTab;

    @FindBy(xpath = "//a[@href='#tab-154']")
    public WebElement generalInfoTab;

    @FindBy(xpath = "//div[@id='dvMainContact']/table/thead/tr/th")
    @CacheLookup
    public WebElement contactsTab;

    public void clickOnCRMProjInfoTab() throws InterruptedException {

        Waits.waitForElement(chromeDriver,crmTab);
        genericMethods.elementClick(crmTab);
        genericMethods.javascriptClick(projectsTab);
        //waitForElement(chromeDriver,addProjectPO.firstProjectInLHSGrid);
        //elementClick(addProjectPO.firstProjectInLHSGrid);
        System.out.println("----In CRM UI---");
    }

    public void clickOnCRMContactsTab() throws InterruptedException
    {
        Waits.waitForElement(chromeDriver,crmTab);
        genericMethods.elementClick(crmTab);
        genericMethods.javascriptClick(contactsTab);
        System.out.println("----In CRM UI---");
    }



    }




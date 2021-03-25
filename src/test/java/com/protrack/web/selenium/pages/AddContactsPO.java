package com.protrack.web.selenium.pages;

import com.protrack.web.selenium.utility.GenericMethods;
import com.protrack.web.selenium.utility.Waits;
import net.bytebuddy.asm.Advice;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;


import static com.protrack.web.selenium.tests.BaseClass.chromeDriver;
import static com.protrack.web.selenium.utility.GenericMethods.*;

public class AddContactsPO {

    WebDriver driver;
    GenericMethods genericMethods = new GenericMethods();
    AddProjectPO addProjectPO = new AddProjectPO(chromeDriver);
    HomePagePO homePagePO = new HomePagePO(chromeDriver);
    SoftAssert softAssert=new SoftAssert();
    public AddContactsPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[normalize-space()='General Information']")
    public WebElement getContactGeneralInfoLabelHeader;

    @FindBy(xpath = "//div[@id='dvMainProject']/table/thead/tr/th")
    public WebElement clkOncontactToProjectTab;

    @FindBy(xpath = "//tr[@class='odd']//td[@class='center sorting_1']")
    public WebElement clkOnCreatedOnFirstProjectGrid;

    //@FindBy(xpath = "//div[@id='dv_GeneralInfo_CompanyInfo']/div[4]/div[1]//a[@class='nextArrow']")
    @FindBy(xpath = "//div[@id='dv_GeneralInfo_CompanyInfo']/div[3]/div[2]/a[@class='nextArrow']")
    public WebElement clickOnContactPrimeContactnextArrow;

    @FindBy(xpath = "//input[@id='FirstName']")
    public WebElement getContactGeneralInfoPrimarycontactName;

    @FindBy(xpath = "//input[@id='FirstName']")
    public WebElement getContactGeneralInfoFirstnameUneditableFormat;

    @FindBy(xpath = "//input[@id='LastName']")
    public WebElement getContactGeneralInfoLastNameUneditableFormat;

    @FindBy(xpath = "//input[@id='JobTitle']")
    public  WebElement getContactGeneralInfoJobTitleUneditableFormat;

    @FindBy(xpath = "//span[@aria-owns='ddlCompanyName_listbox']")
    public WebElement getContactgeneralinfoCompanyUneditableFormat;

    @FindBy(xpath = "//span[@aria-owns='eddnVisibility_listbox']")
    public WebElement getContactGenralInfoPublicUneditableFormat;

    /*@FindBys({@FindBy(xpath = "//div[@id='project1']/div[3]/ul/li")})
    public List<WebElement> contactTabToTabNavigation;*/
    @FindBy(xpath = "//a[normalize-space()='General Information']")
    public WebElement clkContactGeneralInfoTab;

    @FindBy(xpath = "//a[normalize-space()='Project Information']")
    public WebElement clkContactProjectInfoTab;

    @FindBy(xpath="//table[@id='tblContactProjectGrid']/thead/tr/th[1]")
    public WebElement getContactProjectGridText;

    @FindBy(xpath ="//a[normalize-space()='Resources']")
    public WebElement clkContactResourcesTab;

    @FindBy(xpath = "//table[@id='tblDocumentList']/thead/tr/th[1]")
    public WebElement getContactResourcesDocumentText;

    @FindBy(xpath = "//a[normalize-space()='Interaction Notes']")
    public WebElement clkContactInteractionNTab;

    @FindBy(xpath = "//table[@id='tblInteractionNotesGrid']/thead/tr/th[1]")
    public WebElement getcontactInteractionnotesGrid;

    public void verifyContactPageByClickingONArrowPrimaryContact() throws InterruptedException {
        waitForElementClickable(clkOncontactToProjectTab,20);
        javascriptClick(clkOncontactToProjectTab);
        waitForSearchResults();
        waitForElementClickable(addProjectPO.projectSearchBar, 20);
        clearTextField(addProjectPO.projectSearchBar);
        clickAndEnterText(addProjectPO.projectSearchBar, "Akka");
        waitForElementClickable(clkOnCreatedOnFirstProjectGrid, 30);
        elementClick(clkOnCreatedOnFirstProjectGrid);
        waitForSearchResults();
        String actual=addProjectPO.gridprimaryContactPersonDDLabelText.getText();
        waitForSearchResults();
        waitForElementClickable(clickOnContactPrimeContactnextArrow,20);
        javascriptClick(clickOnContactPrimeContactnextArrow);
        waitForSearchResults();
        Assert.assertTrue(actual.contains(getContactGeneralInfoPrimarycontactName.getAttribute("innerText")),"Primary Contact Name Does Not Match with General Information of First Name");

    }

    public void verifyContactDetailsinViewMode() throws InterruptedException {
        //waitForElementClickable(homePagePO.contactsTab,30);
        //javascriptClick(homePagePO.contactsTab);
        waitForSearchResults();
        Assert.assertEquals(false,getContactGeneralInfoFirstnameUneditableFormat.isEnabled(),"Display First Name Un-editable Format");
        Assert.assertEquals(false,getContactGeneralInfoLastNameUneditableFormat.isEnabled(),"Display Last Name Un-editable Format");
        Assert.assertEquals(false,getContactGeneralInfoJobTitleUneditableFormat.isEnabled(),"Display Job Title Un-editable Format");
        Assert.assertEquals(false,getContactgeneralinfoCompanyUneditableFormat.isSelected(),"Display Company Name Un-editable Format");
        Assert.assertEquals(false,getContactGenralInfoPublicUneditableFormat.isSelected(),"Display Public Un-editable Format");
    }
   public void verifyOneTabToAnothertabWithinTheContacts() throws InterruptedException {
   waitForElementClickable(clkContactGeneralInfoTab,20);
   javascriptClick(clkContactGeneralInfoTab);
   Assert.assertTrue(getContactGeneralInfoLabelHeader.getText().contains("General Information"),"General Information Header is displayed");
   waitForSearchResults();
   waitForElementClickable(clkContactProjectInfoTab,20);
   javascriptClick(clkContactProjectInfoTab);


   }





}
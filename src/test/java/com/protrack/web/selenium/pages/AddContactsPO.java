package com.protrack.web.selenium.pages;

import com.protrack.web.selenium.utility.GenericMethods;
import com.protrack.web.selenium.utility.Waits;
import net.bytebuddy.asm.Advice;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.util.HashMap;
import java.util.List;
import static com.protrack.web.selenium.tests.BaseClass.chromeDriver;
import static com.protrack.web.selenium.tests.StaticContext.getContactTitle;
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
    //Navigation One Tab To Another Tab
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

    //Add New Contacts
    @FindBy(id="Title")
    public WebElement contactTxtTitle;

    @FindBy(id="Prefix")
    public WebElement contactTxtPrefix;

    @FindBy(id="FirstName")
    public  WebElement contactTxtFirstName;

    @FindBy(id="PhoneticFirstName")
    public WebElement contactTxtPhoneticFirstname;

    @FindBy(id="PronunciationFirstName")
    public WebElement contactTxtPronunciationFirstName;

    @FindBy(id="MiddleName")
    public WebElement contactTxtMiddleName;

    @FindBy(id="LastName")
    public WebElement contactTxtLastName;

    @FindBy(id="PhoneticLastName")
    public  WebElement contactTxtPhoneticLastName;

    @FindBy(id="PronunciationLastName")
    public WebElement contactTxtPronunciationLastName;

    @FindBy(id="MaidenName")
    public WebElement contactTxtMaidenName;

    @FindBy(id="Suffix")
    public WebElement contactTxtSuffix;

    @FindBy(id="NickName")
    public WebElement contactTxtNickName;

    @FindBy(id="JobTitle")
    public WebElement contactTxtJobTitle;

    @FindBy(id="Department")
    public WebElement contactTxtDepartment;

    @FindBys({@FindBy(xpath="companyDropdown")})
    public List<WebElement> contactCompanydropDown;

    @FindBy(id="PhoneticCompanyName")
    public WebElement contactTxtPhoneticCompanyName;

    @FindBy(xpath="project")
    public WebElement contactDropDownProject;

    @FindBy(xpath = "BirthDay")
    public WebElement contactDropdownbirthDay;

    @FindBy(xpath="Date")
    public WebElement contacTdropDate;

    @FindBy(id="txtContactDateNote")
    public WebElement contactTxtNoteContactDateNote;

    @FindBy(xpath="visibility")
    public WebElement contactDropVisibility;

    @FindBy(xpath = "tags-tokenfield")
    public WebElement contactTxtTagsTokenfield;

    @FindBy(id="ContactNotes")
    public WebElement contactTxtContactNotes;

    @FindBy(id="DummyField1")
    public WebElement contactTxtDummyField1;

    @FindBy(id="DummyField2")
    public WebElement contactTxtDummyField2;

    @FindBy(xpath = "//input[@id='DummyDate1']")
    public WebElement contactTxtDummyDate1;

    @FindBy(xpath = "//input[@id='DummyDate2']")
    public WebElement contactTxtDummyDate2;

    @FindBy(xpath = "//select[@id='ddnContactPhoneType']")
    public WebElement  contactDropDownPhone;

    @FindBy(id = "txtPhoneContactPhoneVal")
    public WebElement contactTxtPhoneContactPhoneVal;

    @FindBy(id="txtContactPhoneName")
    public WebElement contactTxtContactPhoneName;

    @FindBy(xpath = "//select[@id='ddnContactEmailType']")
    public WebElement contactDropDownHome;

    @FindBy(id="txtEmailContactEmailVal")
    public WebElement contactTxtEmailContactEmailVal;

    @FindBy(id="txtContactEmailName")
    public WebElement contactTxtNotesContactEmailName;

    @FindBy(id="ddnContactAddressType")
    public WebElement contactTxtddnContactAddressType;

    @FindBy(id="txtContactAddressName")
    public WebElement contactTxtContactAddressName;

    @FindBy(id="txtAddressContactAddressVal")
    public WebElement contactTxtAddressContactAddressVal;

    @FindBy(id="txtStreet2ContactAddressVal")
    public WebElement contactTxtStreet2ContactAddressVal;

    @FindBy(id="txtTownContactAddressVal")
    public WebElement contactTxtTownContactAddressVal;

    @FindBy(id="ddnAddressCountryList")
    public WebElement contactDropAddressCountryList;

    @FindBy(id="ddnAddressStateList")
    public WebElement contactDropddnAddressStateList;

    @FindBy(id="txtZipcodeContactAddressVal")
    public WebElement contactTxtZipcodeContactAddressVal;

    @FindBy(id="ddnContactURLType")
    public WebElement contactDropddnContactURLType;

    @FindBy(id="txtContactURLValue")
    public WebElement contactTxtContactURLValue;

    @FindBy(id="txtContactURLNote")
    public WebElement contactTxtContactURLNote;

    @FindBy(id="ddnContactSocialProfileType")
    public WebElement contactDdnContactSocialProfileType;

    @FindBy(id="txtContactSocialProfileVal")
    public WebElement contactTxtContactSocialProfileVal;

    @FindBy(id="txtContactSocialProfileName")
    public WebElement contactTxtContactSocialProfileName;

    @FindBy(id="ddnContactInstantMessengerType")
    public WebElement contactDdnContactInstantMessengerType;

    @FindBy(id="txtContactInstantMessengerVal")
    public WebElement contactTxtContactInstantMessengerVal;

    @FindBy(id="txtContactInstantMessengerName")
    public WebElement contactTxtContactInstantMessengerName;

    @FindBy(id="btnContactTabSave")
    public WebElement contactClkONContactSubmitTButton;



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
   waitForSearchResults();
   Assert.assertTrue(getContactGeneralInfoLabelHeader.getText().contains("General Information"),"General Information Header is Displayed");
   waitForElementClickable(clkContactProjectInfoTab,20);
   javascriptClick(clkContactProjectInfoTab);
   waitForSearchResults();
   Assert.assertTrue(getContactProjectGridText.getText().contains("Project Name"),"Project Information Tab Project Name is  Displayed");
   waitForElementClickable(clkContactResourcesTab,20);
   javascriptClick(clkContactResourcesTab);
   waitForSearchResults();
   Assert.assertTrue(getContactResourcesDocumentText.getText().contains("Section"),"Resources Tab Section is Displayed in Resource Document List");
   waitForElementClickable(clkContactInteractionNTab,20);
   javascriptClick(clkContactInteractionNTab);
   waitForSearchResults();
   Assert.assertTrue(getcontactInteractionnotesGrid.getText().contains("Date"),"Interaction Notes Tab Date column is Not Displayed in Interaction Notes");
   }

    public void fillAddContactData(HashMap<String, String> contactDetails) throws InterruptedException {
        GenericMethods.waitForElementClickable(addProjectPO.addNewButton, 20);
        GenericMethods.javascriptClick(addProjectPO.addNewButton);
        waitForSearchResults();
        //addProjectPO.fillProjectData(projectDetails);
        System.out.println("--Add New Contact Data ---");
        clickAndEnterText(contactTxtTitle, getContactTitle());
        clickAndEnterText(contactTxtPrefix, contactDetails.get("Prefix"));
        clickAndEnterText(contactTxtFirstName, contactDetails.get("First_Name"));
        clickAndEnterText(contactTxtPhoneticFirstname, contactDetails.get("Phonetics_First_name"));
        clickAndEnterText(contactTxtPronunciationFirstName, contactDetails.get("Pronunciation_First_Name"));
        clickAndEnterText(contactTxtMiddleName, contactDetails.get("Middle_Name"));
        clickAndEnterText(contactTxtLastName, contactDetails.get("Last_Name"));
        clickAndEnterText(contactTxtPhoneticLastName, contactDetails.get("Phonetic_Last_Name"));
        clickAndEnterText(contactTxtPronunciationLastName, contactDetails.get("Pronunciation_Last_Name"));
        clickAndEnterText(contactTxtMaidenName, contactDetails.get("Maiden_Name"));
        clickAndEnterText(contactTxtSuffix, contactDetails.get("Suffix"));
        clickAndEnterText(contactTxtNickName, contactDetails.get("Nick_Name"));
        clickAndEnterText(contactTxtPhoneticCompanyName, contactDetails.get("Phonetic_Company_Name"));
        // clickAndEnterText(contactDropDownProject); dropdown Project
    }
        public void fillDateData(HashMap <String, String> contactDetails){

        }
        public void fillCommunicationInformationData(HashMap<String, String> contactDetails) throws InterruptedException {
          clickAndEnterText(contactTxtPhoneContactPhoneVal,contactDetails.get("Phone_number"));
          clickAndEnterText(contactTxtContactPhoneName,contactDetails.get("Extension"));
        }
        public void fillEmailData(HashMap<String,String> contactDetails) throws InterruptedException {
            //clickAndEnterText(dropDown);
            clickAndEnterText(contactTxtContactAddressName,contactDetails.get("Alis"));
            clickAndEnterText(contactTxtAddressContactAddressVal,contactDetails.get("Street_Address"));
            clickAndEnterText(contactTxtStreet2ContactAddressVal,contactDetails.get("Street_Address2"));
            clickAndEnterText(contactTxtTownContactAddressVal,contactDetails.get("Town_City"));
            //clickAndEnterText(); DropDown
            clickAndEnterText(contactTxtZipcodeContactAddressVal,contactDetails.get("Zip_Code"));
        }
        public void fillUrlData(HashMap<String,String> contactDetails) throws InterruptedException {
            clickAndEnterText(contactTxtContactURLValue,contactDetails.get("Url_Address"));
            clickAndEnterText(contactTxtContactURLNote,contactDetails.get("Notes"));
           //clickAndEnterText(contactTxt);

        }
        public void fillSocialProfile(HashMap<String,String> contactDetails)
        {
            clickAndEnterText();
        }


}

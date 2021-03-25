package com.protrack.web.selenium.pages;

import com.protrack.web.selenium.utility.DateTimeUtil;
import com.protrack.web.selenium.utility.GenericMethods;
import com.protrack.web.selenium.utility.PropertyReader;
import com.thoughtworks.qdox.parser.structs.TagDef;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static com.protrack.web.selenium.tests.StaticContext.getProjectTitle;
import static com.protrack.web.selenium.tests.StaticContext.setProjectTitle;
import static com.protrack.web.selenium.utility.GenericMethods.*;
import static jdk.nashorn.internal.objects.NativeString.trim;

public class AddProjectPO {
    public TagDef primaryContactPersonDDLabelText;
    WebDriver driver;

    public AddProjectPO (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //Company Information Section PO
    @FindBy(xpath = "//*[@id='addLink']")
    public WebElement addNewButton;

   @FindBy(xpath = "//*[@id='ProjectName']")
   public WebElement projectNameTextField;

   @FindBy(id = "ProjectName")
   public WebElement projectNameLabelText;

    @FindBy(xpath = "//form[@id='frmProject']/div/div[2]/div[2]/span/span/span[2]/span")
    public WebElement companyDropdown;

   @FindBy(css = "div.k-animation-container > #CompanyId-list > span.k-list-filter > input.k-textbox")
    public WebElement getCompanyDropdownTextField;

   @FindBy(id = "CompanyName")
   public WebElement newCompanyName;


   @FindBy(xpath = "//div[@id='dv_GeneralInfo_GeneralInfo']/div/div[3]/span/span/span")
   public WebElement newCompanyTypeDropDown;



   @FindBy(css = "span.k-input")
   public WebElement newCompanyDropdownTextField;

   //@FindBy(css = "span.k-dropdown-wrap.k-state-default.k-state-hover.k-state-focused > span.k-input")
    @FindBy(xpath = "//div[@id='dv_GeneralInfo_GeneralInfo']/div/div[4]/span/span/span")
   public WebElement newCompanyProjNameDropDown;

   @FindBy(css = "#ddnProjectId-list > span.k-list-filter > input.k-textbox")
   public WebElement newCompanyProjNameTextField;

    @FindBy(css = "div.k-animation-container > #CategoryId-list > span.k-list-filter > input.k-textbox")
    public WebElement projectCategoryInputField;

  //  @FindBy(css = "span.k-dropdown-wrap.k-state-default.k-state-focused.k-state-hover > span.k-input")
    @FindBy(css = "span.k-input")
    public WebElement projectCategoryDropdownOptions;

     @FindBy(css = "#CompanyId-list > span.k-list-filter > input.k-textbox")
     public WebElement companyAddCategory;

   @FindBy(css = "span.k-widget.k-dropdown.k-header")
   // @FindBy(xpath = "//div[@id='dv_GeneralInfo_CompanyInfo']/div/div[2]")
    public WebElement projectCategoryLabelText;

    @FindBy(id ="ddnProjectManager")
    public WebElement projectManagerDropdown;

    @FindBy(name = "ProjectManager")
    public WebElement projectManagerDropdownLabelText;


    @FindBy(id = "ddlCommonCompanyId")
    public WebElement companyInfoHeader;

    @FindBy(xpath = "//div[@id='dv_GeneralInfo_CompanyInfo']/h5")
    public WebElement companyInfoLabelHeader;

    @FindBy(xpath = "//h4[text()='Add Project Info']")
    public WebElement addProjectInfoHeader;

    @FindBy(xpath = "//form[@id='frmProject']/div/div[4]/div[2]/span/span/span[2]/span")
    public WebElement getPrimaryContactPersonDropDown;

    @FindBy(css = "div.k-animation-container > #PrimaryContactId-list > span.k-list-filter > input.k-textbox")
    public WebElement getPrimaryContactPersonTextField;


    @FindBy(id = "ddlPrimaryContactId")
    public WebElement gridprimaryContactPersonDDLabelText;


    @FindBy(id = "ddlSecondaryContactId")
    public WebElement secondaryContactPersonDDLabelText;

    @FindBy(xpath = "//form[@id='frmProject']/div/div[4]/div[3]/span/span/span[2]/span")
    public WebElement getSecondaryContactPersonDropDown;


 //   @FindBy(xpath = "(//div[@id='SecondaryContactId-list']/span/input)[2]")
    @FindBy(xpath = "//div[@id='SecondaryContactId-list']/span/input")
   // @FindBy(css = "#SecondaryContactId-list > span.k-list-filter > input.k-textbox")
    public WebElement getSecondaryContactPersonTextField;




  //  @FindBy(css = "span.k-dropdown-wrap.k-state-default")
    @FindBy(xpath = "//div[@id='dv_GeneralInfo_CompanyInfo']/div[4]/div[2]")
    public WebElement SecondaryContactPersonLabelDisplayed;

    @FindBy(id = "other-attendies")
    public WebElement otherContactsDDLabelText;

     @FindBy(xpath = "//div[@id='other-attendies']/div/div")
    public WebElement getOtherContactsDropDown;

   @FindBy(xpath = "//div[@id='other-attendies']/div/div/input")
    public WebElement getOtherContactsTextField;

   @FindBy(xpath = "//form[@id='frmProject']/div/div[5]/div[2]/span/span/span")
    public WebElement getIndustryClusterDropDown;

   @FindBy(css = "div.k-animation-container > #ddnIndustryClusterId-list > span.k-list-filter > input.k-textbox")
   public WebElement getGetIndustryClusterTextField;

    @FindBy(id = "ddlServiceTypeId")
    public WebElement industryClusterDDLabelText;

    @FindBy(xpath = "//form[@id='frmProject']/div/div[5]/div[3]/div[2]/div/input")
    public WebElement getNAICSCodeDropDown;

    @FindBy(xpath = "//form[@id='frmProject']/div/div[5]/div[3]/div[2]/div/input")
    public WebElement getNAICSCodeTextField;


    @FindBy(id = "dv_GeneralInfo_CompanyInfo")
    public WebElement getNAICSCodeLabelField;

    @FindBy(id = "ProjectProjectDate")
    public WebElement getDateField;

    @FindBy(xpath = "//div[@id='pnl-addProjectProjectDate']/div/div[2]")
    public WebElement getDateLabelField;

    @FindBy(xpath = "//form[@id='frmProject']/div/div[12]/div[2]/textarea")
    public WebElement getNotesTextField;

    @FindBy(xpath = "//div[@id='dv_GeneralInfo_CompanyInfo']/div[8]/div")
    public WebElement getNotesLabelField;

    @FindBy(id="projectTags-tokenfield")
    public WebElement getTagsTextField;


    @FindBy(css = "div.tokenfield.form-control.disabled")
    public WebElement getTagsTextLabelField;

    @FindBy(xpath = "//a[@id='addProjectProjectDate']/i")
    public WebElement datePlusIcon;

    @FindBy(id = "ExtraNumField1")
    public WebElement getExtraNumField1;

    @FindBy(id = "ExtraNumField2")
    public WebElement getExtraNumField2;

   @FindBy(id = "ExtraNumField3")
    public WebElement getExtraNumField3;

   @FindBy(id = "ExtraNumField4")
    public WebElement getExtraNumField4;

  @FindBy(id = "txtPhoneProjectPhoneVal")
    public WebElement PhoneNumberTextField;

    @FindBy(id = "txtProjectPhoneName")
    public WebElement PhoneExtensionTextField;

    @FindBy(id = "txtEmailProjectEmailVal")
    public WebElement EmailIDField;

    @FindBy(id = "txtProjectEmailName")
    public WebElement EmailNotesField;

@FindBy(xpath = "//div[@id='pnlCommu-addProjectEmail']/div/div[3]/div/div/div/div")
public WebElement emailNotesLabelText;

    @FindBy(xpath = "//div[@id='pnlCommu-addProjectEmail']/div/div[2]")
    public WebElement EmailLabelValue;

   // @FindBy(xpath = "//div[@id='pnlCommu-addProjectEmail']/div[2]/div")
    @FindBy(xpath = "//div[@id='pnlCommu-addProjectEmail']/div[2]/div/label")
    public WebElement emailDropdownLabelValue;

     // @FindBy(xpath = "//div[@id='pnlCommu-addProjectEmail']/div[2]")
    @FindBy(xpath = "//div[@id='pnlCommu-addProjectEmail']/div[2]/div[2]")
    public WebElement editEmailIDLabelValue;

    @FindBy(xpath = "//div[@id='pnlCommu-addProjectEmail']/div/div")
    public WebElement emailAddedMainDropdownLabelValue;

    @FindBy(css = "div.jq-toast-single.jq-has-icon.jq-icon-error")
    public WebElement emailInvalidErrAlert;


    @FindBy(id = "ExtraVarcharField1")
    public WebElement getExtraStringField1;

   @FindBy(id = "ExtraVarcharField2")
    public WebElement getExtraStringField2;

   @FindBy(id = "ProjectDummyDate1")
    public WebElement getDummyDateField1;

   @FindBy(id = "ProjectDummyDate2")
    public WebElement getDummyDateField2;

    @FindBy(id = "txtEmailProjectEmailVal")
    public WebElement emailIDField;

    @FindBy(id="btnProjectTabSave")
    public WebElement submitBtn;

    @FindBy(id="btnCompanyTabInProjectSave")
    public WebElement newCompanyFormSubmitBtn;

    @FindBy(id="btnCompanyTabInProjectCancel")
    public WebElement newCompanyFormCancelBtn;

    @FindBy(id = "btnProjectTabCancel")
    public WebElement cancelBtn;

     @FindBy(id = "ProjectName")
     public WebElement getCreatedProjectNameTitle;

     @FindBy(css = "i.fa.fa-pencil")
     public WebElement editProject;

     @FindBy(css = "a.addNew.pull-right.addNewCompany > i.fa.fa-plus-circle")
     public WebElement CompanyPlusIcon;

    //Communication Information Section
  //  @FindBy(id="ddnProjectPhoneType")
    @FindBy(css = "#ddnProjectPhoneType")
    public WebElement getProjectPhoneDropDown;

    @FindBy(id="ddnProjectEmailType")
    public WebElement getProjectEmailDropDown;

    @FindBy(css = "#addProjectPhone > i.fa.fa-plus-circle")
    public WebElement clickPhonePlusIcon;

    @FindBy(css = "#addProjectEmail > i.fa.fa-plus-circle")
    public WebElement clickEmailPlusIcon;

    @FindBy(xpath = "//div[@id='pnlCommu-addProjectPhone']/div/div")
    public WebElement addedPhoneLabelValue;

    @FindBy(xpath = "//div[@id='pnlCommu-addProjectPhone']/div/div[2]")
    public WebElement addedLabelPhoneNumber;

    @FindBy(xpath = "//div[@id='pnlCommu-addProjectPhone']/div/div[3]/div/div/div/div")
    public WebElement addedPhoneExtensionLabel;

    @FindBy(css = "img.imgedit")
    public WebElement editIconPhoneGrid;

   @FindBy(xpath = "//div[@id='mainPnlProjectEmail']/div/div/div/a/i" )
   public WebElement saveIconEmailGrid;

    @FindBy(css = "a.updateCommunicationDataItem.refresh > i.fa.fa-floppy-o")
    public WebElement saveIconPhoneGrid;



   @FindBy(xpath = "//div[@id='pnlCommu-addProjectPhone']/div[2]/div")
   // @FindBy(xpath = "//div[@id='pnlCommu-addProjectPhone']/div/div")
    public WebElement labelPhoneGrid;


    @FindBy(css = "img.removeCommunicationDataItem.icon_margin_left")
    public WebElement deletePhoneGrid;

//    @FindBy(css = "img.removeCommunicationDataItem.icon_margin_left")
//    public WebElement deleteEmailGrid;

    @FindBy(css = "#mainPnlProjectPhone > div.horizontalRuleDiv")
    public WebElement emptyPostDeletePhoneGrid;

    @FindBy(xpath = "//div[@id='pnlCommu-addProjectEmail']/div/div")
    public WebElement postDeleteEmailGrid;

    @FindBy(id = "mainPnlProjectAddress")
    public WebElement postDeleteAddressGrid;

    @FindBy(id="ddnProjectAddressType")
    public WebElement getProjectAddressDropDown;

    @FindBy(xpath = "//div[@id='pnlCommu-addProjectAddress']/div/div")
    public WebElement addprojectAddressDropdownLabelText;

    @FindBy(id = "txtProjectAddressName")
    public WebElement addressAliasTextField;

    @FindBy(id = "txtAddressProjectAddressVal")
    public WebElement addressStreetAddress1;

    @FindBy(id = "txtStreet2ProjectAddressVal")
    public WebElement addressStreetAddress2;

    @FindBy(id = "txtTownProjectAddressVal")
    public WebElement addressTownTextField;

    @FindBy(id = "ddnAddressCountryList")
    public WebElement addressCountryDropDown;

    @FindBy(id = "ddnAddressStateList")
    public WebElement addressStateDropDown;

    @FindBy(id = "txtZipcodeProjectAddressVal")
    public WebElement addressZipCodeTextField;

    @FindBy(xpath = "//a[@id='addProjectAddress']/i")
    public WebElement addprojectAddressPlusIcon;

    @FindBy(xpath = "//img[@title='Edit']")
    public WebElement editIconAddressGrid;

    @FindBy(xpath = "(//img[@title='Edit'])[2]")
    public WebElement editIconURLGrid;

    @FindBy(xpath = "//img[@title='Edit']")
    public WebElement editIconSocialProfileGrid;


    @FindBy(xpath = "//div[@id='mainPnlContactSocialProfile']/div/div/div/a/i")
    public WebElement saveIconSocialProfileGrid;


    @FindBy(css = "#addProjectAddress > i.fa.fa-plus-circle")
    public WebElement addressGridPlusIcon;

    @FindBy(xpath = "//div[@id='mainPnlProjectAddress']/div/div/div/a/i")
    public WebElement saveIconAddressGrid;

    @FindBy(xpath = "//div[@id='mainPnlProjectURL']/div/div/div/a/i")
    public WebElement saveIconURLGrid;

    @FindBy(css = "img.removeCommunicationDataItem.icon_margin_left")
    public WebElement deleteIconAddressGrid;

 //  @FindBy(xpath = "//div[@id='pnl-addProjectURL']/div[2]/div[3]/div/div/div/div[2]/div/img")
   @FindBy(xpath = "//div[@id='pnl-addProjectURL']/div/div[3]/div/div/div/div[2]/div/img")
   public WebElement deleteIconURLGrid;

    @FindBy(css = "img.removeProjectItem.removeDataItem")
    public WebElement deleteIconURL2Grid;

    @FindBy(id="ddnProjectURLType")
    public WebElement getProjectURLDropDown;

    @FindBy(id="txtProjectURLValue")
    public WebElement addProjectURLTextField;

    @FindBy(id = "txtProjectURLNote")
    public WebElement addProjectURLNotes;

    @FindBy(xpath = "//a[@id='addProjectURL']/i")
    public WebElement addProjectURLPlusIcon;

    @FindBy(xpath = "//div[@id='pnl-addProjectURL']/div/div")
    public WebElement addProjectURLLabelText;

    @FindBy(xpath = "//div[@id='pnl-addProjectURL']/div[2]/div")
    public WebElement addProjectURLEditedLabelText;

    @FindBy(xpath = "//div[@id='pnl-addProjectSocialProfile']/div/div")
    public WebElement addProjectSocialProfileEditedLabelText;


    @FindBy(id="pnl-addProjectSocialProfile")
    public WebElement addProjectSocialProfileLabelText;

    @FindBy(id="ddnProjectSocialProfileType")
    public WebElement getProjectSocialProfileDropDown;

    @FindBy(id="txtProjectSocialProfileVal")
    public WebElement addProjectSocialProfileTextField;

    @FindBy(xpath = "//a[@id='addProjectSocialProfile']/i")
    public WebElement addProjectSocialProfilePlusIcon;

    @FindBy(id="ddnProjectInstantMessengerType")
    public WebElement getProjectInstantMessengerDropDown;

    @FindBy(id="txtProjectInstantMessengerVal")
    public WebElement addProjectInstantMessengerTextField;

    @FindBy(xpath = "//a[@id='addProjectInstantMessenger']/i")
    public WebElement addProjectInstantMessengerPlusIcon;

    @FindBy(xpath = "//div[@id='pnl-addProjectInstantMessenger']/div/div")
    public WebElement addProjectInstantMsgLabelText;


    @FindBy(id = "ExtraVarcharField3")
    public WebElement getExtraStringField3;

    @FindBy(id = "ExtraVarcharField4")
    public WebElement getExtraStringField4;

    @FindBy(id = "ProjectDummyDate3")
    public WebElement getDummyDateField3;

    @FindBy(id = "ProjectDummyDate4")
    public WebElement getDummyDateField4;

    //Other Information PO
    @FindBy(id = "btnRfiYes")
    public WebElement getRadioBtnRespondtoRFI;

    @FindBy(id = "RFIDate")
    public WebElement getOtherInfoRFIDateField;

    @FindBy(id = "ExpectedClosingDate")
    public WebElement getExpectedClosingDateLabelText;

     @FindBy(css = "div.k-animation-container > #ddnProjectSourceId-list > span.k-list-filter > input.k-textbox")
     public WebElement getOtherInfoProjectSourceDropDownTextField;

     @FindBy(xpath = "//form[@id='frmProject']/div[3]/div[3]/div[2]/span/span/span")
    public WebElement getOtherInfoProjectSourceDropDown;

     @FindBy(xpath = "//div[@id='dv_GeneralInfo_OtherInfo']/div[3]/div[2]/span")
     public WebElement addProjectSourceLabelText;

    @FindBy(id = "ExpectedClosingDate")
    public WebElement getOtherInfoExpectedClosingDate;

    @FindBy(id = "ddnAssignTo")
    public WebElement getOtherInfoAssignToDropDown;

    @FindBy(id = "ExtraVarcharField5")
    public WebElement getExtraStringField5;

    @FindBy(id = "ExtraVarcharField6")
    public WebElement getExtraStringField6;

    @FindBy(id = "ProjectDummyDate5")
    public WebElement getOtherInfoDummyDate5;

    @FindBy(xpath = "//div[@id='dv_GeneralInfo_OtherInfo']/div[7]/div[3]")
    public WebElement dummyDateField5labelText;

    @FindBy(id = "ProjectDummyDate6")
    public WebElement getOtherInfoDummyDate6;

     @FindBy(id = "textCreatedBy")
    public WebElement getOtherInfoTextCreatedBy;

    //Projects Left Pane Grid PO

    @FindBy(css = "div.prjct-nme-wrap")
    public WebElement getprojectLeftPaneGrid;

    @FindBy(css = "th.selected.center.sorting_asc")
    public WebElement getSortedProjectList;

    //Projects Tab LHS Search bar and PO

    @FindBy(id = "txtSearch")
    public WebElement projectSearchBar;

    @FindBy(css = "div.prjct-nme-inr.ellipseTextB")
       public List<WebElement> firstProjectNameLHSGrid;

    @FindBy(css = "div.prjct-nme-inr.ellipseTextB")
    public WebElement firstProjectInLHSGrid;

    @FindBy(xpath = "//table[@id='tblProject']/tbody/tr[*]/td/div[2]/div")
    public List<WebElement> CreatedProjectTitles;

    @FindBy(xpath = "//table[@id='tblContactProjectGrid']/tbody/tr[3]/td/span")
    public List<WebElement> ContactProjectInfoList;

    @FindBy(css = "span.ellipseTextA")
    public WebElement contactProjectSelected;

    @FindBy(css="i.fa.fa-sort-desc")
    public WebElement getProjectSortingDropDownClick;

    @FindBy(xpath = "//div[@id='dvMainProject']/div/ul/li")
    public List<WebElement> ProjectDropDownItemToSort;
    //Edit Project PO
    @FindBy(id = "btnProjectTabCancel")
    public WebElement CancelButton;

    @FindBy(xpath = "//button[text()='Dont save and continue']")
    public WebElement DontSaveAndContinueButton;

    //Dashboard and Add Project
    @FindBy(css = "#menu > li > #Dashboard")
    public WebElement dashboardTab;

    @FindBy(id = "lnkAddProject")
    public WebElement homeAddProjectLink;

    // Contacts PO
    @FindBy(css = "#tblContact > thead > tr > th")
    public WebElement contactsTab;

    @FindBy(linkText = "Project Information")
    public WebElement projectInfoTab;

//Project Benefits PO
  //  @FindBy(linkText = "Project Benefits")
    @FindBy(xpath = "//a[contains(text(),'Project Benefits')]")
    public WebElement projectBenefitsTab;

    @FindBy(css = "#txtYear > select")
    public WebElement projectBenefitsInvestmentYr;

    @FindBy(id = "addNewInvestment")
    public WebElement addNewInvestmentBtn;

    @FindBy(id = "txtRealState")
    public WebElement InvestmentRealEstateTextField;

    @FindBy(id = "txtInventory")
    public WebElement InvestmentInventoryTextField;

    @FindBy(id = "txtMachineryEquipment")
    public WebElement InvestmentMachineEquipmentTextField;

    @FindBy(id = "txtFurnitureFixtures")
    public WebElement InvestmentFurnitureFixturesTextField;

    @FindBy(css = "#investmentRows > tr")
    public List<WebElement> investmentRowsGrid;

    @FindBy(css = "img.imgedit")
    public WebElement investmentGridEditIcon;

    @FindBy(id = "updateInvestment")
    public WebElement investmentUpdateBtn;

    //Employment Info PO
    @FindBy(css = "#ProjectJobtypeTable > thead > tr > th")
    public WebElement employmentInfoGrid;

    @FindBy(id = "txtFullNumber")
    public WebElement empInfoFullTimeNumber;

    @FindBy(css = "input.gridCurrencyForm")
    public WebElement empInfoClickToInputTextField;

    @FindBy(id = "ProjectJobtypeTable")
    public WebElement empInfoToEditInField;

    @FindBy(id = "updateJobType")
    public WebElement empInfoUpdateBtn;

    @FindBy(id = "txtMgmtNumber")
    public WebElement empInfoMgmtNumber;
    @FindBy(id = "txtPartTimeNumber")
    public WebElement empInfoPartTimeNumber;
    @FindBy(id = "txtContractNumber")
    public WebElement empInfoContractNumber;
    @FindBy(id = "txtOthersNumber")
    public WebElement empInfoOthersNumber;

    @FindBy(id = "txtOthersAvgSalary")
    public WebElement empInfoAvgAnnualWage;

    @FindBy(css = "input.gridBigAmount")
    public WebElement empInfoAvgAnnualWageTextField;

    @FindBy(css = "img.imgedit")
    public WebElement empInfoGridEditIcon;

   //@FindBy(css = "label.year.gridCurrencyForm.R-lblclass")
   @FindBy(xpath = "//tbody[@id='jobTypeRows']/tr")
    public WebElement empInfoGridData;

    @FindBy(id = "JobTypeTotal")
    public WebElement jobTypeTotalTextField;

    @FindBy(id = "addNewJobType")
    public WebElement empInfoAddNewBtn;



    public void fillProjectData(HashMap<String, String> projectdetails) throws InterruptedException {
      GenericMethods.waitForElementClickable(projectNameTextField,30);
       setProjectTitle("ProTest_"+ DateTimeUtil.getcurrentDateTime());
     clickAndEnterText(projectNameTextField,getProjectTitle());
     clickAndEnter(projectCategoryDropdownOptions, projectCategoryInputField,projectdetails.get("Category"));
       elementClick(projectManagerDropdown);
       selectByText(projectManagerDropdown,projectdetails.get("Project_Manager"));
       clickAndEnter(companyDropdown,getCompanyDropdownTextField,projectdetails.get("Company"));

       clickAndTab(getPrimaryContactPersonDropDown,getPrimaryContactPersonTextField,projectdetails.get("Primary_Contact_Person"));
        waitForSearchResults();
        waitForElementClickable(getSecondaryContactPersonDropDown,20);
        clickAndSelect(getSecondaryContactPersonDropDown,getSecondaryContactPersonTextField,projectdetails.get("Secondary_Contact_Person"));
       waitForSearchResults();
      clickAndEnterDrpDown(getOtherContactsDropDown,getOtherContactsTextField,projectdetails.get("Other_Contacts"));
        clickAndEnter(getIndustryClusterDropDown,getGetIndustryClusterTextField,projectdetails.get("Industry_Cluster"));
        clickAndTab(getNAICSCodeDropDown,getNAICSCodeTextField,projectdetails.get("NAICS_Code"));



         scrollPageToDown();
        waitForElementClickable(getDateField,30);
     clickAndEnterText(getTagsTextField,projectdetails.get("Tags_Text"));
    clickAndEnterText(getDateField,projectdetails.get("Date_Field"));
     clickAndEnterText(getNotesTextField,"Testing Notes");
     elementClick(datePlusIcon);
    waitForSearchResults();
        clickAndEnterText(getExtraNumField1,projectdetails.get("Extra_Num_Field1"));
        waitForElementClickable(getExtraNumField2,10);
        clickAndEnterText(getExtraNumField2,projectdetails.get("Extra_Num_Field2"));
       clickAndEnterText(getExtraNumField3,projectdetails.get("Extra_Num_Field3"));
        clickAndEnterText(getExtraNumField4,projectdetails.get("Extra_Num_Field4"));
        clickAndEnterText(getExtraStringField1,projectdetails.get("Extra_String_Field1"));
        clickAndEnterText(getExtraStringField2,projectdetails.get("Extra_String_Field2"));
        clickAndEnterText(getDummyDateField1,projectdetails.get("DummyDateField1"));
       clickAndEnterText(getDummyDateField2,projectdetails.get("DummyDateField2"));
//
//////Filling Communication Information Section
       scrollPageToDown();
         GenericMethods.waitForElementClickable(getProjectPhoneDropDown,10);
        GenericMethods.selectByText(getProjectPhoneDropDown,projectdetails.get("PhoneDropDown"));
        clickAndEnterText(PhoneNumberTextField,projectdetails.get("PhoneNumberTextField"));
        clickAndEnterText(PhoneExtensionTextField,projectdetails.get("PhoneExtensionTextField"));
        elementClick(clickPhonePlusIcon);
         selectByText(getProjectEmailDropDown,projectdetails.get("EmailDropDown"));
        clickAndEnterText(EmailIDField,projectdetails.get("EmailIDField"));
        clickAndEnterText(EmailNotesField,projectdetails.get("EmailNotesField"));
        elementClick(clickEmailPlusIcon);
          selectByText(getProjectAddressDropDown,projectdetails.get("AddressDropDown"));
          elementClick(addprojectAddressPlusIcon);
          waitForSearchResults();
           selectByText(getProjectURLDropDown,projectdetails.get("URLDropDown"));
        GenericMethods.clickAndEnterText(addProjectURLTextField,projectdetails.get("URLTextField"));
        elementClick(addProjectURLPlusIcon);
        waitForSearchResults();

        selectByText(getProjectSocialProfileDropDown,projectdetails.get("SocialProfileDropDown"));
        GenericMethods.clickAndEnterText(addProjectSocialProfileTextField,projectdetails.get("SocialProfileTextField"));
        elementClick(addProjectSocialProfilePlusIcon);
        waitForSearchResults();

       selectByText(getProjectInstantMessengerDropDown,projectdetails.get("InstantMessengerDropDown"));
        GenericMethods.clickAndEnterText(addProjectInstantMessengerTextField,projectdetails.get("InstantMessengerTextField"));
        elementClick(addProjectInstantMessengerPlusIcon);
        waitForSearchResults();

        GenericMethods.clickAndEnterText(getExtraStringField3,projectdetails.get("Extra_String_Field3"));
       GenericMethods.clickAndEnterText(getExtraStringField4,projectdetails.get("Extra_String_Field4"));
         clickAndEnterText(getDummyDateField3,projectdetails.get("DummyDateField3"));
           clickAndEnterText(getDummyDateField4,projectdetails.get("DummyDateField4"));

////        //Other Information Section
     scrollPageToElement(getRadioBtnRespondtoRFI);
        clickAndEnterText(getRadioBtnRespondtoRFI,projectdetails.get("Response_to_RFI"));
        clickAndEnterText(getOtherInfoRFIDateField,projectdetails.get("RFIDateField"));

     waitForElementClickable(getOtherInfoProjectSourceDropDown,20);
     clickAndEnter(getOtherInfoProjectSourceDropDown,getOtherInfoProjectSourceDropDownTextField,projectdetails.get("Project_Source"));
        clickAndEnterText(getOtherInfoExpectedClosingDate,projectdetails.get("ClosingDate"));
        waitForElementClickable(getOtherInfoAssignToDropDown,20);
        selectByText(getOtherInfoAssignToDropDown,projectdetails.get("Assign_To"));
        validateReadOnlyText(getOtherInfoTextCreatedBy, PropertyReader.getProperty("username"));
       clickAndEnterText(getExtraStringField5,projectdetails.get("Extra_String_Field5"));
        clickAndEnterText(getExtraStringField6,projectdetails.get("Extra_String_Field6"));
        clickAndEnterText(getOtherInfoDummyDate5,projectdetails.get("DummyDate5"));
          clickAndEnterText(getOtherInfoDummyDate6,projectdetails.get("DummyDate6"));
     System.out.println("Add Project form is filled up successfully");
        scrollPageToUp();
    }

    public void fillNewCompanyProjectData(HashMap<String, String> projectdetails) throws InterruptedException {
        GenericMethods.waitForElementClickable(newCompanyName,30);
        clickAndEnterText(newCompanyName,projectdetails.get("newCompanyName"));
        Thread.sleep(2000);
        clickAndEnter(newCompanyTypeDropDown, newCompanyDropdownTextField,projectdetails.get("newCompanyType"));
       clickAndEnter(newCompanyProjNameDropDown, newCompanyProjNameTextField,projectdetails.get("newCompanyProjName"));
//        elementClick(projectManagerDropdown);
//        selectByText(projectManagerDropdown,projectdetails.get("Project_Manager"));
        }

    public void fillInvestmentData(HashMap<String, String> projectDetails) throws InterruptedException {
        selectByText(projectBenefitsInvestmentYr,projectDetails.get("Year"));
        clickAndEnterText(InvestmentRealEstateTextField,projectDetails.get("Real_Estate"));
         waitForElementClickable(InvestmentInventoryTextField,10);
        clickAndEnterText(InvestmentInventoryTextField,projectDetails.get("Inventory"));
        waitForElementClickable(InvestmentMachineEquipmentTextField,10);
        clickAndEnterText(InvestmentMachineEquipmentTextField,projectDetails.get("Machine_and_Equipment"));
        waitForElementClickable(InvestmentFurnitureFixturesTextField,10);
        clickAndEnterText(InvestmentFurnitureFixturesTextField,projectDetails.get("Furniture_and_Fixture"));
    }

    public void fillEmpInformationData(HashMap<String, String> projectDetails) throws InterruptedException {
     //   selectByText(projectBenefitsInvestmentYr,projectDetails.get("Year"));

        waitForElementClickable(empInfoFullTimeNumber,10);
       clickAndEnter(empInfoFullTimeNumber,empInfoClickToInputTextField,projectDetails.get("Full_Time"));
        waitForElementClickable(empInfoMgmtNumber,10);
     clickAndEnter(empInfoMgmtNumber,empInfoClickToInputTextField,projectDetails.get("Management"));
        waitForElementClickable(empInfoPartTimeNumber,10);
       clickAndEnter(empInfoPartTimeNumber,empInfoClickToInputTextField,projectDetails.get("Part_Time"));
     waitForElementClickable(empInfoContractNumber,10);
       clickAndEnter(empInfoContractNumber,empInfoClickToInputTextField,projectDetails.get("Contract"));
      waitForElementClickable(empInfoOthersNumber,10);
    clickAndEnter(empInfoOthersNumber,empInfoClickToInputTextField,projectDetails.get("Others"));
        waitForElementClickable(empInfoAvgAnnualWage,20);
        clickAndEnter(empInfoAvgAnnualWage,empInfoAvgAnnualWageTextField,projectDetails.get("Average_Annual_Wage"));
            }


    public void fillPhoneInformationData(HashMap<String, String> projectDetails) throws InterruptedException {
        GenericMethods.waitForElementClickable(getProjectPhoneDropDown, 10);
        GenericMethods.selectByText(getProjectPhoneDropDown, projectDetails.get("PhoneDropDown"));
        clickAndEnterText(PhoneNumberTextField, projectDetails.get("PhoneNumberTextField"));
        clickAndEnterText(PhoneExtensionTextField, projectDetails.get("PhoneExtensionTextField"));
        //elementClick(clickPhonePlusIcon);
        javascriptClick(clickPhonePlusIcon);
        GenericMethods.waitForElementClickable(getProjectPhoneDropDown, 10);
        GenericMethods.selectByText(getProjectPhoneDropDown, projectDetails.get("PhoneDropDown1"));
        clickAndEnterText(PhoneNumberTextField, projectDetails.get("PhoneNumberTextField1"));
        clickAndEnterText(PhoneExtensionTextField, projectDetails.get("PhoneExtensionTextField1"));
        javascriptClick(clickPhonePlusIcon);
        //elementClick(clickPhonePlusIcon);
    }


    public void fillEmailInformationData(HashMap<String, String> projectDetails) throws InterruptedException {
        GenericMethods.waitForElementClickable(getProjectEmailDropDown, 10);
        selectByText(getProjectEmailDropDown,projectDetails.get("EmailDropDown"));
        clickAndEnterText(EmailIDField,projectDetails.get("EmailIDField"));
        clickAndEnterText(EmailNotesField,projectDetails.get("EmailNotesField"));
        elementClick(clickEmailPlusIcon);
        GenericMethods.waitForElementClickable(getProjectEmailDropDown, 10);
        selectByText(getProjectEmailDropDown,projectDetails.get("EmailDropDown1"));
        clickAndEnterText(EmailIDField,projectDetails.get("EmailIDField1"));
        clickAndEnterText(EmailNotesField,projectDetails.get("EmailNotesField1"));
        elementClick(clickEmailPlusIcon);
    }

    public void fillAddressData(HashMap<String, String> projectDetails) throws InterruptedException {
        selectByText(getProjectAddressDropDown,projectDetails.get("AddressDropDown"));
        clickAndEnterText(addressAliasTextField,projectDetails.get("Alias"));
        clickAndEnterText(addressStreetAddress1,projectDetails.get("StreetAddress1"));
        clickAndEnterText(addressStreetAddress2,projectDetails.get("StreetAddress2"));
        clickAndEnterText(addressTownTextField,projectDetails.get("Town_City"));
        selectByText(addressCountryDropDown,projectDetails.get("Country"));
        waitForSearchResults();
        selectByText(addressStateDropDown,projectDetails.get("State"));
        waitForSearchResults();
        clickAndEnterText(addressZipCodeTextField,projectDetails.get("ZipCode"));
        elementClick(addprojectAddressPlusIcon);
        waitForSearchResults();
    }

    public void editEmailData(HashMap<String, String> projectDetails)throws InterruptedException {
        selectByText(getProjectEmailDropDown,projectDetails.get("Edited_EmailDropDown"));
        GenericMethods.waitForElementClickable(EmailIDField, 10);
        clearTextField(EmailIDField);
        clickAndEnterText(EmailIDField,projectDetails.get("Edit_EmailID"));

        waitForElementClickable(saveIconEmailGrid,10);
        elementClick(saveIconEmailGrid);

    }

    public void emailIDValidation(HashMap<String, String> projectDetails)throws InterruptedException {
        selectByText(getProjectEmailDropDown,projectDetails.get("EmailDropDown1"));
        clickAndEnterText(EmailIDField,projectDetails.get("Email_withoutDomain"));
        clickAndEnterText(EmailNotesField,projectDetails.get("EmailNotesField1"));
        elementClick(clickEmailPlusIcon);
        waitForSearchResults();

        selectByText(getProjectEmailDropDown,projectDetails.get("EmailDropDown1"));
        clearTextField(EmailIDField);
        clearTextField(EmailNotesField);
        waitForSearchResults();
        clickAndEnterText(EmailIDField,projectDetails.get("Email_blank"));
       waitForSearchResults();
        clickAndEnterText(EmailNotesField,projectDetails.get("EmailNotesField1"));
        elementClick(clickEmailPlusIcon);
        waitForSearchResults();
        selectByText(getProjectEmailDropDown,projectDetails.get("EmailDropDown1"));
        clearTextField(EmailIDField);
        clearTextField(EmailNotesField);
        clickAndEnterText(EmailIDField,projectDetails.get("Email_Invalid"));
        clickAndEnterText(EmailNotesField,projectDetails.get("EmailNotesField1"));
        elementClick(clickEmailPlusIcon);
        waitForSearchResults();

        selectByText(getProjectEmailDropDown,projectDetails.get("EmailDropDown1"));
        clearTextField(EmailIDField);
        clearTextField(EmailNotesField);
        clickAndEnterText(EmailIDField,projectDetails.get("EmailIDField"));
        clickAndEnterText(EmailNotesField,projectDetails.get("EmailNotesField1"));
        elementClick(clickEmailPlusIcon);
        waitForSearchResults();
    }


    public void addURLData(HashMap<String, String> projectDetails)throws InterruptedException {
        selectByText(getProjectURLDropDown,projectDetails.get("URLDropDownHome"));
        GenericMethods.clickAndEnterText(addProjectURLTextField,projectDetails.get("URLTextField"));
        clickAndEnterText(addProjectURLNotes,projectDetails.get("URLNotes"));
        elementClick(addProjectURLPlusIcon);
        waitForSearchResults();

    }

    public void addSocialProfileData(HashMap<String, String> projectDetails)throws InterruptedException
    {
        selectByText(getProjectSocialProfileDropDown,projectDetails.get("SocialProfileDropDown"));
        GenericMethods.clickAndEnterText(addProjectSocialProfileTextField,projectDetails.get("SocialProfileTextField"));
        elementClick(addProjectSocialProfilePlusIcon);
        waitForSearchResults();
    }



public String getRandomCreatedProjectTitle()
{
    // create instance of Random class
    Random rand = new Random();
    // randomly select project from grid
     return   CreatedProjectTitles.get(rand.nextInt(CreatedProjectTitles.size())).getText();
}


public String getFirstProjectInGrid(){
         System.out.println("First Project displayed in Project Grid is : " +firstProjectNameLHSGrid.get(0).getText());
         return (trim(firstProjectNameLHSGrid.get(0).getText()));
}

public void getProjectItemToSort() throws InterruptedException {
         System.out.println("Total:" +ProjectDropDownItemToSort.size());
    for(int i=0;i<ProjectDropDownItemToSort.size();i++)
    {
        getProjectSortingDropDownClick.click();
        ProjectDropDownItemToSort.get(i).click();
        Thread.sleep(2000);
        System.out.println("List is sorted for each chosen field."+ProjectDropDownItemToSort.get(i).getText());
            }
}

public void editProjectData(HashMap<String, String> projectdetails) throws InterruptedException
{
    elementClick(projectManagerDropdown);
    selectByText(projectManagerDropdown,projectdetails.get("Edit_Project_Manager"));
    System.out.println("Project is edited successfully");
}

    }

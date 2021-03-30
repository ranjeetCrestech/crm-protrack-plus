package com.protrack.web.selenium.tests;

import com.protrack.web.selenium.pages.AddProjectPO;
import com.protrack.web.selenium.pages.EditPagePO;
import com.protrack.web.selenium.pages.HomePagePO;
import com.protrack.web.selenium.utility.DateTimeUtil;
import com.protrack.web.selenium.utility.GenericMethods;
import com.protrack.web.selenium.utility.PropertyReader;
import com.protrack.web.selenium.utility.Waits;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.protrack.web.selenium.tests.StaticContext.getProjectTitle;
import static com.protrack.web.selenium.tests.StaticContext.setProjectTitle;
import static com.protrack.web.selenium.utility.GenericMethods.*;
import static com.protrack.web.selenium.utility.GenericMethods.waitForElementClickable;
import static com.protrack.web.selenium.utility.ReadDataFromExcelFile.readExcel;
import static com.protrack.web.selenium.utility.Waits.waitForElement;
import static jdk.nashorn.internal.objects.NativeString.trim;

public class AddProjectInfoTest extends BaseClass{


    HomePagePO homePagePO = new HomePagePO(chromeDriver);
    AddProjectPO addProjectPO = new AddProjectPO(chromeDriver);
    EditPagePO editPagePO = new EditPagePO(chromeDriver);


    @DataProvider(name="test-data")
    public Object[][] readData() throws Exception {
        Object [][] hashMapObj  = readExcel("D://Automation//TestData", "Test.xlsx", "Sheet1");
        return hashMapObj;
    }


    @DataProvider(name="new_companydata")
    public Object[][] readCompanyData() throws Exception {
        Object [][] hashMapObj  = readExcel("D://Automation//TestData", "TestCompany.xlsx", "Sheet1");
        return hashMapObj;
    }
    @DataProvider(name="ProjectBenefits_Investmentdata")
    public Object[][] readInvestmentData() throws Exception {
        Object [][] hashMapObj  = readExcel("D://Automation//TestData", "TestInvestment.xlsx", "Sheet1");
        return hashMapObj;
    }

    @DataProvider(name="ProjectBenefits_EmployementInfo")
    public Object[][] readEmployementInfo() throws Exception {
        Object [][] hashMapObj  = readExcel("D://Automation//TestData", "TestEmploymentInfo.xlsx", "Sheet1");
        return hashMapObj;
    }

    @DataProvider(name="Project_emaildata")
    public Object[][] readEmailData() throws Exception {
        Object [][] hashMapObj  = readExcel("D://Automation//TestData", "TestEmailAdd.xlsx", "Sheet1");
        return hashMapObj;
    }

    @DataProvider(name="Project_addressAdd")
    public Object[][] readAddressData() throws Exception {
        Object [][] hashMapObj  = readExcel("D://Automation//TestData", "TestAddressAdd.xlsx", "Sheet1");
        return hashMapObj;
    }

    @DataProvider(name="Project_URLAdd")
    public Object[][] readURLData() throws Exception {
        Object [][] hashMapObj  = readExcel("D://Automation//TestData", "TestURLAdd.xlsx", "Sheet1");
        return hashMapObj;
    }

    @DataProvider(name="Project_SocialProfileAdd")
    public Object[][] readSocialProfileData() throws Exception {
        Object [][] hashMapObj  = readExcel("D://Automation//TestData", "TestSocialProfileAdd.xlsx", "Sheet1");
        return hashMapObj;
    }


  @Test(dataProvider = "test-data", groups = { "Regression" },alwaysRun = true, priority=4)
    public void Project_CRM_08_023(HashMap<String, String> projectDetails) throws InterruptedException {
        GenericMethods.waitForElementClickable(addProjectPO.addNewButton,20);
        GenericMethods.javascriptClick(addProjectPO.addNewButton);
        waitForSearchResults();
        addProjectPO.fillProjectData(projectDetails);
        System.out.println("--Add New ProjectInfo ---");
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        waitForSearchResults();
        Assert.assertEquals(addProjectPO.projectNameLabelText.getAttribute("value"),getProjectTitle());
        Assert.assertEquals(addProjectPO.projectCategoryLabelText.getText(),projectDetails.get("Category"));
    Assert.assertTrue(addProjectPO.projectManagerDropdownLabelText.getText().contains(projectDetails.get("Project_Manager")),projectDetails.get("Project_Manager"));
     Assert.assertEquals(addProjectPO.companyInfoHeader.getText(),projectDetails.get("Company"));
     Assert.assertEquals(addProjectPO.primaryContactPersonDDLabelText.getText(),projectDetails.get("Primary_Contact_Person"));
     Assert.assertEquals(addProjectPO.otherContactsDDLabelText.getText(),projectDetails.get("Other_Contacts"));
       Assert.assertEquals(addProjectPO.industryClusterDDLabelText.getText(),projectDetails.get("Industry_Cluster"));
        Assert.assertTrue(addProjectPO.getNAICSCodeLabelField.getText().contains(projectDetails.get("NAICS_Code")));
       Assert.assertEquals(addProjectPO.getTagsTextLabelField.getText(),projectDetails.get("Tags_Text"));
        Assert.assertEquals(addProjectPO.getDateLabelField.getText(),projectDetails.get("Date_Field"));
       Assert.assertTrue(addProjectPO.getNotesLabelField.getText().contains("Testing Notes"));
        Assert.assertEquals(addProjectPO.getExtraNumField1.getAttribute("value"),projectDetails.get("Extra_Num_Field1"));
        Assert.assertEquals(addProjectPO.getExtraNumField2.getAttribute("value"),projectDetails.get("Extra_Num_Field2"));
        Assert.assertEquals(addProjectPO.getExtraNumField3.getAttribute("value"),projectDetails.get("Extra_Num_Field3"));
        Assert.assertEquals(addProjectPO.getExtraNumField4.getAttribute("value"),projectDetails.get("Extra_Num_Field4"));
        Assert.assertEquals(addProjectPO.getExtraStringField1.getAttribute("value"),projectDetails.get("Extra_String_Field1"));
        Assert.assertEquals(addProjectPO.getExtraStringField2.getAttribute("value"),projectDetails.get("Extra_String_Field2"));
      Assert.assertEquals(addProjectPO.getDummyDateField1.getAttribute("value"),projectDetails.get("DummyDateField1"));
  Assert.assertEquals(addProjectPO.getDummyDateField2.getAttribute("value"),projectDetails.get("DummyDateField2"));
//Communication section
      Assert.assertEquals(addProjectPO.addedPhoneLabelValue.getText(),projectDetails.get("PhoneDropDown"));
      Assert.assertEquals((addProjectPO.addedLabelPhoneNumber.getText()).replaceAll("[()-]+",""),projectDetails.get("PhoneNumberTextField"));
      Assert.assertEquals(addProjectPO.addedPhoneExtensionLabel.getText(),projectDetails.get("PhoneExtensionTextField"));
        Assert.assertEquals(addProjectPO.emailAddedMainDropdownLabelValue.getText(),projectDetails.get("EmailDropDown"));
      Assert.assertEquals(addProjectPO.EmailLabelValue.getText(),projectDetails.get("EmailIDField"));
       Assert.assertEquals(addProjectPO.emailNotesLabelText.getText(),projectDetails.get("EmailNotesField"));

        Assert.assertTrue(addProjectPO.addprojectAddressDropdownLabelText.getText().contains(projectDetails.get("AddressDropDown")));
   Assert.assertTrue(addProjectPO.addProjectURLLabelText.getText().contains(projectDetails.get("URLDropDown")),projectDetails.get("URLDropDown"));
   Assert.assertTrue(addProjectPO.addProjectSocialProfileLabelText.getAttribute("innerText").contains(projectDetails.get("SocialProfileDropDown")),projectDetails.get("SocialProfileDropDown"));

   Assert.assertTrue(addProjectPO.addProjectInstantMsgLabelText.getAttribute("innerText").contains(projectDetails.get("InstantMessengerDropDown")),projectDetails.get("InstantMessengerDropDown"));
        Assert.assertEquals(addProjectPO.getExtraStringField3.getAttribute("value"),projectDetails.get("Extra_String_Field3"));
        Assert.assertEquals(addProjectPO.getExtraStringField4.getAttribute("value"),projectDetails.get("Extra_String_Field4"));
       Assert.assertEquals(addProjectPO.getDummyDateField3.getAttribute("value"),projectDetails.get("DummyDateField3"));
       Assert.assertEquals(addProjectPO.getDummyDateField4.getAttribute("value"),projectDetails.get("DummyDateField4"));

      Assert.assertEquals(addProjectPO.getOtherInfoRFIDateField.getAttribute("value"),projectDetails.get("RFIDateField"));

    Assert.assertTrue(addProjectPO.addProjectSourceLabelText.getAttribute("innerText").contains(projectDetails.get("Project_Source")),projectDetails.get("Project_Source"));
   Assert.assertEquals(addProjectPO.getExpectedClosingDateLabelText.getAttribute("value"),projectDetails.get("ClosingDate"));
              Assert.assertTrue(addProjectPO.getOtherInfoAssignToDropDown.getAttribute("innerText").contains(projectDetails.get("Assign_To")),projectDetails.get("Assign_To"));

      Assert.assertEquals(addProjectPO.getExtraStringField5.getAttribute("value"),projectDetails.get("Extra_String_Field5"));
      Assert.assertEquals(addProjectPO.getExtraStringField6.getAttribute("value"),projectDetails.get("Extra_String_Field6"));
       Assert.assertEquals(addProjectPO.getOtherInfoDummyDate5.getAttribute("value"),projectDetails.get("DummyDate5"));
       Assert.assertEquals(addProjectPO.getOtherInfoDummyDate6.getAttribute("value"),projectDetails.get("DummyDate6"));
//TC23 validation
      Assert.assertEquals(trim(addProjectPO.getFirstProjectInGrid()),getProjectTitle());
      System.out.println("Recently added project matches with the Project displayed in the grid : "+getProjectTitle());

    }


  @Test(groups = { "Regression" },priority=6)
    public void Project_CRM_24() throws InterruptedException {
        javascriptClick(homePagePO.projectsTab);
        waitForElementClickable(addProjectPO.getSortedProjectList,30);
        elementClick(addProjectPO.getSortedProjectList);
        System.out.println("Project list sorted");
        addProjectPO.getProjectItemToSort();
    }

 @Test(groups = { "Regression" },priority=7 )
     public void Project_CRM_21() throws InterruptedException {
       waitForElementClickable(addProjectPO.projectSearchBar,20);
        clickAndEnterText(addProjectPO.projectSearchBar,addProjectPO.getRandomCreatedProjectTitle());
       Thread.sleep(5000);
        waitForElement(chromeDriver,addProjectPO.firstProjectInLHSGrid);
        elementClick(addProjectPO.firstProjectInLHSGrid);
      Assert.assertEquals(addProjectPO.firstProjectInLHSGrid.getText(),addProjectPO.getRandomCreatedProjectTitle());
        System.out.println("Project searched successfully is: " +addProjectPO.getRandomCreatedProjectTitle());
       clearTextField(addProjectPO.projectSearchBar);
           }


  @Test(dataProvider = "test-data",groups = { "Regression" },priority=8)
    public void Project_CRM_26(HashMap<String, String> projectDetails) throws InterruptedException {
      waitForElement(chromeDriver,addProjectPO.getprojectLeftPaneGrid);
    Thread.sleep(5000);
      elementClick(addProjectPO.getSortedProjectList);
      waitForSearchResults();
      waitForElement(chromeDriver,addProjectPO.firstProjectInLHSGrid);
     elementClick(addProjectPO.firstProjectInLHSGrid);
      waitForElement(chromeDriver,addProjectPO.editProject);
      GenericMethods.javascriptClick(addProjectPO.editProject);
        waitForSearchResults();
       addProjectPO.editProjectData(projectDetails);
        System.out.println("--Edit ProjectInfo ---");
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        Assert.assertTrue(addProjectPO.projectManagerDropdownLabelText.getText().contains(projectDetails.get("Edit_Project_Manager")),projectDetails.get("Edit_Project_Manager"));


    }

   @Test(dataProvider = "test-data",groups = { "Regression" },priority=9)
    public void Project_CRM_27(HashMap<String, String> projectDetails) throws InterruptedException
    {
      Thread.sleep(5000);
      elementClick(addProjectPO.firstProjectInLHSGrid);
       waitForElement(chromeDriver,addProjectPO.editProject);
         elementClick(addProjectPO.editProject);
        Thread.sleep(5000);
       addProjectPO.editProjectData(projectDetails);
        System.out.println("--Edit ProjectInfo ---");
        GenericMethods.javascriptClick(addProjectPO.CancelButton);
        Thread.sleep(2000);
        GenericMethods.javascriptClick(addProjectPO.DontSaveAndContinueButton);
        Assert.assertTrue(addProjectPO.projectManagerDropdownLabelText.getText().contains(projectDetails.get("Project_Manager")),projectDetails.get("Project_Manager"));
        System.out.println("Discarded the edited Project Details");
    }


  @Test(dataProvider = "test-data",groups = { "Regression" },priority=10)
    public void Project_CRM_28(HashMap<String, String> projectDetails) throws InterruptedException {
       elementClick(addProjectPO.getSortedProjectList);
        waitForSearchResults();
        waitForElementClickable(addProjectPO.firstProjectInLHSGrid,30);
        elementClick(addProjectPO.firstProjectInLHSGrid);
        waitForElement(chromeDriver,addProjectPO.editProject);
        GenericMethods.javascriptClick(addProjectPO.editProject);
        waitForSearchResults();
        addProjectPO.editProjectData(projectDetails);
        System.out.println("--Edit ProjectInfo ---");
        editPagePO.ProjectDataTab.click();
        waitForSearchResults();

//       Assert.assertTrue(addProjectPO.DontSaveAndContinueButton.isDisplayed(),"Confirmation Pop-up with button displayed");
        GenericMethods.executescriptClick(addProjectPO.DontSaveAndContinueButton);

        System.out.println("Confirmation prompt displayed when moved to another tab");
    }


 @Test(dataProvider = "new_companydata", groups = { "Regression" },priority=11)
    public void Project_CRM_34(HashMap<String, String> projectDetails) throws InterruptedException {
        GenericMethods.waitForElementClickable(addProjectPO.addNewButton,20);
        GenericMethods.javascriptClick(addProjectPO.addNewButton);
        GenericMethods.waitForElementClickable(addProjectPO.projectNameTextField,30);
        setProjectTitle("ProTest_"+ DateTimeUtil.getcurrentDateTime());
        clickAndEnterText(addProjectPO.projectNameTextField,getProjectTitle());
      //  clickAndEnter(addProjectPO.projectCategoryDropdownOptions, addProjectPO.projectCategoryInputField,"Lead");
        elementClick(addProjectPO.projectManagerDropdown);
       selectByIndex(addProjectPO.projectManagerDropdown,8);
    // selectByText(addProjectPO.projectManagerDropdown,"Gaurav Saxena");
     elementClick(addProjectPO.CompanyPlusIcon);
     addProjectPO.fillNewCompanyProjectData(projectDetails);
     GenericMethods.javascriptClick(addProjectPO.newCompanyFormSubmitBtn);
     Assert.assertEquals(addProjectPO.newCompanyName.getAttribute("value"),projectDetails.get("newCompanyName"));

      GenericMethods.javascriptClick(addProjectPO.submitBtn);
      System.out.println("--Added New  Company Info ---");
    }

 @Test(dataProvider = "test-data",groups = { "Regression" },priority=12)
    public void Project_CRM_36(HashMap<String, String> projectDetails) throws InterruptedException
    {
        chromeDriver.get("https://previewweb.myprotrackplus.net/Project/Index/2");
        Waits.waitForElement(chromeDriver,homePagePO.crmTab);
        waitForSearchResults();
        elementClick(homePagePO.crmTab);

        GenericMethods.waitForElementClickable(addProjectPO.addNewButton,20);
      //  GenericMethods.javascriptClick(addProjectPO.addNewButton);
        elementClick(addProjectPO.addNewButton);
        GenericMethods.waitForElementClickable(addProjectPO.projectNameTextField,30);
        elementClick(addProjectPO.projectNameTextField);
        setProjectTitle("ProTest_"+ DateTimeUtil.getcurrentDateTime());
        clickAndEnterText(addProjectPO.projectNameTextField,getProjectTitle());
      //  clickAndEnter(addProjectPO.projectCategoryDropdownOptions, addProjectPO.projectCategoryInputField,projectDetails.get("Category"));
       waitForSearchResults();
        elementClick(addProjectPO.projectManagerDropdown);
       selectByText(addProjectPO.projectManagerDropdown,projectDetails.get("Project_Manager"));
    //   clickAndEnter(addProjectPO.companyDropdown,addProjectPO.getCompanyDropdownTextField,projectDetails.get("Company"));
       clickAndTab(addProjectPO.getPrimaryContactPersonDropDown,addProjectPO.getPrimaryContactPersonTextField,projectDetails.get("Primary_Contact_Person"));
        Assert.assertEquals(addProjectPO.getPrimaryContactPersonTextField.getAttribute("value"),projectDetails.get("Primary_Contact_Person"));
        Thread.sleep(9000);

      // clickAndEnter(addProjectPO.getSecondaryContactPersonDropDown,addProjectPO.getSecondaryContactPersonTextField,projectDetails.get("Secondary_Contact_Person"));
        clickAndSelect(addProjectPO.getSecondaryContactPersonDropDown,addProjectPO.getSecondaryContactPersonTextField,projectDetails.get("Secondary_Contact_Person"));
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        waitForSearchResults();
        Assert.assertTrue(addProjectPO.SecondaryContactPersonLabelDisplayed.isDisplayed(),"Secondary data is displayed post Primary data selection");

        }


     @Test(groups = { "Regression" },priority=13)
    public void Project_CRM_37() throws InterruptedException {
        Random rand = new Random();
        Waits.waitForElement(chromeDriver,homePagePO.crmTab);
        elementClick(homePagePO.crmTab);
        GenericMethods.waitForElementClickable(addProjectPO.contactsTab,20);
        elementClick(addProjectPO.contactsTab);
        waitForSearchResults();
        GenericMethods.waitForElementClickable(addProjectPO.projectInfoTab,20);
        elementClick(addProjectPO.projectInfoTab);
        int i = rand.nextInt(addProjectPO.ContactProjectInfoList.size());
        String projectNameToValidate = addProjectPO.ContactProjectInfoList.get(i).getText();
        elementClick(addProjectPO.ContactProjectInfoList.get(i));
        waitForElementClickable(addProjectPO.firstProjectInLHSGrid,30);
        Assert.assertEquals(projectNameToValidate,addProjectPO.firstProjectInLHSGrid.getText());
        elementClick(addProjectPO.firstProjectInLHSGrid);
        waitForSearchResults();
        Assert.assertEquals(addProjectPO.firstProjectInLHSGrid.getText(),addProjectPO.contactProjectSelected.getText());
        System.out.println("Project Details Page displayed on selecting the Contacts Project name in project grid");
    }

    @Test(dataProvider = "ProjectBenefits_Investmentdata", groups = { "Regression" },priority=14)
    public void Project_CRM_40(HashMap<String, String> projectDetails) throws InterruptedException {

    GenericMethods.waitForElementClickable(addProjectPO.addNewButton,20);
    GenericMethods.javascriptClick(addProjectPO.addNewButton);
     waitForSearchResults();

     GenericMethods.waitForElementClickable(addProjectPO.projectNameTextField,30);
     setProjectTitle("ProTest_"+ DateTimeUtil.getcurrentDateTime());
     clickAndEnterText(addProjectPO.projectNameTextField,getProjectTitle());


     waitForElementClickable(addProjectPO.projectBenefitsTab,20);
    elementClick(addProjectPO.projectBenefitsTab);
    waitForElementClickable(addProjectPO.projectBenefitsInvestmentYr,30);
    addProjectPO.fillInvestmentData(projectDetails);
    System.out.println("--Added New Investment Info ---");
    GenericMethods.javascriptClick(addProjectPO.addNewInvestmentBtn);
    GenericMethods.javascriptClick(addProjectPO.submitBtn);
  String investmentDataAdded =   addProjectPO.investmentRowsGrid.get(0).getText();
   String[] investment = investmentDataAdded.split("\\s+");
  System.out.println("Input string separated by spaces: " + investmentDataAdded);
    // System.out.println(investment[1]);
    Thread.sleep(10000);


      Assert.assertEquals(investment[0],projectDetails.get("Year"));
     Assert.assertEquals((investment[1].replaceAll("[(),]+","")),projectDetails.get("Real_Estate"));
     Assert.assertEquals((investment[2].replaceAll("[(),]+","")),projectDetails.get("Inventory"));
     Assert.assertEquals((investment[3].replaceAll("[(),]+","")),projectDetails.get("Machine_and_Equipment"));
     Assert.assertEquals((investment[4].replaceAll("[(),]+","")),projectDetails.get("Furniture_and_Fixture"));

    scrollPageToUp();
    waitForSearchResults();
}

 @Test(dataProvider = "ProjectBenefits_Investmentdata",groups = { "Regression" },dependsOnMethods = { "Project_CRM_40" },priority=15)
    public void Project_CRM_41(HashMap<String, String> projectDetails) throws InterruptedException {
        GenericMethods.javascriptClick(addProjectPO.editProject);
     waitForSearchResults();
     elementClick(addProjectPO.projectBenefitsTab);
//     GenericMethods.waitForElementClickable(addProjectPO.investmentGridEditIcon,20);
     scrollByVisibleElement(addProjectPO.investmentGridEditIcon);
        GenericMethods.javascriptClick(addProjectPO.investmentGridEditIcon);
        waitForElementClickable(addProjectPO.projectBenefitsInvestmentYr,30);
        GenericMethods.clearTextField(addProjectPO.InvestmentRealEstateTextField);
        selectByText(addProjectPO.projectBenefitsInvestmentYr,projectDetails.get("Updated_Year"));
        waitForElementClickable(addProjectPO.InvestmentRealEstateTextField,20);
        clickAndEnterText(addProjectPO.InvestmentRealEstateTextField,projectDetails.get("Updated_Real_Estate"));
        System.out.println("--Editing Investment Info ---");
        GenericMethods.javascriptClick(addProjectPO.investmentUpdateBtn);
        String investmentDataAdded =   addProjectPO.investmentRowsGrid.get(0).getText();
        String[] investment = investmentDataAdded.split("\\s+");
       System.out.println("Edited string separated by spaces: " + investmentDataAdded);
        Assert.assertEquals(investment[0],projectDetails.get("Updated_Year"));
        Assert.assertEquals(investment[1],projectDetails.get("Updated_Real_Estate"));
        scrollPageToUp();
    }

 @Test(dataProvider = "ProjectBenefits_EmployementInfo", groups = { "Regression" },priority=16)
    public void Project_CRM_43(HashMap<String, String> projectDetails) throws InterruptedException {

        Waits.waitForElement(chromeDriver,homePagePO.crmTab);
        elementClick(homePagePO.crmTab);
        GenericMethods.waitForElementClickable(addProjectPO.addNewButton,20);
        GenericMethods.javascriptClick(addProjectPO.addNewButton);
        Thread.sleep(5000);
        elementClick(addProjectPO.projectBenefitsTab);
      waitForSearchResults();
     JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
     executor.executeScript("document.getElementsByClassName('tab-content').scrollDown += 200");

        waitForElementClickable(addProjectPO.employmentInfoGrid,30);
          addProjectPO.fillEmpInformationData(projectDetails);
        System.out.println("--Added Employment Info ---");
        GenericMethods.javascriptClick(addProjectPO.empInfoAddNewBtn);

     String empInfoDataAdded =   addProjectPO.empInfoGridData.getText();
        String[] empInfoData = empInfoDataAdded.split(" ");
        System.out.println(Arrays.toString(empInfoData));


        Assert.assertEquals(empInfoData[1],projectDetails.get("Full_Time"));
        Assert.assertEquals(empInfoData[3],projectDetails.get("Management"));
        Assert.assertEquals(empInfoData[5],projectDetails.get("Part_Time"));
        Assert.assertEquals(empInfoData[7],projectDetails.get("Contract"));
        Assert.assertEquals(empInfoData[9],projectDetails.get("Others"));

        GenericMethods.javascriptClick(addProjectPO.submitBtn);
    }

 @Test(dataProvider = "ProjectBenefits_EmployementInfo", groups = { "Regression" },priority=17)
    public void Project_CRM_44(HashMap<String, String> projectDetails) throws InterruptedException {

        waitForSearchResults();
        elementClick(addProjectPO.projectBenefitsTab);
      JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
      executor.executeScript("document.getElementsByClassName('tab-content').scrollDown += 300");

        GenericMethods.javascriptClick(addProjectPO.editProject);
        Thread.sleep(5000);
        waitForElementClickable(addProjectPO.empInfoGridEditIcon,30);
        GenericMethods.javascriptClick(addProjectPO.empInfoGridEditIcon);
        elementClick(addProjectPO.empInfoFullTimeNumber);
        doubleClick(addProjectPO.empInfoClickToInputTextField);
        Thread.sleep(2000);
         clearTextField(addProjectPO.empInfoClickToInputTextField);
        waitForElementClickable(addProjectPO.empInfoClickToInputTextField,20);
        clickAndEnterText(addProjectPO.empInfoClickToInputTextField,projectDetails.get("Updated_Full_Time"));
        GenericMethods.javascriptClick(addProjectPO.empInfoUpdateBtn);
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        waitForSearchResults();

       String empInfoDataAdded =   addProjectPO.empInfoGridData.getText();
       System.out.println(empInfoDataAdded);
        String[] empInfoData = empInfoDataAdded.split(" ");
        System.out.println(Arrays.toString(empInfoData));
        System.out.println("Input string with spaces : " + empInfoDataAdded);

       Assert.assertEquals(empInfoData[1],projectDetails.get("Updated_Full_Time"));

    }


    @Test(dataProvider = "test-data", groups = { "Regression" },priority=18)
    public void Project_CRM_CRM_45(HashMap<String, String> projectDetails) throws InterruptedException {
        GenericMethods.waitForElementClickable(addProjectPO.addNewButton,20);
         GenericMethods.javascriptClick(addProjectPO.addNewButton);
         waitForSearchResults();
        GenericMethods.waitForElementClickable(addProjectPO.projectNameTextField,30);
        setProjectTitle("ProTest_"+ DateTimeUtil.getcurrentDateTime());
        clickAndEnterText(addProjectPO.projectNameTextField,getProjectTitle());
        addProjectPO.fillPhoneInformationData(projectDetails);
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        System.out.println("Multiple Phone Numbers can be added by clicking on the + Button");
        Assert.assertEquals(addProjectPO.addedPhoneLabelValue.getText(),projectDetails.get("PhoneDropDown"));
    waitForSearchResults();
    scrollPageToUp();
    }

   @Test(dataProvider = "test-data", groups = { "Regression" },dependsOnMethods = { "Project_CRM_CRM_45" },priority=19)
    public void Project_CRM_CRM_46(HashMap<String, String> projectDetails) throws InterruptedException {
        waitForElementClickable(addProjectPO.projectSearchBar,20);
        clearTextField(addProjectPO.projectSearchBar);
        waitForSearchResults();
        clickAndEnterText(addProjectPO.projectSearchBar,getProjectTitle());

        waitForElementClickable(addProjectPO.firstProjectInLHSGrid,30);
        elementClick(addProjectPO.firstProjectInLHSGrid);
        waitForElement(chromeDriver,addProjectPO.editProject);
        GenericMethods.javascriptClick(addProjectPO.editProject);
        waitForSearchResults();
        GenericMethods.waitForElementClickable(addProjectPO.projectNameTextField,30);
        scrollByVisibleElement(addProjectPO.editIconPhoneGrid);
        GenericMethods.waitForElementClickable(addProjectPO.editIconPhoneGrid, 10);
        elementClick(addProjectPO.editIconPhoneGrid);
        GenericMethods.waitForElementClickable(addProjectPO.getProjectPhoneDropDown, 10);
        GenericMethods.selectByText(addProjectPO.getProjectPhoneDropDown, projectDetails.get("Edited_PhoneDropDown"));
       waitForElementClickable(addProjectPO.saveIconPhoneGrid,10);
        elementClick(addProjectPO.saveIconPhoneGrid);
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        System.out.println("Successfully updated the value for the Phone number ");
       Assert.assertEquals(addProjectPO.labelPhoneGrid.getText(),projectDetails.get("Edited_PhoneDropDown"));
        System.out.println("Verified the value for the Phone number");
        scrollPageToUp();
       waitForSearchResults();

    }

 @Test(dataProvider = "test-data", groups = { "Regression" },dependsOnMethods = { "Project_CRM_CRM_46" },priority=20)
    public void Project_CRM_047(HashMap<String, String> projectDetails) throws InterruptedException {
        waitForElementClickable(addProjectPO.projectSearchBar, 20);
        clearTextField(addProjectPO.projectSearchBar);
        clickAndEnterText(addProjectPO.projectSearchBar, getProjectTitle());
        waitForElementClickable(addProjectPO.firstProjectInLHSGrid, 30);
        elementClick(addProjectPO.firstProjectInLHSGrid);
        waitForElement(chromeDriver, addProjectPO.editProject);
        GenericMethods.javascriptClick(addProjectPO.editProject);
        GenericMethods.scrollByVisibleElement(addProjectPO.deletePhoneGrid);
        waitForElementClickable(addProjectPO.deletePhoneGrid,30);
        elementClick(addProjectPO.deletePhoneGrid);
       GenericMethods.javascriptClick(addProjectPO.submitBtn);
        Assert.assertTrue(addProjectPO.emptyPostDeletePhoneGrid.isDisplayed());
    }

 @Test(dataProvider = "test-data", groups = { "Regression" },priority=21)
    public void Project_CRM_048(HashMap<String, String> projectDetails) throws InterruptedException {
     waitForSearchResults();
         GenericMethods.waitForElementClickable(addProjectPO.addNewButton,20);
         GenericMethods.javascriptClick(addProjectPO.addNewButton);

     waitForElementClickable(addProjectPO.projectNameTextField,20);
     setProjectTitle("ProTest_"+ DateTimeUtil.getcurrentDateTime());
     clickAndEnterText(addProjectPO.projectNameTextField,getProjectTitle());

     JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
     executor.executeScript("document.getElementsByClassName('tab-content').scrollDown += 500");


      //  GenericMethods.scrollByVisibleElement(addProjectPO.getProjectPhoneDropDown);
         GenericMethods.selectByText(addProjectPO.getProjectPhoneDropDown,projectDetails.get("PhoneDropDown"));
         clickAndEnterText(addProjectPO.PhoneNumberTextField, projectDetails.get("PhoneNumberTextField1"));
         clickAndEnterText(addProjectPO.PhoneExtensionTextField, projectDetails.get("PhoneExtensionTextField1"));
        javascriptClick(addProjectPO.clickPhonePlusIcon);
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
         Assert.assertEquals(addProjectPO.addedPhoneLabelValue.getText(),projectDetails.get("PhoneDropDown"));
        Assert.assertEquals((addProjectPO.addedLabelPhoneNumber.getText()).replaceAll("[()-]+",""),projectDetails.get("PhoneNumberTextField1"));
        waitForSearchResults();
         System.out.println("Added Main Phone number");
         scrollPageToUp();
    }

    @Test(dataProvider = "test-data", groups = { "Regression" },priority=22)
    public void Project_CRM_057(HashMap<String, String> projectDetails) throws InterruptedException {
        GenericMethods.waitForElementClickable(addProjectPO.addNewButton,30);
        GenericMethods.javascriptClick(addProjectPO.addNewButton);
        waitForSearchResults();
     waitForElementClickable(addProjectPO.projectNameTextField,20);
     setProjectTitle("ProTest_"+ DateTimeUtil.getcurrentDateTime());
     clickAndEnterText(addProjectPO.projectNameTextField,getProjectTitle());

        GenericMethods.scrollByVisibleElement(addProjectPO.getProjectPhoneDropDown);
        GenericMethods.selectByText(addProjectPO.getProjectPhoneDropDown,projectDetails.get("PhoneDropDown"));
        clickAndEnterText(addProjectPO.PhoneNumberTextField, projectDetails.get("PhoneNumberTextField1"));
        clickAndEnterText(addProjectPO.PhoneExtensionTextField, projectDetails.get("PhoneExtensionInvalidTextChk"));
        clickAndEnterText(addProjectPO.PhoneExtensionTextField, projectDetails.get("PhoneExtensionTextField1"));
     //   elementClick(addProjectPO.clickPhonePlusIcon);
      javascriptClick(addProjectPO.clickPhonePlusIcon);

        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        Assert.assertEquals(addProjectPO.addedPhoneExtensionLabel.getText(),projectDetails.get("PhoneExtensionTextField1"));
        System.out.println("Added Numeric Extension Phone number");
      scrollPageToUp();
      waitForSearchResults();
    }


  @Test(dataProvider = "test-data", groups = { "Regression" },priority=23)
    public void Project_CRM_058(HashMap<String, String> projectDetails) throws InterruptedException {
        GenericMethods.waitForElementClickable(addProjectPO.addNewButton,20);
        GenericMethods.javascriptClick(addProjectPO.addNewButton);

      waitForElementClickable(addProjectPO.projectNameTextField,20);
      setProjectTitle("ProTest_"+ DateTimeUtil.getcurrentDateTime());
      clickAndEnterText(addProjectPO.projectNameTextField,getProjectTitle());

        GenericMethods.scrollByVisibleElement(addProjectPO.getProjectPhoneDropDown);
        GenericMethods.selectByText(addProjectPO.getProjectPhoneDropDown,projectDetails.get("PhoneDropDown"));
        clickAndEnterText(addProjectPO.PhoneNumberTextField, projectDetails.get("PhoneNumberTextField1"));
        clickAndEnterText(addProjectPO.PhoneExtensionTextField, projectDetails.get("PhoneExtensionInvalidTextChk"));
        clickAndEnterText(addProjectPO.PhoneExtensionTextField, projectDetails.get("PhoneExtensionInvalidlengthChk"));
        clickAndEnterText(addProjectPO.PhoneExtensionTextField, projectDetails.get("PhoneExtensionMaxlengthChk"));
        elementClick(addProjectPO.clickPhonePlusIcon);

        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        Assert.assertEquals(addProjectPO.addedPhoneExtensionLabel.getText(),projectDetails.get("PhoneExtensionMaxlengthChk"));
        waitForSearchResults();
        System.out.println("Max length of 20 chars Numeric Extension Phone validated");
        scrollPageToUp();

    }

   @Test(dataProvider = "Project_emaildata", groups = { "Regression" },priority=24)
        public void Project_CRM_059(HashMap<String, String> projectDetails) throws InterruptedException {
        Waits.waitForElement(chromeDriver, homePagePO.crmTab);
        elementClick(homePagePO.crmTab);
        waitForSearchResults();
        GenericMethods.waitForElementClickable(addProjectPO.addNewButton,20);
        GenericMethods.javascriptClick(addProjectPO.addNewButton);
        GenericMethods.waitForElementClickable(addProjectPO.projectNameTextField,30);
        setProjectTitle("ProTest_" + DateTimeUtil.getcurrentDateTime());
        clickAndEnterText(addProjectPO.projectNameTextField,getProjectTitle());
        addProjectPO.fillEmailInformationData(projectDetails);
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        System.out.println("Multiple Emails can be added by clicking on the + Button");
       Assert.assertEquals(addProjectPO.EmailLabelValue.getText(),projectDetails.get("EmailIDField"));
       waitForSearchResults();
    scrollPageToUp();
    }


  @Test(dataProvider = "Project_emaildata", groups = { "Regression" },dependsOnMethods = { "Project_CRM_059" },priority=25)
    public void Project_CRM_060(HashMap<String, String> projectDetails) throws InterruptedException {
        scrollByVisibleElement(addProjectPO.projectSearchBar);
        waitForElementClickable(addProjectPO.projectSearchBar,20);
        clickAndEnterText(addProjectPO.projectSearchBar,getProjectTitle());
    waitForSearchResults();
      //  waitForElementClickable(addProjectPO.firstProjectInLHSGrid,30);
        elementClick(addProjectPO.firstProjectInLHSGrid);
        waitForElement(chromeDriver,addProjectPO.editProject);
        GenericMethods.javascriptClick(addProjectPO.editProject);
        waitForSearchResults();
      // GenericMethods.waitForElementClickable(addProjectPO.projectNameTextField,30);
      JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
      executor.executeScript("document.getElementsByClassName('tab-content').scrollDown += 300");
     //   GenericMethods.scrollByVisibleElement(addProjectPO.editIconPhoneGrid);
        GenericMethods.waitForElementClickable(addProjectPO.editIconPhoneGrid, 10);
        elementClick(addProjectPO.editIconPhoneGrid);
        addProjectPO.editEmailData(projectDetails);
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        System.out.println("Successfully updated Email data ");
        waitForSearchResults();
      Assert.assertEquals(addProjectPO.emailDropdownLabelValue.getText(),projectDetails.get("Edited_EmailDropDown"));
     Assert.assertTrue(addProjectPO.editEmailIDLabelValue.getText().contains(projectDetails.get("Edit_EmailID")));
    System.out.println("Verified the value for the Email");
      waitForSearchResults();
    scrollPageToUp();



    }

 @Test(dataProvider = "Project_emaildata", groups = { "Regression" },priority=26,dependsOnMethods = { "Project_CRM_060" })
    public void Project_Module_061(HashMap<String, String> projectDetails) throws InterruptedException {
       scrollByVisibleElement(addProjectPO.projectSearchBar);
        waitForElementClickable(addProjectPO.projectSearchBar, 20);
     clearTextField(addProjectPO.projectSearchBar);
       clickAndEnterText(addProjectPO.projectSearchBar, getProjectTitle());
       waitForSearchResults();
        waitForElementClickable(addProjectPO.firstProjectInLHSGrid, 30);
        elementClick(addProjectPO.firstProjectInLHSGrid);
        waitForElement(chromeDriver, addProjectPO.editProject);
        GenericMethods.javascriptClick(addProjectPO.editProject);
        waitForSearchResults();
       GenericMethods.scrollByVisibleElement(addProjectPO.deletePhoneGrid);
        waitForElementClickable(addProjectPO.deletePhoneGrid,30);
        elementClick(addProjectPO.deletePhoneGrid);
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
       Assert.assertFalse(addProjectPO.postDeleteEmailGrid.getText().contains("Work"));
     scrollPageToUp();
     waitForElementClickable(addProjectPO.projectSearchBar,20);

    }

  @Test(dataProvider = "Project_emaildata", groups = { "Regression" },priority=27)
    public void Project_CRM_062(HashMap<String, String> projectDetails) throws InterruptedException {
      chromeDriver.get("https://previewweb.myprotrackplus.net/Project/Index/2");
      Waits.waitForElement(chromeDriver,homePagePO.crmTab);
      waitForSearchResults();
      elementClick(homePagePO.crmTab);
       waitForSearchResults();
      GenericMethods.waitForElementClickable(addProjectPO.addNewButton,20);
        GenericMethods.javascriptClick(addProjectPO.addNewButton);
        GenericMethods.waitForElementClickable(addProjectPO.projectNameTextField,30);
        setProjectTitle("ProTest_"+ DateTimeUtil.getcurrentDateTime());
        clickAndEnterText(addProjectPO.projectNameTextField,getProjectTitle());
        GenericMethods.waitForElementClickable(addProjectPO.getProjectEmailDropDown, 10);
        selectByText(addProjectPO.getProjectEmailDropDown,projectDetails.get("EmailDropDown1"));
        clickAndEnterText(addProjectPO.EmailIDField,projectDetails.get("EmailIDField1"));
        clickAndEnterText(addProjectPO.EmailNotesField,projectDetails.get("EmailNotesField1"));
        elementClick(addProjectPO.clickEmailPlusIcon);

        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        System.out.println("Email of type Home added successfully");
        Assert.assertEquals(addProjectPO.emailAddedMainDropdownLabelValue.getText(),projectDetails.get("EmailDropDown1"));
        System.out.println("Validated Email of type  Home");
    scrollPageToUp();
    }

   @Test(dataProvider = "Project_emaildata", groups = { "Regression" },priority=28)
    public void Project_CRM_066(HashMap<String, String> projectDetails) throws InterruptedException {
        Waits.waitForElement(chromeDriver, homePagePO.crmTab);
        elementClick(homePagePO.crmTab);
        Thread.sleep(5000);
        GenericMethods.waitForElementClickable(addProjectPO.addNewButton,20);
        GenericMethods.javascriptClick(addProjectPO.addNewButton);
        GenericMethods.waitForElementClickable(addProjectPO.projectNameTextField,30);
        setProjectTitle("ProTest_"+ DateTimeUtil.getcurrentDateTime());
        clickAndEnterText(addProjectPO.projectNameTextField,getProjectTitle());
        GenericMethods.waitForElementClickable(addProjectPO.getProjectEmailDropDown, 10);
        addProjectPO.emailIDValidation(projectDetails);
       GenericMethods.javascriptClick(addProjectPO.submitBtn);
       Assert.assertTrue(addProjectPO.emailInvalidErrAlert.getAttribute("innerText").contains("Please provide valid email addresses."),projectDetails.get("ErrInvalidEmail"));
       Assert.assertEquals(addProjectPO.EmailLabelValue.getText(),projectDetails.get("EmailIDField"));
       System.out.println("Email ID validation done and Valid email added successfully");
    }

    @Test(dataProvider = "Project_addressAdd", groups = { "Regression" },priority=29)
    public void Project_CRM_067(HashMap<String, String> projectDetails) throws InterruptedException {
        waitForSearchResults();
        GenericMethods.waitForElementClickable(addProjectPO.addNewButton, 20);
        GenericMethods.javascriptClick(addProjectPO.addNewButton);

        waitForElementClickable(addProjectPO.projectNameTextField, 20);
        setProjectTitle("ProTest_" + DateTimeUtil.getcurrentDateTime());
        clickAndEnterText(addProjectPO.projectNameTextField, getProjectTitle());

        JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
        executor.executeScript("document.getElementsByClassName('tab-content').scrollDown += 500");

        GenericMethods.waitForElementClickable(addProjectPO.getProjectAddressDropDown, 10);
        addProjectPO.fillAddressData(projectDetails);
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        waitForSearchResults();
        Assert.assertTrue(addProjectPO.addprojectAddressDropdownLabelText.getText().contains(projectDetails.get("AddressDropDown")));
    }


    @Test(dataProvider = "Project_addressAdd", groups = { "Regression" },priority=30)
    public void Project_CRM_72(HashMap<String, String> projectDetails) throws InterruptedException {
        waitForSearchResults();
        GenericMethods.waitForElementClickable(addProjectPO.addNewButton, 20);
        GenericMethods.javascriptClick(addProjectPO.addNewButton);

        waitForElementClickable(addProjectPO.projectNameTextField, 20);
        setProjectTitle("ProTest_" + DateTimeUtil.getcurrentDateTime());
        clickAndEnterText(addProjectPO.projectNameTextField, getProjectTitle());

        JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
        executor.executeScript("document.getElementsByClassName('tab-content').scrollDown += 500");

        GenericMethods.waitForElementClickable(addProjectPO.getProjectAddressDropDown, 10);
        addProjectPO.fillAddressData(projectDetails);
        selectByText(addProjectPO.getProjectAddressDropDown,projectDetails.get("AddressDropDown1"));
        clickAndEnterText(addProjectPO.addressAliasTextField,projectDetails.get("Alias1"));
        clickAndEnterText(addProjectPO.addressStreetAddress1,projectDetails.get("StreetAddress11"));
        clickAndEnterText(addProjectPO.addressStreetAddress2,projectDetails.get("StreetAddress22"));
        clickAndEnterText(addProjectPO.addressTownTextField,projectDetails.get("Town_City1"));
        selectByText(addProjectPO.addressCountryDropDown,projectDetails.get("Country1"));
        waitForSearchResults();
        selectByText(addProjectPO.addressStateDropDown,projectDetails.get("State1"));
        waitForSearchResults();
        clickAndEnterText(addProjectPO.addressZipCodeTextField,projectDetails.get("ZipCode1"));
        elementClick(addProjectPO.addprojectAddressPlusIcon);
        waitForSearchResults();
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        waitForSearchResults();

    }




    @Test(dataProvider = "Project_addressAdd", groups = { "Regression" },priority=31)
    public void Project_CRM_73(HashMap<String, String> projectDetails) throws InterruptedException {
        scrollByVisibleElement(addProjectPO.projectSearchBar);
        waitForElementClickable(addProjectPO.projectSearchBar, 20);
        clearTextField(addProjectPO.projectSearchBar);
        clickAndEnterText(addProjectPO.projectSearchBar, getProjectTitle());
        waitForSearchResults();
        waitForElementClickable(addProjectPO.firstProjectInLHSGrid, 30);
        elementClick(addProjectPO.firstProjectInLHSGrid);
        waitForElement(chromeDriver, addProjectPO.editProject);
        GenericMethods.javascriptClick(addProjectPO.editProject);
        waitForSearchResults();
        GenericMethods.waitForElementClickable(addProjectPO.editIconAddressGrid, 10);
        elementClick(addProjectPO.editIconAddressGrid);
        GenericMethods.waitForElementClickable(addProjectPO.getProjectAddressDropDown, 10);
        selectByText(addProjectPO.getProjectAddressDropDown,projectDetails.get("AddressDropDownEdited"));
        elementClick(addProjectPO.saveIconAddressGrid);
        waitForSearchResults();
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        waitForSearchResults();
        Assert.assertTrue(addProjectPO.addprojectAddressDropdownLabelText.getAttribute("innerText").contains(projectDetails.get("AddressDropDownEdited")));
        clearTextField(addProjectPO.projectSearchBar);
        waitForSearchResults();
    }

    @Test(groups = { "Regression" },priority=32)
    public void Project_CRM_074() throws InterruptedException {
        scrollByVisibleElement(addProjectPO.projectSearchBar);
        waitForElementClickable(addProjectPO.projectSearchBar, 20);
        clearTextField(addProjectPO.projectSearchBar);
        clickAndEnterText(addProjectPO.projectSearchBar, getProjectTitle());
        waitForSearchResults();
        waitForElementClickable(addProjectPO.firstProjectInLHSGrid, 30);
        elementClick(addProjectPO.firstProjectInLHSGrid);
        waitForElement(chromeDriver, addProjectPO.editProject);
        GenericMethods.javascriptClick(addProjectPO.editProject);
        waitForSearchResults();
       JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
        executor.executeScript("document.getElementsByClassName('tab-content').scrollDown += 500");

       elementClick(addProjectPO.deleteIconAddressGrid);
       GenericMethods.javascriptClick(addProjectPO.submitBtn);
       waitForSearchResults();

        Assert.assertFalse(addProjectPO.postDeleteAddressGrid.getText().contains("Branch Office"));
        scrollPageToUp();
        waitForElementClickable(addProjectPO.projectSearchBar,20);
        clearTextField(addProjectPO.projectSearchBar);
        waitForSearchResults();

    }

    @Test(dataProvider = "test-data", groups = { "Regression" },priority=33)
    public void Project_CRM_076(HashMap<String, String> projectDetails) throws InterruptedException {
        GenericMethods.waitForElementClickable(addProjectPO.addNewButton, 20);
        GenericMethods.javascriptClick(addProjectPO.addNewButton);
        waitForSearchResults();
        selectByText(addProjectPO.getProjectURLDropDown,projectDetails.get("URLDropDownHome"));
        GenericMethods.clickAndEnterText(addProjectPO.addProjectURLTextField,projectDetails.get("URLTextField"));
        clickAndEnterText(addProjectPO.addProjectURLNotes,projectDetails.get("URLNotes"));
        elementClick(addProjectPO.addProjectURLPlusIcon);
        waitForSearchResults();
        Assert.assertTrue(addProjectPO.addProjectURLLabelText.getText().contains(projectDetails.get("URLDropDownHome")),projectDetails.get("URLDropDownHome"));
        System.out.println("Project Tab  URL of type Home added successfully.");
    }

    @Test(dataProvider = "Project_URLAdd", groups = { "Regression" },priority=34)
    public void Project_CRM_080(HashMap<String, String> projectDetails) throws InterruptedException {
        GenericMethods.waitForElementClickable(addProjectPO.addNewButton, 20);
        GenericMethods.javascriptClick(addProjectPO.addNewButton);
        waitForSearchResults();

        waitForElementClickable(addProjectPO.projectNameTextField, 20);
        setProjectTitle("ProTest_" + DateTimeUtil.getcurrentDateTime());
        clickAndEnterText(addProjectPO.projectNameTextField, getProjectTitle());

        JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
        executor.executeScript("document.getElementsByClassName('tab-content').scrollDown += 500");

        GenericMethods.waitForElementClickable(addProjectPO.getProjectURLDropDown, 10);
        addProjectPO.addURLData(projectDetails);

        selectByText(addProjectPO.getProjectURLDropDown,projectDetails.get("URLDropDownHP"));
        GenericMethods.clickAndEnterText(addProjectPO.addProjectURLTextField,projectDetails.get("URLTextField1"));
        clickAndEnterText(addProjectPO.addProjectURLNotes,projectDetails.get("URLNotes1"));
        elementClick(addProjectPO.addProjectURLPlusIcon);
        waitForSearchResults();
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        waitForSearchResults();
        Assert.assertTrue(addProjectPO.addProjectURLLabelText.getText().contains(projectDetails.get("URLDropDownHome")),projectDetails.get("URLDropDownHome"));
        System.out.println("Project Tab Multiple  URLs added successfully.");

   }

    @Test(dataProvider = "Project_URLAdd", groups = { "Regression" },priority=35)
    public void Project_CRM_081(HashMap<String, String> projectDetails) throws InterruptedException {
        scrollByVisibleElement(addProjectPO.projectSearchBar);
        waitForElementClickable(addProjectPO.projectSearchBar, 20);
        clearTextField(addProjectPO.projectSearchBar);
        clickAndEnterText(addProjectPO.projectSearchBar, getProjectTitle());
        waitForSearchResults();
        waitForElementClickable(addProjectPO.firstProjectInLHSGrid, 30);
        elementClick(addProjectPO.firstProjectInLHSGrid);
        waitForElement(chromeDriver, addProjectPO.editProject);
        GenericMethods.javascriptClick(addProjectPO.editProject);
        waitForSearchResults();
        GenericMethods.waitForElementClickable(addProjectPO.editIconURLGrid, 10);
        elementClick(addProjectPO.editIconURLGrid);
        waitForSearchResults();
        GenericMethods.waitForElementClickable(addProjectPO.getProjectURLDropDown, 10);
        selectByText(addProjectPO.getProjectURLDropDown,projectDetails.get("URLDropDownEdited"));
        elementClick(addProjectPO.saveIconURLGrid);
        waitForSearchResults();
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        waitForSearchResults();
        Assert.assertTrue(addProjectPO.addProjectURLEditedLabelText.getAttribute("innerText").contains(projectDetails.get("URLDropDownEdited")));
        clearTextField(addProjectPO.projectSearchBar);
        waitForSearchResults();
        System.out.println("Project Tab URL edited successfully.");
    }

    @Test(dataProvider = "Project_URLAdd", groups = { "Regression" },priority=36)
    public void Project_CRM_082(HashMap<String, String> projectDetails) throws InterruptedException {
        scrollByVisibleElement(addProjectPO.projectSearchBar);
        waitForElementClickable(addProjectPO.projectSearchBar, 20);
        clearTextField(addProjectPO.projectSearchBar);
        clickAndEnterText(addProjectPO.projectSearchBar, getProjectTitle());
        waitForSearchResults();
        waitForElementClickable(addProjectPO.firstProjectInLHSGrid, 30);
        elementClick(addProjectPO.firstProjectInLHSGrid);
        waitForElement(chromeDriver, addProjectPO.editProject);
        GenericMethods.javascriptClick(addProjectPO.editProject);
        waitForSearchResults();

        JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
        executor.executeScript("document.getElementsByClassName('tab-content').scrollDown += 500");
        GenericMethods.waitForElementClickable(addProjectPO.deleteIconURLGrid, 10);
     //   elementClick(addProjectPO.deleteIconURLGrid);
        addProjectPO.deleteIconURLGrid.click();
         waitForSearchResults();
        addProjectPO.deleteIconURLGrid.click();
      //  elementClick(addProjectPO.deleteIconURLGrid);

        waitForSearchResults();
        System.out.println("Project Tab URL deleted successfully.");
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        waitForSearchResults();
        waitForElement(chromeDriver, addProjectPO.editProject);
        GenericMethods.javascriptClick(addProjectPO.editProject);
        waitForSearchResults();

        GenericMethods.waitForElementClickable(addProjectPO.getProjectURLDropDown, 10);
        addProjectPO.addURLData(projectDetails);
        waitForSearchResults();

        Assert.assertTrue(addProjectPO.addProjectURLLabelText.getText().contains(projectDetails.get("URLDropDownHome")),projectDetails.get("URLDropDownHome"));
        scrollPageToUp();
        waitForElementClickable(addProjectPO.projectSearchBar,20);
        clearTextField(addProjectPO.projectSearchBar);
        System.out.println("Project Tab URL added successfully post deletion.");
    }

    @Test(dataProvider = "Project_SocialProfileAdd", groups = { "Regression" },priority=37)
    public void Project_CRM_083_090(HashMap<String, String> projectDetails) throws InterruptedException {
        GenericMethods.waitForElementClickable(addProjectPO.addNewButton, 20);
        GenericMethods.javascriptClick(addProjectPO.addNewButton);
        waitForSearchResults();

        waitForElementClickable(addProjectPO.projectNameTextField, 20);
        setProjectTitle("ProTest_" + DateTimeUtil.getcurrentDateTime());
        clickAndEnterText(addProjectPO.projectNameTextField, getProjectTitle());

        JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
        executor.executeScript("document.getElementsByClassName('tab-content').scrollDown += 500");

        GenericMethods.waitForElementClickable(addProjectPO.getProjectSocialProfileDropDown, 10);
        addProjectPO.addSocialProfileData(projectDetails);
        selectByText(addProjectPO.getProjectSocialProfileDropDown,projectDetails.get("SocialProfileDropDown1"));
        GenericMethods.clickAndEnterText(addProjectPO.addProjectSocialProfileTextField,projectDetails.get("SocialProfileTextField1"));
        elementClick(addProjectPO.addProjectSocialProfilePlusIcon);

        waitForSearchResults();
        Assert.assertTrue(addProjectPO.addProjectSocialProfileLabelText.getText().contains(projectDetails.get("SocialProfileTextField")),projectDetails.get("SocialProfileTextField"));
        System.out.println(" Social Profile of type Twitter added succesfully.");

    }

    @Test(dataProvider = "Project_SocialProfileAdd", groups = { "Regression" },priority=37)
    public void Project_CRM_091(HashMap<String, String> projectDetails) throws InterruptedException {
        scrollByVisibleElement(addProjectPO.projectSearchBar);
        waitForElementClickable(addProjectPO.projectSearchBar, 20);
        clearTextField(addProjectPO.projectSearchBar);
        clickAndEnterText(addProjectPO.projectSearchBar, getProjectTitle());
        waitForSearchResults();
       elementClick(addProjectPO.firstProjectInLHSGrid);

        waitForElement(chromeDriver, addProjectPO.editProject);
        GenericMethods.javascriptClick(addProjectPO.editProject);
        waitForSearchResults();


        GenericMethods.waitForElementClickable(addProjectPO.editIconSocialProfileGrid, 10);
        elementClick(addProjectPO.editIconSocialProfileGrid);
        waitForSearchResults();

        GenericMethods.waitForElementClickable(addProjectPO.getProjectSocialProfileDropDown, 10);
        selectByText(addProjectPO.getProjectSocialProfileDropDown,projectDetails.get("SocialProfileDropDownEdited"));
        elementClick(addProjectPO.saveIconSocialProfileGrid);
        waitForSearchResults();
        GenericMethods.javascriptClick(addProjectPO.submitBtn);
        waitForSearchResults();
        Assert.assertTrue(addProjectPO.addProjectSocialProfileEditedLabelText.getAttribute("innerText").contains(projectDetails.get("SocialProfileDropDownEdited")));
        clearTextField(addProjectPO.projectSearchBar);
        waitForSearchResults();
        System.out.println("SocialProfile edited successfully.");

    }

}

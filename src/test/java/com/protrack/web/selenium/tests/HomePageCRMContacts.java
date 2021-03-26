package com.protrack.web.selenium.tests;

import com.protrack.web.selenium.pages.AddContactsPO;
import com.protrack.web.selenium.pages.AddProjectPO;
import com.protrack.web.selenium.pages.HomePagePO;
import com.protrack.web.selenium.utility.GenericMethods;
import com.protrack.web.selenium.utility.Waits;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.protrack.web.selenium.utility.GenericMethods.*;
import static com.protrack.web.selenium.utility.ReadDataFromExcelFile.readExcel;
import static com.protrack.web.selenium.utility.Waits.waitForElement;

class HomePageCRMContacts extends BaseClass{
    HomePagePO homePagePO = new HomePagePO(chromeDriver);
    GenericMethods genericMethods = new GenericMethods();
    Waits waits = new Waits();
    AddProjectPO  addProjectPO=new AddProjectPO(chromeDriver);
    AddContactsPO addContactsPO=new AddContactsPO(chromeDriver);

    @DataProvider(name="test-data")
    public Object[][] readData() throws Exception {
        Object [][] hashMapObj  = readExcel("C:\\Users\\SSTSL1108\\Desktop", "ProtrackPlusTestData.xlsx", "Sheet1");
        return hashMapObj;
    }

    @Test(groups = { "Regression" },alwaysRun = true, priority=1)
    public void Contact_Management_001() throws InterruptedException {
        //  selectCRMContactsInfoTab
        homePagePO.clickOnCRMContactsTab();
        waitForSearchResults();
        Assert.assertTrue(addContactsPO.getContactGeneralInfoLabelHeader.getText().contains("General Information"),"General Information Header is displayed");
        System.out.println(" User get the Contacts Details on Right Side of the Page ");
    }

    @Test(groups = { "Regression" },alwaysRun = true, priority=2)
    public void Contact_Management_002() throws InterruptedException {
        addContactsPO. verifyContactPageByClickingONArrowPrimaryContact();
        System.out.println("User Get the Primary Contact Details On Any Project ");
    }
    @Test(groups = { "Regression" },alwaysRun = true, priority=3)
    public void Contact_Management_004() throws InterruptedException {
        addContactsPO.verifyContactDetailsinViewMode();
        waitForSearchResults();
        Assert.assertTrue(addContactsPO.getContactGeneralInfoLabelHeader.getText().contains("General Information"),"General Information Header is displayed");
        System.out.println(" User get the Contacts Details display in View Mode ");
    }
    @Test(groups = { "Regression" },alwaysRun = true, priority=4)
    public void Contact_Management_005() throws InterruptedException {
        addContactsPO.verifyOneTabToAnothertabWithinTheContacts();
        System.out.println("User Navigate From One Tab to Another Tab Within Contacts Module");
    }



    @Test(dataProvider = "test-data", groups = { "Regression" },priority=5)
    public void Contact_Management_006(HashMap<String,String> contactDetails) throws InterruptedException {
       addContactsPO.fillAddContactData(contactDetails);
       JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
       executor.executeScript("document.getElementsByClassName('tab-content').scrollDown += 500");
       addContactsPO.fillCommunicationInformationData(contactDetails);
       addContactsPO.fillEmailData(contactDetails);
       addContactsPO.fillUrlData(contactDetails);
    }
}

package com.protrack.web.selenium.tests;

import com.protrack.web.selenium.pages.AddContactsPO;
import com.protrack.web.selenium.pages.AddProjectPO;
import com.protrack.web.selenium.pages.HomePagePO;
import com.protrack.web.selenium.utility.GenericMethods;
import com.protrack.web.selenium.utility.Waits;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.protrack.web.selenium.utility.GenericMethods.*;
import static com.protrack.web.selenium.utility.Waits.waitForElement;

class HomePageCRMContacts extends BaseClass{
    HomePagePO homePagePO = new HomePagePO(chromeDriver);
    GenericMethods genericMethods = new GenericMethods();
    Waits waits = new Waits();
    AddProjectPO  addProjectPO=new AddProjectPO(chromeDriver);
    AddContactsPO addContactsPO=new AddContactsPO(chromeDriver);

    @Test
    public void Contact_Management_001() throws InterruptedException {
        //  selectCRMContactsInfoTab
        homePagePO.clickOnCRMContactsTab();
        waitForSearchResults();
        Assert.assertTrue(addContactsPO.getContactGeneralInfoLabelHeader.getText().contains("General Information"),"General Information Header is displayed");
        System.out.println(" User get the Contacts Details on Right Side of the Page ");
    }

    @Test
    public void Contact_Management_002() throws InterruptedException {
        addContactsPO. verifyContactPageByClickingONArrowPrimaryContact();
        System.out.println("User Get the Primary Contact Details On Any Project ");
    }
    @Test
    public void Contact_Management_004() throws InterruptedException {
        addContactsPO.VerifyContactDetailsinViewMode();
        waitForSearchResults();
        Assert.assertTrue(addContactsPO.getContactGeneralInfoLabelHeader.getText().contains("General Information"),"General Information Header is displayed");
        System.out.println(" User get the General Information display in View Mode ");
    }

}

package com.protrack.web.selenium.tests;

import com.protrack.web.selenium.pages.AddProjectPO;
import com.protrack.web.selenium.pages.HomePagePO;
import com.protrack.web.selenium.utility.GenericMethods;
import com.protrack.web.selenium.utility.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.management.snmp.jvminstr.JvmOSImpl;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

import static com.protrack.web.selenium.tests.BaseClass.chromeDriver;
import static com.protrack.web.selenium.tests.StaticContext.getProjectTitle;
import static com.protrack.web.selenium.utility.GenericMethods.waitForElementClickable;
import static com.protrack.web.selenium.utility.GenericMethods.waitForSearchResults;
import static com.protrack.web.selenium.utility.ReadDataFromExcelFile.readExcel;
import static jdk.nashorn.internal.objects.NativeString.trim;




public class HomePageCRMTest extends BaseClass{

    HomePagePO homePagePO = new HomePagePO(chromeDriver);
    GenericMethods genericMethods = new GenericMethods();
    Waits waits = new Waits();
    AddProjectPO addProjectPO = new AddProjectPO(chromeDriver);


 @Test(groups = { "Regression" },priority=1)
    public void Project_CRM_01() throws InterruptedException {
      //  selectCRMProjectInfoTab
        homePagePO.clickOnCRMProjInfoTab();
         waitForSearchResults();
      Assert.assertTrue(addProjectPO.companyInfoLabelHeader.getText().contains("Company Information"),"Company Information Header is displayed");
        System.out.println(" User get the Project Details on Right Side of the Page ");}

@Test(groups = { "Regression" },dependsOnMethods = { "Project_CRM_01" },priority=2)
    public void Project_CRM_03() throws InterruptedException {
       homePagePO.clickOnCRMProjInfoTab();
       Assert.assertTrue(addProjectPO.firstProjectNameLHSGrid.contains(addProjectPO.firstProjectInLHSGrid),"Project Data is displayed in grid");
        System.out.println("User tap on the Project tab from Left Panel ");

    }


 @Test(groups = { "Regression" },priority=3)
    public void Project_CRM_05() throws InterruptedException {
      GenericMethods.elementClick(homePagePO.crmTab);
     waitForElementClickable(homePagePO.breTab,20);
     System.out.println("---Moving to BRE TAB--");
        GenericMethods.elementClick(homePagePO.breTab);
       waitForElementClickable(homePagePO.breDropdownForms,30);
      GenericMethods.mousehover(homePagePO.breDropdownForms);
     waitForSearchResults();
      Assert.assertTrue(homePagePO.breheading.getText().contains("BRE"),"BRE");
     System.out.println("---In Library of Documents Tab-----");
      GenericMethods.elementClick(homePagePO.libraryOfDocumentsTab);
    waitForElementClickable(homePagePO.libraryDropdownOptionMunicipalDocuments,20);
      GenericMethods.mousehover(homePagePO.libraryDropdownOptionMunicipalDocuments);
     waitForSearchResults();
      Assert.assertTrue(homePagePO.LibofDocheading.getText().contains("Municipal Documents"),"Municipal Documents");
       System.out.println("---In Reports Tab---");
       GenericMethods.elementClick(homePagePO.reportsTab);
        waitForElementClickable(homePagePO.reportsTaxReport,20);
     GenericMethods.mousehover(homePagePO.reportsTaxReport);
     waitForSearchResults();
      Assert.assertTrue(homePagePO.TaxReportHeading.getText().contains("Tax Reports"),"Tax Reports");
       waitForElementClickable(homePagePO.adminTab,10);
         System.out.println("----In Admin Tab------");
      GenericMethods.elementClick(homePagePO.adminTab);
      waitForElementClickable(homePagePO.AdminConfigureModule,20);
      GenericMethods.mousehover(homePagePO.AdminConfigureModule);
      GenericMethods.mousehover(homePagePO.AdminCM_DropdownMgmt);
     waitForSearchResults();
      Assert.assertTrue(homePagePO.AdminCM_DropdownMgmtHeading.getText().contains("Manage Dropdowns"),"Manage Dropdowns");
     waitForElementClickable(homePagePO.calendarTab,30);
       System.out.println("-----In Calender Tab------");
       GenericMethods.elementClick(homePagePO.calendarTab);
     waitForSearchResults();
      Assert.assertTrue(homePagePO.CalenderHeading.getText().contains("Calendar"),"Calendar");
        waitForElementClickable(homePagePO.crmTab,30);
      System.out.println("------ Moving back to CRM Tab-----");
   GenericMethods.elementClick(homePagePO.crmTab);
     waitForSearchResults();
      Assert.assertTrue(homePagePO.CRMHeading.getText().contains("CRM"),"CRM");
      System.out.println(" User can Interchange Tabs across module Smoothly ");

    }
}

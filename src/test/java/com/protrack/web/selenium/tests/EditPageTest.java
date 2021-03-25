package com.protrack.web.selenium.tests;

import com.protrack.web.selenium.pages.AddProjectPO;
import com.protrack.web.selenium.pages.EditPagePO;
import com.protrack.web.selenium.pages.HomePagePO;
import com.protrack.web.selenium.utility.GenericMethods;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static com.protrack.web.selenium.tests.BaseClass.chromeDriver;
import static com.protrack.web.selenium.utility.GenericMethods.elementClick;
import static com.protrack.web.selenium.utility.GenericMethods.waitForElementClickable;
import static com.protrack.web.selenium.utility.ReadDataFromExcelFile.readExcel;
import static com.protrack.web.selenium.utility.Waits.waitForElement;

public class EditPageTest {
    AddProjectPO addProjectPO = new AddProjectPO(chromeDriver);
    EditPagePO editPagePO = new EditPagePO(chromeDriver);
    HomePagePO homePagePO = new HomePagePO(chromeDriver);



}

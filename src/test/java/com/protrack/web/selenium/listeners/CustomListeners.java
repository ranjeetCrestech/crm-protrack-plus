package com.protrack.web.selenium.listeners;

import com.protrack.web.selenium.utility.GenericMethods;
import org.testng.IExecutionListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


/* public class CustomListeners implements IExecutionListener {
    @Override
    public void onExecutionStart() {
    }
    @Override
    public void onExecutionFinish() {
    }

}*/

public class CustomListeners implements ITestListener{
    GenericMethods genericMethods = new GenericMethods();

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            //Getting the result name by .getTitle() method
            genericMethods.screenCapture();
            }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}

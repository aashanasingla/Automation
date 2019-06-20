package com.gojek;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Reporting implements ITestListener {

    public void onStart(ITestContext arg0) {
        System.out.println("+Begin test: " + arg0.getName());
    }

    public void onTestStart(ITestResult arg0) {
        System.out.println(" Starting test: " + arg0.getName());
    }

    public void onTestSuccess(ITestResult arg0) {
        System.out.println(" Test passed: " + arg0.getName());
    }

    public void onTestFailure(ITestResult arg0) {
        System.out.println(" Test failed: " + arg0.getName());
    }

    public void onTestSkipped(ITestResult arg0) {
        System.out.println(" Test ignored: " + arg0.getName());
    }

    public void onFinish(ITestContext arg0) {
        System.out.println("-End test: " + arg0.getName());
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

        // TODO Auto-generated method stub

    }
}

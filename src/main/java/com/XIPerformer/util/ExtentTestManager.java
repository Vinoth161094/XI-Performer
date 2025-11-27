package com.XIPerformer.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentReports extent = ExtentManager.getInstance();
        ExtentTest test = extent.createTest(testName, desc);
        extentTest.set(test);
        return getTest();
    }

    public static synchronized ExtentTest getTest() {
        return extentTest.get();
    }
}
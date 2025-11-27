package com.XIPerformer.util;

import java.text.SimpleDateFormat;

import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;
    private static String reportFileName = "TestReport.html";

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportFileName);
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
}
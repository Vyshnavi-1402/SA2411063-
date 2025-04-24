package com.APItests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseTest {
	public static ExtentReports extent;
    public static ExtentTest test;
   
    @BeforeSuite
    public void setUp() {
        extent = ExtenetManager.getReportInstance();
    }

    @AfterSuite
    public void tearDown() {
        extent.flush(); // generates the HTML report
    }
}

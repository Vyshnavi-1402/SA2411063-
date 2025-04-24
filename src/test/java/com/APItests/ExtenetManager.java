package com.APItests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtenetManager {
	 static ExtentReports extent;

	    public static ExtentReports getReportInstance() {
	        if (extent == null) {
	            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/API_Test_Report.html");
	            reporter.config().setReportName("API Automation Report");
	            reporter.config().setDocumentTitle("API Test Results");

	            extent = new ExtentReports();
	            extent.attachReporter(reporter);
	            extent.setSystemInfo("Tester", "Vyshnavi H K");
	        }
	        return extent;
	    }
}

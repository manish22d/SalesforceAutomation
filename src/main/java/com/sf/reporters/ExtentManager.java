package com.sf.reporters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {

            String workingDir = System.getProperty("user.dir");
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(workingDir + "\\Reports\\ExtentReportResults.html");
            extent = new ExtentReports();


            extent.setSystemInfo("Host Name", "Windows System");
            extent.setSystemInfo("User Name", "user");
            extent.setSystemInfo("Environment", "Automation Test Report");
            extent.attachReporter(htmlReporter);
        }
        return extent;
}
    }
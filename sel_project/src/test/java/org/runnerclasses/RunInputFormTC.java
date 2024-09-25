package org.runnerclasses;


import org.general.setup.GenericFunctions;
import org.openqa.selenium.WebDriver;
//import org.website.pages.InputFormPage;
import org.website.testcases.InputFormPageAllTestcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class RunInputFormTC {
	



	static WebDriver driver;
	static ExtentSparkReporter extentSparkReporter;
	static ExtentReports extentReports;
	static ExtentTest extentTest;
    

	public static void main(String[] args) {
		try {

			ClassLoader loader = ClassLoader.getSystemClassLoader();
			loader.setDefaultAssertionStatus(true);
			extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "/Test-Reports/ExtentReports/extentReport.html");
		    extentReports = new ExtentReports();
		    extentReports.attachReporter(extentSparkReporter);
			InputFormPageAllTestcases inputformTC = new InputFormPageAllTestcases();
			GenericFunctions genericFunctions = new GenericFunctions();
			driver = genericFunctions.createChromeDriver(driver);
			inputformTC.testCase1(driver, extentTest, extentReports);
			inputformTC.testcase2(driver,extentTest, extentReports);
			extentReports.flush();
			inputformTC.CloseDriver(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

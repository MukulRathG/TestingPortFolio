package org.runnerclasses;

import org.general.setup.GenericFunctions;
import org.openqa.selenium.WebDriver;
import org.website.pages.InputFormPage;
import org.website.testcases.*;

public class RunInputFormTC {
	static WebDriver driver;

	public static void main(String[] args) {
		try {

			ClassLoader loader = ClassLoader.getSystemClassLoader();
			loader.setDefaultAssertionStatus(true);

			
			// static InputFormPage inputFormpage;
			InputFormPageAllTestcases inputformTC = new InputFormPageAllTestcases();
//			InputFormPage inputFormPage = new InputFormPage(driver);
//            inputFormPage.readAllLocatorValuesForPage();
			GenericFunctions genericFunctions = new GenericFunctions();
			driver = genericFunctions.createChromeDriver(driver);
			inputformTC.testCase1(driver);
//			inputformTC.CloseDriver(driver);
			inputformTC.testcase2(driver);
			inputformTC.CloseDriver(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

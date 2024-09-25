package org.website.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.website.pages.InputFormPage;
import org.website.pages.ValidationResponseInputFormPage;
import org.general.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.general.setup.*;

public class InputFormPageAllTestcases implements IConst {
	// Create WebDriver and all pages including GenericFunctions as it is needed to
	// call required generic functions
	WebDriver driver;
	GenericFunctions genericFunctions = new GenericFunctions();
	InputFormPage inputFormpage;
	ValidationResponseInputFormPage validationResponseInputFormPage;


	// TC_1 -- Get all details of Page (heading/description of page/ Form heading /
	// Form purpose Paragraph)
//	public ExtentTe
	public void testCase1(WebDriver driver,ExtentTest extentTest, ExtentReports extentReports) {
		try {
			
			String methodName = new Exception().getStackTrace()[0].getMethodName();
			extentTest = extentReports.createTest(methodName, "To verify all details of Page");
			System.out.println("Test execution started : " + methodName);
			extentTest.log(Status.INFO, "Starting test to verify all details of Page");
			inputFormpage = new InputFormPage(driver);
			driver.get(inputFormPageURL);
			genericFunctions.maximizeWindow(driver);
			String expectedHeadingOfPage = "Input Validation Examples";
			String expectedParagraphOfPageDetails = "This page has input validation using JavaScript, HTML5 and there is associated server side validation. For exploratory testing, this page may have been coded with some bugs. For automating, it is a relatively simple form with a submission.";
			String expectedHeadingOfForm = "The Input Form";
			String expectedPurposeOfFormParagraph = "The information will be submitted to the server if it passes client side validation.";
			if (driver.getCurrentUrl().contains("input-validation.html")) {
				try {
					assert inputFormpage.getHeadingOfPage().equalsIgnoreCase(expectedHeadingOfPage)
							: "Heading of page was expected to be - " + expectedHeadingOfPage
									+ "\nbut it was found on page as - " + "\n" + inputFormpage.getHeadingOfPage();
					assert inputFormpage.getPageDetailsParagraph().equalsIgnoreCase(expectedParagraphOfPageDetails)
							: "Paragraph containing page details was expected to be - " + "\n"
									+ expectedParagraphOfPageDetails + "\nbut it was found on page as - " + "\n"
									+ inputFormpage.getPageDetailsParagraph();
					assert inputFormpage.getHeadingOfForm().equalsIgnoreCase(expectedHeadingOfForm)
							: "Heading of Form was expected to be - " + "\n" + expectedHeadingOfForm
									+ "\nbut was found to be on page as - " + "\n" + inputFormpage.getHeadingOfForm();
					assert inputFormpage.getPurposeOfFormParagraph().equalsIgnoreCase(expectedPurposeOfFormParagraph)
							: "Paragraph containing purpose of Form was expected to be - " + "\n"
									+ expectedPurposeOfFormParagraph + "\nbut was found on page to be -" + "\n"
									+ inputFormpage.getPurposeOfFormParagraph();
					String successMsg = "All Text Contents of page mentioned below are validated: \n1) Heading of Page \n2) Paragraph containing page details \n3) Heading of Form \n4) Purpose of Form paragraph";
					String reportSuccessMsg = "All Text Contents of page mentioned below are validated: "
							+ "1) Heading of Page "
							+ "2) Paragraph containing page details "
							+ "3) Heading of Form "
							+ "4) Purpose of Form paragraph";
					
					System.out.println(successMsg);
					extentTest.log(Status.PASS, reportSuccessMsg);
				} catch (AssertionError e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					extentTest.log(Status.FAIL, e.getMessage());
				}

			} else {
				String alertMsg = "Browser is redirecting to Wrong URL!";
				System.out.println(alertMsg);
				extentTest.log(Status.FAIL, alertMsg);
			}
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			extentTest.log(Status.FAIL, e.getLocalizedMessage());
		}
	}

	// Second Testcase would check for all the scenarios where the validation is
	// needed to be parameterized
	public void testcase2(WebDriver driver, ExtentTest extentTest, ExtentReports extentReports) throws IOException, InterruptedException {

		try {

			String methodName = new Exception().getStackTrace()[0].getMethodName();
			extentTest = extentReports.createTest(methodName, "To verify Various Input Data combinations");
			System.out.println("Test execution started : " + methodName);

			extentTest.log(Status.INFO, "Starting test to verify Various Input Data combinations");

			inputFormpage = new InputFormPage(driver);
			validationResponseInputFormPage = new ValidationResponseInputFormPage(driver);
			driver.get(inputFormPageURL);
			genericFunctions.maximizeWindow(driver);
			// Read values from TestData XLSX and give input then compare response with
			// expected response.
			for (int testCaseNum = 1; testCaseNum <= 14; testCaseNum++) {
				String testCaseID = genericFunctions.ReadCellData(InputFormTestDataWorkbookPath,
						InputFormTestDataWorkSheet, testCaseNum, 0);
				String validationRule = genericFunctions.ReadCellData(InputFormTestDataWorkbookPath,
						InputFormTestDataWorkSheet, testCaseNum, 1);
				String typeOfTestCase = genericFunctions.ReadCellData(InputFormTestDataWorkbookPath,
						InputFormTestDataWorkSheet, testCaseNum, 2);
				String firstNameData = genericFunctions.ReadCellData(InputFormTestDataWorkbookPath,
						InputFormTestDataWorkSheet, testCaseNum, 3);
				String lastNameData = genericFunctions.ReadCellData(InputFormTestDataWorkbookPath,
						InputFormTestDataWorkSheet, testCaseNum, 4);
				Double ageDataNumeric = genericFunctions.ReadNumericCellData(InputFormTestDataWorkbookPath,
						InputFormTestDataWorkSheet, testCaseNum, 5);
				String ageData = ageDataNumeric.toString();
				String countryData = genericFunctions.ReadCellData(InputFormTestDataWorkbookPath,
						InputFormTestDataWorkSheet, testCaseNum, 6);
				String notesData = genericFunctions.ReadCellData(InputFormTestDataWorkbookPath,
						InputFormTestDataWorkSheet, testCaseNum, 7);
				String expectedValidationReport = genericFunctions.ReadCellData(InputFormTestDataWorkbookPath,
						InputFormTestDataWorkSheet, testCaseNum, 8);
				String expectedValidationMessage = genericFunctions.ReadCellData(InputFormTestDataWorkbookPath,
						InputFormTestDataWorkSheet, testCaseNum, 9);

				// Input all values
				if (firstNameData.equals("NULL")) {
					firstNameData = "";
				}

				inputFormpage.EnterFirstName(firstNameData);
				inputFormpage.EnterLastName(lastNameData);
				inputFormpage.EnterAge(ageData);
				inputFormpage.EnterCountry(countryData);
				inputFormpage.EnterNotes(notesData);
				inputFormpage.clickSubmitButton();
				
				extentTest.log(Status.INFO, "Input Data for : "+testCaseID);
				extentTest.log(Status.INFO, "FirstName Value : "+firstNameData);
				extentTest.log(Status.INFO, "LastName Value : "+lastNameData);
				extentTest.log(Status.INFO, "Age Value :"+ageData);
				extentTest.log(Status.INFO, "Country Value :"+countryData);
				extentTest.log(Status.INFO, "Notes Value :"+notesData);
	
				Thread.sleep(6000);

				// checking the expected output and marking as pass/fail
				try {
					if (driver.findElement(By.xpath("/html/body/h2")).isDisplayed()) {
						if (driver.findElement(By.xpath("/html/body/h2")).getText()
								.equals("500 Internal Server Error")) {
							genericFunctions.TakeScreenshotSaveInFile(driver, extentTest, testCaseID);
							String failMsg = "Failed Validating this Testcase: " + testCaseID;
							System.out.println(failMsg);
							extentTest.log(Status.FAIL, failMsg);
							driver.get(inputFormPageURL);
							continue;
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					if (expectedValidationReport.contains("Warning")) {
						// Take Screenshot of page and save it under Test-Reports
						genericFunctions.TakeScreenshotSaveInFile(driver, extentTest, testCaseID);
						String successMsg = "Validated for the following testCaseID: " + testCaseID;
						System.out.println(successMsg);
						extentTest.log(Status.PASS, successMsg);
						driver.navigate().refresh();
						Thread.sleep(4000);
					} else if (expectedValidationReport.contains("Label")) {
						if (inputFormpage.checkFirstNameValidatorLabelVisible(driver)) {
							assert inputFormpage.getFirstNameValidatorLabelMessage(driver)
									.equalsIgnoreCase(expectedValidationMessage)
									: "Expected Validator Label Text was -" + "\n" + expectedValidationMessage + "\n"
											+ "but found to be - \n"
											+ inputFormpage.getFirstNameValidatorLabelMessage(driver);
							genericFunctions.TakeScreenshotSaveInFile(driver, extentTest, testCaseID);
							String successMsg = "Validated for the following testCaseID: " + testCaseID;
							System.out.println(successMsg);
							extentTest.log(Status.PASS, successMsg);
							driver.navigate().refresh();
							Thread.sleep(4000);
						} else {
							assert inputFormpage.getLastNameValidatorLabelMessage(driver)
									.equalsIgnoreCase(expectedValidationMessage)
									: "Expected Validator Label Text was -" + "\n" + expectedValidationMessage + "\n"
											+ "but found to be - \n"
											+ inputFormpage.getLastNameValidatorLabelMessage(driver);
							genericFunctions.TakeScreenshotSaveInFile(driver, extentTest, testCaseID);
							String successMsg = "Validated for the following testCaseID: " + testCaseID;
							System.out.println(successMsg);
							extentTest.log(Status.PASS, successMsg);
//							ExtentTestRealManager.getTest().log(LogStatus.PASS, successMsg);
//							validationResponseInputFormPage.clickBackToFormLink();
							driver.navigate().refresh();
							Thread.sleep(4000);
						}
					} else {
						if (validationResponseInputFormPage.checkValidInputHeadingVisible(driver)) {
							assert validationResponseInputFormPage.getValidInputMessage()
									.equals(expectedValidationMessage)
									: "Expected Validation Message was -" + "\n" + expectedValidationMessage + "\n"
											+ "but found to be - \n"
											+ validationResponseInputFormPage.getValidInputMessage();
							genericFunctions.TakeScreenshotSaveInFile(driver, extentTest, testCaseID);
							String successMsg = "Validated for the following testCaseID: " + testCaseID;
							System.out.println(successMsg);
							extentTest.log(Status.PASS, successMsg);
//							ExtentTestRealManager.getTest().log(LogStatus.PASS, successMsg);
							System.out.println(validationResponseInputFormPage.getUserInputHeading());
							System.out.println(validationResponseInputFormPage.getuserInputFirstNameHeading() + " - "
									+ validationResponseInputFormPage.getuserInputFirstNameValue());
							System.out.println(validationResponseInputFormPage.getuserInputLastNameHeading() + " - "
									+ validationResponseInputFormPage.getuserInputLastNameValue());
							System.out.println(validationResponseInputFormPage.getuserInputAgeHeading() + " - "
									+ validationResponseInputFormPage.getuserInputAgeValue());
							System.out.println(validationResponseInputFormPage.getuserInputCountryHeading() + " - "
									+ validationResponseInputFormPage.getuserInputCountryValue());
							System.out.println(validationResponseInputFormPage.getuserInputNotesHeading() + " - "
									+ validationResponseInputFormPage.getuserInputNotesValue());
							validationResponseInputFormPage.clickBackToFormLink();
							Thread.sleep(4000);

						} else {
							assert validationResponseInputFormPage.getFirstNameErrorMessage(driver)
									.equals(expectedValidationMessage)
									: "Expected Validation Message was -" + "\n" + expectedValidationMessage + "\n"
											+ "but found to be - \n"
											+ validationResponseInputFormPage.getFirstNameErrorMessage(driver);
							genericFunctions.TakeScreenshotSaveInFile(driver, extentTest, testCaseID);
							String successMsg = "Validated for the following testCaseID: " + testCaseID;
							System.out.println(successMsg);
							extentTest.log(Status.PASS, successMsg);
//							ExtentTestRealManager.getTest().log(LogStatus.PASS, successMsg);
							System.out.println(validationResponseInputFormPage.getUserInputHeading());
							System.out.println(validationResponseInputFormPage.getuserInputFirstNameHeading() + " - "
									+ validationResponseInputFormPage.getuserInputFirstNameValue());
							System.out.println(validationResponseInputFormPage.getuserInputLastNameHeading() + " - "
									+ validationResponseInputFormPage.getuserInputLastNameValue());
							System.out.println(validationResponseInputFormPage.getuserInputAgeHeading() + " - "
									+ validationResponseInputFormPage.getuserInputAgeValue());
							System.out.println(validationResponseInputFormPage.getuserInputCountryHeading() + " - "
									+ validationResponseInputFormPage.getuserInputCountryValue());
							System.out.println(validationResponseInputFormPage.getuserInputNotesHeading() + " - "
									+ validationResponseInputFormPage.getuserInputNotesValue());
							validationResponseInputFormPage.clickBackToFormLink();
							Thread.sleep(4000);
						}
					}
				}

			}
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			genericFunctions.TakeScreenshotSaveInFile(driver, extentTest, e.getMessage());
			System.out.println(e.getMessage());
			extentTest.log(Status.FAIL, e.getMessage());

		} catch (Exception e) {
			genericFunctions.TakeScreenshotSaveInFile(driver, extentTest, e.getLocalizedMessage());
			e.printStackTrace();
			extentTest.log(Status.FAIL, e.getLocalizedMessage());
		}
	}

	// Method to be called to close the browser instance completely with all Tabs
	public void CloseDriver(WebDriver driver) {
		System.out.println("All Test Executions Completed, closing browser!");
		driver.quit();
	}

}

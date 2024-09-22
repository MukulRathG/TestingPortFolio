package org.website.pages;

import java.io.IOException;

import org.general.setup.GenericFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.pages.configDataLoaders.ValidationResponseInputFormPageDataLoader;

public class ValidationResponseInputFormPage extends ValidationResponseInputFormPageDataLoader {

	WebDriver driver;

	GenericFunctions genericfunctions = new GenericFunctions();

	// This constructor creates a WebDriver object automatically
	public ValidationResponseInputFormPage(WebDriver driver) throws IOException {
		this.driver = driver;
	}

	public By headingOfPage = By.xpath(headingOfPageLocatorValue);
	public By headingOfReport = By.xpath(headingOfReportLocatorValue);
	public By headingOfValidInput = By.id(headingOfValidInputLocatorValue);
	public By validInputMessage = By.id(validInputMessageLocatorValue);
	public By userInputHeading = By.xpath(userInputHeadingLocatorValue);
	public By userInputFirstNameHeading = By.id(userInputFirstNameHeadingLocatorValue);
	public By userInputFirstNameValue = By.id(userInputFirstNameValueLocatorValue);
	public By userInputLastNameHeading = By.id(userInputLastNameHeadingLocatorValue);
	public By userInputLastNameValue = By.id(userInputLastNameValueLocatorValue);
	public By userInputAgeHeading = By.id(userInputAgeHeadingLocatorValue);
	public By userInputAgeValue = By.id(userInputAgeValueLocatorValue);
	public By userInputCountryHeading = By.id(userInputCountryHeadingLocatorValue);
	public By userInputCountryValue = By.id(userInputCountryValueLocatorValue);
	public By userInputNotesHeading = By.id(userInputNotesHeadingLocatorValue);
	public By userInputNotesValue = By.id(userInputNotesValueLocatorValue);
	public By indexLink = By.linkText(indexLinkLocatorValue);
	public By backToFormLink = By.id(backToInputFormLinkLocatorValue);
	public By firstNameErrorHeadingElement = By.id(firstNameErrorHeading);
	public By firstNameErrorMessageElement = By.id(firstNameErrorValue);

	public void clickIndexLink() {
		driver.findElement(indexLink).click();
	}

	public void clickBackToFormLink() {
		driver.findElement(backToFormLink).click();
	}

	public String getHeadingOfPage() {
		String headingPage = driver.findElement(headingOfPage).getText();
		return headingPage;
	}

	public String getHeadingOfReport() {
		return driver.findElement(headingOfReport).getText();
	}
	public String getHeadingOfValidInput() {
		return driver.findElement(headingOfValidInput).getText();
	}
	public String getValidInputMessage() {
		return driver.findElement(validInputMessage).getText();
	}
	public String getUserInputHeading() {
		return driver.findElement(userInputHeading).getText();
	}
	public String getuserInputFirstNameHeading() {
		return driver.findElement(userInputFirstNameHeading).getText();
	}
	public String getuserInputFirstNameValue() {
		return driver.findElement(userInputFirstNameValue).getText();
	}
	public String getuserInputLastNameHeading() {
		return driver.findElement(userInputLastNameHeading).getText();
	}
	public String getuserInputLastNameValue() {
		return driver.findElement(userInputLastNameValue).getText();
	}
	public String getuserInputAgeHeading() {
		return driver.findElement(userInputAgeHeading).getText();
	}
	public String getuserInputAgeValue() {
		return driver.findElement(userInputAgeValue).getText();
	}
	public String getuserInputCountryHeading() {
		return driver.findElement(userInputCountryHeading).getText();
	}
	public String getuserInputCountryValue() {
		return driver.findElement(userInputCountryValue).getText();
	}
	public String getuserInputNotesHeading() {
		return driver.findElement(userInputNotesHeading).getText();
	}
	public String getuserInputNotesValue() {
		return driver.findElement(userInputNotesValue).getText();
	}
	
	public boolean checkValidInputHeadingVisible(WebDriver driver) {
		return driver.findElement(headingOfValidInput).isDisplayed();
	}

	public boolean checkFirstNameErrorHeadingVisible(WebDriver driver) {
		return driver.findElement(firstNameErrorHeadingElement).isDisplayed();
	}
	
	public String getFirstNameErrorMessage(WebDriver driver) {
		return driver.findElement(firstNameErrorMessageElement).getText();
	}
	
	
}

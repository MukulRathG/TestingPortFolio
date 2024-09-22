package org.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.pages.configDataLoaders.InputFormPageDataLoader;

import java.io.IOException;

import org.general.setup.GenericFunctions;
import org.general.setup.IConst;

public class InputFormPage extends InputFormPageDataLoader implements IConst {

	WebDriver driver;
	

	GenericFunctions genericfunctions = new GenericFunctions();

	// This constructor creates a WebDriver object automatically
	public InputFormPage(WebDriver driver) throws IOException {
		this.driver = driver;
		

	}
	


	// Identify all the elements in the page and interactions possible in the page
	By headingOfPage = By.xpath(inputFormheadingOfPageLocatorValue);

	By pageDetailsParagraph = By.xpath(inputFormpageDetailsParagraphLocatorValue);

	By headingOfForm = By.xpath(inputFormheadingOfFormLocatorValue);

	By purposeOfFormParagraph = By.xpath(inputFormpurposeOfFormParagraphLocatorValue);

	public By firstNameValidationLabel = By.name(firstNameValidationLabelLocatorValue);
	public By lastNameValidationLabel = By.name(lastNameValidationLabelLocatorValue);
	
	
	
	public By firstName = By.id(inputFormfirstNameLocatorValue);
	public By lastName = By.id(inputFormlastNameLocatorValue);
	public By age = By.id(inputFormageLocatorValue);

	public By countryDropdown = By.id(inputFormcountryDropdownLocatorValue);

	public By notesTextArea = By.id(inputFormnotesTextAreaLocatorValue);

	public void clickSubmitButton() {
		driver.findElement(By.xpath(inputFormsubmitButtonLocatorValue)).click();
	}

	public void clickIndexLink() {
		driver.findElement(By.linkText(inputFormindexLinkLocatorValue)).click();
	}

	public void clickAboutLink() {
		driver.findElement(By.linkText(inputFormaboutLinkLocatorValue)).click();
	}

	public String getHeadingOfPage() {
		String headingPage = driver.findElement(headingOfPage).getText();
		return headingPage;
	}

	public String getPageDetailsParagraph() {
		String pageDetails = driver.findElement(pageDetailsParagraph).getText();
		return pageDetails;
	}

	public String getHeadingOfForm() {
		String headingForm = driver.findElement(headingOfForm).getText();
		return headingForm;
	}

	public String getPurposeOfFormParagraph() {
		String purposeOfForm = driver.findElement(purposeOfFormParagraph).getText();
		return purposeOfForm;
	}
	
	public void EnterFirstName(String firstNameValue) {
		driver.findElement(this.firstName).sendKeys(firstNameValue);
	}
	
	public void EnterLastName(String lastNameValue) {
		driver.findElement(this.lastName).sendKeys(lastNameValue);
	}
	
	public void EnterAge(String ageValue) {
		driver.findElement(this.age).sendKeys(ageValue);
	}
	
	public void EnterCountry(String countryValue) {
		Select countrySelect =new Select(driver.findElement(this.countryDropdown));
		countrySelect.selectByVisibleText(countryValue);
	}
	
	public void EnterNotes(String notesValue) {
		driver.findElement(this.notesTextArea).sendKeys(notesValue);
	}
	
	public boolean checkFirstNameValidatorLabelVisible(WebDriver driver) {
		return driver.findElement(firstNameValidationLabel).isDisplayed();
	}
	
	public String getFirstNameValidatorLabelMessage(WebDriver driver) {
		return driver.findElement(firstNameValidationLabel).getText();
	}
	
	public boolean checkLastNameValidatorLabelVisible(WebDriver driver) {
		return driver.findElement(lastNameValidationLabel).isDisplayed();
	}
	
	public String getLastNameValidatorLabelMessage(WebDriver driver) {
		return driver.findElement(lastNameValidationLabel).getText();
	}

}

package org.pages.configDataLoaders;

import java.io.IOException;

import org.general.setup.GenericFunctions;
import org.general.setup.IConst;

public class ValidationResponseInputFormPageDataLoader implements IConst {

	GenericFunctions genericFunctions = new GenericFunctions();

	// All Locator Values initialization
	protected String headingOfPageLocatorValue;
	protected String headingOfReportLocatorValue;
	protected String headingOfValidInputLocatorValue;
	protected String validInputMessageLocatorValue;
	protected String userInputHeadingLocatorValue;
	protected String userInputFirstNameHeadingLocatorValue;
	protected String userInputFirstNameValueLocatorValue;
	protected String userInputLastNameHeadingLocatorValue;
	protected String userInputLastNameValueLocatorValue;
	protected String userInputAgeHeadingLocatorValue;
	protected String userInputAgeValueLocatorValue;
	protected String userInputCountryHeadingLocatorValue;
	protected String userInputCountryValueLocatorValue;
	protected String userInputNotesHeadingLocatorValue;
	protected String userInputNotesValueLocatorValue;
	protected String indexLinkLocatorValue;
	protected String backToInputFormLinkLocatorValue;
	protected String firstNameErrorHeading;
	protected String firstNameErrorValue;
	
	public ValidationResponseInputFormPageDataLoader() throws IOException {
		LoadAllConfigDataFromExcel();
	}

	public void LoadAllConfigDataFromExcel() throws IOException {
		headingOfPageLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 1, 2);
		headingOfReportLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 2, 2);
		headingOfValidInputLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 3, 2);
		validInputMessageLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 4, 2);
		userInputHeadingLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 5, 2);
		userInputFirstNameHeadingLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 6, 2);
		userInputFirstNameValueLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 7, 2);
		userInputLastNameHeadingLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 8, 2);
		userInputLastNameValueLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 9, 2);
		userInputAgeHeadingLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 10, 2);
		userInputAgeValueLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 11, 2);
		userInputCountryHeadingLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 12, 2);
		userInputCountryValueLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 13, 2);
		userInputNotesHeadingLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 14, 2);
		userInputNotesValueLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 15, 2);
		indexLinkLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 16, 2);
		backToInputFormLinkLocatorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 17, 2);
		firstNameErrorHeading = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 18, 2);
		firstNameErrorValue = genericFunctions.ReadCellData(ValidationResponseExcelWorkbookPath,
				ValidationResponseExcelWorksheet, 19, 2);
	}

}

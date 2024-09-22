package org.pages.configDataLoaders;

import java.io.IOException;

import org.general.setup.GenericFunctions;
import org.general.setup.IConst;

public class InputFormPageDataLoader implements IConst {

	// Input Form Page Locators Values initialization
		protected String inputFormheadingOfPageLocatorValue;
		protected String inputFormpageDetailsParagraphLocatorValue;
		protected String inputFormheadingOfFormLocatorValue;
		protected String inputFormpurposeOfFormParagraphLocatorValue;
		protected String inputFormfirstNameLocatorValue;
		protected String inputFormlastNameLocatorValue;
		protected String inputFormageLocatorValue;
		protected String inputFormcountryDropdownLocatorValue;
		protected String inputFormnotesTextAreaLocatorValue;
		protected String inputFormsubmitButtonLocatorValue;
		protected String inputFormindexLinkLocatorValue;
		protected String inputFormaboutLinkLocatorValue;
		protected String firstNameValidationLabelLocatorValue;
		protected String lastNameValidationLabelLocatorValue;
		
		GenericFunctions genericfunctions = new GenericFunctions();
		
		public void LoadInputFormPageLocatorValues() throws IOException {
			inputFormheadingOfPageLocatorValue = genericfunctions.ReadCellData(inputFormPageConfigExcelWorkbookPath,
					inputFormPageConfigExcelWorkSheet, 1, 2);
			inputFormpageDetailsParagraphLocatorValue = genericfunctions.ReadCellData(inputFormPageConfigExcelWorkbookPath,
					inputFormPageConfigExcelWorkSheet, 2, 2);
			inputFormheadingOfFormLocatorValue = genericfunctions.ReadCellData(inputFormPageConfigExcelWorkbookPath,
					inputFormPageConfigExcelWorkSheet, 3, 2);
			inputFormpurposeOfFormParagraphLocatorValue = genericfunctions.ReadCellData(inputFormPageConfigExcelWorkbookPath,
					inputFormPageConfigExcelWorkSheet, 4, 2);
			inputFormfirstNameLocatorValue = genericfunctions.ReadCellData(inputFormPageConfigExcelWorkbookPath,
					inputFormPageConfigExcelWorkSheet, 5, 2);
			inputFormlastNameLocatorValue = genericfunctions.ReadCellData(inputFormPageConfigExcelWorkbookPath,
					inputFormPageConfigExcelWorkSheet, 6, 2);
			inputFormageLocatorValue = genericfunctions.ReadCellData(inputFormPageConfigExcelWorkbookPath,
					inputFormPageConfigExcelWorkSheet, 7, 2);
			inputFormcountryDropdownLocatorValue = genericfunctions.ReadCellData(inputFormPageConfigExcelWorkbookPath,
					inputFormPageConfigExcelWorkSheet, 8, 2);
			inputFormnotesTextAreaLocatorValue = genericfunctions.ReadCellData(inputFormPageConfigExcelWorkbookPath,
					inputFormPageConfigExcelWorkSheet, 9, 2);
			inputFormsubmitButtonLocatorValue = genericfunctions.ReadCellData(inputFormPageConfigExcelWorkbookPath,
					inputFormPageConfigExcelWorkSheet, 10, 2);
			inputFormindexLinkLocatorValue = genericfunctions.ReadCellData(inputFormPageConfigExcelWorkbookPath,
					inputFormPageConfigExcelWorkSheet, 11, 2);
			inputFormaboutLinkLocatorValue = genericfunctions.ReadCellData(inputFormPageConfigExcelWorkbookPath,
					inputFormPageConfigExcelWorkSheet, 12, 2);
			firstNameValidationLabelLocatorValue = genericfunctions.ReadCellData(inputFormPageConfigExcelWorkbookPath,
					inputFormPageConfigExcelWorkSheet, 13, 2);
			lastNameValidationLabelLocatorValue = genericfunctions.ReadCellData(inputFormPageConfigExcelWorkbookPath,
					inputFormPageConfigExcelWorkSheet, 14, 2);
		}
		
		public InputFormPageDataLoader() throws IOException {
			LoadInputFormPageLocatorValues();
		}
}

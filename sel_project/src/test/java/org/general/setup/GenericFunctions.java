package org.general.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericFunctions implements IConst {

	public WebDriver createChromeDriver(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		return driver;
	}

	public String ReadCellData(String ExcelPath, String SheetName, int vRow, int vColumn) throws IOException {
		FileInputStream file = new FileInputStream(ExcelPath);

		// Create Workbook instance holding reference to
		// .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheet(SheetName);
		XSSFRow row = sheet.getRow(vRow);
		XSSFCell cell = row.getCell(vColumn);
		String value = cell.getStringCellValue();

		return value;
	}
	
	public Double ReadNumericCellData(String ExcelPath, String SheetName, int vRow, int vColumn) throws IOException {
		FileInputStream file = new FileInputStream(ExcelPath);

		// Create Workbook instance holding reference to
		// .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheet(SheetName);
		XSSFRow row = sheet.getRow(vRow);
		XSSFCell cell = row.getCell(vColumn);
		Double value = cell.getNumericCellValue();

		return value;
	}
	
	
	public void TakeScreenshotSaveInFile(WebDriver driver,String screenshotName) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm");  
		LocalDateTime now = LocalDateTime.now();
		String currentTimeStamp = dtf.format(now);
		//Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(ScreenshotFolderPath+"\\"+screenshotName+currentTimeStamp+".png"));
        
	}

}

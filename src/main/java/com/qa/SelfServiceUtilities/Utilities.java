package com.qa.SelfServiceUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import IES_TestBaseClass.SelfServiceBaseClass;

public class Utilities extends SelfServiceBaseClass {
	Select select;
	public static long Page_Load = 30;
	public static long Implicit_Time = 20;
	static String value;
	public static String TESTDATA_SHEET_PATH = "E:/IES Validation Data/IESDevData.xlsx";
	public static String TESTDATA_SHEET_PATH1 = "E:/IES Validation Data/IESProdData.xlsx";
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static DataFormatter formatter = new DataFormatter();
	// public static Workbook book;
	// public static Sheet sheet;

	////////// Logout/////////////////////
	@FindBy(id = "aLogoutD")
	WebElement logout;
	
	////////////////// Chat Box//////////////////////////

	@FindBy(xpath = "//div[@class='meshim_widget_widgets_IconFont icon_font close']")
	static WebElement close;

	public Utilities() {

		PageFactory.initElements(driver, this);
	}

	////////////////////// LiveChat////////////////////////
	public static void LiveChatSupport() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]//iframe[1]")));
			driver.switchTo().frame(driver.findElement(By.xpath("//div[2]//iframe[1]")));
			close.click();
			driver.switchTo().defaultContent();
		} catch (Throwable e) {
			// TODO: handle exception
		}
	}

	///////////// IES logout//////////
	public void IES_logout() {
		jse.executeScript("arguments[0].style.border='3px solid red'", logout);
		jse.executeScript("arguments[0].click();", logout);
	}

	public static void getScreenshot() throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
	}

	public static Object[][] getTestData(String sheetName) throws Exception {
		FileInputStream file = null;
		if (wso.getRow(1).getCell(18).getStringCellValue().trim().equalsIgnoreCase("Dev")) {
			try {

				file = new FileInputStream(TESTDATA_SHEET_PATH);

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			}
		} else if (wso.getRow(1).getCell(18).getStringCellValue().trim().equalsIgnoreCase("Prod")) {
			try {

				file = new FileInputStream(TESTDATA_SHEET_PATH1);

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			}

		}
		try {

			workbook = new XSSFWorkbook(file);

		} catch (IOException e2) {

			e2.printStackTrace();

		}
		worksheet = workbook.getSheet(sheetName);
		XSSFRow Row = worksheet.getRow(0); // get my Row which start from 0

		int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
		int ColNum = Row.getLastCellNum(); // get last ColNum

		Object Data[][] = new Object[RowNum - 1][ColNum]; // pass my count data in array

		for (int i = 0; i < RowNum - 1; i++) // Loop work for Rows
		{
			XSSFRow row = worksheet.getRow(i + 1);

			for (int j = 0; j < ColNum; j++) // Loop work for colNum
			{
				if (row == null)
					Data[i][j] = "";
				else {
					XSSFCell cell = row.getCell(j);
					if (cell == null)
						Data[i][j] = ""; // if it get Null value it pass no data
					else {
						String value = formatter.formatCellValue(cell);
						Data[i][j] = value; // This formatter get my all values as string i.e integer, float all type
											// data value
					}
				}
			}
		}
		// sheet = book.getSheet(sheetName);
		//
		// Object[][] data = new
		// Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//
		// for (int i = 0; i < sheet.getLastRowNum(); i++) {
		// Row row = sheet.getRow(i + 1);
		// if (row == null) {
		// // This whole row is empty
		// // Handle it as needed
		// continue;
		// }
		//
		// for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
		//
		// Cell cell = row.getCell(k);
		// // Cell cell = row.getCell(k, Row.RETURN_BLANK_AS_NULL);
		//
		// if (cell == null) {
		//
		// // The spreadsheet is empty in this cell
		//
		// value = "";
		// } else {
		// // Do something useful with the cell's contents
		// try {
		// value = cell.getRichStringCellValue().toString();
		// } catch (Exception e) {
		// value = ((XSSFCell) cell).getRawValue();
		// }
		//
		// }
		//
		// data[i][k] = value;
		//
		// // System.out.println(data[i][k]);
		//
		// }
		//
		// }

		return Data;

	}

}

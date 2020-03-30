package com.qa.SelfServiceUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.TestClasses.SelfServiceDependentTest;

import IES_TestBaseClass.BaseClass;

public class WriteSelfServiceDependent extends BaseClass {

	public static String TESTDATA_SHEET_PATH = "E:/IES Validation Data/IESDevData.xlsx";
	public static String TESTDATA_SHEET_PATH1 = "E:/IES Validation Data/IESProdData.xlsx";
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public String ColName = "Status";
	public int col_num;

	public void WriteResultDependent(String Ress, int DR) throws FileNotFoundException {
		// file_input_stream = new FileInputStream("E:/IES Validation
		// Data/IESDevData.xlsx");
		FileInputStream file_input_stream = null;
		if (wso.getRow(1).getCell(18).getStringCellValue().trim().equalsIgnoreCase("Dev")) {
			try {

				file_input_stream = new FileInputStream(TESTDATA_SHEET_PATH);

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			}
		} else if (wso.getRow(1).getCell(18).getStringCellValue().trim().equalsIgnoreCase("Prod")) {
			try {

				file_input_stream = new FileInputStream(TESTDATA_SHEET_PATH1);

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			}

		}
		try {
			workbook = new XSSFWorkbook(file_input_stream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		worksheet = workbook.getSheet(SelfServiceDependentTest.sheetName);
		XSSFRow Row = worksheet.getRow(0);
		int sheetIndex = workbook.getSheetIndex(SelfServiceDependentTest.sheetName);
		DataFormatter formatter = new DataFormatter();
		if (sheetIndex == -1) {
			System.out.println("No such sheet in file exists");

		} else {
			col_num = -1;
			for (int i = 0; i < Row.getLastCellNum(); i++) {
				XSSFCell cols = Row.getCell(i);

				String colsval = formatter.formatCellValue(cols);
				if (colsval.trim().equalsIgnoreCase(ColName.trim())) {
					col_num = i;

					break;
				}
			}
			Row = worksheet.getRow(DR);
			try {
				// get my Row which is equal to Data  Result and that colNum
				XSSFCell cell = worksheet.getRow(DR).getCell(col_num);
				// if no cell found then it create cell
				if (cell == null) {
					cell = Row.createCell(col_num);
				}

				// Set Result is pass in that cell number
				cell.setCellValue(Ress);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		FileOutputStream file_output_stream = null;
		// file_output_stream = new FileOutputStream("E:/IES Validation
		// Data/IESDevData.xlsx");
		if (wso.getRow(1).getCell(18).getStringCellValue().trim().equalsIgnoreCase("Dev")) {
			try {

				file_output_stream = new FileOutputStream(TESTDATA_SHEET_PATH);

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			}
		} else if (wso.getRow(1).getCell(18).getStringCellValue().trim().equalsIgnoreCase("Prod")) {
			try {

				file_output_stream = new FileOutputStream(TESTDATA_SHEET_PATH1);

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			}

		}
		try {
			workbook.write(file_output_stream);
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			file_output_stream.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		if (col_num == -1) {
			System.out.println("Column you are searching for does not exist");
		}

	}

}

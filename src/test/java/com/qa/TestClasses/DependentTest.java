package com.qa.TestClasses;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.PageClasses.CaseAndLocationPage;
import com.qa.PageClasses.DependentPage;
import com.qa.PageClasses.LoginPage;
import com.qa.Utilities.Utilities;

import IES_TestBaseClass.BaseClass;

public class DependentTest extends BaseClass {
	Logger log = Logger.getLogger(DependentTest.class);
	LoginPage loginpage;
	CaseAndLocationPage CaseLocation;
	Utilities utility;
	DependentPage dependent;
	public static String sheetName = "Dependent";

	public DependentTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		log.info(
				"****************************** Starting test cases for the execution of Dependent Page  *****************************************");
		initialization();
		loginpage = new LoginPage();
		dependent = new DependentPage();
		log.info("****************************** login into the application *****************************************");
		loginpage.IES_login();
		CaseLocation = new CaseAndLocationPage();
		utility = new Utilities();
		log.info(
				"****************************** Selecting the Case and location *****************************************");
		try {
			CaseLocation.IES_CaseAndLocation();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@DataProvider

	public Object[][] getDependentTestData() {

		Object data[][] = Utilities.getTestData(sheetName);

		return data;
	}

	@Test(dataProvider = "getDependentTestData")
	public void IESDependentAddition(String SrNo,String FirstName, String MiddleName, String LastName, String SSN,
			String Date_of_Birth, String Cell_Phone, String HeightFeet_dependent, String HeightInch_dependent,
			String Weight_dependent, String Gender_dependent, String Relation_dependent, String Tobaco_dependent, String Status) throws InterruptedException {
		log.info(
				"****************************** Doing Activity on the Dependent Page *****************************************");
		try {
			dependent.Dependent_Addition(SrNo,FirstName, MiddleName, LastName, SSN, Date_of_Birth, Cell_Phone,
					HeightFeet_dependent, HeightInch_dependent, Weight_dependent, Gender_dependent, Relation_dependent,Tobaco_dependent, Status);
		} catch (Throwable e) {
			//
		}
	}

	@AfterMethod
	public void teardown() throws InterruptedException, IOException {
		log.info(
				"****************************** Clicking on logout button after the action on Demographic Page *****************************************");
		Thread.sleep(2000);
		utility.IES_logout();
		try {
			if (driver.getCurrentUrl().equals(wso.getRow(1).getCell(1).getStringCellValue().trim())) {
				driver.quit();
			}
		} catch (Throwable e) {
			driver.quit();

		}
		log.info("****************************** Browser is closed *****************************************");
	}

}

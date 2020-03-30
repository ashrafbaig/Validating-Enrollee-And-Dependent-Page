package com.qa.TestClasses;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.PageClasses.SelfServiceCaseAndLocationPage;
import com.qa.PageClasses.SelfServiceDependentPage;
import com.qa.PageClasses.SelfServiceEnrolleePage;
import com.qa.PageClasses.SelfServiceLoginPage;
import com.qa.SelfServiceUtilities.Utilities;

import IES_TestBaseClass.SelfServiceBaseClass;

public class SelfServiceEnrolleeTest extends SelfServiceBaseClass {
	Logger log = Logger.getLogger(SelfServiceEnrolleeTest.class);
	SelfServiceLoginPage loginpage;
	SelfServiceCaseAndLocationPage CaseLocation;
	Utilities utility;
	SelfServiceDependentPage dependent;
	SelfServiceEnrolleePage enrollee;
	public static String sheetName = "Enrollee";

	public SelfServiceEnrolleeTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		log.info(
				"****************************** Starting test cases for the execution of Enrollee Page  *****************************************");
		initialization();
		loginpage = new SelfServiceLoginPage();
		log.info("****************************** login into the application *****************************************");
		loginpage.IES_login();
		enrollee = new SelfServiceEnrolleePage();
		CaseLocation = new SelfServiceCaseAndLocationPage();
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

	public Object[][] getEnrolleeTestData() throws Exception {

		Object data[][] = Utilities.getTestData(sheetName);

		return data;
	}

	@Test(dataProvider = "getEnrolleeTestData")
	public void IESProductAddition(String SrNo, String FirstName, String MiddleName, String LastName, String Address,
			String Address_2, String City_enrolle, String Zip_Code__enrolle, String SSN, String Date_of_Birth,
			String Cell_Phone, String Email, String HeightFeet_enrolle, String HeightInch_enrolle,
			String Weight_enrolle, String Date_of_Hire, String Employee_Id, String Occupation_enrolle,
			String Annual_Salary, String Business_Unit_Department_Number, String HourlyIncome, String State_enrolle,
			String CitizenshipCountry_enrolle, String StateofEnrollment_enrolle, String Gender_enrolle,
			String Location_enrolle, String MemberStatus_enrolle, String PayFrequency_enrolle, String Tobaco_enrolle,
			String Status) throws InterruptedException {
		log.info(
				"****************************** Doing Activity on the Demographic Page *****************************************");
		try {
			dependent = enrollee.Enrolle_Addition(SrNo, FirstName, MiddleName, LastName, Address, Address_2,
					City_enrolle, Zip_Code__enrolle, SSN, Date_of_Birth, Cell_Phone, Email, HeightFeet_enrolle,
					HeightInch_enrolle, Weight_enrolle, Date_of_Hire, Employee_Id, Occupation_enrolle, Annual_Salary,
					Business_Unit_Department_Number, HourlyIncome, State_enrolle, CitizenshipCountry_enrolle,
					StateofEnrollment_enrolle, Gender_enrolle, Location_enrolle, MemberStatus_enrolle,
					PayFrequency_enrolle, Tobaco_enrolle, Status);
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
			if (driver.getCurrentUrl().equals(wso.getRow(1).getCell(2).getStringCellValue().trim())) {
				driver.quit();
			}
		} catch (Throwable e) {
			driver.quit();

		}
		log.info("****************************** Browser is closed *****************************************");
	}
}

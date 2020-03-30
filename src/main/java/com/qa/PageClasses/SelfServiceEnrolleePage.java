package com.qa.PageClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.SelfServiceUtilities.WriteSelfServiceEnrollee;
import com.qa.Utilities.Utilities;

import IES_TestBaseClass.SelfServiceBaseClass;

public class SelfServiceEnrolleePage extends SelfServiceBaseClass {

	Select select;
	String AlertName;
	WriteSelfServiceEnrollee obj1 = new WriteSelfServiceEnrollee();
	public String Res;
	public int DataSet;
	@FindBy(id = "ContentPlaceHolder1_txtFirstName")
	WebElement First_Name;

	@FindBy(id = "ContentPlaceHolder1_txtMI")
	WebElement Middle_Name;

	@FindBy(id = "ContentPlaceHolder1_txtLastName")
	WebElement Last_Name;

	@FindBy(id = "ContentPlaceHolder1_txtAddress")
	WebElement Address1;

	@FindBy(id = "ContentPlaceHolder1_txtSecondAddress")
	WebElement Address2;

	@FindBy(id = "ContentPlaceHolder1_ddlState")
	WebElement State;

	@FindBy(id = "ContentPlaceHolder1_txtCity")
	WebElement City;

	@FindBy(id = "ContentPlaceHolder1_txtZipCode")
	WebElement ZipCode;

	@FindBy(id = "ContentPlaceHolder1_txtCellPhone")
	WebElement CellPhone;

	@FindBy(id = "ContentPlaceHolder1_txtEmail")
	WebElement EmailId;

	@FindBy(id = "ContentPlaceHolder1_txtWieght")
	WebElement Weight;

	@FindBy(id = "ContentPlaceHolder1_txtMemberId")
	WebElement MemberId;

	@FindBy(id = "ContentPlaceHolder1_txtOccupation")
	WebElement Occupation;

	@FindBy(id = "ContentPlaceHolder1_txtAnnualCompensation")
	WebElement AnnualCompensation;

	@FindBy(id = "ContentPlaceHolder1_txtDepartmentNumber")
	WebElement DepartmentNumber;

	@FindBy(id = "ContentPlaceHolder1_txtSSN")
	WebElement SSN_Web;

	@FindBy(id = "ContentPlaceHolder1_ddlHeightFt")
	WebElement HeightFt;

	@FindBy(id = "ContentPlaceHolder1_ddlHeightIn")
	WebElement HeightIn;

	@FindBy(id = "ContentPlaceHolder1_ddlPayfrequency")
	WebElement PayFrquency;

	////////////////////// For A&A Case/////////////////////
	@FindBy(id = "ContentPlaceHolder1_ddlCitizenshipCountry")
	WebElement CitizenshipCountry;

	@FindBy(id = "ContentPlaceHolder1_ddlStateofEnrollment")
	WebElement StateofEnrollment;
	//////////////////////////////////////////////////////////

	////////////////////////// OAPFF/////////////////////////////
	@FindBy(id = "ContentPlaceHolder1_ddlMemberStatus")
	WebElement MemberStatus;
	///////////////////////////////////////////

	@FindBy(id = "ContentPlaceHolder1_ddlGender")
	WebElement Gender;

	@FindBy(id = "ContentPlaceHolder1_btnSaveAndContinue")
	WebElement SaveAndContinue;

	@FindBy(id = "ContentPlaceHolder1_ddlLocation")
	WebElement Location;

	@FindBy(id = "ContentPlaceHolder1_txtMDOB")
	WebElement DOB;
	@FindBy(id = "ContentPlaceHolder1_txtMHireDate")
	WebElement HireDate;

	@FindBy(id = "ContentPlaceHolder1_txtHourlyPay")
	WebElement HourlyPay;

	/////////// Tobaco////////
	@FindBy(id = "ContentPlaceHolder1_ddlTobaco")
	WebElement Tobaco;

	public SelfServiceEnrolleePage() {

		PageFactory.initElements(driver, this);
	}

	public SelfServiceDependentPage Enrolle_Addition(String SrNo, String FirstName, String MiddleName, String LastName,
			String Address, String Address_2, String City_enrolle, String Zip_Code__enrolle, String SSN,
			String Date_of_Birth, String Cell_Phone, String Email, String HeightFeet_enrolle, String HeightInch_enrolle,
			String Weight_enrolle, String Date_of_Hire, String Employee_Id, String Occupation_enrolle,
			String Annual_Salary, String Business_Unit_Department_Number, String HourlyIncome, String State_enrolle,
			String CitizenshipCountry_enrolle, String StateofEnrollment_enrolle, String Gender_enrolle,
			String Location_enrolle, String MemberStatus_enrolle, String PayFrequency_enrolle, String Tobaco_enrolle,
			String Status) throws Exception {
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ContentPlaceHolder1_txtFirstName")));
		try {
			Utilities.LiveChatSupport();
		} catch (Throwable LCS) {
			LCS.printStackTrace();
			driver.switchTo().defaultContent();
		}
		wait.until(ExpectedConditions.elementToBeClickable(First_Name));
		try {
			First_Name.clear();
			First_Name.sendKeys(FirstName);
		} catch (Throwable FN) {
			FN.printStackTrace();
		}
		try {
			Middle_Name.clear();
			Middle_Name.sendKeys(MiddleName);
		} catch (Throwable MN) {
			MN.printStackTrace();
		}
		try {
			Last_Name.clear();
			Last_Name.sendKeys(LastName);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			Address1.clear();
			Address1.sendKeys(Address);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			Address2.clear();
			Address2.sendKeys(Address_2);
		} catch (Throwable Add2) {
			Add2.printStackTrace();
		}
		try {
			City.clear();
			City.sendKeys(City_enrolle);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			select = new Select(State);
			select.selectByVisibleText(State_enrolle);
			// List<WebElement> State_list = select.getOptions();
			// int No_State = State_list.size();
			// for (int i = 0; i < No_State; i++) {
			// if (i == 0) {
			//
			// continue;
			//
			// }
			// if (i == 1) {
			// select.selectByIndex(i);
			// break;
			// }
			// }
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// select.selectByVisibleText("Indiana");
		try {
			ZipCode.clear();
			ZipCode.sendKeys(Zip_Code__enrolle.trim());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			if (CitizenshipCountry.isDisplayed() || CitizenshipCountry.isEnabled()) {
				select = new Select(CitizenshipCountry);
				select.selectByVisibleText(CitizenshipCountry_enrolle.trim());
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			if (StateofEnrollment.isDisplayed() || StateofEnrollment.isEnabled()) {
				select = new Select(StateofEnrollment);
				select.selectByVisibleText(StateofEnrollment_enrolle.trim());
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// SSN_Web.clear();
		try {
			if (SSN_Web.isDisplayed() && SSN_Web.isEnabled()) {
				jse.executeScript("arguments[0].value='" + SSN.trim() + "';", SSN_Web);
			}
			// if (SSN_Web.getAttribute("value").isEmpty()) {
			// jse.executeScript("arguments[0].value='" + SSN.trim() + "';", SSN_Web);
			// }
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// jse.executeScript("arguments[0].value='" + SSN + "';", SSN_Web);
		try {
			DOB.clear();
			jse.executeScript(
					"document.getElementById('ContentPlaceHolder1_txtMDOB').value='" + Date_of_Birth.trim() + "';");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			select = new Select(Gender);
			select.selectByVisibleText(Gender_enrolle.trim());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			CellPhone.clear();
			CellPhone.sendKeys(Cell_Phone);
		} catch (Throwable cell) {
			cell.printStackTrace();
		}
		try {
			if (EmailId.getAttribute("readOnly").equals("false")) {
				EmailId.clear();
				EmailId.sendKeys(Email);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			if (HeightFt.isEnabled() && HeightFt.isDisplayed()) {
				select = new Select(HeightFt);
				select.selectByVisibleText(HeightFeet_enrolle);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			if (HeightIn.isEnabled() && HeightIn.isDisplayed()) {
				select = new Select(HeightIn);
				select.selectByVisibleText(HeightInch_enrolle);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			if (Weight.isEnabled() && Weight.isDisplayed()) {
				Weight.clear();
				Weight.sendKeys(Weight_enrolle);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			HireDate.clear();
			jse.executeScript(
					"document.getElementById('ContentPlaceHolder1_txtMHireDate').value='" + Date_of_Hire.trim() + "';");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		try {
			select = new Select(Location);
			select.selectByVisibleText(Location_enrolle.trim());
			// List<WebElement> Location_list = select.getOptions();
			// int No_Location = Location_list.size();
			// for (int i = 0; i < No_Location; i++) {
			// if (i == 0) {
			//
			// continue;
			//
			// }
			// if (i == 1) {
			// select.selectByIndex(i);
			// break;
			// }
			// }
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// select.selectByVisibleText(wso.getRow(1).getCell(20).getStringCellValue());
		// MemberId.clear();
		try {
			if (MemberStatus.isDisplayed()) {
				select = new Select(MemberStatus);
				select.selectByVisibleText(MemberStatus_enrolle.trim());
				// List<WebElement> MemberStatus_List = select.getOptions();
				// int No_MemberStatus = MemberStatus_List.size();
				// for (int i = 0; i < No_MemberStatus; i++) {
				// if (i == 0) {
				//
				// continue;
				//
				// }
				// if (i == 1) {
				// select.selectByIndex(i);
				// break;
				// }
				// select.selectByVisibleText(wso.getRow(1).getCell(13).getStringCellValue());
				// }
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			if (MemberId.isDisplayed() && MemberId.isEnabled()) {
				MemberId.sendKeys(Employee_Id.trim());

			}
			// if (MemberId.getAttribute("value").isEmpty()) {
			// MemberId.sendKeys(Employee_Id);
			// }
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// MemberId.sendKeys(Employee_Id);
		try {
			Occupation.clear();
			Occupation.sendKeys(Occupation_enrolle);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			if (PayFrquency.isEnabled() && PayFrquency.isDisplayed()) {
				select = new Select(PayFrquency);
				select.selectByVisibleText(PayFrequency_enrolle.trim());
				// List<WebElement> Payfrequency_list = select.getOptions();
				// int No_Payfrequency = Payfrequency_list.size();
				// for (int i = 0; i < No_Payfrequency; i++) {
				// if (i == 0) {
				//
				// continue;
				//
				// }
				// if (i == 1) {
				// select.selectByIndex(i);
				// break;
				// }
				// }
				// //
				// select.selectByVisibleText(wso.getRow(1).getCell(11).getStringCellValue());
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			AnnualCompensation.clear();
			AnnualCompensation.sendKeys(Annual_Salary);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			HourlyPay.sendKeys(HourlyIncome);
		} catch (Throwable Hp) {
			Hp.printStackTrace();
		}
		try {
			if (DepartmentNumber.isDisplayed() && DepartmentNumber.isEnabled()) {
				DepartmentNumber.sendKeys(Business_Unit_Department_Number);
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		try {
			select = new Select(Tobaco);
			select.selectByVisibleText(Tobaco_enrolle.trim());
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.accept();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		DataSet = Integer.parseInt(SrNo.trim());
		Thread.sleep(2000);
		try {
			SaveAndContinue.click();
			wait.until(ExpectedConditions.alertIsPresent());

			System.out.println("alert was present");
			Alert alert = driver.switchTo().alert();
			AlertName = alert.getText();
			Res = "Fail" + "," + AlertName;
			obj1.WriteResult(Res, DataSet);
			System.out.println(AlertName);
			alert.accept();
			// Alert alert = driver.switchTo().alert();
			// System.out.println(alert.getText());
			// Thread.sleep(2000);
			// alert.accept();
		} catch (Throwable e) {
			System.out.println("alert was not present");
			Res = "Pass";
			obj1.WriteResult(Res, DataSet);
		}
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), wso.getRow(1).getCell(17).getStringCellValue().trim());

		return new SelfServiceDependentPage();
	}

}

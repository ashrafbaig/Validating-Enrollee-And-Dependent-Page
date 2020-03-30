package com.qa.PageClasses;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.qa.Utilities.Utilities;
import com.qa.Utilities.WriteEnrollee;

import IES_TestBaseClass.BaseClass;

public class EnrolleePage extends BaseClass {

	Select select;
	String AlertName;
	WriteEnrollee obj1 = new WriteEnrollee();
	// public int DataSet=-1;
	public String Res;
	public int DataSet;
	@FindBy(id = "ContentPlaceHolder1_btnAdd")
	WebElement Add_Button;

	@FindBy(id = "ContentPlaceHolder1_txtFirstName")
	WebElement First_Name;

	@FindBy(id = "ContentPlaceHolder1_txtMI")
	WebElement Middle_Name;

	@FindBy(id = "ContentPlaceHolder1_txtLastName")
	WebElement Last_Name;

	@FindBy(id = "ContentPlaceHolder1_txtAddress")
	WebElement Address1;

	@FindBy(id = "ContentPlaceHolder1_txtAddress2")
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

	@FindBy(id = "ContentPlaceHolder1_ddlPayFrquency")
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

	@FindBy(id = "ContentPlaceHolder1_txtHourlyPay")
	WebElement HourlyPay;

	@FindBy(id = "ContentPlaceHolder1_ddlTobaco")
	WebElement Tobaco;

	@FindBy(id = "ContentPlaceHolder1_txtMDOB")
	WebElement DOB;

	@FindBy(id = "ContentPlaceHolder1_txtMHireDate")
	WebElement DOH;

	public EnrolleePage() {

		PageFactory.initElements(driver, this);
	}

	public DependentPage Enrolle_Addition(String SrNo, String FirstName, String MiddleName, String LastName,
			String Address, String Address_2, String City_enrolle, String Zip_Code__enrolle, String SSN,
			String Date_of_Birth, String Cell_Phone, String Email, String HeightFeet_enrolle, String HeightIch_enrolle,
			String Weight__enrolle, String Date_of_Hire, String Employee_Id, String Occupation_enrolle,
			String Annual_Salary, String Business_Unit_Department_Number, String HourlyIncome, String State_enrolle,
			String CitizenshipCountry_enrolle, String StateofEnrollment_enrolle, String Gender_enrolle,
			String Location_enrolle, String MemberStatus_enrolle, String PayFrequency_enrolle, String Tobaco_enrolle,
			String Status) throws Exception {
		// Add_Button.click();
//		Utilities.Search_Enrollee();
//		Thread.sleep(2000);
		try {
			Add_Button.click();
			
			try {
				Utilities.LiveChatSupport();
			} catch (Throwable LCS) {
				LCS.printStackTrace();
				driver.switchTo().defaultContent();
			}
			// DataSet++;
			wait.until(ExpectedConditions.elementToBeClickable(First_Name));
			try {
				First_Name.clear();
				First_Name.sendKeys(FirstName);
			} catch (Throwable e) {
				e.printStackTrace();
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
				if (State.isDisplayed() && State.isEnabled()) {
					jse.executeScript("arguments[0].selectedIndex ='0';", State);
					select = new Select(State);
					// select.selectByVisibleText(State_enrolle);
					List<WebElement> State_list = select.getOptions();
					int No_State = State_list.size();
					for (int i = 0; i < No_State; i++) {
						if (i == 0) {

							continue;

						}
						if (Integer.parseInt(State_enrolle.trim()) >= 1) {
							select.selectByIndex(Integer.parseInt(State_enrolle.trim()));
							break;
						}
					}
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
			// select.selectByVisibleText("Indiana");
			try {
				ZipCode.clear();
				ZipCode.sendKeys(Zip_Code__enrolle);
			} catch (Throwable e) {
				e.printStackTrace();
			}
			try {

				try {
					if (CitizenshipCountry.isDisplayed() && CitizenshipCountry.isEnabled()) {
						jse.executeScript("arguments[0].selectedIndex ='0';", CitizenshipCountry);
						select = new Select(CitizenshipCountry);
						// select.selectByVisibleText(CitizenshipCountry_enrolle.trim());
						List<WebElement> CitizenshipCountry_list = select.getOptions();
						int No_CitizenshipCountry = CitizenshipCountry_list.size();
						for (int i = 0; i < No_CitizenshipCountry; i++) {
							if (i == 0) {

								continue;

							}
							if (Integer.parseInt(CitizenshipCountry_enrolle.trim()) >= 1) {
								select.selectByIndex(Integer.parseInt(CitizenshipCountry_enrolle.trim()));
								break;
							}
						}
					}
				} catch (Throwable noelement) {
				}
				try {
					if (StateofEnrollment.isDisplayed() && StateofEnrollment.isEnabled()) {
						jse.executeScript("arguments[0].selectedIndex ='0';", StateofEnrollment);
						select = new Select(StateofEnrollment);

						// select.selectByVisibleText(StateofEnrollment_enrolle);

						List<WebElement> StateofEnrollment_list = select.getOptions();
						int No_StateofEnrollment = StateofEnrollment_list.size();
						for (int i = 0; i < No_StateofEnrollment; i++) {
							if (i == 0) {

								continue;

							}
							if (Integer.parseInt(StateofEnrollment_enrolle.trim()) >= 1) {
								select.selectByIndex(Integer.parseInt(StateofEnrollment_enrolle.trim()));
								break;
							}
						}
					}
				} catch (Throwable noelement) {
				}
				try {
					SSN_Web.clear();
					jse.executeScript("arguments[0].value='" + SSN + "';", SSN_Web);
				} catch (Throwable e) {
					e.printStackTrace();
				}

				try {
					DOB.clear();
					jse.executeScript(
							"document.getElementById('ContentPlaceHolder1_txtMDOB').value='" + Date_of_Birth + "';");
				} catch (Throwable e) {
					e.printStackTrace();
				}

				try {
					jse.executeScript("arguments[0].selectedIndex ='0';", Gender);
					select = new Select(Gender);
					// select.selectByVisibleText(Gender_enrolle);
					List<WebElement> Gender_list = select.getOptions();
					int No_Gender = Gender_list.size();
					for (int i = 0; i < No_Gender; i++) {
						if (i == 0) {

							continue;

						}
						if (Integer.parseInt(Gender_enrolle.trim()) >= 1) {
							select.selectByIndex(Integer.parseInt(Gender_enrolle.trim()));
							break;
						}
					}
				} catch (Throwable e) {
					e.printStackTrace();
				}
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
			} catch (UnhandledAlertException e1) {

			} catch (NoAlertPresentException e2) {

			} catch (Throwable e) {
				e.printStackTrace();
			}
			try {
				if (CellPhone.isEnabled() && CellPhone.isDisplayed()) {
					CellPhone.clear();
					CellPhone.sendKeys(Cell_Phone);
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
			try {
				if (EmailId.isEnabled() && EmailId.isDisplayed()) {
					EmailId.clear();
					EmailId.sendKeys(Email);

					Alert alert = driver.switchTo().alert();
					System.out.println(alert.getText());
					alert.accept();
				}
			} catch (UnhandledAlertException e1) {

			} catch (NoAlertPresentException e2) {

			} catch (Throwable e) {
				e.printStackTrace();
			}
			try {

				if (HeightFt.isEnabled() && HeightFt.isDisplayed()) {
					jse.executeScript("arguments[0].selectedIndex ='0';", HeightFt);
					select = new Select(HeightFt);
					select.selectByVisibleText(HeightFeet_enrolle);
				}
			} catch (Throwable HFT) {
				HFT.printStackTrace();
			}

			try {
				if (HeightIn.isEnabled() && HeightIn.isDisplayed()) {
					jse.executeScript("arguments[0].selectedIndex ='0';", HeightIn);
					select = new Select(HeightIn);
					select.selectByVisibleText(HeightIch_enrolle);
				}
			} catch (Throwable HIN) {
				HIN.printStackTrace();
			}
			try {
				if (Weight.isEnabled() && Weight.isDisplayed()) {
					Weight.clear();
					Weight.sendKeys(Weight__enrolle);
				}
			} catch (Throwable WEI) {
				WEI.printStackTrace();
			}
			try {
				if (DOH.isDisplayed() && DOH.isEnabled()) {
					DOH.clear();
					jse.executeScript("document.getElementById('ContentPlaceHolder1_txtMHireDate').value='"
							+ Date_of_Hire + "';");
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
			try {
				if (Location.isDisplayed() && Location.isEnabled()) {
					jse.executeScript("arguments[0].selectedIndex ='0';", Location);
					select = new Select(Location);
					// select.selectByVisibleText(Location_enrolle);

					List<WebElement> Location_list = select.getOptions();
					int No_Location = Location_list.size();
					for (int i = 0; i < No_Location; i++) {
						if (i == 0) {

							continue;

						}
						if (Integer.parseInt(MemberStatus_enrolle.trim()) >= 1) {
							select.selectByIndex(Integer.parseInt(MemberStatus_enrolle.trim()));
							break;
						}
					}
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
			// select.selectByVisibleText(wso.getRow(1).getCell(12).getStringCellValue());
			try {
				if (MemberStatus.isDisplayed() && MemberStatus.isEnabled()) {
					jse.executeScript("arguments[0].selectedIndex ='0';", MemberStatus);
					select = new Select(MemberStatus);
					List<WebElement> Member_list = select.getOptions();
					int No_Member = Member_list.size();
					for (int i = 0; i < No_Member; i++) {
						if (i == 0) {

							continue;

						}
						if (Integer.parseInt(MemberStatus_enrolle.trim()) >= 1) {
							select.selectByIndex(Integer.parseInt(MemberStatus_enrolle.trim()));
							break;
						}
					}
					// select.selectByVisibleText(MemberStatus_enrolle);
					Thread.sleep(2000);
				}
			} catch (Throwable MS) {
				MS.printStackTrace();
			}
			try {
				if (MemberId.isDisplayed() && MemberId.isEnabled()) {
					MemberId.clear();
					MemberId.sendKeys(Employee_Id);
				}
			} catch (Throwable MI) {
				MI.printStackTrace();
			}
			try {
				if (Occupation.isEnabled() && Occupation.isDisplayed()) {
					Occupation.clear();
					Occupation.sendKeys(Occupation_enrolle);
				}
			} catch (Throwable Occupation) {
				Occupation.printStackTrace();
			}
			try {
				if (PayFrquency.isEnabled() && PayFrquency.isDisplayed()) {
					jse.executeScript("arguments[0].selectedIndex ='0';", PayFrquency);
					select = new Select(PayFrquency);
					// select.selectByValue(PayFrequency_enrolle.toUpperCase().trim());
					List<WebElement> Payfrequency_list = select.getOptions();
					int No_Payfrequency = Payfrequency_list.size();
					for (int i = 0; i < No_Payfrequency; i++) {
						if (i == 0) {

							continue;

						}
						if (Integer.parseInt(PayFrequency_enrolle.trim()) >= 1) {
							select.selectByIndex(Integer.parseInt(PayFrequency_enrolle.trim()));
							break;
						}
					}
					// select.selectByVisibleText(wso.getRow(1).getCell(11).getStringCellValue());
				}
			} catch (Throwable PF) {
				PF.printStackTrace();
			}
			try {
				if (AnnualCompensation.isDisplayed() && AnnualCompensation.isEnabled()) {
					AnnualCompensation.clear();
					AnnualCompensation.sendKeys(Annual_Salary);
				}
			} catch (Throwable Anns) {
				Anns.printStackTrace();
			}
			try {
				if (HourlyPay.isDisplayed() && HourlyPay.isEnabled()) {
					HourlyPay.clear();
					HourlyPay.sendKeys(HourlyIncome);
				}
			} catch (Throwable Hp) {
				Hp.printStackTrace();
			}
			try {
				if (DepartmentNumber.isDisplayed() && DepartmentNumber.isEnabled()) {
					DepartmentNumber.clear();
					DepartmentNumber.sendKeys(Business_Unit_Department_Number);
				}
			} catch (Throwable DN) {
				DN.printStackTrace();
			}
			try {
				if (Tobaco.isDisplayed() && Tobaco.isEnabled()) {
					jse.executeScript("arguments[0].selectedIndex ='0';", Tobaco);
					select = new Select(Tobaco);
					List<WebElement> Tobaco_list = select.getOptions();
					int No_Tobaco = Tobaco_list.size();
					for (int i = 0; i < No_Tobaco; i++) {
						if (i == 0) {

							continue;

						}
						if (Integer.parseInt(Tobaco_enrolle.trim()) >= 1) {
							try {
							select.selectByIndex(Integer.parseInt(Tobaco_enrolle.trim()));
							Alert alert = driver.switchTo().alert();
							System.out.println(alert.getText());
							alert.accept();
							}catch (UnhandledAlertException e) {
								
							}catch (NoAlertPresentException e) {
								
							}catch (Throwable e) {
								e.printStackTrace();
							}
							break;
						}
					}
				}
				// select.selectByVisibleText(Tobaco_enrolle);
			} catch (Throwable TB) {
				TB.printStackTrace();
			}
			Thread.sleep(2000);
			DataSet = Integer.parseInt(SrNo.trim());
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

				// } catch (UnhandledAlertException e1) {
				// Res = "Pass";
				// obj1.WriteResult(Res, DataSet);
				//
			} catch (Throwable e2) {
				System.out.println("alert was not present");
				Res = "Pass";
				obj1.WriteResult(Res, DataSet);
			}
			
		} catch (StaleElementReferenceException e) {
			// Add_Button.click();
			try {
				Utilities.LiveChatSupport();
			} catch (Throwable LCS) {
				LCS.printStackTrace();
				driver.switchTo().defaultContent();
			}
			// DataSet++;
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
			} catch (Throwable LN) {
				LN.printStackTrace();
			}
			try {
				Address1.clear();
				Address1.sendKeys(Address);
			} catch (Throwable Add1) {
				Add1.printStackTrace();
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
			} catch (Throwable city) {
				city.printStackTrace();
			}

			try {
				if (State.isDisplayed() && State.isEnabled()) {
					jse.executeScript("arguments[0].selectedIndex ='0';", StateofEnrollment);
					select = new Select(State);
					// select.selectByVisibleText(State_enrolle);
					List<WebElement> State_list = select.getOptions();
					int No_State = State_list.size();
					for (int i = 0; i < No_State; i++) {
						if (i == 0) {

							continue;

						}
						if (Integer.parseInt(State_enrolle.trim()) >= 1) {
							select.selectByIndex(Integer.parseInt(State_enrolle.trim()));
							break;
						}
					}
				}
			} catch (Throwable state) {
				state.printStackTrace();
			}
			// select.selectByVisibleText("Indiana");
			try {
				ZipCode.clear();
				ZipCode.sendKeys(Zip_Code__enrolle);
			} catch (Throwable zc) {
				zc.printStackTrace();
			}
			try {

				try {
					if (CitizenshipCountry.isDisplayed() && CitizenshipCountry.isEnabled()) {
						jse.executeScript("arguments[0].selectedIndex ='0';", CitizenshipCountry);
						select = new Select(CitizenshipCountry);
						// select.selectByVisibleText(CitizenshipCountry_enrolle);
						List<WebElement> CitizenshipCountry_list = select.getOptions();
						int No_CitizenshipCountry = CitizenshipCountry_list.size();
						for (int i = 0; i < No_CitizenshipCountry; i++) {
							if (i == 0) {

								continue;

							}
							if (Integer.parseInt(CitizenshipCountry_enrolle.trim()) >= 1) {
								select.selectByIndex(Integer.parseInt(CitizenshipCountry_enrolle.trim()));
								break;
							}
						}
					}
				} catch (Throwable noelement) {
				}
				try {
					if (StateofEnrollment.isDisplayed() && StateofEnrollment.isEnabled()) {
						jse.executeScript("arguments[0].selectedIndex ='0';", StateofEnrollment);
						select = new Select(StateofEnrollment);
						// select.selectByVisibleText(StateofEnrollment_enrolle);
						List<WebElement> StateofEnrollment_list = select.getOptions();
						int No_StateofEnrollment = StateofEnrollment_list.size();
						for (int i = 0; i < No_StateofEnrollment; i++) {
							if (i == 0) {

								continue;

							}
							if (Integer.parseInt(StateofEnrollment_enrolle.trim()) >= 1) {
								select.selectByIndex(Integer.parseInt(StateofEnrollment_enrolle.trim()));
								break;
							}
						}
					}
				} catch (Throwable noelement) {
				}
				try {
					SSN_Web.clear();
					jse.executeScript("arguments[0].value='" + SSN + "';", SSN_Web);
				} catch (Throwable ssn) {
					ssn.printStackTrace();
				}

				try {
					DOB.clear();
					jse.executeScript(
							"document.getElementById('ContentPlaceHolder1_txtMDOB').value='" + Date_of_Birth + "';");
				} catch (Throwable dob) {
					dob.printStackTrace();
				}

				try {
					if (Gender.isDisplayed() && Gender.isEnabled()) {
						jse.executeScript("arguments[0].selectedIndex ='0';", Gender);
						select = new Select(Gender);
						// select.selectByVisibleText("Male");
						List<WebElement> Gender_list = select.getOptions();
						int No_Gender = Gender_list.size();
						for (int i = 0; i < No_Gender; i++) {
							if (i == 0) {

								continue;

							}
							if (Integer.parseInt(Gender_enrolle.trim()) >= 1) {
								select.selectByIndex(Integer.parseInt(Gender_enrolle.trim()));
								break;
							}
						}
					}
				} catch (Throwable gender) {
					gender.printStackTrace();
				}
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
			} catch (UnhandledAlertException e1) {

			} catch (NoAlertPresentException e2) {

			} catch (Throwable all) {
				all.printStackTrace();
			}
			try {
				CellPhone.clear();
				CellPhone.sendKeys(Cell_Phone);
			} catch (Throwable cell) {
				cell.printStackTrace();
			}
			try {
				EmailId.clear();
				EmailId.sendKeys(Email);

				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
			} catch (UnhandledAlertException e1) {

			} catch (NoAlertPresentException e2) {

			} catch (Throwable mail) {
				mail.printStackTrace();
			}
			try {
				if (HeightFt.isEnabled() && HeightFt.isDisplayed()) {
					jse.executeScript("arguments[0].selectedIndex ='0';", HeightFt);
					select = new Select(HeightFt);
					select.selectByVisibleText(HeightFeet_enrolle);
				}
			} catch (Throwable HFT) {
				HFT.printStackTrace();
			}

			try {
				if (HeightIn.isEnabled() && HeightIn.isDisplayed()) {
					jse.executeScript("arguments[0].selectedIndex ='0';", HeightIn);
					select = new Select(HeightIn);
					select.selectByVisibleText(HeightIch_enrolle);
				}
			} catch (Throwable HIN) {
				HIN.printStackTrace();
			}
			try {
				if (Weight.isEnabled() && Weight.isDisplayed()) {
					Weight.clear();
					Weight.sendKeys(Weight__enrolle);
				}
			} catch (Throwable WEI) {
				WEI.printStackTrace();
			}
			try {
				DOH.clear();
				jse.executeScript(
						"document.getElementById('ContentPlaceHolder1_txtMHireDate').value='" + Date_of_Hire + "';");
			} catch (Throwable doh) {
				doh.printStackTrace();
			}
			try {
				if (Location.isDisplayed() && Location.isEnabled()) {
					jse.executeScript("arguments[0].selectedIndex ='0';", Location);
					select = new Select(Location);
					// select.selectByVisibleText(Location_enrolle);
					List<WebElement> Location_list = select.getOptions();
					int No_Location = Location_list.size();
					for (int i = 0; i < No_Location; i++) {
						if (i == 0) {

							continue;

						}
						if (Integer.parseInt(Location_enrolle.trim()) >= 1) {
							select.selectByIndex(Integer.parseInt(Location_enrolle.trim()));
							break;
						}
					}
				}
			} catch (Throwable location) {
				location.printStackTrace();
			}
			// select.selectByVisibleText(wso.getRow(1).getCell(12).getStringCellValue());
			try {
				if (MemberStatus.isDisplayed() && MemberStatus.isEnabled()) {
					jse.executeScript("arguments[0].selectedIndex ='0';", MemberStatus);
					select = new Select(MemberStatus);
					List<WebElement> MemberStatus_list = select.getOptions();
					int No_MemberStatus = MemberStatus_list.size();
					for (int i = 0; i < No_MemberStatus; i++) {
						if (i == 0) {

							continue;

						}
						if (Integer.parseInt(MemberStatus_enrolle.trim()) >= 1) {
							select.selectByIndex(Integer.parseInt(MemberStatus_enrolle.trim()));
							break;
						}
					}
					// select.selectByVisibleText(MemberStatus_enrolle);
					Thread.sleep(2000);
				}
			} catch (Throwable MS) {
				MS.printStackTrace();
			}
			try {
				if (MemberId.isDisplayed() && MemberId.isEnabled()) {
					MemberId.clear();
					MemberId.sendKeys(Employee_Id);
				}
			} catch (Throwable MI) {
				MI.printStackTrace();
			}
			try {
				Occupation.clear();
				Occupation.sendKeys(Occupation_enrolle);
			} catch (Throwable Occupation) {
				Occupation.printStackTrace();
			}
			try {
				if (PayFrquency.isEnabled() && PayFrquency.isDisplayed()) {
					jse.executeScript("arguments[0].selectedIndex ='0';", PayFrquency);
					select = new Select(PayFrquency);
					// select.selectByValue(PayFrequency_enrolle);
					List<WebElement> Payfrequency_list = select.getOptions();
					int No_Payfrequency = Payfrequency_list.size();
					for (int i = 0; i < No_Payfrequency; i++) {
						if (i == 0) {

							continue;

						}
						if (Integer.parseInt(PayFrequency_enrolle.trim()) >= 1) {
							select.selectByIndex(Integer.parseInt(PayFrequency_enrolle.trim()));
							break;
						}
					}
					// select.selectByVisibleText(wso.getRow(1).getCell(11).getStringCellValue());
				}
			} catch (Throwable PF) {
				PF.printStackTrace();
			}
			try {
				AnnualCompensation.clear();
				AnnualCompensation.sendKeys(Annual_Salary);
			} catch (Throwable Anns) {
				Anns.printStackTrace();
			}
			try {
				HourlyPay.clear();
				HourlyPay.sendKeys(HourlyIncome);
			} catch (Throwable Hp) {
				Hp.printStackTrace();
			}
			try {
				if (DepartmentNumber.isDisplayed() && DepartmentNumber.isEnabled()) {
					DepartmentNumber.clear();
					DepartmentNumber.sendKeys(Business_Unit_Department_Number);
				}
			} catch (Throwable DN) {
			}

			try {
				if (Tobaco.isDisplayed() && Tobaco.isEnabled()) {
					jse.executeScript("arguments[0].selectedIndex ='0';", Tobaco);
					select = new Select(Tobaco);
					List<WebElement> Tobaco_list = select.getOptions();
					int No_Tobaco = Tobaco_list.size();
					for (int i = 0; i < No_Tobaco; i++) {
						if (i == 0) {

							continue;

						}
						if (Integer.parseInt(Tobaco_enrolle.trim()) >= 1) {
							select.selectByIndex(Integer.parseInt(Tobaco_enrolle.trim()));
							break;
						}
					}
					// select.selectByVisibleText(Tobaco_enrolle);
				}
			} catch (Throwable TB) {
				TB.printStackTrace();
			}
			Thread.sleep(2000);
			DataSet = Integer.parseInt(SrNo.trim());
			try {
				SaveAndContinue.click();
				// wait.until(ExpectedConditions.alertIsPresent());
				wait.until(ExpectedConditions.alertIsPresent());

				System.out.println("alert was present");
				Alert alert = driver.switchTo().alert();
				AlertName = alert.getText();
				Res = "Fail" + " " + AlertName;
				obj1.WriteResult(Res, DataSet);
				System.out.println(AlertName);
				alert.accept();

				// } catch (UnhandledAlertException e1) {
				// Res = "Pass";
				// obj1.WriteResult(Res, DataSet);
				// // Res = "Fail" + " " + AlertName;
				// // obj1.WriteResult(Res, DataSet);
				//
			} catch (Throwable e2) {
				System.out.println("alert was not present");
				Res = "Pass";
				obj1.WriteResult(Res, DataSet);
			}

		}
		Thread.sleep(2000);
		return new DependentPage();
	}

}

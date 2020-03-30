package com.qa.PageClasses;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.SelfServiceUtilities.Utilities;
import com.qa.SelfServiceUtilities.WriteSelfServiceDependent;

import IES_TestBaseClass.SelfServiceBaseClass;

public class SelfServiceDependentPage extends SelfServiceBaseClass {

	Select select;
	String DependentAlertName;
	public String DependentRes;
	public int DataSet;
	WriteSelfServiceDependent obj2 = new WriteSelfServiceDependent();
	@FindBy(id = "ContentPlaceHolder1_ucNavigation1_stepDependent")
	WebElement Dependent_Button;

	@FindBy(id = "ContentPlaceHolder1_txtDependentFirstName")
	WebElement First_Name;

	@FindBy(id = "ContentPlaceHolder1_txtDependentMiddleName")
	WebElement Middle_Name;

	@FindBy(id = "ContentPlaceHolder1_txtDependentLastName")
	WebElement Last_Name;

	@FindBy(id = "ContentPlaceHolder1_ddlRelationship")
	WebElement Relationship;

	@FindBy(id = "ContentPlaceHolder1_txtTelephoneNumber")
	WebElement CellPhone;

	@FindBy(id = "ContentPlaceHolder1_txtWeight")
	WebElement Weight;

	@FindBy(id = "ContentPlaceHolder1_txtSSN")
	WebElement SSN_Web;

	@FindBy(id = "ContentPlaceHolder1_ddlHeightFeet")
	WebElement HeightFt;

	@FindBy(id = "ContentPlaceHolder1_ddlHeightInch")
	WebElement HeightIn;

	@FindBy(id = "ContentPlaceHolder1_ddlIsTobaccoOrNicotine")
	WebElement Tobaco;

	@FindBy(id = "ContentPlaceHolder1_ddlGender")
	WebElement Gender;

	@FindBy(id = "ContentPlaceHolder1_btnSave")
	WebElement Save_button;

	@FindBy(id = "ContentPlaceHolder1_btnSaveAndContinue")
	WebElement SaveAndContinue;

	@FindBy(xpath = "//div[@class='table-responsive table-responsive1']")
	WebElement Dependent_Div;

	public SelfServiceDependentPage() {

		PageFactory.initElements(driver, this);
	}

	public void Dependent_Addition(String SrNo, String FirstName, String MiddleName, String LastName, String SSN,
			String Date_of_Birth, String Cell_Phone, String HeightFeet_dependent, String HeightInch_dependent,
			String Weight_enrolle, String Gender_dependent, String Relation_dependent, String Tobaco_dependent,
			String Status) throws InterruptedException {
		try {
			Utilities.LiveChatSupport();
		} catch (Throwable e) {
			e.printStackTrace();
			driver.switchTo().defaultContent();
		}
		SaveAndContinue.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ContentPlaceHolder1_txtDependentFirstName")));
		jse.executeScript("arguments[0].scrollIntoView(true);", Dependent_Div);
		// jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		DataSet = Integer.parseInt(SrNo.trim());
		try {
			driver.findElement(By.id("ContentPlaceHolder1_GVDependent_btnDeleteDependent_" + DataSet)).click();
			// delete_list.get(DataSet).click();
			Thread.sleep(2000);
			Alert firstAlert = wait.until(ExpectedConditions.alertIsPresent());
			firstAlert.accept();
			Thread.sleep(2000);
			Alert secondAlert = wait.until(ExpectedConditions.alertIsPresent());
			secondAlert.accept();
			// List<WebElement> delete_list =
			// driver.findElements(By.xpath("//td/a[@onclick]"));
			// int delete_dependent = delete_list.size();
			// for (int i = 0; i < delete_dependent; i++) {
			// delete_list = driver.findElements(By.xpath("//td/a[@onclick]"));
			// switch (Relation_dependent) {
			// case "Spouse":
			// driver.findElement(By.id("ContentPlaceHolder1_GVDependent_btnDeleteDependent_1")).click();
			// Alert alert = driver.switchTo().alert();
			// alert.accept();
			// alert.accept();
			// break;
			// default:
			// driver.findElement(By.id("ContentPlaceHolder1_GVDependent_btnDeleteDependent_2")).click();
			// Alert alert2 = driver.switchTo().alert();
			// alert2.accept();
			// alert2.accept();
			// break;
			// }

		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			First_Name.sendKeys(FirstName);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			Middle_Name.sendKeys(MiddleName);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			Last_Name.sendKeys(LastName);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		try {
			jse.executeScript("arguments[0].value='" + SSN + "';",
					driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtSSN']")));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			jse.executeScript("arguments[0].value='" + Date_of_Birth + "';",
					driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtDOB']")));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			CellPhone.sendKeys(Cell_Phone);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			select = new Select(Gender);
			select.selectByVisibleText(Gender_dependent.trim());
			// List<WebElement> Gen_list = select.getOptions();
			// int Gen_size = Gen_list.size();
			// for (int i = 0; i < Gen_size; i++) {
			// String gen_name = Gen_list.get(i).getText();
			// if (gen_name.equals(Gender_dependent)) {
			// select.selectByIndex(i);
			// break;
			// } else {
			// select.selectByValue("F");
			//
			// }
			// }
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// select.selectByVisibleText("Female");
		try {
			select = new Select(Relationship);
			select.selectByVisibleText(Relation_dependent.trim());
			// List<WebElement> Rel_list = select.getOptions();
			// int Rel_size = Rel_list.size();
			// for (int i = 0; i < Rel_size; i++) {
			// String rel_name = Rel_list.get(i).getText();
			// if (rel_name.equals(Relation_dependent)) {
			// select.selectByIndex(i);
			// break;
			// } else {
			// select.selectByVisibleText("Member");
			// }
			// }
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			if (HeightFt.isEnabled() && HeightFt.isDisplayed()) {
				select = new Select(HeightFt);
				select.selectByVisibleText(HeightFeet_dependent);

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			if (HeightIn.isEnabled() && HeightIn.isDisplayed()) {
				select = new Select(HeightIn);
				select.selectByVisibleText(HeightInch_dependent);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			if (Weight.isEnabled() && Weight.isDisplayed()) {

				Weight.sendKeys(Weight_enrolle);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			if (Tobaco.isDisplayed() && Tobaco.isEnabled()) {
				select = new Select(Tobaco);
				select.selectByVisibleText(Tobaco_dependent.trim());
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		try {
			Save_button.click();
			wait.until(ExpectedConditions.alertIsPresent());
			System.out.println("alert was present");
			Alert alert = driver.switchTo().alert();
			DependentAlertName = alert.getText();
			if (DependentAlertName.equalsIgnoreCase("Dependent record added successfully")) {
				DependentRes = "Pass";
				obj2.WriteResultDependent(DependentRes, DataSet);
				System.out.println(DependentAlertName);
				alert.accept();
			} else {
				DependentRes = "Fail" + "," + DependentAlertName;
				obj2.WriteResultDependent(DependentRes, DataSet);
				System.out.println(DependentAlertName);
				alert.accept();
			}

			// WebDriverWait wait = new WebDriverWait(driver, 10);
			// wait.until(ExpectedConditions.alertIsPresent());
			// Alert alert = driver.switchTo().alert();
			// System.out.println(alert.getText());
			// alert.accept();
		} catch (Throwable e) {
			// exception handling
		}

	}
}

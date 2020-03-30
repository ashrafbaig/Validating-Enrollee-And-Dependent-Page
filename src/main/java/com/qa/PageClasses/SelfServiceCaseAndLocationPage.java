package com.qa.PageClasses;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import IES_TestBaseClass.SelfServiceBaseClass;

public class SelfServiceCaseAndLocationPage extends SelfServiceBaseClass {

	Select Case_dropdown;
	Select Location_dropdown;

	///////////////// SelfService/////////////////
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlLocation']")
	WebElement SelfService_CaseDropDown;

	@FindBy(id = "ContentPlaceHolder1_btnNext")
	WebElement SelfService_NextButton;

	@FindBy(id = "ContentPlaceHolder1_btnSkip")
	WebElement SelfService_SkipButton;

	public SelfServiceCaseAndLocationPage() {

		PageFactory.initElements(driver, this);
	}

	public SelfServiceEnrolleePage IES_CaseAndLocation() throws InterruptedException {

		Case_dropdown = new Select(SelfService_CaseDropDown);
		List<WebElement> Case_list = Case_dropdown.getOptions();
		int Case_size = Case_list.size();
		for (int i = 0; i < Case_size; i++) {
			String case_name = Case_list.get(i).getText();
			String Case = wso.getRow(1).getCell(15).getStringCellValue().trim();
			if (case_name.equals(Case)) {
				Case_dropdown.selectByIndex(i);
				break;
			}
		}

		SelfService_NextButton.click();
		try {
			SelfService_SkipButton.click();
		} catch (Throwable sb) {
			sb.printStackTrace();
		}
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), wso.getRow(1).getCell(12).getStringCellValue().trim());

		return new SelfServiceEnrolleePage();
	}

}

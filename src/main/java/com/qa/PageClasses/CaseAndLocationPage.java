package com.qa.PageClasses;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import IES_TestBaseClass.BaseClass;

public class CaseAndLocationPage extends BaseClass {

	@FindBy(xpath = "//select[@id='ddlCase']")
	WebElement CaseDropDown;

	@FindBy(xpath = "//select[@id='ddlLocation']")
	WebElement LocationDropDown;

	@FindBy(id = "btnNext")
	WebElement Next_Button;

	public CaseAndLocationPage() {

		PageFactory.initElements(driver, this);
	}

	Select Case_dropdown;
	Select Location_dropdown;

	public EnrolleePage IES_CaseAndLocation() throws InterruptedException {
		Case_dropdown = new Select(CaseDropDown);
		List<WebElement> Case_list = Case_dropdown.getOptions();
		int Case_size = Case_list.size();
		for (int i = 0; i < Case_size; i++) {
			String case_name = Case_list.get(i).getText();
			String Case = wso.getRow(1).getCell(7).getStringCellValue().trim();
			if (case_name.equals(Case)) {
				Case_dropdown.selectByIndex(i);
				break;
			}
		}

		Location_dropdown = new Select(LocationDropDown);
		List<WebElement> Location_list = Location_dropdown.getOptions();
		int Location_size = Location_list.size();
		for (int i = 0; i < Location_size; i++) {
			String location_name = Location_list.get(i).getText();
			String Location = wso.getRow(1).getCell(8).getStringCellValue().trim();
			if (location_name.equals(Location)) {
				Location_dropdown.selectByIndex(i);
				break;
			}

		}
		Next_Button.click();
		Thread.sleep(2000);
		String Expected_URL = wso.getRow(1).getCell(9).getStringCellValue().trim();
		Assert.assertEquals(driver.getCurrentUrl(), Expected_URL);
		return new EnrolleePage();
	}

}

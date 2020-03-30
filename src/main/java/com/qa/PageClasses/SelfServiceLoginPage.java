package com.qa.PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import IES_TestBaseClass.SelfServiceBaseClass;

public class SelfServiceLoginPage extends SelfServiceBaseClass {

////////////////////////SelfService//////////////////////
	@FindBy(id = "ContentPlaceHolder1_txtUserName")
	WebElement SelfService_username;

	@FindBy(id = "ContentPlaceHolder1_txtPassword")
	WebElement SelfService_password;

	@FindBy(id = "ContentPlaceHolder1_btnLogin")
	WebElement SelfService_loginbutton;

	public SelfServiceLoginPage() {

		PageFactory.initElements(driver, this);
	}

	public SelfServiceCaseAndLocationPage IES_login() {

		SelfService_username.sendKeys(wso.getRow(1).getCell(13).getStringCellValue().trim());
		SelfService_password.sendKeys(wso.getRow(1).getCell(14).getStringCellValue().trim());
		SelfService_loginbutton.click();
		Assert.assertEquals(driver.getCurrentUrl(), wso.getRow(1).getCell(11).getStringCellValue().trim());
		return new SelfServiceCaseAndLocationPage();

	}

}

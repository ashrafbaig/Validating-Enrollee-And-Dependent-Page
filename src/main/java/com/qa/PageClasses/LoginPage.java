package com.qa.PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import IES_TestBaseClass.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id = "txtUsername")
	WebElement username;

	@FindBy(id = "txtPassword")
	WebElement password;

	@FindBy(id = "btnLogin")
	WebElement login_button;

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public CaseAndLocationPage IES_login() {
		username.sendKeys(wso.getRow(1).getCell(3).getStringCellValue().trim());
		password.sendKeys(wso.getRow(1).getCell(4).getStringCellValue().trim());
//		username.sendKeys("Ashraf");
//		password.sendKeys("Ashraf2019");
		login_button.click();
		String ExpectedURL = wso.getRow(1).getCell(10).getStringCellValue().trim();
		Assert.assertEquals(driver.getCurrentUrl(), ExpectedURL);

		return new CaseAndLocationPage();

	}

}

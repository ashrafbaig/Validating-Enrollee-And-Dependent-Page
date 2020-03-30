package com.qa.TestClasses;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.PageClasses.CaseAndLocationPage;
import com.qa.PageClasses.LoginPage;

import IES_TestBaseClass.BaseClass;

public class LoginTest extends BaseClass {
	LoginPage loginpage;
	CaseAndLocationPage CaseLocation;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialization();

	}

	@Test
	public void IES_loginTest() {
		loginpage = new LoginPage();
		CaseLocation=loginpage.IES_login();
		

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}

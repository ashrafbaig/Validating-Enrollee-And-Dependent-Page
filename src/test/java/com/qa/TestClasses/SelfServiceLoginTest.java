package com.qa.TestClasses;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.PageClasses.SelfServiceCaseAndLocationPage;
import com.qa.PageClasses.SelfServiceLoginPage;

import IES_TestBaseClass.SelfServiceBaseClass;

public class SelfServiceLoginTest extends SelfServiceBaseClass {

	SelfServiceLoginPage loginpage;
	SelfServiceCaseAndLocationPage CaseLocation;

	public SelfServiceLoginTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialization();

	}

	@Test
	public void IES_loginTest() {
		loginpage = new SelfServiceLoginPage();
		CaseLocation = loginpage.IES_login();

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}

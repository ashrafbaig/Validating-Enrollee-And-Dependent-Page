package com.qa.TestClasses;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.PageClasses.SelfServiceCaseAndLocationPage;
import com.qa.PageClasses.SelfServiceEnrolleePage;
import com.qa.PageClasses.SelfServiceLoginPage;

import IES_TestBaseClass.SelfServiceBaseClass;

public class SelfServiceCaseAndLocationTest extends SelfServiceBaseClass {

	SelfServiceLoginPage loginpage;
	SelfServiceCaseAndLocationPage CaseLocation;
	SelfServiceEnrolleePage enrolleAdd;

	public SelfServiceCaseAndLocationTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginpage = new SelfServiceLoginPage();
		loginpage.IES_login();
	}

	@Test
	public void IES_CaseAndLocationTest() throws InterruptedException {
		enrolleAdd = CaseLocation.IES_CaseAndLocation();

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}

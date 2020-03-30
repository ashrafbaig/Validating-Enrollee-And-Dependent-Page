package com.qa.TestClasses;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.PageClasses.CaseAndLocationPage;
import com.qa.PageClasses.EnrolleePage;
import com.qa.PageClasses.LoginPage;

import IES_TestBaseClass.BaseClass;

public class CaseAndLocationTest extends BaseClass {
	LoginPage loginpage;
	CaseAndLocationPage CaseLocation;
	EnrolleePage enrolleAdd;

	public CaseAndLocationTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginpage = new LoginPage();
		CaseLocation = new CaseAndLocationPage();
		loginpage.IES_login();
	}

	@Test
	public void IES_CaseAndLocationTest() throws InterruptedException {
		enrolleAdd=CaseLocation.IES_CaseAndLocation();

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}

package com.fba.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fba.qa.base.TestBase;
import com.fba.qa.pages.DealsPage;
import com.fba.qa.pages.HomePage;
import com.fba.qa.pages.LoginPage;
import com.fba.qa.util.TestUtil;

public class DealsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;
	TestUtil utilPage;
	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
		dealsPage = new DealsPage();
		utilPage = new TestUtil();
	}
	
	@Test
	public void searchDealTest() {
		utilPage.switchToFrame();
		homePage.clickDealsPage();
		//homePage.pageVerification();
		dealsPage.typeKeyword();
		dealsPage.typeTag();
		dealsPage.clickSearch();
	}
	
	@AfterMethod
	public void teerDown() {
		driver.quit();
	}

}

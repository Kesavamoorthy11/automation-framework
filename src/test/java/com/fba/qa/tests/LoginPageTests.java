package com.fba.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fba.qa.base.TestBase;
import com.fba.qa.pages.HomePage;
import com.fba.qa.pages.LoginPage;

public class LoginPageTests extends TestBase{
	
	private LoginPage loginPage;
	private HomePage homePage;
	public LoginPageTests() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	//@Test(priority=1)
	public void loginPageTitle() {
	String title =	loginPage.pageTitle();
	Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	//@Test(priority=2)
	public void validateLoginPageLogo() {
	boolean flag = loginPage.validateCRMImage();	
	Assert.assertTrue(flag);
	}
	@Test()
	public void login() {
		try {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		/*String name =homePage.acountantName();
		name.equalsIgnoreCase(prop.getProperty("accountName"));*/
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

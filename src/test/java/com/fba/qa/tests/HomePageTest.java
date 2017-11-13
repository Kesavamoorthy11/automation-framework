package com.fba.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fba.qa.base.TestBase;
import com.fba.qa.pages.ContactsPage;
import com.fba.qa.pages.HomePage;
import com.fba.qa.pages.LoginPage;
import com.fba.qa.util.TestUtil;

/**
 * @author Kesavamoorthy
 *
 */
public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = new ContactsPage();
	}
	
	//@Test
	public void verifyHomePageTitleTest() {
		String title = homePage.pageName();
		Assert.assertEquals(title, "CRMPRO", "Home Page title not matched");
	}
	
	//@Test
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		String name = homePage.acountantName();
		System.out.println(name);
		if(name.equals(prop.getProperty("accountName")));
	}
	
	@Test
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		homePage.contactLinkClick();
		contactPage.isContactLabelPresent();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

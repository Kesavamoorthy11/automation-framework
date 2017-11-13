package com.fba.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fba.qa.base.TestBase;
import com.fba.qa.pages.ContactsPage;
import com.fba.qa.pages.HomePage;
import com.fba.qa.pages.HomePage.contactsDropDown;
import com.fba.qa.pages.LoginPage;
import com.fba.qa.util.TestUtil;

public class ContactPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	TestUtil utilPage;
	
	String sheetName = "Contacts";
	public ContactPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage= new LoginPage();
		contactPage = new ContactsPage();
		utilPage = new TestUtil();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
	}
	
	@Test
	public void checkContactsGridRow() {
		utilPage.switchToFrame();
		homePage.contactLinkClick();
		contactPage.clickOnCheckBoxGridByRowId(1);
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test
	public void goToNewContactPage(){
		utilPage.switchToFrame();
		homePage.selectContactsDropDown(contactsDropDown.NewContacts);
	}
	
	@Test(dataProvider="getTestData")
	public void validateCreateNewContact(String title, String firstname, String lastname, String company) {
		utilPage.switchToFrame();
		homePage.selectContactsDropDown(contactsDropDown.NewContacts);
		contactPage.createNewContact(title, firstname, lastname, company);
	}
	
	@AfterMethod
	public void teerDown(){
		driver.quit();
	}

}

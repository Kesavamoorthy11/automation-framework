package com.fba.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fba.qa.base.TestBase;

public class HomePage extends TestBase{

	ContactsPage contactPage;
	public HomePage(){
		PageFactory.initElements(driver, this);
		contactPage = new ContactsPage();
	}
	
	@FindBy(xpath="//td[@class='headertable']//td[@class='headertext'][1]")
	@CacheLookup
	WebElement loginName;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contacts;
	
	@FindBy(xpath="//a[@title='Deals']")
	@CacheLookup
	WebElement deals;
	
	@FindBy(xpath="//a[@title='Tasks']")
	@CacheLookup
	WebElement tasks;
	
	public String pageName() {
		return driver.getTitle();
	}
	
	public boolean contactLinkClick() {
		contacts.click();
		return contactPage.isContactLabelPresent();
	}
	
	public DealsPage clickDealsPage() {
		deals.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTaskPage() {
		tasks.click();
		return new TasksPage();
	}
	
	public void clickOnTask() {
		tasks.click();
	}
	
	public String acountantName() {
		String name =loginName.getText();
		return name;
	}
	
	public HomePage pageVerification() {
		loginName.isDisplayed();
		contacts.isSelected();
		return pageVerification();
	}
	
	private void contactsDropDownPath(final int dropdownNumber) {
		driver.findElement(By.xpath("//ul[@class='mlddm']/li[4]/ul/li["+dropdownNumber+"]/a")).click();
	}
	
	public void selectContactsDropDown(contactsDropDown dropdown) {
		Actions action = new Actions(driver);
		action.moveToElement(contacts).build().perform();
		switch (dropdown) {
		case NewContacts:
			contactsDropDownPath(1);
			break;
		case CombinedForm:
			contactsDropDownPath(2);
			break;
		case fullSearchForm:
			contactsDropDownPath(3);
		}
		}
	
	
	public enum contactsDropDown {
		NewContacts, CombinedForm, fullSearchForm;
	}
}

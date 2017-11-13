package com.fba.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fba.qa.base.TestBase;

public class ContactsPage extends TestBase{

	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactLabel;
	
	@FindBy(xpath="//form[@id='contactForm']/table//tr[2]//tbody/tr[1]/td[2]/select[@name='title']")
	@CacheLookup
	WebElement title;
	
	@FindBy(xpath="//input[@id='first_name']")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='surname']")
	@CacheLookup
	WebElement lastname;
	
	@FindBy(xpath="//input[@value='Save']")
	@CacheLookup
	WebElement saveButton;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	@CacheLookup
	WebElement company;
	
	public boolean isContactLabelPresent() {
		return contactLabel.isDisplayed();
	}
	
	public void clickOnCheckBoxGridByRowId(int row) {
		row = row+1;
		driver.findElement(By.xpath("(//input[@name='contact_id'])["+row+"]"));
	}
	
	private void selectTitle(String titleName){
		Select select= new Select(title);
		select.selectByVisibleText(titleName);
	}
	
	private void typeFirstname(String fristname){
		firstName.sendKeys(fristname);
	}
	
	private void typeLastname(String surname) {
		lastname.sendKeys(surname);
	}
	
	private void typeCompany(String companyName) {
		company.sendKeys(companyName);
	}
	
	private void clickSaveButton() {
		saveButton.submit();
	}
	
	public void createNewContact (String titlename,String firstname, String ltname, String orgname) {
	selectTitle(titlename);
    typeFirstname(firstname);
    typeLastname(ltname);
    typeCompany(orgname);
    clickSaveButton();
	}
}

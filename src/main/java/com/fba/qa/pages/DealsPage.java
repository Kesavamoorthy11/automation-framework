package com.fba.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fba.qa.base.TestBase;

public class DealsPage extends TestBase{

	public DealsPage () {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='cs_keyword']")
	@CacheLookup
	WebElement keywordField;
	
	@FindBy(xpath="//input[@name='tag']")
	@CacheLookup
	WebElement tagField;
	
	@FindBy(xpath="//input[@value='Search']")
	@CacheLookup
	WebElement searchButton;
	
	public void typeKeyword(){
		keywordField.sendKeys("Deals");
	}
	public void typeTag(){
		tagField.sendKeys("values");
	}
	public void clickSearch(){
		searchButton.submit();
	}
}

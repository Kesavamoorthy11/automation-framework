package com.fba.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fba.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	public HomePage homePage;
	public LoginPage() {
		PageFactory.initElements(driver, this);
		homePage = new HomePage();
	}

	@FindBy(name="username")
	@CacheLookup
	WebElement userName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement pass;
	
	@FindBy(xpath="//div[@class='input-group-btn']/input")
	@CacheLookup
	WebElement loginButton;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	@CacheLookup
	WebElement crmLogo;
	
	public String pageTitle () {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String username, String password) {
		userName.sendKeys(username);
		pass.sendKeys(password);
		loginButton.submit();
		return new HomePage();
	}
}

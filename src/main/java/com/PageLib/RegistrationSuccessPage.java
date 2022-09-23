package com.PageLib;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestMain;
import com.Utils.BugTrackers;

public class RegistrationSuccessPage extends TestMain {
	@FindBy(xpath ="//table[@width = '492']/tbody/tr[3]" )
	WebElement RegistrationSuccessMsg;

	@FindBy (linkText = "sign-in ")
	WebElement SigninLinkAfterRegistration;

	public RegistrationSuccessPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyRegistrationSuccesMsg() {
		return RegistrationSuccessMsg.isDisplayed();
	}
	public String returnRegistrationPageTitle() {
		return driver.getTitle();
	}
	public String returnRegistrationSuccessPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public void flashErrUnExpected() {
		BugTrackers.flash(RegistrationSuccessMsg, driver);
	 }
	 public void createBugAleart() {
		 BugTrackers.generateAlert(driver,("This Was Not Expected"));
		 }
	
	 public void drawBorderOnUnexpected() {
		BugTrackers.drawBorder(RegistrationSuccessMsg, driver); 
	 }
}

package com.PageLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestMain;
import com.Utils.BugTrackers;

public class LoginErrorPage extends TestMain {
	@FindBy(xpath = "//span[contains(text(),'and password correct')] ")
	 WebElement loginErrMsg;
	 
	 public LoginErrorPage() {
		 PageFactory.initElements(driver, this);
	 }
	 public boolean validateLoginErrMsg() {
		 return loginErrMsg.isDisplayed();
	 }
	 public String getCurrentPageTitle () {
		 return driver.getTitle();
	 }
	 
	 public void flashErrUnExpected() { 
		 BugTrackers.flash(loginErrMsg, driver);
	 }
	 public void createBugAleart() {
		 BugTrackers.generateAlert(driver, ("This is Bug Please fix it"));
	 }
	 public void drawBorderOnUnexpected() {
		BugTrackers.drawBorder(loginErrMsg, driver); 
	 }
}

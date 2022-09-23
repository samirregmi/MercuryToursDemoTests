package com.PageLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestMain;
import com.Utils.BugTrackers;
//CarRentals, Cruise , Hotels,support
public class CruisesPage extends TestMain {

	@FindBy(linkText = "Cruises")
	WebElement cruiseLink;
	
	public CruisesPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void flashErr() {
	BugTrackers.flash(cruiseLink, driver);
	
}
	public void drawBorder() throws Exception {
		BugTrackers.drawBorder(cruiseLink, driver);	
		Thread.sleep(3000);
	}
	public void createBugAlert() throws Exception {
		BugTrackers.generateAlert(driver, "Bug Found Please Fix!!!");
		Thread.sleep(3000);
	}
}

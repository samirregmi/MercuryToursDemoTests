package com.PageLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestMain;
import com.Utils.BugTrackers;

public class Car_RentalsPage extends TestMain {
@FindBy(xpath = "//table[@width = '492']/tbody/tr/td/img[@width = '492']")
WebElement UnderConstructionLabel;

@FindBy(xpath = "//Table[@width = '492']/tbody/tr[3]/td/p/font/b/font[1]")
WebElement BodyInfo;

@FindBy(xpath = "//img[@height= '23']")
WebElement BackToHomeBtn;

@FindBy(linkText = "Home")
WebElement HomeLink;

public Car_RentalsPage() {
	PageFactory.initElements(driver, this);
}
public boolean underConstructionLabelIsPresent() {
	return UnderConstructionLabel.isDisplayed();
}

public void clickBackToHomeBtn() {
	BackToHomeBtn.click();
}
public void clickHomeLink() {
	HomeLink.click();
}
public String getPageTitle() {
	return driver.getTitle();
}
public String getPageUrl() {
	return driver.getCurrentUrl();
}
public String  validateBodyText() {
	return BodyInfo.getText();
}

public void flashErrUnExpected() { 
	 BugTrackers.flash(UnderConstructionLabel, driver);
}
public void drawBorderOnUnexpected() {
	BugTrackers.drawBorder(UnderConstructionLabel, driver); 
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void createBugAleart() {
	 BugTrackers.generateAlert(driver, ("You are on right page"));
}
}



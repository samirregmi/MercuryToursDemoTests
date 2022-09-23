package com.PageLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.TestBase.TestMain;

public class FlightsPage extends TestMain {
	Select select;
	@FindBy(xpath = "//table[@width = '492']/tbody/tr/td/img[@width = '492']")
	WebElement FlightFinderLabel;

	@FindBy(xpath = "//table[@width='492']/tbody/tr[3]/td/font")
	WebElement FlightFinderInfo;

	@FindBy(linkText = "SIGN-OFF")
	WebElement signoffBtn;

	@FindBy(xpath = "//input[@value = 'roundtrip']")
	WebElement roundtripRadioBtn;

	@FindBy(xpath = "//input[@value = 'oneway']")
	WebElement onewayRadioBtn;

	@FindBy(name = "passCount")
	WebElement passengerCount;

	@FindBy(name = "fromPort")
	WebElement departingPort;

	@FindBy(name = "fromMonth")
	WebElement departingMonth;

	@FindBy(name = "fromDay")
	WebElement departingDay;

	@FindBy(name = "toPort")
	WebElement arrivingPort;

	@FindBy(name = "toMonth")
	WebElement arrivingMonth;

	@FindBy(name = "toDay")
	WebElement arrivingDay;

	@FindBy(xpath = "//input[@value = 'Coach']")
	WebElement economyRadioBtn;

	@FindBy(xpath = "//input[@value = 'Business']")
	WebElement businessClassRadioBtn;

	@FindBy(xpath = "//input[@value = 'First']")
	WebElement firstClassRadioBtn;

	@FindBy(name = "airline")
	WebElement airlinesSelectionDropdown;

	@FindBy(xpath = "//input[@name = 'findFlights']")
	WebElement ContinueBtn;
	
	@FindBy(linkText = "Home")
	WebElement HomeLink;
	
	public FlightsPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public boolean validateFlightFinderLabelIsDisplayed() {
		return FlightFinderLabel.isDisplayed();

	}

	public String returnFlightFInderInfo() {
		return FlightFinderInfo.getText();
	}
	public void clickSignoffBtn() {
		signoffBtn.click();	
	}
	
	public void clickHomeLink() {
		HomeLink.click();
	}
	
	public void selectTripType() {
	if(roundtripRadioBtn.isSelected()) {
		onewayRadioBtn.click();	
	}
	else if(onewayRadioBtn.isSelected()) {
		roundtripRadioBtn.click();	
	}
	else {
		System.err.println("Feature Unavailable");
	}
		
	}
public void selectPassengerCount() {
	this.select = new Select(passengerCount);
	select.selectByIndex(3);
	select.selectByValue("2");
	select.selectByVisibleText("1");
}
public void selectDepartingCity() {
	this.select = new Select(departingPort);
	select.selectByIndex(4);
	select.selectByValue("New York");
	}
public void selectDepartingMonth() {
	this.select = new Select(departingMonth);
	select.selectByVisibleText("July");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	select.selectByIndex(5);
	}
public void selectDepartingday() {
	this.select = new Select(departingDay);
	select.selectByValue("20");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	select.selectByIndex(20);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	select.selectByVisibleText("10");
	
}

public void selectArrivingCity(){
	this.select = new Select(arrivingPort);
	select.selectByValue("Zurich");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	select.selectByIndex(8);
}

public void selectreturMonth(){
	this.select = new Select(arrivingMonth);	
select.selectByIndex(9);
try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
select.selectByVisibleText("October");
}

public void selectreturDay(){
	this.select = new Select(arrivingDay);
	select.selectByValue("25");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	select.selectByVisibleText("16");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	select.selectByIndex(21);
}
public void selectServicClass(){
	economyRadioBtn.click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	businessClassRadioBtn.click();
	firstClassRadioBtn.click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	economyRadioBtn.click();
}
public void selectAirlines(){
	this.select = new Select(airlinesSelectionDropdown);
	select.selectByVisibleText("Pangea Airlines");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	select.selectByIndex(2);
}

public void clickContBtn() {
	ContinueBtn.click();	
}
public String returnCurrentPageTitle() {
	return driver.getTitle();
}
public String returnCurrentUrl() {
	return driver.getCurrentUrl();
}

}
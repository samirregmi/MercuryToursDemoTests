package com.PageLib;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestMain;
import com.Utils.BugTrackers;

public class HomePage extends TestMain {

	@FindBy(name = "userName")
	WebElement usernameTextField;

	@FindBy(name = "password")
	WebElement passwordTextField;

	@FindBy(name = "submit")
	WebElement submitBtn;

	@FindBy(linkText = "SIGN-ON")
	WebElement signOnLink;

	@FindBy(linkText = "REGISTER")
	 WebElement RegisterLink;

	@FindBy(linkText = "SUPPORT")
	WebElement SupportLink;

	@FindBy(linkText = "Flights")
	WebElement FlightsLink;

	@FindBy(linkText = "Cruises")
	WebElement CruisesLink;

	@FindBy(linkText = "Hotels")
	WebElement FindHotelsLink;
	
	@FindBy(linkText = "Home")
	WebElement HomeLink;
	
	@FindBy(linkText = "Car Rentals")
	WebElement CarRentalsLink;

	@FindBy(xpath = "//img[@alt = 'Specials']")
	WebElement SpecialsHeader;
	
	@FindBy(xpath = "//table[@width = '270']")
	WebElement SpecialDealsInfoAtHomepage;

	@FindBy(xpath = "//img[@alt = 'Tour Tips']")
	WebElement TourTipsHeader;
	
	@FindBy(xpath = "//font[contains(text(),'carry a travel first aid')]")
	WebElement TourTipsInfoAtHomepage;

	@FindBy(xpath = "//table[@width = '192']/tbody/tr[4]/td/table/tbody/tr[1]")////table[@width = '192']/tbody/tr[4]/td/table/tbody/tr[1]
	WebElement findAFlightInfo;

	@FindBy(xpath = "//table[@width = '492']/tbody/tr[2]//td//p/img")
	WebElement FeaturedDestinationInfo;

	@FindBy(xpath = "//a[text()='Salon Travel']")
	WebElement TravelAgencyLink;
	
	@FindBy(linkText = "featured vacation destinations")
	WebElement featuredVacationDestinationsLink;
	
	@FindBy(linkText = "Register here")
	WebElement RegisterHereLink;

	@FindBy(xpath = "//img[@alt = 'Mercury Tours']")
	WebElement MercuryToursLogo;
	
	@FindBy(xpath = "//table[@width = '277']/tbody/tr[3]//td/img")
	WebElement TIPLogo;
	
	

public HomePage() {
	PageFactory.initElements(driver, this);
}
	public boolean verifyMercuryToursLogo() {
	return MercuryToursLogo.isDisplayed();
}
	public  void loginWithClickSubmitButton(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		submitBtn.click();
		
	}
	public void loginByHittingEnterKey(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		submitBtn.sendKeys(Keys.ENTER);
	}
	public void entertUserName(String username) {
		usernameTextField.sendKeys(username);
	}

	public void enterPassword(String Password) {
		passwordTextField.sendKeys(Password);
	}

	public void clickSubmitBtn() {
		submitBtn.click();
	}
	
	public void clickCarRentalsLink() {
		CarRentalsLink.click();
	}

	public void hitEnterButtonOnKeyBoard() {
		submitBtn.sendKeys(Keys.ENTER);
	}

	public void clickSignonLink() {
		signOnLink.click();
	}

	public void clickRegisterLink() {
		RegisterLink.click();
	}

	public void clickSupportLink() {
		SupportLink.click();
	}

	public void clickFlightsLink() {
		FlightsLink.click();
	}

	public void clickCruisesLink() {
		CruisesLink.click();
	}

	public void clickFindHotelsLink() {
		FindHotelsLink.click();
	}
	public void clickTravelagencyLink() {
		TravelAgencyLink.click();
	}
	
	public void clickHomeLink() {
		HomeLink.click();
	}
	public boolean verifyIfTIPLogoIsPresent() {
		return TIPLogo.isDisplayed();
	}
	
	public void clickRegisterHereLink() {
		RegisterHereLink.click();
	}
	
	public boolean verifySpecialsHeaderOnHomePage() {
	return	SpecialsHeader.isDisplayed();	
	}
	
	public boolean verifyTourTipsHeaderOnHomePage() {
		return	TourTipsHeader.isDisplayed();	
		}
	
	public String verifyTourTipsInfoAtHomepage() {
		return TourTipsInfoAtHomepage.getText();
	}
	
	public boolean verifyFeaturedDestinationInfoAtHomepage() {
		return SpecialDealsInfoAtHomepage.isDisplayed();
	}
	public String validateSpecialsInformation() {
		return SpecialDealsInfoAtHomepage.getText();
	} 

	public boolean validateFindFlightInfo() {
		return findAFlightInfo.isDisplayed();
	}
	public String validateFindAFlightInfoText() {
		return findAFlightInfo.getText();
	}

	public boolean validatefeaturedDestination() {
		return FeaturedDestinationInfo.isDisplayed();
	}
	
	public String validateTextUnderFeaturedDestinations() {
		return FeaturedDestinationInfo.getText();	
	}
	
	public void clickFeaturedVacationDestinationsLink() {
		 featuredVacationDestinationsLink.click();
	}	
	public boolean verifyIffeaturedVacationDestinationsLinkIsPresent() {
		return featuredVacationDestinationsLink.isDisplayed();
	}
	public void validateRegisterHereLink() {
		RegisterHereLink.click();
	}
		
	public String returnHomePageTitle() {
		return driver.getTitle();
	}

	public String returnHomePageURL() {
		return driver.getCurrentUrl();
		
	}
	
	public void flashErrMsg(){
	BugTrackers.flash(CruisesLink, driver);	
		
	 }
	
	 public void createBugAleart() {
		 BugTrackers.generateAlert(driver, ("THIS WAS NOT EXPECTED\n FIX IT"));
	 }
	 
	 public void drawBorder() {
			BugTrackers.drawBorder(CruisesLink, driver);
		}
	
	
}



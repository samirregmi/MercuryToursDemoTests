package com.PageLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestMain;

public class LoginSuccessPage extends TestMain {
	@FindBy(xpath = "//h3[contains(text(),'Login Successfully')]")
	WebElement loginSuccessMsg;
	
	@FindBy(xpath = "//a[contains(text(),'SIGN-OFF')]")
	WebElement signOffLink;
	
	@FindBy(xpath = "//img[@ alt = 'Mercury Tours']]")
	WebElement MercuryToursLogo;
	
	public LoginSuccessPage() {
		PageFactory.initElements(driver, this);
	}
	public void clickSignoffLink() {
		signOffLink.click();
	}
	
	public boolean verifyMercuryToursLogo() {
		return MercuryToursLogo.isDisplayed();
	}
	public String returnLoginSuccessPageTitle() {
	return driver.getTitle();
	}
	
	public String returnLoginSuccessfulMsg() {
		return loginSuccessMsg.getText();
	}
	public boolean verifyLoginSuccessMsg() {
		return loginSuccessMsg.isDisplayed();
	}

}

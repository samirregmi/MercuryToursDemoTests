package com.PageLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestMain;

public class Sign_OnPage extends TestMain {
	@FindBy(xpath = "//font[contains (text(),' Enter your user information ')]")
	WebElement SignOnMsg;
	
	@FindBy(xpath = "//table[@width = '492']/tbody/tr/td/img[@ height = '30']")
	WebElement SignOnBannerOnSignonPage;

	@FindBy(name="userName")
	WebElement userNameTxtField;

	@FindBy(name="password")
	WebElement passwordTxtField;

	@FindBy(name="submit")
	WebElement submitBtn;
	
	@FindBy(linkText = "Home")
	WebElement HomeLink;

	public Sign_OnPage() {
		PageFactory.initElements(driver,this);
	}
	public void EnterUserName(String Uname) {
		userNameTxtField.sendKeys(Uname);	
	}
	public void EnterPassword(String Password) {
		passwordTxtField.sendKeys(Password);
		}
	public void ClickSubmitButton() {
		submitBtn.click();
	}
	public void clickHomeLink() {
		HomeLink.click();
	}
	public void SignOn(String username, String Password) {
		userNameTxtField.sendKeys(username);
		passwordTxtField.sendKeys(Password);
		submitBtn.click();
	}
	
	public boolean validateSignOnMsg() {
		return SignOnMsg.isDisplayed();
	}
	public String returnSignOnPageTitle() {
		return driver.getTitle();
	}
}

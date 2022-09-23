package com.PageLib;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.TestBase.TestMain;

public class RegisterPage extends TestMain {
	@FindBy(name = "firstName")
	WebElement firstnameTxtField;

	@FindBy(name = "lastName")
	WebElement lastnameTxtField;

	@FindBy(name = "phone")
	WebElement phoneNoTxtField;

	@FindBy(name = "userName")
	WebElement emailAddTxtField;

	@FindBy(name = "address1")
	WebElement addressTxtField;

	@FindBy(name = "city")
	WebElement cityTxtField;

	@FindBy(name = "state")
	WebElement stateTxtField;

	@FindBy(name = "postalCode")
	WebElement postalCodeTxtField;

	@FindBy(name = "country")
	WebElement countryTxtField;


	@FindBy(name = "email")
	WebElement usernameTxtField;

	@FindBy(name = "password")
	WebElement passwordTxtField;

	@FindBy(name = "confirmPassword")
	WebElement confirmPasswordTXTField;

	@FindBy(name = "submit")
	WebElement clickSubmitBtn;

	@FindBy(xpath = "//table[@width = '492']/tbody/tr/td/img[@height = '30']")
	WebElement RegisterLabel;
	
	@FindBy(xpath = "//font[contains(text(),'reservation confirmation emails')]")
	WebElement registerPageHeaderTXT ;
	
	@FindBy(linkText = "Home")
	WebElement HomeLink;
	
	public RegisterPage () {
		PageFactory.initElements(driver, this);
	}
	//(String Fname, String Lname, String phone, String email, String address, String city, String State, String zip,String 
	//country, String Username, String Password, String confirmPassword)
	public void RegistrationFunctionality(String Fname, String Lname, String phone, String email, String address, String city, 
			                        String State, String zip, String Username, String Password, String confirmPassword) throws Exception {
		
		firstnameTxtField.sendKeys(Fname);
		lastnameTxtField.sendKeys(Lname);
		phoneNoTxtField.sendKeys(phone);
		emailAddTxtField.sendKeys(email);
		addressTxtField.sendKeys(address);
		cityTxtField.sendKeys(city);
		stateTxtField.sendKeys(State);
		postalCodeTxtField.sendKeys(zip);
		Select select = new Select(countryTxtField);
		select.selectByIndex(5);
		usernameTxtField.sendKeys(Username);
		passwordTxtField.sendKeys(Password);
		confirmPasswordTXTField.sendKeys(confirmPassword);
		//clickSubmitBtn.click();
	}
	public void countryName() {
		countryTxtField.sendKeys("$%#@");	
	}
	
	public void clickSubmitButton() {
		clickSubmitBtn.click();
	}
	public void hitEnterButton() {
		clickSubmitBtn.sendKeys(Keys.ENTER);
	}
	
	
	public void clickHomeLink() {
		HomeLink.click();
	}
	
	public boolean registerPageInfoTxt() {
		 return registerPageHeaderTXT.isDisplayed();
	}
	public String getRegisterPageInfoTxt() {
		return registerPageHeaderTXT.getText();
	}
	
	public boolean validateRegisterLabelIsDisplayed() {
		return RegisterLabel.isDisplayed();
	}
	public String getRegisterPageTitle() {
		return driver.getTitle();
	}
	public String getRegisterPageUrl() {
		return driver.getCurrentUrl();
	}
	
	
}

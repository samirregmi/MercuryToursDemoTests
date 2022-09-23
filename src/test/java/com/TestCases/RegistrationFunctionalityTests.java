package com.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageLib.HomePage;
import com.PageLib.RegisterPage;
import com.PageLib.RegistrationSuccessPage;
import com.TestBase.TestMain;
import com.TestDatas.RegistrationFunctionalityTestDatas;

public class RegistrationFunctionalityTests extends TestMain {
	HomePage home;
	RegisterPage register;
	RegistrationSuccessPage registerSuccess;

	public RegistrationFunctionalityTests() {
		super();
	}

	@BeforeMethod
	public void browserSetup() {
		initialization();
		home = new HomePage();
		register = new RegisterPage();
		registerSuccess = new RegistrationSuccessPage();
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

	//@Test(dataProviderClass = RegistrationFunctionalityTestDatas.class, dataProvider = "positiveRegistrationData")
	public void positiveRegistrationTest(String Fname, String Lname, String phone, String email, String address,
			String city, String State, String zip, String Username, String Password, String confirmPassword)
			throws Exception {
		Assert.assertEquals(home.returnHomePageURL(), prop.getProperty("HomepageUrl"));
		Assert.assertTrue(home.verifyIfTIPLogoIsPresent());
		home.clickRegisterLink();
		Assert.assertTrue(register.validateRegisterLabelIsDisplayed());
		register.RegistrationFunctionality(Fname, Lname, phone, email, address, city, State, zip, Username, Password,
				confirmPassword);
		register.clickSubmitButton();
		Assert.assertTrue(registerSuccess.verifyRegistrationSuccesMsg());
		Assert.assertEquals(registerSuccess.returnRegistrationPageTitle(), prop.getProperty("RegistrationPageTitle"));
	}

	//@Test(dataProviderClass = RegistrationFunctionalityTestDatas.class, dataProvider = "Blank Form Nagativetive Registration Test")
	public void negativeRegistrationTestByleavingAllFieldsBlank(String Fname, String Lname, String phone, String email,
			String address, String city, String State, String zip, String Username, String Password,
			String confirmPassword) throws Exception {
		Thread.sleep(3000);
		Assert.assertTrue(home.verifyMercuryToursLogo());
		home.clickRegisterLink();
		Assert.assertTrue(register.validateRegisterLabelIsDisplayed());
		register.RegistrationFunctionality(Fname, Lname, phone, email, address, city, State, zip, Username, Password,
				confirmPassword);
		register.hitEnterButton();
		registerSuccess.flashErrUnExpected();
		registerSuccess.drawBorderOnUnexpected();
		Thread.sleep(3000);
		registerSuccess.createBugAleart();
		//Assert.assertFalse(registerSuccess.verifyRegistrationSuccesMsg());

	}
	//@Test(dataProviderClass = RegistrationFunctionalityTestDatas.class, dataProvider = "Negativetive Registration Test")
	public void negativeRegistrationTestBynumericAndSpecialCharacter(String Fname, String Lname, String phone, String email,
			String address, String city, String State, String zip, String Username, String Password,
			String confirmPassword) throws Exception{
		Assert.assertTrue(home.verifyMercuryToursLogo());
		Assert.assertEquals(home.verifyTourTipsInfoAtHomepage(), prop.getProperty("TourTips"));
		home.clickRegisterLink();
	Assert.assertEquals(register.getRegisterPageInfoTxt(), prop.getProperty("RegisterPageInfotxt"));
	register.RegistrationFunctionality(Fname, Lname, phone, email, address, city, State, zip, Username, Password, confirmPassword);
	register.hitEnterButton();
	registerSuccess.flashErrUnExpected();
	registerSuccess.drawBorderOnUnexpected();
	registerSuccess.createBugAleart();
	//Assert.assertFalse(registerSuccess.verifyRegistrationSuccesMsg());
	}
	
	//@Test(dataProviderClass = RegistrationFunctionalityTestDatas.class, dataProvider = "Negative Registration SeperatePasswords" )
	public void negativeRegistrationFunctionlaityTestBySeperatePasswordForPasswordAndConfirmPasswordField(String Fname, String Lname, String phone, String email,
			String address, String city, String State, String zip, String Username, String Password,
			String confirmPassword) throws Exception {
		Assert.assertTrue(home.verifyMercuryToursLogo());
		Assert.assertEquals(home.verifyTourTipsInfoAtHomepage(), prop.getProperty("TourTips"));
		home.clickRegisterLink();
		Assert.assertEquals(register.getRegisterPageInfoTxt(), prop.getProperty("RegisterPageInfotxt"));
		register.RegistrationFunctionality(Fname, Lname, phone, email, address, city, State, zip, Username, Password, confirmPassword);
		register.clickSubmitButton();
		Thread.sleep(3000);
	}
	
	@Test(dataProviderClass = RegistrationFunctionalityTestDatas.class, dataProvider = "NegativeRegistrationDataWithDuplicateDatas")
	public void negativeRegistrationWithDuplicateRegistrationTestData(String Fname, String Lname, String phone, String email,
			String address, String city, String State, String zip, String Username, String Password,
			String confirmPassword) throws Exception {
		Assert.assertTrue(home.verifyMercuryToursLogo());
		Assert.assertEquals(home.verifyTourTipsInfoAtHomepage(), prop.getProperty("TourTips"));
		home.clickRegisterLink();
		Assert.assertEquals(register.getRegisterPageInfoTxt(), prop.getProperty("RegisterPageInfotxt"));
		register.RegistrationFunctionality(Fname, Lname, phone, email, address, city, State, zip, Username, Password, confirmPassword);
		register.clickSubmitButton();
	}
}


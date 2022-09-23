package com.TestCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageLib.HomePage;
import com.PageLib.LoginErrorPage;
import com.PageLib.LoginSuccessPage;
import com.PageLib.Sign_OnPage;
import com.TestBase.TestMain;
import com.TestDatas.LoginFunctionalityTestDatas;

public class LoginFunctionalityTests extends TestMain {
HomePage home;
LoginSuccessPage login;
LoginErrorPage loginerr;
Sign_OnPage sign_on;

public LoginFunctionalityTests() {
	super();
}
@BeforeMethod
public void setUp() {
	initialization();
	home = new HomePage();
	login = new LoginSuccessPage();
	loginerr = new LoginErrorPage();
	sign_on = new Sign_OnPage();
}
@AfterMethod
	public void closeBrowser() {
	tearDown();
	}
//1.
	@Test(dataProviderClass =LoginFunctionalityTestDatas.class, dataProvider = "positive login Data" )
	public void positiveLoginFunctionalityTest(String uname, String pword) throws Exception {
		Assert.assertEquals(home.returnHomePageTitle(), prop.getProperty("HomePageTitle"));
		home.loginWithClickSubmitButton(uname, pword);
		// home.entertUserName(uname);
		// home.enterPassword(pword);
		// home.clickSubmitBtn();
		Assert.assertTrue(login.verifyLoginSuccessMsg());
		Assert.assertEquals(login.returnLoginSuccessPageTitle(), prop.getProperty("LoginPageTitle"));
	}

	// 2.
	@Test(dataProviderClass =LoginFunctionalityTestDatas.class, dataProvider = "positive login Data" )
	public void PositiveLoginFromSignOnPage(String username, String password) {

		Assert.assertTrue(home.verifyFeaturedDestinationInfoAtHomepage());
		home.clickSignonLink();
		Assert.assertTrue(sign_on.validateSignOnMsg());
		sign_on.SignOn(username, password);

		Assert.assertTrue(login.verifyLoginSuccessMsg());
	}

	// 3.
	@Test(dataProviderClass =LoginFunctionalityTestDatas.class, dataProvider = "positive login Data" )
	public void positiveLoginFunctionalityTestByHittingEnterKey(String uname, String pword) {
		Assert.assertEquals(home.returnHomePageTitle(), prop.getProperty("HomePageTitle"));
		home.loginByHittingEnterKey(uname, pword);
		// home.entertUserName(uname);
		// home.enterPassword(pword);
		// home.clickSubmitBtn();
		Assert.assertTrue(login.verifyLoginSuccessMsg());
		Assert.assertEquals(login.returnLoginSuccessPageTitle(), prop.getProperty("LoginPageTitle"));
	}

	// 4.
	@Test(dataProviderClass =LoginFunctionalityTestDatas.class, dataProvider = "Negative Login Data" )
	public void NegativeLoginFunctionalityWithInvalidCredentialsAndHitEnterButton(String uname, String pword) throws Exception {
		Assert.assertEquals(home.returnHomePageTitle(), prop.getProperty("HomePageTitle"));
		home.loginByHittingEnterKey(uname, pword);
		// home.entertUserName(uname);
		// home.enterPassword(pword);
		// home.clickSubmitBtn();
		loginerr.flashErrUnExpected();
		loginerr.createBugAleart();
		Thread.sleep(5000);
		
		Assert.assertTrue(loginerr.validateLoginErrMsg());
	}
	
	//5.
	@Test(dataProviderClass =LoginFunctionalityTestDatas.class, dataProvider = "Negative Login Data" )
	public void NegativeLoginFunctionalityWithInvalidCredentialsAndClickSubmitButton(String uname, String pword) throws Exception {
		Assert.assertEquals(home.returnHomePageTitle(), prop.getProperty("HomePageTitle"));
		home.loginWithClickSubmitButton(uname, pword);
		// home.entertUserName(uname);
		// home.enterPassword(pword);
		// home.clickSubmitBtn();
		loginerr.flashErrUnExpected();
		loginerr.drawBorderOnUnexpected();
		loginerr.createBugAleart();
		Thread.sleep(5000);
		
		
		
		Assert.assertTrue(loginerr.validateLoginErrMsg());
	}

	// 6.
	@Test(dataProviderClass = LoginFunctionalityTestDatas.class,dataProvider = "Invalid UserName Valid Password")
	public void NegativeLoginFunctionalityTestInvalidUsernameValidPassword(String uname, String pword)
			throws Exception {
		Assert.assertEquals(home.returnHomePageTitle(), prop.getProperty("HomePageTitle"));
		home.loginWithClickSubmitButton(uname, pword);
		// home.entertUserName(uname);
		// home.enterPassword(pword);
		// home.clickSubmitBtn();
		loginerr.flashErrUnExpected();
		loginerr.createBugAleart();
		Thread.sleep(5000);

		Assert.assertTrue(loginerr.validateLoginErrMsg());
	}

	// 7.
	@Test(dataProviderClass = LoginFunctionalityTestDatas.class , dataProvider = "InalidUsernameAndInvalidPasswordData")
	public void NegativeLoginFunctionalityTestWithInvalidCredentialsAndClick(String uname, String pword)
			throws Exception {
		Assert.assertEquals(home.returnHomePageTitle(), prop.getProperty("HomePageTitle"));
		Assert.assertEquals(home.returnHomePageTitle(), "Welcome: Mercury Tours");
		home.loginWithClickSubmitButton(uname, pword);
		// home.entertUserName(uname);
		// home.enterPassword(pword);
		// home.clickSubmitBtn();
		
		
	}
//8.
	@Test(dataProviderClass = LoginFunctionalityTestDatas.class, dataProvider = "ValidUsernameInvalidPassword")
		public void NegativeLoginFunctionalityTestValidUsernameInvalidPassword(String uname, String pword) {
		Assert.assertEquals(home.returnHomePageTitle(), prop.getProperty("HomePageTitle"));
		home.loginByHittingEnterKey(uname, pword);
		// home.entertUserName(uname);
		// home.enterPassword(pword);
		// home.clickSubmitBtn();
		Assert.assertTrue(loginerr.validateLoginErrMsg());
	}

	// 9.
	@Test (dataProviderClass = LoginFunctionalityTestDatas.class,dataProvider = "BlankUsernameAndPasswordNegativeLoginData")
	public void NegativeLoginFunctionalityTestWithBlankTextFieldAndClickSubmitbtn(String uname, String pword) {
		Assert.assertEquals(home.returnHomePageTitle(), prop.getProperty("HomePageTitle"));
		home.loginWithClickSubmitButton(uname, pword);
		// home.entertUserName(uname);
		// home.enterPassword(pword);
		// home.clickSubmitBtn();
		Assert.assertTrue(loginerr.validateLoginErrMsg());
	}

	

}
	


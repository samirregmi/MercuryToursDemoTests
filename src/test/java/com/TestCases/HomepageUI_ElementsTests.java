package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageLib.HomePage;
import com.PageLib.LoginSuccessPage;
import com.TestBase.TestMain;

public class HomepageUI_ElementsTests extends TestMain {
  HomePage home;
  LoginSuccessPage lsp;

public HomepageUI_ElementsTests() {
	super();
}
@BeforeMethod
public  void setUp() {
	initialization();
	home = new HomePage();
	lsp = new LoginSuccessPage();
}
@AfterMethod
public  void closeBrowser() {
	tearDown();	
}
//1.
@Test
public void verifyCorrectHomepageUrl() {
Assert.assertEquals(home.returnHomePageURL(), prop.getProperty("HomepageUrl"));
}
//2.
@Test
public void verifyMercuryToursLogoIsPresent() {
Assert.assertTrue(home.verifyMercuryToursLogo());
}
//3.
@Test
public void verifyIfMessageUnderFindAFlightHaveSpellingErrors() {
Assert.assertEquals(home.validateFindAFlightInfoText(), prop.getProperty("FindAFlight"));	
}
//4.
@Test
public void verifyInformationUnderSpecialsBannerIsCorrect() {
Assert.assertEquals(home.returnHomePageTitle(), prop.getProperty("HomePageTitle"));
Assert.assertTrue(home.verifySpecialsHeaderOnHomePage());
Assert.assertTrue(home.verifySpecialsHeaderOnHomePage());
Assert.assertTrue(home.verifyFeaturedDestinationInfoAtHomepage());
//Assert.assertEquals(home.validateSpecialsInformation(), "Atlanta to Las Vegas	\r\n"
//		+ "$398\r\n"
//		+ "Boston to San Francisco	\r\n"
//		+ "$513\r\n"
//		+ "Los Angeles to Chicago	\r\n"
//		+ "$168\r\n"
//		+ "New York to Chicago	\r\n"
//		+ "$198\r\n"
//		+ "Phoenix to San Francisco	\r\n"
//		+ "$213\r\n"
//		+ "");
}

@Test
public void VerifyIfFeaturedDestinationInfoIsDisplayedOnHomepageWithCorrectInformation() {
	Assert.assertEquals(home.returnHomePageURL(), prop.getProperty("HomepageUrl"));
	Assert.assertTrue(home.validatefeaturedDestination());
}
//6.
@Test
public void VerifyIfMessageUnderTourTipsHasAnySpellingErrors() {
	
	Assert.assertEquals(home.verifyTourTipsInfoAtHomepage(), prop.getProperty("TourTips"));
}
//7.
@Test
public void verifyLoginFunctionalityIsFunctional( ) {
	Assert.assertEquals(home.returnHomePageTitle(), prop.getProperty("HomePageTitle"));
	home.entertUserName(prop.getProperty("username" ));
	home.enterPassword(prop.getProperty("password"));
	home.clickSubmitBtn();
	Assert.assertEquals(home.returnHomePageURL(), prop.getProperty("HomepageUrl"));
	
}
//8.
@Test
public void verifySubmitButtonOnHomepageIsClickable() {
Assert.assertEquals(home.returnHomePageTitle(), prop.getProperty("HomePageTitle"));
home.clickSubmitBtn();
//Assert.assertTrue(lsp.verifyMercuryToursLogo());
Assert.assertEquals(lsp.returnLoginSuccessfulMsg(), prop.getProperty("LoginSuccessPageMsg"));
}
//9. //Bug
@Test
public void verifyFeaturedVacationDestinationsLinkIsFunctional() throws Exception {
home.clickFeaturedVacationDestinationsLink();
Assert.assertFalse(home.verifyIffeaturedVacationDestinationsLinkIsPresent());

//home.flashErrMsg();
//home.createBugAleart();
//home.drawBorder();
}
}

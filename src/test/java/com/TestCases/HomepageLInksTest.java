package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageLib.Car_RentalsPage;
import com.PageLib.CruisesPage;
import com.PageLib.FlightsPage;
import com.PageLib.HomePage;
import com.PageLib.HotelsPage;
import com.PageLib.RegisterPage;
import com.PageLib.Sign_OnPage;
import com.PageLib.SupportPage;
import com.TestBase.TestMain;
import com.Utils.BugTrackers;

public class HomepageLInksTest extends TestMain  {
HomePage home;
Sign_OnPage sop;
RegisterPage rp;
SupportPage sup;
FlightsPage fp;
HotelsPage hp;
Car_RentalsPage crp;
CruisesPage cruisep;
BugTrackers bugs;
 

public HomepageLInksTest(){//(HomePage home, Sign_OnPage sop, RegisterPage rp, SupportPage sup, FlightsPage fp,
		//HotelsPage hp, Car_RentalsPage crp, CruisesPage cruisep, BugTrackers bugs) {
	super();
	
	
}

@BeforeMethod
public  void loadBrowser() {
	initialization();	 
	home = new HomePage();
	sop = new Sign_OnPage();
	rp = new RegisterPage();
	sup = new SupportPage();
	fp = new FlightsPage();
	hp = new HotelsPage();
	crp = new Car_RentalsPage();
	cruisep = new CruisesPage();
	bugs = new BugTrackers();
	
}
@AfterMethod
public void closeBrowser() {
	tearDown();
}
//1.
@Test
public void sign_On_Link_Test() {
	Assert.assertEquals(home.validateFindAFlightInfoText(), prop.getProperty("FindAFlight"));
	Assert.assertEquals(home.returnHomePageTitle(), prop.getProperty("HomePageTitle"));
	home.clickSignonLink();
	Assert.assertTrue(sop.validateSignOnMsg());
	Assert.assertEquals(sop.returnSignOnPageTitle(), prop.getProperty("SignOnPageTitle"));
	sop.clickHomeLink();
	Assert.assertEquals(home.returnHomePageTitle(), prop.getProperty("HomePageTitle"));
	System.out.println("Sign_On_ Link And Back To Home Link are Functional");
}
//2.
@Test
public void Register_Link_Test() {
Assert.assertEquals(home.returnHomePageURL(), prop.getProperty("HomepageUrl"));
Assert.assertTrue(home.verifyMercuryToursLogo());
home.clickRegisterLink();
Assert.assertTrue(rp.validateRegisterLabelIsDisplayed());
rp.clickHomeLink();
Assert.assertTrue(home.verifyMercuryToursLogo());
System.out.println("Register Link And Home Link are Functional");
}
//3.
@Test
public void Flight_Link_Test() {
	Assert.assertTrue(home.validateFindFlightInfo());
	Assert.assertTrue(home.verifyMercuryToursLogo());
	home.clickFlightsLink();
	Assert.assertTrue(fp.validateFlightFinderLabelIsDisplayed());
	fp.clickHomeLink();
	home.verifyMercuryToursLogo();
	System.out.println("Flights Link and Home Link are Functional");
}
//4.
@Test
public void Car_Rentals_Link_Test() throws Exception {
	Assert.assertTrue(home.verifySpecialsHeaderOnHomePage());
	home.clickCarRentalsLink();
	Assert.assertTrue(crp.underConstructionLabelIsPresent());
	crp.clickBackToHomeBtn();
	home.clickCarRentalsLink();
	try {
		crp.flashErrUnExpected();
		crp.drawBorderOnUnexpected();
		crp.createBugAleart();
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	crp.clickHomeLink();
}
//5
@Test
public void Cruises_Link_Test() {
Assert.assertEquals(home.returnHomePageTitle(), prop.getProperty("HomePageTitle"));	
home.clickCruisesLink();
//Assert.assertTrue(crp.underConstructionLabelIsPresent());
try {
	cruisep.flashErr();
	cruisep.drawBorder();
	cruisep.createBugAlert();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	System.out.println("This Test should fail and there is a bug in this feature");
}

}
//6.
@Test
public void Hotels_Link_Test() throws Exception {
//Thread.sleep(3000);
Assert.assertEquals(home.validateFindAFlightInfoText(), prop.getProperty("FindAFlight"));	
Assert.assertEquals(home.returnHomePageURL(), prop.getProperty("HomepageUrl"));
home.clickFindHotelsLink();
Thread.sleep(3000);
Assert.assertTrue(hp.underConstructionLabelIsPresent());
Assert.assertTrue(hp.underConstructionLabelIsPresent());
hp.clickBackToHomeBtn();
Assert.assertTrue(home.validatefeaturedDestination());
home.clickFindHotelsLink();
hp.clickHomeLink();
}
//7.
@Test
public void Support_Link_Test() {
	Assert.assertEquals(home.validateFindAFlightInfoText(), prop.getProperty("FindAFlight"));	
	Assert.assertEquals(home.returnHomePageURL(), prop.getProperty("HomepageUrl"));
	home.clickSupportLink();
	Assert.assertTrue(hp.underConstructionLabelIsPresent());
	sup.clickBackToHomeBtn();
	Assert.assertTrue(home.validatefeaturedDestination());
	home.clickSupportLink();
	hp.clickHomeLink();	
}

//8.
@Test
public void Register_here_Link_Test() {
	Assert.assertTrue(home.verifyTourTipsHeaderOnHomePage());
	Assert.assertEquals(home.returnHomePageTitle(), prop.getProperty("HomePageTitle"));
	home.clickRegisterHereLink();
	Assert.assertEquals(rp.getRegisterPageUrl(), prop.getProperty("RegisterPageUrl"));
	Assert.assertTrue(rp.registerPageInfoTxt());
	rp.clickHomeLink();
	Assert.assertEquals(home.verifyTourTipsInfoAtHomepage(), prop.getProperty("TourTips"));
}
//9.
//@Test
public void Salon_Travel_Link_Test() {
	
}

//10.
//@Test
public void Featured_Vacations_Destinations_Link_Test() {
	
}

//11.
//@Test
public void BusinessTravel_Link_Test() {
	
}
}

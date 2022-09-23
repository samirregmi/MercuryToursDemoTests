package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageLib.FlightFinderResultPage;
import com.PageLib.FlightsPage;
import com.PageLib.HomePage;
import com.TestBase.TestMain;

public class FlightSearchFunctionalityTest extends TestMain {
	HomePage home;
	FlightsPage flights;
	FlightFinderResultPage flightresult;
	
	public FlightSearchFunctionalityTest() {
		super();
		
	}
	@BeforeMethod
	public void setUps() {
		initialization();	
		home = new HomePage();
		flights = new FlightsPage();
		flightresult = new FlightFinderResultPage();
		
	}
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}	
@Test	
public void positiveFlightFinderFunctionalityTest() throws Exception {
	Assert.assertEquals(home.returnHomePageTitle(), prop.getProperty("HomePageTitle"));	
	Assert.assertTrue(home.verifyIfTIPLogoIsPresent());
	
	home.clickFlightsLink();
	Assert.assertTrue(flights.validateFlightFinderLabelIsDisplayed());
	Assert.assertEquals(flights.returnFlightFInderInfo(), prop.getProperty("FlightFinderInfo"));
	flights.selectTripType();
	flights.selectPassengerCount();
	flights.selectDepartingCity();
	flights.selectDepartingMonth();
	flights.selectDepartingday();
	flights.selectArrivingCity();
	flights.selectreturMonth();
	flights.selectreturDay();
	flights.selectServicClass();
	flights.selectAirlines();
	flights.clickContBtn();
	Thread.sleep(3000);
	Assert.assertEquals(flightresult.returnCurrentPageTitle(), prop.getProperty("FlightResultPageTitle"));
	Assert.assertTrue(flightresult.validateFlightFinderResult());
	flightresult.clickBackToHomeBtn();
	Assert.assertTrue(home.verifyIfTIPLogoIsPresent());
	}
}

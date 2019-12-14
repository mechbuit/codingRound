package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightsPage;
import pages.LoginPage;

public class FlightBookingTest extends BaseTest{
	LoginPage lnPage;
	FlightsPage flightPage;


	@Test
	public void testThatResultsAppearForAOneWayJourney() {
		lnPage = new LoginPage(driver);
		flightPage = new FlightsPage(driver);
		lnPage.launchApplication();
		flightPage.searchFlight("Bangalore", "Delhi");
		Assert.assertTrue(flightPage.isSearchSummaryPresent());
	}
}

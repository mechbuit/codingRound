package tests;

import org.testng.annotations.Test;

import pages.HotelsPage;
import pages.LoginPage;

public class HotelBookingTest extends BaseTest {
	LoginPage lnPage;
	HotelsPage hotelsPage;
	
	@Test
	public void shouldBeAbleToSearchForHotels() {
		lnPage = new LoginPage(driver);
		hotelsPage = new HotelsPage(driver);
		lnPage.launchApplication();
		hotelsPage.searchHotels("Indiranagar, Bangalore", "1 room, 2 adults");
	}
}

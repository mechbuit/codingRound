package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import wrapper.SeleniumHelper;

public class HeaderSection {

	WebDriver driver;
	SeleniumHelper wrapper;
	
	By yourTrip = By.id("userAccountLink");
	
	public HeaderSection(WebDriver driver) {
		this.driver = driver;
		wrapper = new SeleniumHelper(driver);
	}
	
	
	
}

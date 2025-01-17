package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import wrapper.SeleniumHelper;

public class HotelsPage {

	WebDriver driver;
	SeleniumHelper wrapper;
	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;
	
	@FindBy(id = "ui-id-1")
	private WebElement uiid1;
	
	@FindBy(id = "CheckInDate")
	private WebElement checkInDate;
	
	@FindBy(xpath = "(//td/a)[1]")
	private WebElement todaysDate;

	@FindBy(xpath = "(//td/a)[2]")
	private WebElement tomorrowsDate;
	
	
	public HotelsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wrapper = new SeleniumHelper(driver);
	}
	
	public void searchHotels(String where, String travellersOnhome){
		wrapper.click(hotelLink);
		wrapper.sendKeys(localityTextBox, where);
		wrapper.waitFor(5000);
		List<WebElement> options = uiid1.findElements(By.tagName("li"));
		options.get(1).click();
		wrapper.waitFor(2000);
		wrapper.click(checkInDate);
		wrapper.click(todaysDate);
		wrapper.click(tomorrowsDate);
		wrapper.waitFor(2000);
		wrapper.click(travellerSelection);
		Select select = new Select(travellerSelection);
		select.selectByVisibleText(travellersOnhome);
		wrapper.click(searchButton);
	}
	
	
	

}

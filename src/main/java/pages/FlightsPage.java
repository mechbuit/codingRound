package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrapper.SeleniumHelper;

public class FlightsPage {


	WebDriver driver;
	SeleniumHelper wrapper;

	By oneWay = By.id("OneWay");
	By fromTag = By.id("FromTag");
	By toTag = By.id("ToTag");
	By searchBtn = By.id("SearchBtn");
	By uiid1 = By.id("ui-id-1");
	By uiid2 = By.id("ui-id-2");
	By searchSummary = By.className("searchSummary");
	By date = By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a");

	public FlightsPage(WebDriver driver) {
		this.driver = driver;
		wrapper = new SeleniumHelper(driver);
	}

	public void searchFlight(String from, String to){
		wrapper.click(oneWay);
		wrapper.clear(fromTag);
		wrapper.sendKeys(fromTag, from);
		wrapper.waitFor(5000);
		List<WebElement> originOptions = driver.findElement(uiid1).findElements(By.tagName("li"));
        originOptions.get(0).click();
        wrapper.clear(toTag);
        wrapper.sendKeys(toTag, to);
        wrapper.waitFor(5000);
        List<WebElement> destinationOptions = driver.findElement(uiid2).findElements(By.tagName("li"));
        destinationOptions.get(0).click();
        driver.findElement(date).click();
        wrapper.click(searchBtn);
        wrapper.waitFor(5000);
	}

	public boolean isSearchSummaryPresent(){
		return wrapper.isElementPresent(searchSummary);
	}


}

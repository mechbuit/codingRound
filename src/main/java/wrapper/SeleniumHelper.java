package wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public SeleniumHelper(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60000);
	}
	
	public void click(By by){
		try{
			wait.until(ExpectedConditions.elementToBeClickable(by)).click();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void sendKeys(By by, String text){
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void clear(By by){
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(by)).clear();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public boolean isElementPresent(By by) {
	    try {
	        driver.findElement(by);
	        System.out.println("Element Present");
	        return true;
	    } catch (NoSuchElementException e) {
	        System.out.println("Element absent");
	        return false;
	    }
	}
	
	public WebElement getElement(By by) {
		try {
			return driver.findElement(by);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  
        }
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrapper.SeleniumHelper;


public class LoginPage {

	WebDriver driver;
	SeleniumHelper wrapper;
	HeaderSection header;
	
	By signIn = By.id("SignIn");
	By signInButton = By.id("signInButton");
	By errors1 = By.id("errors1");
	By userName = By.id("email");
	By password = By.id("password");
	By loginFrameWindow = By.id("modal_window");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wrapper = new SeleniumHelper(driver);
		header = new HeaderSection(driver);
	}
	
	public void logIn(String uName, String pwd){
		wrapper.click(header.yourTrip);
		wrapper.click(signIn);
		wrapper.waitFor(5000);
		driver.switchTo().frame(wrapper.getElement(loginFrameWindow));
		wrapper.sendKeys(userName, uName);
		wrapper.sendKeys(password, pwd);
		wrapper.click(signInButton);
	}
	
	public void launchApplication(){
		driver.get("https://www.cleartrip.com/");
	}
	
	public String getError(){
		String error = "";
		error = wrapper.getElement(errors1).getText();
		return error;
	}
	
}

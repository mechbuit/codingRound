package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;



public class SignInTest extends BaseTest{

	
	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
		LoginPage lnPage = new LoginPage(driver);
		lnPage.launchApplication();
		lnPage.logIn("", "");
		String error = lnPage.getError();
		Assert.assertTrue(error.contains("There were errors in your submission"));
	}
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;


public class SignInTest extends BaseTest{
	LoginPage lnPage;

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
		lnPage = new LoginPage(driver);
		lnPage.launchApplication();
		lnPage.logIn("", "");
		String error = lnPage.getError();
		Assert.assertTrue(error.contains("There were errors in your submission"));
	}
}

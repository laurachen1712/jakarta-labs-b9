package qaautomation.may2022;

import org.testng.Assert;
import org.testng.annotations.Test;

import qaautomation.may2022.pages.LoginPageFactory;
import qaautomation.may2022.pages.ProfilePageFactory;

public class WebTestAfterPageFactory extends BaseWebTest {

	@Test
	public void testLogin() {
		// cara mendapatkan username dengan xpath

		LoginPageFactory loginPage = new LoginPageFactory(driver, explicitWait);
		ProfilePageFactory profilePage = new ProfilePageFactory(driver, explicitWait);
		String username = "tomsmith";
		String password = "SuperSecretPassword!";

		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
		String actualText = profilePage.getProfileText();
		String expectedText = "You logged into a secure area!";

		Assert.assertTrue(actualText.contains(expectedText));
	}

}

package qaautomation.may2022;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import qaautomation.may2022.pages.LoginPage;
import qaautomation.may2022.pages.ProfilePage;

public class WebTestAfterPOM extends BaseWebTestHeadless {

	LoginPage loginPage = new LoginPage(driver, explicitWait);
	ProfilePage profilePage = new ProfilePage(driver, explicitWait);

	@Test
	public void testLogin() {
		// cara mendapatkan username dengan xpath
		String username = "tomsmith";
		String password = "SuperSecretPassword!";

		loginPage.loginWeb(username, password);
		String actualText = profilePage.getProfileText();
		String expectedText = "You logged into a secure area!";

		Assert.assertTrue(actualText.contains(expectedText));
	}

	@Test
	public void testLoginFailedWrongPassword() {
		// cara mendapatkan username dengan xpath
		driver.get().findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.get().findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretzzzzz");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();

		String expectedText = "invalid";

		Assert.assertTrue(actualText.contains(expectedText));
	}

	@Test
	public void testLoginFailedWrongUsername() {
		// cara mendapatkan username dengan xpath
		driver.get().findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmithzzz");
		driver.get().findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();

		String expectedText = "invalid";

		Assert.assertTrue(actualText.contains(expectedText));
	}

	@Test
	public void testLoginFailedWrongUsernameandPassword() {
		// cara mendapatkan username dengan xpath
		driver.get().findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmithzzz");
		driver.get().findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSeczretzzzzz");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();

		String expectedText = "invalid";

		Assert.assertTrue(actualText.contains(expectedText));
	}

}

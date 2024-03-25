package qaautomation.may2022;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTestAfterRefactorr extends BaseWebTest {

	@Test
	public void testLogin() {
		// cara mendapatkan username dengan xpath
		driver.get().findElement(By.id("username")).sendKeys("tomsmith");
		driver.get().findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();
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

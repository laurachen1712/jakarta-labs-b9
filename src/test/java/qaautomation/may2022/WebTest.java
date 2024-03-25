package qaautomation.may2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTest {

	@Test
	public void testLogin() {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.get("http://the-internet.herokuapp.com/login");
		// cara mendapatkan username dengan xpath
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "You logged into a secure area!";

		Assert.assertTrue(actualText.contains(expectedText));

		driver.quit();
	}

	@Test
	public void testLoginFailedWrongPassword() {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/login");
		// cara mendapatkan username dengan xpath
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretzzzzz");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();

		String expectedText = "invalid";

		Assert.assertTrue(actualText.contains(expectedText));

		driver.quit();
	}

	@Test
	public void testLoginFailedWrongUsername() {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/login");
		// cara mendapatkan username dengan xpath
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmithzzz");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();

		String expectedText = "invalid";

		Assert.assertTrue(actualText.contains(expectedText));

		driver.quit();
	}

	@Test
	public void testLoginFailedWrongUsernameandPassword() {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/login");
		// cara mendapatkan username dengan xpath
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmithzzz");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSeczretzzzzz");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();

		String expectedText = "invalid";

		Assert.assertTrue(actualText.contains(expectedText));

		driver.quit();
	}

}

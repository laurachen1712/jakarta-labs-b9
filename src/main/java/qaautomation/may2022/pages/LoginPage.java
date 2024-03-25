package qaautomation.may2022.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	By username = By.id("username");
	By password = By.xpath("//input[@id='password']");
	By loginBtn = By.xpath("//button[@type='submit']");

	public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}

	public void loginWeb(String user, String pass) {
		setText(username, user);
		setText(password, pass);
		clickAndWait(loginBtn);
	}

	public void inputUsername(String user) {
		setText(username, user);
	}

	public void inputPassword(String pass) {
		setText(password, pass);
	}

	public void clickLoginButton() {
		clickAndWait(loginBtn);
	}

}

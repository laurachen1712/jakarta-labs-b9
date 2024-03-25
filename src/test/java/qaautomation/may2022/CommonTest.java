package qaautomation.may2022;

import org.testng.annotations.Test;

import qaautomation.may2022.pages.CommonPage;
import qaautomation.may2022.utils.TestUtility;

public class CommonTest extends BaseWebTest {

	CommonPage commonPage = new CommonPage(driver, explicitWait);

	@Test
	public void testSwitching() {
		commonPage.openNewTab();
		commonPage.switchWindow(1);
		commonPage.openUrl("https://facebook.com");
		commonPage.openNewWindow();
		commonPage.switchWindow(2);
		commonPage.openUrl("https://twitter.com");
		TestUtility.hardWait(3);
	}

}

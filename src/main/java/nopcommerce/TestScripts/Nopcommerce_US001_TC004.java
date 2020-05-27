package nopcommerce.TestScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import nopcommerce.PageObjects.Nopcommerce_US001_Page;

public class Nopcommerce_US001_TC004 extends Base{

	@Test
	public void Login_Test() {
		PageFactory.initElements(driver, Nopcommerce_US001_Page.class);
		Nopcommerce_US001_Page.login_button.click();
		log.info("Loggin button clicked as the forms are filled defaultly");
		report_logger = extent.createTest("Invalid Login Check");
		if(Nopcommerce_US001_Page.dashboard.isDisplayed()) {
			Assert.assertTrue(true);
			report_logger.pass("Login Test Passed");
			log.info("Successfully logged and admin Dashboard displayed");
		}else {
			Base.takeScreenshot(driver, "Login_Test");
			Assert.fail();
			report_logger.fail("Login Test Failed");
			log.error("unexpected failure. Loggin Failed");
		}
	}	
}

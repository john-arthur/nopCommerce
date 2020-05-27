package nopcommerce.TestScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import nopcommerce.PageObjects.Nopcommerce_US001_Page;


public class Nopcommerce_US001_TC001 extends Base {

	@Test
	public void loginButtonEnableCheck() {
		PageFactory.initElements(driver, Nopcommerce_US001_Page.class);
		// report_logger = extent.createTest("Login_Enable-Check" + " - Test Succesfully executed");
		boolean login_is_enabled = Nopcommerce_US001_Page.login_button.isEnabled();
		
		report_logger = extent.createTest("Login Button Enable Check");
		
		if (login_is_enabled) {
			log.info("Login button disabled feature is passed");
			Assert.assertTrue(true);
			report_logger.pass("Valid Button Enable Check Passed");
		} else {
			log.error("Login button diabled feature is failed");
			Base.takeScreenshot(driver, "loginButtonEnableCheck");
			
			Assert.fail();
			report_logger.fail("Valid Button Enable Check Failed");
		}
	}
}

package nopcommerce.TestScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import nopcommerce.PageObjects.Nopcommerce_US001_Page;

public class Nopcommerce_US001_TC003 extends Base{

	@Test
	public void invalidLoginTest() {
		PageFactory.initElements(driver, Nopcommerce_US001_Page.class);
		Nopcommerce_US001_Page.email_field.clear();
		Nopcommerce_US001_Page.password_field.clear();
		Base.sendingKeys(Nopcommerce_US001_Page.email_field, prop.getProperty("password"));
		log.info("valid password given as email");
		Base.sendingKeys(Nopcommerce_US001_Page.password_field, prop.getProperty("email"));
		log.info("valid email given as password");
		Nopcommerce_US001_Page.login_button.click();
		log.info("Log in button clicked");
		
		report_logger = extent.createTest("Invalid Login Test");
		
		if(Nopcommerce_US001_Page.login_error.isDisplayed()) {
			Assert.assertTrue(true);
			report_logger.pass("Valid Login Verification Passed");
			log.info("Error message displayed. Build Successfull");
		}else {
			Base.takeScreenshot(driver, "invalidLoginTest");
			Assert.fail();
			log.error("Account logged in rather error message displayed");
		}
	}
	
}

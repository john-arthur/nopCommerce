package nopcommerce.TestScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import nopcommerce.PageObjects.Nopcommerce_US001_Page;

public class Nopcommerce_US001_TC002 extends Base {

	@Test
	public void fieldsCheckup() {
		PageFactory.initElements(driver, Nopcommerce_US001_Page.class);
		Nopcommerce_US001_Page.email_field.clear();
		log.info("email filed cleared");
		Base.sendingKeys(Nopcommerce_US001_Page.email_field, "dummy");
		log.info("invalid string passed");
		Nopcommerce_US001_Page.password_field.click();
		
		report_logger = extent.createTest("Fields_Checkup");
		
		if (Nopcommerce_US001_Page.email_error_message_2.isDisplayed()) {

			Assert.assertTrue(true);
			report_logger.createNode("email_field").pass("email_field_test_passed");

			log.info("Email field verification passed");
		} else {
			log.error("Email field verification failed");
			Base.takeScreenshot(driver, "emailFieldCheckup");
			
			Assert.fail();
			report_logger.createNode("email_field").fail("email_field_test_failed");
		}

		Nopcommerce_US001_Page.email_field.clear();
		Base.sendingKeys(Nopcommerce_US001_Page.email_field, "dummy@dummy.com");
		Nopcommerce_US001_Page.password_field.clear();
		Base.sendingKeys(Nopcommerce_US001_Page.password_field, "dummy");
		Nopcommerce_US001_Page.login_button.click();

		if (Nopcommerce_US001_Page.login_error.isDisplayed()) {

			Assert.assertTrue(true);
			report_logger.createNode("login_error_message").pass("login_error_message_passed");

			log.info("Unable to loggin usign invalid credentils. Test Passed");
		} else {
			Base.takeScreenshot(driver, "emailFieldCheckup2");

			Assert.fail();
			report_logger.createNode("login_error_message").fail("login_error_message_failed");

			log.error("Unexpected Log in using invalid credentials. Test Failed");
		}
	}

}

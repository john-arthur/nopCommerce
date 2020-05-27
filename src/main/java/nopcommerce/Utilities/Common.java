package nopcommerce.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Common {

// ---------Sending Keys -------------------------------------------------------
	public static void sendingKeys(WebElement element, String input) {
		element.sendKeys(input);
	}
	
	public static Properties getProperties() {
		return ReadConfig.readConfig();
	}
	
// --------- Explicit Wait ------------------------------------------------------
	public WebElement explicitWait(WebElement element) {
		return null;
	}
	
// --------- Screenshot --------------------------------------------------------
	public static void takeScreenshot(WebDriver driver, String testName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
        
		File destfile = new File(System.getProperty("user.dir")+ "\\Screenshots\\"+ testName +".png");
		
        try {
			FileHandler.copy(srcfile, destfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

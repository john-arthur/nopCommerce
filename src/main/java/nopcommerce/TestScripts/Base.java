package nopcommerce.TestScripts;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import nopcommerce.Utilities.Common;

public class Base extends Common {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest report_logger;

	@BeforeSuite
	public void setup() {

		String timestamp = new SimpleDateFormat("YYYY.MM.DD.HH.mm.SS").format(new Date());
		String repName = "Test-report_" + timestamp + ".html";

		htmlReporter = new ExtentHtmlReporter(".\\test-output\\extent-report\\" + repName);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Name", "job_id");
		extent.setSystemInfo("Tester name", "John");

		htmlReporter.config().setDocumentTitle("NopCommerce-report");
		htmlReporter.config().setReportName("NopCommerce-report");
		htmlReporter.config().setTheme(Theme.DARK);

		log = Logger.getLogger(Base.class);
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\Configuration\\log4j.properties");
		prop = getProperties();
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("Check the browser");
		}
		log.info("Browser Launched");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void tearDown() {
		log.info("Browser killed");
		driver.quit();
	}

	@BeforeClass
	public void beforeClassSetup() {
		driver.get(prop.getProperty("url"));
		log.info("Application opened");
	}

	@AfterClass
	public void afterClassSetup() {
		driver.manage().deleteAllCookies();
		log.info("Application cleared and ready for next test run");
	}
}

package nopcommerce.Utilities;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import nopcommerce.TestScripts.Base;

public class Reporting extends Base implements ITestListener {

	@Override
	public void onFinish(ITestContext arg) {
		extent.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		report_logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		report_logger.log(Status.FAIL, result.getThrowable());
		String path = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + ".png";
		File desfile = new File(path);
		if (desfile.exists()) {
			try {
				report_logger.fail("Screen shot is below: " + report_logger.addScreenCaptureFromPath(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		report_logger.log(Status.PASS, 
				MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		report_logger = extent.createTest(result.getName());
		report_logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}

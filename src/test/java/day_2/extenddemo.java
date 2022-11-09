package day_2;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extenddemo {
	static ExtentHtmlReporter htmlrep;
	static ExtentReports repot;
	
	

	public static void getstartrep(String loc) {
		htmlrep=new ExtentHtmlReporter(loc);
		htmlrep.config().setDocumentTitle("testng 8am green");	
		htmlrep.config().setReportName("fipkart login");
		htmlrep.config().setTheme(Theme.DARK);

		repot=new ExtentReports();
		repot.attachReporter(htmlrep);
		repot.setSystemInfo("browser name", "edge");
		repot.setSystemInfo("browser ver", "105");
		repot.setSystemInfo("os", "windows 11");
		repot.setSystemInfo("env", "QA");
		repot.setSystemInfo("sprint", "20");

	}

	public static void getcontindoce(ITestResult r) {
		String name = r.getName();

		int status = r.getStatus();
		switch (status) {
		case 1:
			repot.createTest(name).pass("test ca se pass");
			break;
		case 2:
			repot.createTest(name).fail("test ca se fail");
			break;

		default:
			repot.createTest(name).skip("test ca se skip");

			break;
		}

	}
	public static void getendrep() {
		repot.flush();

	}
//	public static ExtentHtmlReporter htmlReporter;
//	public static ExtentReports extent;
//	public static ExtentTest extentTest;
//
//	@BeforeSuite
//	public void setUp() {
//
//		htmlReporter = new ExtentHtmlReporter(System.getProperty("User.dir")+"\\src\\test\\resources\\reports\\htmlreports\\ExtentReporting.html");
//		extent = new ExtentReports();
//		extent.attachReporter(htmlReporter);
//
//	}
//
//	@AfterMethod
//	public void getResult(ITestResult result) {
//
//		if (result.getStatus()==ITestResult.FAILURE) {
//
//			extentTest.fail(MarkupHelper.createLabel(result.getName()+" Test Case Failed", ExtentColor.RED));
//			extentTest.fail(result.getThrowable());
//		}
//
//		else if (result.getStatus()==ITestResult.SUCCESS) {
//
//			extentTest.pass(MarkupHelper.createLabel(result.getName()+" Test Case Passed", ExtentColor.GREEN));
//			extentTest.pass(result.getThrowable());
//
//		}
//
//		else {
//
//			extentTest.skip(MarkupHelper.createLabel(result.getName()+" Test Case Skipped", ExtentColor.ORANGE));
//			extentTest.skip(result.getThrowable());
//
//		}
//
//
//	}
//
//	@AfterSuite
//	public void tearDown() {
//
//		extent.flush(); 
//
//	}
//


}

package day_2;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extenhtmrep11 {
	static ExtentHtmlReporter htmlrep;
	static ExtentReports repot;
	
	public static void startrep(String f) {
		 htmlrep=new ExtentHtmlReporter(f);
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
	public static void contindoce(ITestResult r) {
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
	public static void endrep() {
		repot.flush();

	}


}

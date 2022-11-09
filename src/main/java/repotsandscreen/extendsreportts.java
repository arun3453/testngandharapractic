package repotsandscreen;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org_day1.bass.baseclass;

public class extendsreportts extends baseclass{
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String dir = System.getProperty("user.dir");
	
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();      
    }

    public ExtentReports generateExtentReport() {
    	String reportLocation = dir + getPropertyValue("path", "ExtendsReport")+"AutomationTestReport.html";
    	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(new File(reportLocation));
    	sparkReporter.config().setDocumentTitle("Automation Test Results");
    	sparkReporter.config().setTheme(Theme.DARK);
    	sparkReporter.config().setReportName("Test Results");
    	
    	extent = new ExtentReports();
    	extent.attachReporter(sparkReporter);
    	extent.setSystemInfo("Tester", "Arun");
    	extent.setSystemInfo("System OS", "Windows OS");
    	extent.setSystemInfo("Test Application", "Chroma");
    	extent.setSystemInfo("Project", "nexa");

    	System.out.println("Extent Report is ready");
    	return extent; 
    }
    
    
    public ExtentTest createExtentReportTest(String name) {
    	test = extent.createTest(name);
    	System.out.println("Extent report test was created successfully");
    	return test;
    }
    
    public void flushExtentReport() {
    	extent.flush();
    	System.out.println("Extent report was flushed out successfully");
    }

}



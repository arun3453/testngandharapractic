package repotsandscreen;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor;
import org_day1.bass.baseclass;

public class failtestscreeenshot implements ITestListener {
	public static ExtentTest test;
	public static ExtentReports extent;
	public static extendsreportts extentReport;
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test= extentReport.createExtentReportTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			baseclass.takescreenshot(result.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public void onTestFailure(ITestResult result) {
		try {
			baseclass.takescreenshot(result.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onStart(ITestContext context) {
		extentReport=new extendsreportts();
		extent=extentReport.generateExtentReport();
		
	}
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}

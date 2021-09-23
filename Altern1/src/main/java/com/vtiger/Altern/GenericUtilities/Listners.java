package com.vtiger.Altern.GenericUtilities;




import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listners implements ITestListener{
	ExtentReports reports;
	ExtentTest test;
  public void onTestStart(ITestResult result) {
	  test=reports.createTest(result.getMethod().getMethodName());
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS,result.getMethod().getMethodName()+"is passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL, result.getName()+"is failed");
		test.log(Status.FAIL, result.getThrowable());
		BaseClass baseclass=new BaseClass();
			try {
				String path = baseclass.getscreenshot(result.getMethod().getMethodName());
				test.addScreenCaptureFromPath(path);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getMethod().getMethodName()+"Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		JavaUtility js =new JavaUtility();
				String Date = js.getDate();
		ExtentHtmlReporter reporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReportsSDET21/ExtentReports1"+Date+".html");
				reporter.config().setDocumentTitle("SDET21");
				reports=new ExtentReports();
				reports.attachReporter(reporter);
				reports.setSystemInfo("BuildNo", "5.1");
				reports.setSystemInfo("Env", "Pre-Prod");
				reports.setSystemInfo("Platform", "Windows");
				reports.setSystemInfo("Browesr version", "Chrome-93");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		reports.flush();
		
	}

}

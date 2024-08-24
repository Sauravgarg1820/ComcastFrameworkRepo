package com.comcast.crm.listernerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.generic.webdriverutility.UtilityClassObject;
import com.google.common.io.Files;

public class ListImpClass implements ITestListener,ISuiteListener {
	public static ExtentSparkReporter spark;
	 public static ExtentReports report;
	 public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
	     String time = new Date().toString().replace(" ", "_").replace(":", "_");
		 
		 
			spark= new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
			spark.config().setDocumentTitle("CRM Test Suite Results");
			spark.config().setReportName("CRM Report");
			spark.config().setTheme(Theme.DARK);
			
			//add Env information & create test
			report= new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("OS", "Windows-10");
			report.setSystemInfo("BROWSER", "CHROME-100");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backUp");
		report.flush();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		 test = report.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"====STARTED====");

		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//System.out.println("=======>>"+result.getMethod().getMethodName()+"======END=======");
		test.log(Status.PASS, result.getMethod().getMethodName()+"====PASSED====");
}

	
	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		
		TakesScreenshot edriver= (TakesScreenshot)BaseClass.sdriver;
		String filepath = edriver.getScreenshotAs(OutputType.BASE64);
	     String time = new Date().toString().replace(" ", "_").replace(":", "_");
	     test.addScreenCaptureFromBase64String(filepath,testName+"_"+time);
		 test.log(Status.FAIL, result.getMethod().getMethodName()+"====FAILED====");


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}

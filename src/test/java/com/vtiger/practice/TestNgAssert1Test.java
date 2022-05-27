package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestNgAssert1Test extends TestNgBasicConfigurationPracticeTest{
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void practice1Test() {
		ExtentSparkReporter spark = new ExtentSparkReporter("");
		spark.config().setDocumentTitle("DocumentTitle");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("ReportName");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		ExtentTest test = report.createTest("practice1Test");
		
		test.log(Status.INFO,"a-practice1");
		test.log(Status.PASS,"a-practice1");
		test.log(Status.FAIL,"a-practice1");
		test.log(Status.SKIP,"a-practice1");
		test.log(Status.WARNING,"a-practice1");
		report.flush();

		
		
				Reporter.log("a-practice1",true);

		Reporter.log("b-practice1",true);
		Reporter.log("c-practice1",true);
		Reporter.log("d-practice1",true);
		
		softAssert.assertEquals("abc", "ABc");
		Reporter.log("e-practice1",true);
		Reporter.log("f-practice1",true);
	}
	@Test
	public void practice2Test() {
		Reporter.log("a-practice2",true);
		Reporter.log("b-practice2",true);
		Reporter.log("c-practice2",true);
		softAssert.assertEquals(1, 8);
		Reporter.log("d-practice2",true);
		Reporter.log("e-practice2",true);
		Reporter.log("f-practice2",true);
		softAssert.assertAll();
	}

}

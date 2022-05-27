package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class testNGPractice3Test {
	SoftAssert softAssert = new SoftAssert();
	@Test(retryAnalyzer=com.sdet34l1.genericUtility.RetryAnalyserImplementation.class)
	public void practice1Test() {
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
	@Test
	public void practice3TTest() {
		Reporter.log("a-practice3",true);
		Reporter.log("b-practice3",true);
		Reporter.log("c-practice3",true);
		Reporter.log("d-practice3",true);
		Reporter.log("e-practice3",true);
		Reporter.log("f-practice3",true);
	}
	

}

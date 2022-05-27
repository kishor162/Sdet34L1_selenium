package com.vtiger.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNgSoftAssertTest {
	@Test
	public void practice1Test() {
		Reporter.log("a-practice1",true);
		Reporter.log("b-practice1",true);
		Reporter.log("c-practice1",true);
		Reporter.log("d-practice1",true);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("abc", "ABc");
		Reporter.log("e-practice1",true);
		Reporter.log("f-practice1",true);
	}
	@Test
	public void practice2Test() {
		Reporter.log("a-practice2",true);
		Reporter.log("b-practice2",true);
		Reporter.log("c-practice2",true);
		Reporter.log("d-practice2",true);
		Reporter.log("e-practice2",true);
		Reporter.log("f-practice2",true);
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
	
	@Test
	public void practice4TTest() {
		Reporter.log("a-practice4",true);
		Reporter.log("b-practice4",true);
		Reporter.log("c-practice4",true);
		Reporter.log("d-practice4",true);
		Reporter.log("e-practice4",true);
		Reporter.log("f-practice4",true);
	}
	
	

}

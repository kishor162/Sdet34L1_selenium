package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestNgBasicConfigurationPracticeTest {

	
	@BeforeSuite(groups ="Baseclass")
	public void beforesuite1Test() {
		Reporter.log("beforesuite1",true);
	}
	
	@AfterSuite(groups ="Baseclass")
	public void aftersuite1Test() {
		Reporter.log("aftersuite1",true);
	}
	@BeforeClass(groups ="sanity")
	public void beforeclass1Test() {
		Reporter.log("beforeclass1",true);
	}
	@AfterClass(groups ="regression")
	public void afterclass1Test() {
		Reporter.log("afterclass1",true);
	}
	
	@BeforeTest(groups ="Baseclass")
	public void beforeclassTest() {
		Reporter.log("beforetest1",true);
	}
	

	@AfterTest(groups ="regression")
	public void afterclassTest() {
		Reporter.log("aftertest1",true);
	}
	@BeforeMethod(groups ="sanity")
	public void beforemethod1Test() {
		Reporter.log("beforemethod1",true);
	}
	@BeforeMethod(groups ="sanity")
	public void beforemethod2Test() {
		Reporter.log("beforemethod2",true);
	}
	
	@AfterMethod(groups ="regression")
	public void aftermethod1Test() {
		Reporter.log("aftermethod1",true);
	}
	
	@AfterMethod(groups ="Baseclass")
	public void aftermethod2Test() {
		Reporter.log("aftermethod2",true);
	}
	
	
	
}

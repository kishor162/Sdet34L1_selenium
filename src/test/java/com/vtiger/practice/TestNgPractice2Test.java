package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgPractice2Test extends TestNgBasicConfigurationPracticeTest{

	@Test(groups ="sanity")
	public void practice1Test () {
		Reporter.log("TestNgPractice2Test--> Test1",true);
	}
	@Test(groups ="sanity")
	public void practice2Test () {
		Reporter.log("TestNgPractice2Test--> Test2",true);
	}
	@Test(groups ={"regression","sanity"})
	public void practice3Test () {
		Reporter.log("TestNgPractice2Test--> Test3",true);
	}


}

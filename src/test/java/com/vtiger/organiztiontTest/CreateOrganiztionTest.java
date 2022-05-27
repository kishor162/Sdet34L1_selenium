package com.vtiger.organiztiontTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.ExcelUtility;
import com.sdet34l1.genericUtility.JavaUtility;
import com.sdet34l1.genericUtility.WebDriverUtility;
import com.vtiger.objectRepository.CreateNewOrganizationPage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganiztionTest extends BaseClass{
	String organizationName;
	OrganizationPage organizationpage;
	CreateNewOrganizationPage createneworganizationpage;
	OrganizationInformationPage  organizationinformationpage;
	@Test
	public void createorganiztiontest() {
		JavaUtility javautility = new JavaUtility();
		organizationpage= new OrganizationPage(driver);
		createneworganizationpage = new CreateNewOrganizationPage(driver);
		organizationinformationpage  =new OrganizationInformationPage (driver);

		String organizationName = ExcelUtility.getDataFromExcel("organizations", 1, 1) + randonNum;

		homepage.clickOnOrganization(driver);

		organizationpage.createOrganization(driver);
		createneworganizationpage.enterOrganizationName(driver, organizationName);

		javautility.assertionThroughIfCondition(organizationinformationpage.getOrganizarionName(),organizationName,"organizations");







	}

}

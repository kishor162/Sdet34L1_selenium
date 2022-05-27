package com.vtiger.organiztiontTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.ExcelUtility;
import com.sdet34l1.genericUtility.FileUtility;
import com.sdet34l1.genericUtility.IconstantPath;
import com.sdet34l1.genericUtility.JavaUtility;
import com.sdet34l1.genericUtility.WebDriverUtility;
import com.vtiger.objectRepository.CreateNewOrganizationPage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationByPassValueAsIndustry extends BaseClass{


	String organizationName;
	OrganizationPage organizationpage;
	CreateNewOrganizationPage createneworganizationpage;
	@Test
	public void createorganizationbypassvalueasindustry() throws IOException {

		organizationpage= new OrganizationPage(driver);
		createneworganizationpage = new CreateNewOrganizationPage(driver);

		String organizationName = ExcelUtility.getDataFromExcel("organizations", 1, 1) + randonNum;

		homepage.clickOnOrganization(driver);

		organizationpage.createOrganization(driver);
		createneworganizationpage.enterOrganizationName(driver, organizationName);

		createneworganizationpage.enterIndustryValue(organizationName);
		createneworganizationpage.enterIndustryValue("Education");
		createneworganizationpage.enterTypeDropDown("Press");

		createneworganizationpage.saveTheCreateNewOrganizationPage();

	}

}

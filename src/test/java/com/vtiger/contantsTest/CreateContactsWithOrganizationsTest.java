package com.vtiger.contantsTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.ExcelUtility;
import com.sdet34l1.genericUtility.FileUtility;
import com.sdet34l1.genericUtility.IconstantPath;
import com.sdet34l1.genericUtility.JavaUtility;
import com.sdet34l1.genericUtility.WebDriverUtility;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.CreateNewOrganizationPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganizationPage;
import com.vtiger.objectRepository.SearchOrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsWithOrganizationsTest extends BaseClass {
	String orgainationName ;
	String lastName;
	OrganizationPage organizationpage;
	CreateNewOrganizationPage createneworganizationpage;
	ContactPage contactpage;
	CreateNewContactPage createnewcontactpage ;
	SearchOrganizationPage searchorganizationpage;

	@Test
	public void createcontactswithorganizationstest() throws IOException {



		orgainationName =ExcelUtility.getDataFromExcel("organizations", 2, 1)+randonNum;
		lastName =ExcelUtility.getDataFromExcel("contacts", 2, 1)+randonNum;
		organizationpage = new OrganizationPage(driver);
		createneworganizationpage = new CreateNewOrganizationPage(driver);
		contactpage =new ContactPage(driver);
		createnewcontactpage =new CreateNewContactPage(driver);
		searchorganizationpage= new SearchOrganizationPage(driver);

		homepage.clickOnOrganization(driver);
		organizationpage.createOrganization(driver);
		createneworganizationpage.enterOrganizationName(driver, orgainationName);
		createneworganizationpage.saveTheCreateNewOrganizationPage();
         WebDriverUtility.explicitlyWait(driver, 10);
		homepage.clickContact(driver);
		contactpage.CreateNewContact(driver);
		createnewcontactpage.enterTheLastName(driver, lastName);
		createnewcontactpage.saveTheCreateContact(driver);


		searchorganizationpage.selectOrganization( driver,orgainationName);
		WebDriverUtility.switchToWindowBasedOnTitle(driver, "Contacts&action");
		createnewcontactpage.saveTheCreateContact(driver);

	}



}

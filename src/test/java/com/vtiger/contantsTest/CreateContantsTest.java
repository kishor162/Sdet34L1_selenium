package com.vtiger.contantsTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.ExcelUtility;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateNewContactPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContantsTest extends BaseClass{
	String lastName;
	CreateNewContactPage createnewcontactpage;
	ContactPage contactpage;

	@Test
	public void  CreateContantsTest() {

		lastName =ExcelUtility.getDataFromExcel("contacts", 2, 1)+randonNum;
		contactpage = new ContactPage(driver);
		homepage.clickContact(driver);
		contactpage.CreateNewContact(driver);
		createnewcontactpage =new CreateNewContactPage(driver);
		createnewcontactpage.enterTheLastName(driver, lastName);
		createnewcontactpage.saveTheCreateContact(driver);
	}

}

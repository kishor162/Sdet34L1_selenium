package com.vtiger.module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
import com.vtiger.objectRepository.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_08_ContactWithLeadNameTest extends BaseClass {
	String lastName	;
	 HomePage homepage;
	ContactPage contactpage; 
	 CreateNewContactPage createnewcontactpage;
	
	@Test
	public void Tc_08contactwithLeadnametest() throws IOException {

		 lastName = ExcelUtility.getDataFromExcel("modules", 2, 1)+randonNum;
		 homepage = new HomePage(driver);
		 contactpage = new ContactPage(driver);
		  createnewcontactpage= new CreateNewContactPage(driver);
		 homepage.clickContact(driver);
		 
		 contactpage.CreateNewContact(driver);
		createnewcontactpage.enterTheLastName(driver, lastName);
        createnewcontactpage.leadNameDorodown("Employee");
		createnewcontactpage.saveTheCreateContact(driver);
		

	


	}

}

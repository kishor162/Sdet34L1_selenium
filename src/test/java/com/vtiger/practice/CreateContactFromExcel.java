package com.vtiger.practice;

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
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactFromExcel extends BaseClass {
	String lastName ;
	ContactPage contactpage;
	CreateNewContactPage createnewcontactpage;



	@Test ()
	public void  createContactFromExcel() throws IOException {

		String lastName =ExcelUtility.getDataFromExcel("contacts", 2, 1)+randonNum;

		ContactPage contactpage = new ContactPage(driver);
		CreateNewContactPage createnewcontactpage = new CreateNewContactPage(driver);


		homepage.clickContact(driver);


		contactpage.CreateNewContact(driver);


		createnewcontactpage.enterTheLastName(driver, lastName);
		createnewcontactpage.saveTheCreateContact(driver);
		WebElement ActualLastname = driver.findElement(By.id("mouseArea_Last Name"));
		jutil.assertionThroughIfCondition(ActualLastname.getText(), lastName,"LastName is create Successfully");




	}
}














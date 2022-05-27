package com.vtiger.documentsTest;

import java.io.IOException;

import org.apache.commons.exec.LogOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.ExcelUtility;
import com.sdet34l1.genericUtility.FileUtility;
import com.sdet34l1.genericUtility.IconstantPath;
import com.sdet34l1.genericUtility.JavaUtility;
import com.sdet34l1.genericUtility.WebDriverUtility;
import com.vtiger.objectRepository.CreateNewDocumentPage;
import com.vtiger.objectRepository.DocumentPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentTest extends BaseClass{
	String title ;
	String details;
	DocumentPage documentpage; 
	CreateNewDocumentPage createnewdocumentpage;
	@Test
	public void createdocumenttest() throws IOException, InterruptedException {

		title =ExcelUtility.getDataFromExcel("documents", 3, 1)+randonNum;
		details =ExcelUtility.getDataFromExcel("documents", 3, 2)+randonNum;

			documentpage = new DocumentPage(driver);
		createnewdocumentpage = new CreateNewDocumentPage(driver);
		homepage.clickDocument(driver);
		documentpage.createDocument(driver);
		createnewdocumentpage.documentName(driver, title);
		WebDriverUtility.switchToFrame(driver, 0);
		createnewdocumentpage.writeThedeatils(driver, details);
		WebDriverUtility.switchBackToFrame(driver);
	
		createnewdocumentpage.selectAllInformation(driver);
		createnewdocumentpage.italicAction(driver);

		createnewdocumentpage.uploadTheFile(driver);

		createnewdocumentpage.saveNewDocumentPage(driver);


	}



}

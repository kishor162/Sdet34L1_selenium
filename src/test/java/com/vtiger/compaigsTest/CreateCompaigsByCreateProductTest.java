package com.vtiger.compaigsTest;

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
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CompaignsNewCreatePage;
import com.vtiger.objectRepository.CreatingNewProduct;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.ProductPage;
import com.vtiger.objectRepository.SearchProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCompaigsByCreateProductTest extends BaseClass{
	CompaignsNewCreatePage compaignsnewcreatepage;
	CampaignPage compaignPage ;
	ProductPage productPage ;
	CreatingNewProduct creatingNewProduct ;
	SearchProductPage searchproductpage;
	
	@Test
	public void createcompaigsbycreateproducttest() {
		ExcelUtility.getDataFromExcel("products", 2, 1);
		String productName =ExcelUtility.getDataFromExcel("products", 2, 1)+randonNum;

		ExcelUtility.getDataFromExcel("Campaign", 2, 1);
		String campaignName =ExcelUtility.getDataFromExcel("products", 2, 1)+randonNum;
		compaignPage = new CampaignPage (driver);
		compaignsnewcreatepage = new CompaignsNewCreatePage(driver);
		productPage = new ProductPage(driver);
		creatingNewProduct = new CreatingNewProduct(driver);
		searchproductpage =new SearchProductPage(driver);

        homepage.clickProduct(driver);
		productPage.clickCreateProduct(driver);
		creatingNewProduct.setProductName(productName);
		creatingNewProduct.saveTheProductNewCreatePage(driver);

		homepage.clickCampaign(driver);
		compaignPage .CreateCompaigns(driver);
		compaignsnewcreatepage.setTheCamppaignsName(campaignName);
		
		compaignsnewcreatepage.clickOnProductPlusButton();
		
		
		searchproductpage.selectProduct(driver, productName);
		
	
		compaignsnewcreatepage .saveTheCampaignsNewCreatePage();
		
	

	
	}

}

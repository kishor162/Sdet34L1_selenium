package com.vitger.productsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import com.vtiger.objectRepository.CreatingNewProduct;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest  extends BaseClass{
	
	String ProductName ;
	ProductPage productpage;
	CreatingNewProduct creatingnewproduct;

	@Test
	public void createproductfromexceltest () {
		
        ProductName =ExcelUtility.getDataFromExcel("products", 2, 1)+randonNum;
		homepage.clickProduct(driver);
		productpage = new ProductPage(driver);
		creatingnewproduct = new CreatingNewProduct(driver);
		productpage.clickCreateProduct(driver);
		creatingnewproduct.setProductName(ProductName);
		creatingnewproduct.saveTheProductNewCreatePage(driver);

		jutil.assertionThroughIfCondition(creatingnewproduct.actualProductName(driver), ProductName, "Product Name is create Successfully");
		
	}
}

package com.vtiger.module;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sdet34l1.genericUtility.ExcelUtility;
import com.sdet34l1.genericUtility.FileUtility;
import com.sdet34l1.genericUtility.IconstantPath;
import com.sdet34l1.genericUtility.JavaUtility;
import com.sdet34l1.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_06_ExportContactsWithImportContactTest {
	public static void main(String[] args) throws IOException, InterruptedException {


		FileUtility.openPropertyfile(IconstantPath.PROPERTYFILEPATH);
		String url = FileUtility.getDataFromPropertyFile("url");
		String username = FileUtility.getDataFromPropertyFile("username");
		String password = FileUtility.getDataFromPropertyFile("password");
		String timeout = FileUtility.getDataFromPropertyFile("timeout");



		long longtimeout = JavaUtility.StringToLong(timeout);
		int randonNum = JavaUtility.getRandomNumber(10);

		ExcelUtility.openExcel(IconstantPath.EXCELFILEPATH);
		ExcelUtility.getDataFromExcel("modules", 2, 1);
		String lastName	= ExcelUtility.getDataFromExcel("modules", 2, 1)+randonNum;



		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		WebDriverUtility.navigateApp(url, driver);
		WebDriverUtility.browserSetting(driver, longtimeout);


		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("button")).click();
		driver.findElement(By.xpath("//img[@title='Export Contacts']")).click();


		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();

		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();



		driver.findElement(By.xpath("//img[@title='Import Contacts']")).click();

		driver.findElement(By.id("import_file")).sendKeys("‪C:\\Users\\ME\\Downloads\\Contacts (3).csv");
		driver.findElement(By.xpath("//input[@name='next']")).click();
		driver.findElement(By.xpath("//input[@name='import']")).click();
		driver.findElement(By.xpath("//input[@value='Finish']")).click();

		WebElement sinout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriverUtility.moveToElement(driver, sinout);

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		WebDriverUtility.quitBrowser(driver);



	}

}

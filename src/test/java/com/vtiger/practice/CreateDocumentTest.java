package com.vtiger.practice;

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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties p = new Properties();
		p.load(fis);

		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		String timeout = p.getProperty("timeout");

		long Longtimeout = Long.parseLong(timeout);
		
		

		Random r = new Random();
		int randomNimber = r.nextInt(100);

		FileInputStream fisEx = new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fisEx);
		Sheet sh = wb.getSheet("documents");
		Row rw = sh.getRow(3);
		Cell cell = rw.getCell(1);
		String title = cell.getStringCellValue();

		Sheet sh1 = wb.getSheet("documents");
		Row rw1 = sh1.getRow(3);
		Cell cell1 = rw1.getCell(2);
		String details = cell1.getStringCellValue();
		
		String documentpath = wb.getSheet("documents").getRow(3).getCell(3).getStringCellValue();

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait =new WebDriverWait(driver,Longtimeout);

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Longtimeout, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		//Create Documents 
		driver.findElement(By.xpath("//a[text()='Documents']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Document...']")).click();
		driver.findElement(By.name("notes_title")).sendKeys(title);

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//body[@class='cke_show_borders']")).sendKeys(details,Keys.CONTROL+"a");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[@id='cke_5']")).click();
		
		

		driver.findElement(By.xpath("//input[@id='filename_I__']")).sendKeys(documentpath);
		Thread.sleep(10);
		driver.findElement(By.xpath("//b[text()='File Information']/../../following-sibling::tr[4]//input[@title='Save [Alt+S]']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='dvHeaderText']"))));
		
	   WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	   Actions a = new Actions(driver);
	   a.moveToElement(logout).perform();
	   driver.findElement(By.linkText("Sign Out")).click();
	   
	   

		






	}



}

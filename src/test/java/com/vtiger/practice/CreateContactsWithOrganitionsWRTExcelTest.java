package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsWithOrganitionsWRTExcelTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		String timeout = p.getProperty("timeout");
		
		long Longtime = Long.parseLong(timeout);
		
		Random r = new Random();
		boolean randomNumber = r.nextBoolean();
		
		FileInputStream fisEx = new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fisEx);
		
		Sheet sh = wb.getSheet("contacts");
		Row rw = sh.getRow(0);
		Cell cell = rw.getCell(1);
		String value = cell.getStringCellValue();
		
		String lastName = wb.getSheet("contacts").getRow(4).getCell(1).getStringCellValue()+randomNumber ;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Longtime, TimeUnit.SECONDS);
	//step1:logon to the app
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	if(driver.getTitle().contains("Home"))
	{
		wb.getSheet("contacts").getRow(12).createCell(7).setCellValue("Home page is displayed");
		wb.getSheet("contacts").getRow(12).createCell(8).setCellValue("pass");
	}
	//step2:clic on contact
	
	driver.findElement(By.xpath("(//a[.='Contacts'])[1]")).click();
	if(driver.getTitle().contains("Contacts"));
	{
		wb.getSheet("contacts").getRow(14).createCell(7).setCellValue("Contacts page is displayed");
		wb.getSheet("contacts").getRow(14).createCell(8).setCellValue("pass");
	}
	//step 3:
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	if(driver.getTitle().contains("module")) 
	{
		wb.getSheet("contact").getRow(15).createCell(7).setCellValue("create new page is display");
		wb.getSheet("contact").getRow(15).createCell(8).setCellValue("pass");
	}
	
	driver.findElement(By.name("lastname")).sendKeys(lastName);
	
	
	driver.findElement(By.name("button")).click();
	WebElement Actuallastname = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	if(driver.getTitle().contains("action=DetailView")) 
	{
		wb.getSheet("contact").getRow(17).createCell(7).setCellValue("Actual lastname is created");
		wb.getSheet("contact").getRow(17).createCell(8).setCellValue("pass");
	}
	
	if(Actuallastname.getText().equalsIgnoreCase(lastName))
	{
		System.out.println("Last na,e is created");
		System.out.println("pass");
	}
	
	WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	Actions a= new Actions(driver);
	a.moveToElement(logout).perform();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	FileOutputStream fos = new FileOutputStream("./src/test/resources/testData.xlsx");
	wb.write(fos);
	wb.close();
	driver.quit();
	
	
		
		
	}

}

package com.vtiger.practice;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCompaigsByCreateProductTest {
	public static void main(String[] args) throws IOException {


		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		String timeout = p.getProperty("timeout");

		long Longtimeout = Long.parseLong(timeout);

		

		FileInputStream fis1 = new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("products");
		Row rw = sh.getRow(2);
		Cell cell = rw.getCell(1);
		String productName = cell.getStringCellValue() ;
		
		Sheet sh1 = wb.getSheet("Campaign");
		Row rw1 = sh1.getRow(2);
		Cell cell1 = rw1.getCell(1);
		String campaignName= cell1.getStringCellValue();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Longtimeout,TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productName );
		 driver.findElement(By.name("button")).click();
		 
		WebElement click = driver.findElement(By.linkText("More"));
		Actions a =new Actions(driver);
		a.moveToElement(click).perform();
		
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		
		
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		Set<String> child = driver.getWindowHandles();
		for(String c:child)
		{
			driver.switchTo().window(c);
		}
		driver.findElement(By.id("search_txt")).sendKeys(productName);
		driver.findElement(By.name("search")).click();
		
		WebElement dd = driver.findElement(By.xpath("//a[@href='javascript:window.close();']"));
		Actions a2 = new Actions(driver);
		a2.doubleClick(dd).perform();
		driver.close();
		
		
		WebElement logout = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		Actions aa =new Actions(driver);
		aa.doubleClick().perform();
		driver.findElement(By.xpath("(//a[@class='drop_down_usersettings'])[2]")).click();
		driver.close();
		
		
	
		
		


				
	}

}

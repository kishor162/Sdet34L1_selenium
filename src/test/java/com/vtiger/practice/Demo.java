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
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties p = new Properties();
		p.load(fis);

		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		String timeout = p.getProperty("timeout");

		long Longtimeout = Long.parseLong(timeout);

		Random r =new Random();
		int randonNumber = r.nextInt();
		
		FileInputStream fis2 = new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb1= WorkbookFactory.create(fis2);
		Sheet sh1 = wb1.getSheet("contacts");
		Row rw1 = sh1.getRow(2);
		Cell cell1 = rw1.getCell(1);
		String lastName= cell1.getStringCellValue() + randonNumber;

		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Longtimeout,TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(lastName);
		driver.findElement(By.name("button")).click();
		 
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
	}

}

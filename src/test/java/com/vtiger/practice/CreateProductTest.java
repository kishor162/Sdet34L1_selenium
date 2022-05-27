package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/commondata.properties");
	     
		Properties p= new Properties();
		p.load(fis);
		
		
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		String timeout = p.getProperty("timeout");
		
	long Longtimeout = Long.parseLong(timeout);
	WebDriverManager.chromedriver().setup();
	
			WebDriver driver = new ChromeDriver();
			
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Longtimeout, TimeUnit.SECONDS);
			driver.findElement(By.name("user_name")).sendKeys(username);
			
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.xpath("//a[text()='Products']")).click();
			driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
			driver.findElement(By.name("productname")).sendKeys("xyz");
			driver.findElement(By.name("button")).click();
			
			WebElement sinout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			
			Actions a= new Actions(driver);
			a.moveToElement(sinout).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			
			driver.quit();
			
			
	
		
		
	
	
	
	}
	
	

}

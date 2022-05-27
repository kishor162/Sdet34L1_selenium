package com.vtiger.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganiztionTest {
	public static void main(String[] args) {
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("tye23");
		driver.findElement(By.name("button")).click();
		String text =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(text.contains("tye1"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		WebElement logout=driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		
		Actions a= new Actions(driver);
		a.moveToElement(logout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
       
		
		
		
		
	}

}

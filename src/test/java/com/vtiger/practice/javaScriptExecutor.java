package com.vtiger.practice;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExecutor {
	public static void main(String[] args) throws IOException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		js.executeScript("window.location='http://localhost:8888'");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		js.executeScript("arguments[0].value = arguments[1]", driver.findElement(By.name("user_name")),"admin");
		js.executeScript("arguments[0].value = arguments[1]", driver.findElement(By.name("user_password")),"admin");
		js.executeScript("arguments[0].click()",driver.findElement(By.id("submitButton")));
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//b[contains(text(),'Upcoming Activities')]")));
	
		File src =ts.getScreenshotAs(OutputType.FILE);
		String fileNmae = new javaScriptExecutor().getClass().getName();
		String dateTime = new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss").format(new Date());
		File dst= new File("./screenshot/"+fileNmae+"_"+dateTime+".png");
		System.out.println(dst.getAbsolutePath());
		
		
		FileUtils.copyFile(src, dst);
		
		
		
	}

}

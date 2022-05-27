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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationByPassValueAsIndustry {

	public static void main(String[] args) throws IOException, InterruptedException {

		FileInputStream fis =new FileInputStream("./src/test/resources/commondata.properties");
		Properties p =new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		String timeout = p.getProperty("timeout");

		long Longtimeout = Long.parseLong(timeout);

		Random r = new Random();
		int randomNunmber = r.nextInt();

		FileInputStream fis1 = new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);

		Sheet sh = wb.getSheet("organizations");
		Row rw = sh.getRow(1);
		Cell cell = rw.getCell(1);
		String organizationName = cell.getStringCellValue() + randomNunmber;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Longtimeout, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys(organizationName);
		WebElement industry = driver.findElement(By.name("industry"));
		
		Select s =new Select (industry);
		s.selectByValue("Education");
		
		WebElement type = driver.findElement(By.name("accounttype"));
		Select ss =new Select (type );
		ss.selectByValue("Press");
		
		driver.findElement(By.name("button")).click();
		
		WebElement logout = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		Actions a = new Actions(driver);
		a.moveToElement(logout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		wb.close();
		driver.quit();
		
	}

}

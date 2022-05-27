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

public class CreateContactsOrganizationsTest {
	public static void main(String[] args) throws IOException, InterruptedException {

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

		FileInputStream fis1 = new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("organizations");
		Row rw = sh.getRow(2);
		Cell cell = rw.getCell(1);
		String orgainationName = cell.getStringCellValue() + randonNumber;

		Sheet sh1 = wb.getSheet("contacts");
		Row rw1 = sh.getRow(2);
		Cell cell1 = rw.getCell(1);
		String lastName= cell.getStringCellValue() + randonNumber;


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
		driver.findElement(By.name("accountname")).sendKeys(orgainationName);

		 driver.findElement(By.name("button")).click();

Thread.sleep(2000);
driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
         

		
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys( lastName);

		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click() ;

		Set<String> child = driver.getWindowHandles();
		for(String c:child)
		{
			driver.switchTo().window(c);
		}
		driver.findElement(By.id("search_txt")).sendKeys(orgainationName);
		driver.findElement(By.name("search")).click();

		WebElement dd = driver.findElement(By.xpath("//a[@href='javascript:window.close();']"));
		Actions a2 = new Actions(driver);
		a2.doubleClick(dd).perform();
		driver.close();
		
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();

		WebElement logout = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		Actions aa= new Actions(driver);
		aa.moveToElement(logout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.quit();






















	}



}

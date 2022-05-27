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

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromExcel {
	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/commondata.properties");
		Properties p =new Properties();
		p.load(fis);

		String url = p.getProperty("url");
		String username = p.getProperty("username");

		String password = p.getProperty("password");
		String timeout = p.getProperty("timeout");


		long longtiomeout = Long.parseLong(timeout);

		Random ran = new Random();
		int randomNumber = ran.nextInt(100);


		FileInputStream fis1 = new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb= WorkbookFactory.create(fis1); 
		Sheet sh = wb.getSheet("organizations");
		Row rw = sh.getRow(2);
		Cell cell = rw.getCell(1);

		String organitionName = cell.getStringCellValue()+randomNumber;

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(longtiomeout, TimeUnit.SECONDS);

		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(organitionName );
		driver.findElement(By.name("button")).click();
		
		
		WebElement ActualOrganitionName = driver.findElement(By.id("dtlview_Organization Name"));
         if(ActualOrganitionName.getText().equalsIgnoreCase(organitionName))
         {
        	 System.out.println("Organition Created Successfully");
        	 System.out.println("tc pass");
         }
		
        WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a= new Actions(driver);
		a.moveToElement(logout).perform();
		driver.findElement(By.xpath("(//a[@class='drop_down_usersettings'])[2]")).click();
		
		driver.close();










	}


}

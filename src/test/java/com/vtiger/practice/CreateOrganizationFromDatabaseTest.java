package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationFromDatabaseTest {


	public static void main(String[] args) throws SQLException {
		String url=null,username=null,password=null, organame=null,lastname=null;
		Driver d= new Driver();
		DriverManager.registerDriver(d);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocky", "root", "root");

		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from rocky;");
		while(result.next())
		{
			url =result.getString("url");
			username =result.getString("username");
			password =result.getString("password");
			organame =result.getString("organizationname");
			lastname =result.getString("lastname");
		}
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(organame);
		driver.findElement(By.name("button")).click();
		WebElement logout=driver.findElement(By.xpath("(//td[@class='small'])[2]"));

		Actions a= new Actions(driver);
		a.moveToElement(logout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();


	}

}

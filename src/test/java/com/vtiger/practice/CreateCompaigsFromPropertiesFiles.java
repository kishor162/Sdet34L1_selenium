package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.sdet34l1.genericUtility.ExcelUtility;
import com.sdet34l1.genericUtility.IconstantPath;
import com.sdet34l1.genericUtility.JavaUtility;
import com.sdet34l1.genericUtility.WebDriverUtility;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CompaignsNewCreatePage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCompaigsFromPropertiesFiles {
	public static void main(String[] args) throws IOException, SQLException {

		FileInputStream fis =new FileInputStream("./src/test/resources/commondata.properties");
		Properties p = new Properties();
		p.load(fis);


		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		String timeout = p.getProperty("timeout");

		long Longtimeout = Long.parseLong(timeout);
		int randonNum = JavaUtility.getRandomNumber(10);

		ExcelUtility.openExcel(IconstantPath.EXCELFILEPATH);
		ExcelUtility.getDataFromExcel("Campaign", 2, 1);
		String campaignName= ExcelUtility.getDataFromExcel("Campaign", 2, 1)+randonNum;



		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		WebDriverUtility.navigateApp(url, driver);
		WebDriverUtility.browserSetting(driver, Longtimeout);
		LoginPage lp= new LoginPage(driver);
		HomePage hp =new HomePage(driver);
		CampaignPage cp =new CampaignPage(driver);
		CompaignsNewCreatePage cncp = new CompaignsNewCreatePage(driver);

		lp.loginAction(username, password);
		lp.clickToLoginBTn(driver);
		hp.clickCampaign(driver);
		
		
		//driver.findElement(By.linkText("More")).click();
		//driver.findElement(By.linkText("Campaigns")).click();
		
		cp.CreateCompaigns(driver);
		cncp.setTheCamppaignsName( campaignName);
	
		
		//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		//driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		cncp.saveTheCampaignsNewCreatePage();
		//driver.findElement(By.name("button")).click();
		hp.singout(driver);
	
		//WebElement sinout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		//Actions a= new Actions(driver);
	//	a.moveToElement(sinout).perform();
	//	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
        WebDriverUtility.quitBrowser(driver);
	














	}

}

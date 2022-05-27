package com.sdet34l1.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public int randonNum;
	long longtimeout ;
	public String browser;
	public WebDriver driver;
	public LoginPage loginPage  ;
	public  HomePage homepage ;
	public String username;
	public String password;
	public JavaUtility jutil;
	public String url;
	public Action action;
	static WebDriver staticdriver;

	/**
	 * In this annotation we used to open the property file and excel file.
	 * @throws IOException
	 * This is base class
	 */

	@BeforeSuite
	public void beforesuite1Test() throws IOException {

	}
	/**
	 * In this annotation we fetch the common data from the property file
	 * create the instance for all generic utility.
	 * launch browser.
	 * do the browser setting(maximize,implicit wait,action class initialization)
	 * create the instance for common object repository class
	 * @throws IOException
	 */

	//@Parameters("browser")
	@BeforeClass
	public void beforeclass1Test() throws IOException {

		jutil = new JavaUtility();

		FileUtility.openPropertyfile(IconstantPath.PROPERTYFILEPATH);
		ExcelUtility.openExcel(IconstantPath.EXCELFILEPATH);


		//String url= FileUtility.getDataFromPropertyFile("url");
		//username= 	FileUtility.getDataFromPropertyFile("username");
		//password=	FileUtility.getDataFromPropertyFile("password");
		url=System.getProperty("URL");
		browser=System.getProperty("BROWSER");
		username=System.getProperty("USERNAME");
		password =System.getProperty("PASSWORD");

		String timeout= FileUtility.getDataFromPropertyFile("timeout");
		//String browser = FileUtility.getDataFromPropertyFile("browser");
		randonNum = JavaUtility.getRandomNumber(1000);
		longtimeout = JavaUtility.StringToLong(timeout);

		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
		case"firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;


		}

		staticdriver= driver;

		WebDriverUtility.browserSetting(driver, longtimeout);
		WebDriverUtility.intiallizeJs(driver);
		WebDriverUtility.explicitlyWait(driver, longtimeout);
		loginPage =new LoginPage(driver);
		homepage = new HomePage(driver);

		WebDriverUtility.navigateApp(url, driver);


	}
	/**
	 * In this annatation we used for logicAction.
	 */

	@BeforeMethod
	public void beforemethod1Test() {
		loginPage.loginAction(username, password);
		loginPage.clickToLoginBTn(driver);

	}

	/**
	 *In this annotation we used for logoutAction.
	 */
	@AfterMethod
	public void aftermethod1Test() {
		homepage.singout(driver);
	}

	/**
	 * In this annotation we used for close the browser
	 */
	@AfterClass
	public void afterClass1test() {
		WebDriverUtility.quitBrowser(driver);
	}


	/**
	 *  In this annotation we used for claoseTheExcel.
	 * @throws IOException
	 */
	@AfterSuite
	public void aftersuite1test() throws IOException {
		ExcelUtility.closeExcel();

	}


}

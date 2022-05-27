package com.sdet34l1.genericUtility;

import org.openqa.selenium.WebDriver;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

public class GettersAndSettersForListener {
	
   private static GettersAndSettersForListener instance;
	public int randonNum;
	long longtimeout ;
	public String browser;
	public WebDriver driver;
	public LoginPage loginPage  ;
	public  HomePage homepage ;
	public String username;
	public String password;
	public FileUtility   fileutility ;
	public WebDriverUtility webDriverutility;
	public JavaUtility javautility;
	public  ExcelUtility  excelutility;
	public String url;
	public static GettersAndSettersForListener getInstance() {
		return instance;
	}
	public static void setInstance(GettersAndSettersForListener instance) {
		GettersAndSettersForListener.instance = instance;
	}
	public int getRandonNum() {
		return randonNum;
	}
	public void setRandonNum(int randonNum) {
		this.randonNum = randonNum;
	}
	public long getLongtimeout() {
		return longtimeout;
	}
	public void setLongtimeout(long longtimeout) {
		this.longtimeout = longtimeout;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public LoginPage getLoginPage() {
		return loginPage;
	}
	public void setLoginPage(LoginPage loginPage) {
		this.loginPage = loginPage;
	}
	public HomePage getHomepage() {
		return homepage;
	}
	public void setHomepage(HomePage homepage) {
		this.homepage = homepage;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public FileUtility getFileutility() {
		return fileutility;
	}
	public void setFileutility(FileUtility fileutility) {
		this.fileutility = fileutility;
	}
	public WebDriverUtility getWebDriverutility() {
		return webDriverutility;
	}
	public void setWebDriverutility(WebDriverUtility webDriverutility) {
		this.webDriverutility = webDriverutility;
	}
	public JavaUtility getJavautility() {
		return javautility;
	}
	public void setJavautility(JavaUtility javautility) {
		this.javautility = javautility;
	}
	public ExcelUtility getExcelutility() {
		return excelutility;
	}
	public void setExcelutility(ExcelUtility excelutility) {
		this.excelutility = excelutility;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	

}

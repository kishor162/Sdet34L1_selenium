package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.WebDriverUtility;

public class SearchProductPage {
	
	@FindBy(id="search_txt")
	private WebElement searchTxt;
	
	@FindBy(name="search")
	private WebElement searchBTn;
	
	public SearchProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void selectProduct(WebDriver driver,String productName) {
		WebDriverUtility.switchToWindowBasedOnTitle(driver, "Products&action");
		searchTxt.sendKeys(productName);
		searchBTn.click();
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		
		
		
		
	}
	
	

}

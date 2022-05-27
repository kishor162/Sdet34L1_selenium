package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.WebDriverUtility;

public class SearchOrganizationPage {
	
	@FindBy(id="search_txt")
	private WebElement searchTxt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	
	public SearchOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    public void selectOrganization(WebDriver driver,String orgainationName) {
    	WebDriverUtility.switchToWindowBasedOnTitle(driver,"Accounts&action");   
    	searchTxt.sendKeys(orgainationName);
    	searchBtn.click();
    	driver.findElement(By.xpath("//a[.='"+orgainationName+"']")).click();
    	
    	
    	
    }	

}

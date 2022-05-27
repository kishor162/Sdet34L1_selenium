package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sdet34l1.genericUtility.WebDriverUtility;

public class CreateNewOrganizationPage {
	
	@FindBy(name="accountname")
	private WebElement orgNametxt;
	
	
	@FindBy(name="industry")
	private WebElement industrydropdown;
	
	@FindBy(name="accounttype")
	private WebElement accounttypedropdown;
	
	@FindBy(name="button")
	private WebElement saveBTn;
	
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterOrganizationName(WebDriver driver,String name) {
		orgNametxt.sendKeys(name);
	}
	
	public void enterIndustryValue( String value) {
		WebDriverUtility.selectByValue(industrydropdown, value);
	   
	}
	public void enterTypeDropDown(String value) {
		WebDriverUtility.selectByValue(accounttypedropdown, value);;
	}
	
	public void saveTheCreateNewOrganizationPage() {
		saveBTn.click();
	}

}

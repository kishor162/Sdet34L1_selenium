package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.WebDriverUtility;

public class CompaignsNewCreatePage {

	@FindBy(name="campaignname")
	private WebElement campaignNametxt;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement productPlusBTn;
	

	@FindBy(name="button")
	private WebElement saveTab;

	public  CompaignsNewCreatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setTheCamppaignsName(String campaignName) {
		campaignNametxt.sendKeys(campaignName);
		
	}
	public void clickOnProductPlusButton() {
		productPlusBTn.click();
	}
	
	public void saveTheCampaignsNewCreatePage() {
		 saveTab.click();
		
	}
	
	public void waitUntilClickable() {
		WebDriverUtility.waitUntilElementClicable(saveTab);
		
	}

	

}

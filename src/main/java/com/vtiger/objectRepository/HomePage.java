package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.WebDriverUtility;

public class HomePage {

	@FindBy(linkText="More")
	private WebElement moreDropDown;

	@FindBy(linkText="Campaigns")
	private WebElement campainsTab;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement admistrorIcon;

	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement sinoutTab;


	@FindBy(xpath="//a[text()='Products']")
	private WebElement productTab;

	@FindBy(xpath="//a[text()='Documents']")
	private WebElement documentTab;

	@FindBy(xpath="(//a[text()='Contacts'])[1]")
	private WebElement contactTab;
	
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement organizationTb;


	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickCampaign(WebDriver driver) {
		WebDriverUtility.moveToElement(driver, moreDropDown);
		campainsTab.click();
	}
	public void singout(WebDriver driver) {
		WebDriverUtility.moveToElement(driver, admistrorIcon);
		sinoutTab.click();
	}

	public void clickProduct(WebDriver driver) {
		productTab.click();
	}

	public void clickDocument(WebDriver driver) {
		documentTab.click();
	}
	

	public void clickContact(WebDriver driver) {
		contactTab.click();
	}
	
	public void clickOnOrganization(WebDriver driver) {
		organizationTb.click();

	}

}

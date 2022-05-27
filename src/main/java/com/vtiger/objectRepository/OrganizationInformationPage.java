package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	@FindBy(name="accountname")
	private WebElement organizationNametext;

	public  OrganizationInformationPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	public String getOrganizarionName() {
		return organizationNametext.getText();
	}
	public WebElement organizationNameElement() {
		return organizationNametext;
	}
}

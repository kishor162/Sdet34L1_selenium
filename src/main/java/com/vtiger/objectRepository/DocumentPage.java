package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentPage {
	
	@FindBy(xpath="//img[@alt='Create Document...']")
	private WebElement createDocumentTab;
	
	
	public DocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void createDocument(WebDriver driver) {
		
		createDocumentTab.click();
	}
	
}

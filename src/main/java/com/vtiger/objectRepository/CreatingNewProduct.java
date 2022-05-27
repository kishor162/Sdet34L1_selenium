package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProduct {
	
	@FindBy(name="productname")
	private WebElement productNameText;
	
	@FindBy(name="button")
	private WebElement saveTab;
	
	@FindBy(xpath="(//td[@class='dvtCellInfo'])[1]")
	private WebElement headerText;


	
	public CreatingNewProduct(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	public void setProductName(String productName) {
	
		 productNameText.sendKeys(productName);
	}
	
	public String actualProductName(WebDriver driver) {
		return headerText.getText();
		
		
	
	}
	public void saveTheProductNewCreatePage(WebDriver driver) {
		 saveTab.click();
		
	}
		
	
}
 
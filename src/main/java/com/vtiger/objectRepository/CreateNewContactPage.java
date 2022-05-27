package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.WebDriverUtility;

public class CreateNewContactPage {

	@FindBy(name="lastname")
	private WebElement lastName;


	@FindBy(name="leadsource")
	private WebElement leadNameDropdown;



	@FindBy(name="button")
	private WebElement saveTbn;

	@FindBy(xpath="//input[@value='T']")
	private WebElement selectRadioBTn;
	
	@FindBy(xpath="//select[@name='assigned_group_id']")
	private WebElement radioDropdownBTn;

	



	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterTheLastName(WebDriver driver,String name){
		lastName.sendKeys(name);

	}

	public void leadNameDorodown(String name){
		WebDriverUtility.selectByValue(leadNameDropdown, name);
		leadNameDropdown.click();

	}
	
	public void selectRadioDropdown(String value) {
		WebDriverUtility.selectByValue(radioDropdownBTn, value);
		
	}


	public void selectRadioButton(WebDriver driver){
		selectRadioBTn.click();
	}

	public void saveTheCreateContact(WebDriver driver){
		saveTbn.click();

	}


}

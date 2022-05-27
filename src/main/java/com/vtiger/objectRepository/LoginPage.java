package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
		@FindBy(name ="user_name")
		private WebElement userNameText;
		
		@FindBy(name="user_password")
		private WebElement passwordText;
		
		@FindBy(id ="submitButton")
		private WebElement loginBTn;
		 
		//constructor 
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void loginAction(String username,String password) {
			userNameText.sendKeys(username);
			passwordText.sendKeys(password);
		}
		
		public void clickToLoginBTn(WebDriver driver) {
			loginBTn.click();
		}
	

}

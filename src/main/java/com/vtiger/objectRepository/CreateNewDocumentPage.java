package com.vtiger.objectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.WebDriverUtility;

public class CreateNewDocumentPage {


	@FindBy(name="notes_title")
	private WebElement createnewDocumentTab;



	@FindBy(xpath="//body[@class='cke_show_borders']")
	private WebElement noteTxBox;


	@FindBy(xpath="//a[@i.d='cke_5']")
	private WebElement italicActionTbn;	

	@FindBy(xpath="//input[@id='filename_I__']")
	private WebElement uploadFile;

	@FindBy(xpath="//b[text()='File Information']/../../following-sibling::tr[4]//input[@title='Save [Alt+S]']")
	private WebElement saveThePage;

	public CreateNewDocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	public void documentName(WebDriver driver,String title) {

		createnewDocumentTab.sendKeys(title);

	}

	public void writeThedeatils(WebDriver driver,String details) {

		noteTxBox.sendKeys(details);
	}
	public void selectAllInformation(WebDriver driver) {

		noteTxBox.sendKeys(Keys.CONTROL+"a");
	}



	public void italicAction(WebDriver driver) {
		italicActionTbn.click();
	}

	public void uploadTheFile(WebDriver driver) {
		uploadFile.sendKeys("C:\\Users\\ME\\OneDrive\\Desktop\\ty\\ADVANCE AUTOMAION PACKAGE.docx.pdf");
	}
	public void saveNewDocumentPage(WebDriver driver) {
		saveThePage.click();
	}



}

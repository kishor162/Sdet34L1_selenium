package com.vtiger.module;

import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.ExcelUtility;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.HomePage;

public class Tc_10_CreateContactWithMarketingGroupTest extends BaseClass{

	String lastName	;
	HomePage homepage;
	ContactPage contactpage; 
	CreateNewContactPage createnewcontactpage;
	@Test
	public void Tc_10_CreateContactWithMarketingGroupTest () {
		lastName = ExcelUtility.getDataFromExcel("modules", 2, 1)+randonNum;
		homepage = new HomePage(driver);
		contactpage = new ContactPage(driver);
		createnewcontactpage= new CreateNewContactPage(driver);
		homepage.clickContact(driver);

		contactpage.CreateNewContact(driver);
		createnewcontactpage.enterTheLastName(driver, lastName);
		createnewcontactpage.leadNameDorodown("Employee");

		createnewcontactpage.selectRadioButton(driver);

		createnewcontactpage.saveTheCreateContact(driver);
		createnewcontactpage.selectRadioDropdown("3");
		createnewcontactpage.saveTheCreateContact(driver);


	}

}

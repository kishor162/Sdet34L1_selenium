package com.vtiger.compaigsTest;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.ExcelUtility;
import com.sdet34l1.genericUtility.FileUtility;
import com.sdet34l1.genericUtility.IconstantPath;
import com.sdet34l1.genericUtility.JavaUtility;
import com.sdet34l1.genericUtility.WebDriverUtility;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CompaignsNewCreatePage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewCampaigsTest extends BaseClass {  

	String campaignName;
	
	CampaignPage compaignpage;
	CompaignsNewCreatePage compaignsnewcreatepage ;


	@Test(groups ="sanity")
	public void createnewcampaigstest() {

		campaignName= ExcelUtility.getDataFromExcel("Campaign", 2, 1)+randonNum;

		compaignpage =new CampaignPage(driver);
		compaignsnewcreatepage = new CompaignsNewCreatePage(driver);
		homepage.clickCampaign(driver);
		compaignpage.CreateCompaigns(driver);
		compaignsnewcreatepage.setTheCamppaignsName(campaignName);

		compaignsnewcreatepage.saveTheCampaignsNewCreatePage();
	

	}

}

package com.sdet34l1.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used to maintain all Webdriver common actions.
 * @author ME
 *
 */

public class WebDriverUtility {
	static WebDriverWait wait;
    
    static WebDriver driver;
	static JavascriptExecutor js ;
	static JavaUtility jutil = new JavaUtility();

	public WebDriverUtility(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * This method is used to navigate the the application.
	 * @param url
	 * @param driver
	 */

	public static void navigateApp( String url,WebDriver driver) {
		driver.get(url);
	}
	/**
	 * this method is used to maximize the browser and implicitly wait
	 * @param driver
	 * @param longtimeOut
	 */

	public static void browserSetting(WebDriver driver,long longtimeOut) {
		maximizeBrowser(driver);
		waitTillPageLoad(longtimeOut,driver);

	}

	/**
	 * This method is used to implicitly wait till page load.
	 * @param longtimeOut
	 * @param driver
	 */

	public static void waitTillPageLoad(long longtimeOut, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(longtimeOut,TimeUnit.SECONDS);

	}
	/**
	 * This method is used  to maximize the browser .
	 * @param driver
	 */
	public static void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();

	}







	/**
	 * This method is used to close the browser.
	 * @param driver
	 */

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

	/**
	 * This method is used to close the current browser.	
	 * @param driver
	 */
	public static void closeCurrentWindow(WebDriver driver)
	{
		driver.close();
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */

	public static void selectByIndex(WebElement element,int index) {
		Select s = new Select(element);
		s.selectByIndex(index);

	}
	public static void selectByValue(WebElement element,String Value){
		Select s = new Select(element);
		s.selectByValue(Value);

	}
	public static void selectByVisibleText(String text,WebElement element) {
		Select s = new Select(element);
		s.selectByValue(text);

	}

	public static void explicitlyWait(WebDriver driver,long longtimeout) {
		wait=new WebDriverWait(driver,longtimeout);
	}




	/**
	 * This method is used to wait the control till the particular element is clickable.
	 * @param element
	 */

	public static void waitUntilElementClicable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is used to wait the control till the particular element is visible.
	 * @param element
	 */

	public static void waitUntilElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to intiallize wait instance.
	 * @param driver
	 * @param longtimeout
	 */

	/**
	 * This method is used to switch the Window based on title.
	 * @param driver
	 * @param partialText
	 */

	public static void switchToWindowBasedOnTitle(WebDriver driver,String partialText ) {
		Set<String> sessionTDs = driver.getWindowHandles();
		for(String id:sessionTDs)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText))
			{
				break;
			}
		}

	}

	/**
	 * This method is used to switch frame by Index
	 * @param driver
	 * @param Index
	 */
	public static void switchToFrame(WebDriver driver, int Index) {
		driver.switchTo().frame(Index);
	}
	/**
	 * This method is used to switch frame by nameOrId.
	 * @param driver
	 * @param nameOrId
	 */
	public static void switchToFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * This method is used to switch frame by Element.
	 * @param driver
	 * @param element
	 */
	public static void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switchback to Original frame.
	 * @param driver
	 */
	public static void switchBackToFrame(WebDriver driver) {
		driver.switchTo().defaultContent();

	}

	public static void intiallizeJs(WebDriver driver) {
		js = (JavascriptExecutor)driver;
	}

	public static void enterDataThroughJs(WebDriver driver,WebElement element,String data) {

		js.executeScript("arguments[0].value = arguments[1]", element,data);

	}
	public static void clickThroughJs(WebElement element) {

		js.executeScript("arguments[0].click()", element);

	}

	public static void nevigateApplictionThroughJs(WebDriver driver,String url) {

		js.executeScript("window.location=arguments[0]",url);

	}

	public static void scroolToSpecifiedHeight(String height) {
		js.executeScript("window.scrollBy(0,"+height+")");
	}

	public static void scroolToBottom(String height) {
		js.executeScript("window.scrollBy(0,document.body.scroolHeight)");
	}


	public static void scroolTillElement(WebElement element) {
		js.executeScript("arguments[0].scroollIntoView()",element);
	}
	/**
	 * This method is used to takeScreenshot.
	 * @param driver
	 * @param fileNmae
	 * @return 
	 * @throws IOException
	 */
	public static String takeScreenShot(WebDriver driver ,String fileNmae) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File dst= new File("./screenshot/"+fileNmae+"_"+jutil.dataTimeinFormat()+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
		
	}
	/**
	 * This method is to switchWindow from parent to child.
	 * @param driver
	 */
	public static void switchToWindow(WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		for(String b:child)
		{
			driver.switchTo().window(b);
		}
	}
	/**
	 * This method is used to switchWindow from child to parent. 
	 * @param driver
	 * @param element
	 */
	public static void switchToParentWindow(WebDriver driver,String element) {
		driver.switchTo().window(element);
	} 

	/**
	 * This method is used to mouseHover.
	 * @param driver
	 * @param element
	 */
	public static void moveToElement(WebDriver driver,WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	} 
	/**
	 * This method is used to double click .
	 * @param driver
	 * @param element
	 */
	public static void doubleClick(WebDriver driver,WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}





}

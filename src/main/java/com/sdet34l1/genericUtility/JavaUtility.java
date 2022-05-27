   package com.sdet34l1.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;
/**
 * This class contains Only java specific reuable methods
 * @author ME
 *
 */

public class JavaUtility {
	
	/**
	 *This method is used to convert String to long datatype. 
	 * @param value
	 * @return 
	 * @return 
	 */
	public static long StringToLong(String value) {
		 return Long.parseLong(value);
	}
	
	/**
	 * This method used to get the random number.
	 * @param limit
	 * @return
	 */
	
	public static int getRandomNumber(int limit) {
		Random ran = new Random();
		return ran.nextInt( limit);
	}
	
	/**
	 * This method is used to print the message.
	 * @param message
	 */
    public void printStatment(String message) {
    	System.out.println(message);
    }
    /**
     * This method is used for validation.
     * @param actualResult
     * @param expectedResult
     * @param testCaseName
     */
    
    public void assertionThroughIfCondition(String actualResult,String expectedResult,String testCaseName)
    {
    	if(actualResult.equalsIgnoreCase(expectedResult))
    	{
    		System.out.println(testCaseName+"created Successufully");
    		System.out.println("Tc Pass");
    	}
    }
    /**
     * This method is used for wait by  customwait.
     * @param element
     * @param polingTime
     * @param duration
     * @throws InterruptedException
     */
     
    
    /**
     * This method is used for customwait
     * @param element
     * @param polingTime
     * @param duration
     * @throws InterruptedException
     */
    public void customWait(WebElement element,long polingTime,int duration) throws InterruptedException {
    int count =0;
     while(count<=duration) {
    	try {
    	element.click();
    	break;
    	}
    	catch(Exception e) {
    		Thread.sleep(polingTime);
    		}
    	}
     }
    
    /**
     * This method is use for time and date.
     * @return
     */

	public String dataTimeinFormat() {
		return new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss").format(new Date());
	}

   
    }




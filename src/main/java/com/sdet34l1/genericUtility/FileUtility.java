package com.sdet34l1.genericUtility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	static Properties p;
	/**
	 * This method is used to open the property File
	 * @throws IOException
	 */

	public static void openPropertyfile(String filePath) throws IOException {
		FileInputStream fis =new FileInputStream( filePath);
		p =new Properties();
		p.load(fis);
	}

	/**
	 * This method is used to get the data from the Property File
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public static String getDataFromPropertyFile(String key) throws IOException {
		
		String value = p.getProperty(key);
		return value;


	} 



}

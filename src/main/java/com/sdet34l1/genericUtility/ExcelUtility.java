package com.sdet34l1.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.AccessException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is used to maintain all excel specific common method
 * @author ME
 *
 */

public class ExcelUtility {
	/**
	 * 
	 */
	static Workbook wb;
	
	
	/**
	 * This method  is used to open excel sheet.
	 * @param filePath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	   public static void openExcel(String filePath) throws EncryptedDocumentException, IOException {
			FileInputStream  fisExcel = new FileInputStream (filePath);
			wb = WorkbookFactory.create(fisExcel);			
		}
		
		
		/**
		 * This method is used to fetch the data from the excel sheet.
		 * @param sheetName
		 * @param rowNumber
		 * @param cellNumber
		 * @return
		 */
		public static String getDataFromExcel(String sheetName ,int rowNumber,int cellNumber) {
			
			String data = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		    return data;
			}
		/**
		 * This method is used to save the data in excelSheet.
		 * @param fileSavedPath
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		
		public static void saveExcelData(String fileSavedPath) throws EncryptedDocumentException, IOException {
			FileOutputStream fos= new FileOutputStream(fileSavedPath);
			wb.write(fos);	
		}
		
		/**
		 * This method is used to write the data on excel sheet.
		 * @param sheetName
		 * @param rowNumber
		 * @param cellNumber
		 * @param value
		 */
		public static void setDataOnExcel(String sheetName ,int rowNumber,int cellNumber,String value) {
		
			wb.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(value);
		}
		
		
		
		/**
		 * This method is used to close the excelSheet.
		 * @throws IOException
		 */
        public static void closeExcel() throws IOException
        {
        	try {
        	wb.close();
        	}
        	catch(IOException e) {
        		e.printStackTrace();
        		System.out.println("while closing teh Excel Some exception accured then.. please check the Exception."); 		
        	}
        }


	}
	
	
	



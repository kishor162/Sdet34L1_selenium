package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.SystemOutLogger;

public class FetchMultiDataFromExcel {
	 
      public static void main(String[] args) throws IOException {
    	  FileInputStream fis =new FileInputStream("./src/test/resources/testData.xlsx");
    	  
    			 Workbook wb = WorkbookFactory.create(fis);
    	  Sheet sh = wb.getSheet("Data");
    	  
    	  for(int i=0; i<=sh.getLastRowNum();i++);
    	  {
    		  for(int j=0;j<=sh.getRow(1).getLastCellNum();j++)
    		  {
    			 
				
    		  }
    	  }
    	  
	
}
}

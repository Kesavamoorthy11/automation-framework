package com.fba.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.fba.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long PAGE_IMPLICIT_WAIT = 10;

	public static String TESTDATA_SHEET_PATH = "K:\\Dev\\Framework\\TestAutomation\\src\\main\\java\\com\\fba\\qa\\testdata\\FreeCrmFrameWorkTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file= null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch(Exception e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum(); i++) {
			for (int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data [i][k] = sheet.getRow(i+1).getCell(k).toString();	
			}
	}
	return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDir+"\\screenshots\\"+ System.currentTimeMillis()+".png"));
	}
}

package com.bridgelabz.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.bridgelabz.base.BaseClass;

public class UtilityClass extends BaseClass {
	public static long PAGE_LOAD_TIME = 15;
	public static long IMPLICIT_WAIT_TIME = 10;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\ADMIN\\eclipse-workspace\\Java-Programs\\FaceBookPageObjectModel\\src\\main\\resources\\FacedBookLoginPage.xlsx";

	public static Workbook book;
	public static Sheet sheet;

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				try {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("webdriver.chrome.driver\",\"C:\\Users\\ADMIN\\Downloads\\chromedriver_win32//chromedriver.exe");
        try {
            FileUtils.copyFile(scrFile, new File("./screenshots/" + System.currentTimeMillis() / 1000 + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

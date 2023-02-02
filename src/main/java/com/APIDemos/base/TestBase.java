/**
 * 
 */
package com.APIDemos.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

/**
 * This class is parent class of all the classes
 * This class also read the config data file and it also has setup and teardown method
 */
public class TestBase {

	static AppiumDriverLocalService service;
	public static AppiumDriver<MobileElement> driver;	
	private static DesiredCapabilities capablities = new DesiredCapabilities();
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	private static Logger logger=LogManager.getLogger("TestBase.class");
	public static Properties prop = new Properties();
	public static File file = new File("src\\main\\java\\com\\APIDemos\\Data\\config.properties");
	public static FileInputStream fis = null;
	public TestBase() {
		// Exception Handling for FIS
		try {

			fis = new FileInputStream(file);
		}catch(FileNotFoundException e){

			System.out.println(e.getMessage());
		}

		// Exception Handling for Prop
		try {

			prop.load(fis);
		}catch(IOException e) {

			System.out.println(e.getMessage());
		}
		logger.info("************************config file is readed*******************************");

		//code for excel file
		try {
			FileInputStream fis = new FileInputStream("src\\main\\java\\com\\APIDemos\\Data\\TestData.xlsx");
			workbook = new XSSFWorkbook(fis);
		}
		catch( FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}


	public void launchAndIntallApp() {

		sheet = workbook.getSheet("config_data");
		//service = AppiumDriverLocalService.buildDefaultService();
		//service.start();

		capablities.setCapability("appium-version", sheet.getRow(1).getCell(1).getStringCellValue());
		capablities.setCapability("platformVersion", String.valueOf(sheet.getRow(1).getCell(2).getNumericCellValue()));
		capablities.setCapability("platformName", sheet.getRow(1).getCell(3).getStringCellValue());
		capablities.setCapability("appPackage", sheet.getRow(1).getCell(4).getStringCellValue());
		capablities.setCapability("appActivity", sheet.getRow(1).getCell(5).getStringCellValue());
		capablities.setCapability("deviceName", sheet.getRow(1).getCell(6).getStringCellValue());
		capablities.setCapability("app",System.getProperty("user.dir")+sheet.getRow(1).getCell(7).getStringCellValue());
		System.out.println(prop.getProperty("app"));

		try {
			driver = new AndroidDriver<MobileElement>(new URL(sheet.getRow(1).getCell(0).getStringCellValue()),capablities);
			logger.info("***************************Driver Initiated************************************");
		}catch(Exception e) {
			e.printStackTrace();
			logger.info("***********************Exception is occured in Driver Initiation****************");
		}

	}

	public void afterScenario() {
		driver.quit();
		//service.stop();
		logger.info("******************************sevice Stoped******************************************");
	}
}

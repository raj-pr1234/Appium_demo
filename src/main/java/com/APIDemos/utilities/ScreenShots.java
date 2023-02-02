package com.APIDemos.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.APIDemos.base.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class ScreenShots extends TestBase{
	
	
	private static Logger logger=LogManager.getLogger("ScreenShots.class");
	public static void takeScreenShot(AppiumDriver<MobileElement> driver,String filename) {
		
		String  screenshotFileName = System.getProperty("user.dir");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(screenshotFileName + "/screenshots/" + filename + ".png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("***************** This function is used to take the screen shots*********************");
	}
	
	public static byte[] getByteScreenshot(AppiumDriver<MobileElement> driver) throws IOException 
	{
		byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	    logger.info("***************** This function is used to take the screen shots and embedded into extent reports*********************");
	    return screenshot;
	}
}

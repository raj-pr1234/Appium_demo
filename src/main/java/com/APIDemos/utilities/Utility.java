/**
 * 
 */
package com.APIDemos.utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.APIDemos.base.TestBase;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

/**
 * This class is used to generate the common utility methods which 
 * can be used in the whole project
 *
 */
public class Utility extends TestBase {

	private static Logger logger=LogManager.getLogger("Utility.class");

	//This method is used for explicitly wait until the locator not locate the elements
	public static void explicitWait(int time, MobileElement locator) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}

	// This method is used to Place the implicit wait on the element
	public static void implicitWait() {
		int timeUnit = Integer.valueOf(prop.getProperty("implicitWaitTime"));
		driver.manage().timeouts().implicitlyWait(timeUnit,TimeUnit.SECONDS); 
	}

	// This method is used to tap the element
	public static void do_tap(MobileElement element) {
		AndroidTouchAction touch = new AndroidTouchAction (driver);
		touch.tap (TapOptions.tapOptions().withElement (ElementOption.element(element))).perform ();
	}

	// Swipe
	public static void swipeScreen(Direction dir) {
		logger.info("*****************swipeScreen(): dir: '" + dir + "************"); // always log your actions

		// Animation default time:
		//  - Android: 300 ms
		//  - iOS: 200 ms
		// final value depends on your app and could be greater
		final int ANIMATION_TIME = 200; // ms

		final int PRESS_TIME = 200; // ms

		int edgeBorder = 10; // better avoid edges
		PointOption pointOptionStart, pointOptionEnd;

		// init screen variables
		Dimension dims = driver.manage().window().getSize();

		// init start point = center of screen
		pointOptionStart = PointOption.point(dims.width / 5, dims.height / 5);

		switch (dir) {
		case DOWN: // center of footer
			pointOptionEnd = PointOption.point(dims.width / 5, dims.height - edgeBorder);
			break;
		case UP: // center of header
			pointOptionEnd = PointOption.point(dims.width / 5, edgeBorder);
			break;
		case LEFT: // center of left side
			pointOptionEnd = PointOption.point(edgeBorder, dims.height / 4);
			break;
		case RIGHT: // center of right side
			pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 4);
			break;
		default:
			throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
		}

		// execute swipe using TouchAction
		try {
			new TouchAction(driver)
			.press(pointOptionStart)
			// a bit more reliable when we add small wait
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
			.moveTo(pointOptionEnd)
			.release().perform();
		} catch (Exception e) {
			logger.error("***********swipeScreen(): TouchAction FAILED\n" + e.getMessage()+"***************");
			return;
		}

		// always allow swipe action to complete
		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
			// ignore
		}
	}

	public static enum Direction {
		UP,
		DOWN,
		LEFT,
		RIGHT;
	}
	
	public static void swiUPTillFindElement(By by,String errorMessage, int maxSwipes){
		int already_Swiped =0;
		while(driver.findElements(by).size()==0){
			swipeScreen(Utility.Direction.UP);
			++already_Swiped;
			if(already_Swiped>maxSwipes){
				waitForElamentPresent(by,"Cannot find the element by swiping up" + errorMessage,5);

				return;

			}
		}

	}

	// wait for element present
	private static WebElement waitForElamentPresent(By by, String errorMessage, long timeOutInSeconds){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.withMessage(errorMessage);

		return wait.until(ExpectedConditions.presenceOfElementLocated(by));

	}


}

package com.APIDemos.stepdefinations;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.APIDemos.base.TestBase;
import com.APIDemos.utilities.ScreenShots;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HookFile extends TestBase{
	
	private static Logger logger=LogManager.getLogger("HookFile.class");
	@Before
	public void startAppium(Scenario scenario) {
		launchAndIntallApp();
		logger.info("*************Executing The Scenario " +scenario.getName()+" *******************");
	}

	@After
	public void closeservice(Scenario scenario) {
		if(scenario.isFailed()) {
			ScreenShots.takeScreenShot(driver, scenario.getName());
			try {
				scenario.attach(ScreenShots.getByteScreenshot(driver), "image/jpg", scenario.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			//logger.info("******"+ result.getName() +" is failed ******");
			logger.info("****** Taking screensshot of failed test case ******");
		}
		afterScenario();
		logger.info("*************Ending The Scenario " +scenario.getName()+" *******************");
	}
}

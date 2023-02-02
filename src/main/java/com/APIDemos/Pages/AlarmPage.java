package com.APIDemos.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.APIDemos.base.TestBase;
import com.APIDemos.utilities.Utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AlarmPage extends TestBase{

	private Logger logger = LogManager.getLogger("AlarmPage.class");

	public AlarmPage(AppiumDriver<MobileElement>driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		logger.info("**************************** Page factory initialization ***********************");
	}

	//By Locators---------------------------------------------------------------------------------------------
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Alarm']")
	public MobileElement Alarm_selector;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Alarm Controller']")
	public MobileElement alarm_controller;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Alarm Service']")
	public MobileElement alarm_service;
	
	
	@AndroidFindBy(id = "com.hmh.api:id/one_shot")
	public MobileElement one_shot;
	
	@AndroidFindBy(id = "com.hmh.api:id/start_repeating")
	public MobileElement start_repeating;
	
	@AndroidFindBy(id = "com.hmh.api:id/stop_repeating")
	public MobileElement stop_repeating;
	
	@AndroidFindBy(xpath = "//*[@id=\'screenshot\']")
	public MobileElement pop_ups;
	
	
	@AndroidFindBy(id = "com.hmh.api:id/start_alarm")
	public MobileElement start_alarm;
	
	@AndroidFindBy(id = "com.hmh.api:id/stop_alarm")
	public MobileElement stop_alarm;
	
	//Action on page---------------------------------------------------------------------------------------------
	
	public void do_tap_on_alarm_selector() {
		Utility.explicitWait(10, Alarm_selector);
		Utility.do_tap(Alarm_selector);
	}
	
	public void do_tap_on_alarm_controller() {
		Utility.explicitWait(10, alarm_controller);
		Utility.do_tap(alarm_controller);
	}
	
	public void do_tap_on_alarm_service() {
		Utility.explicitWait(10, alarm_service);
		Utility.do_tap(alarm_service);
	}
	
	public boolean check_alarm_controller_buttons_clickable() {
		String one_shot_cond=one_shot.getAttribute("clickable");
		String stop_repeating_cond=stop_repeating.getAttribute("clickable");
		String start_repeating_cond=start_repeating.getAttribute("clickable");
		
		boolean clickable_cond=one_shot_cond.equals("true") && stop_repeating_cond.equals("true")&& 
				start_repeating_cond.equals("true");
		return clickable_cond;
	}
	
	public boolean check_alarm_service_buttons_clickable() {
		String start_alarm_cond=start_alarm.getAttribute("clickable");
		String stop_alarm_cond=stop_alarm.getAttribute("clickable");
		boolean clickable_cond=start_alarm_cond.equals("true")&& stop_alarm_cond.equals("true");
		
		return clickable_cond;
	}
	
	public void do_tap_one_shot() {
		Utility.explicitWait(10, one_shot);
		Utility.do_tap(one_shot);
	}
	public String get_value() {
		return pop_ups.getText();
	}
}

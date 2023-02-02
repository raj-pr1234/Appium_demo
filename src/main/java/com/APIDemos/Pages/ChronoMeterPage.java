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

public class ChronoMeterPage extends TestBase{
	
	public static Logger logger=LogManager.getLogger("ChronoMeterPage.class");
	
	//constructor to initialize the page factory
	public ChronoMeterPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		logger.info("*************************Page Factory initialization *************************");
	}
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Chronometer']")
	public MobileElement chronometer_selector;
	
	@AndroidFindBy(id = "com.hmh.api:id/chronometer")
	public MobileElement timer;
	
	@AndroidFindBy(id = "com.hmh.api:id/start")
	public MobileElement start_btn;
	
	
	@AndroidFindBy(id = "com.hmh.api:id/stop")
	public MobileElement stop_btn;
	
	@AndroidFindBy(id = "com.hmh.api:id/reset")
	public MobileElement reset_btn;
	
	@AndroidFindBy(id = "com.hmh.api:id/set_format")
	public MobileElement set_format_btn;
	
	@AndroidFindBy(id = "com.hmh.api:id/clear_format")
	public MobileElement clear_format_btn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Views/Chronometer']")
	public MobileElement headers;
	

	public void do_click_on_chronometer() {
		Utility.explicitWait(10, chronometer_selector);
		chronometer_selector.click();
	}
	
	public String get_chrono_timer() {
		Utility.explicitWait(10, timer);
		String meter_timer=timer.getText();
		return meter_timer;
	}
	
	public void do_click_on_start_meter() {
		Utility.explicitWait(10, start_btn);
		start_btn.click();
	}
	
	public void do_click_on_stop_meter() {
		Utility.explicitWait(10, stop_btn);
		stop_btn.click();
	}
	
	public void do_click_on_reset_btn() {
		Utility.explicitWait(10, reset_btn);
		reset_btn.click();
	}
	
	public void do_click_on_set_format_btn() {
		Utility.explicitWait(10, set_format_btn);
		set_format_btn.click();
	}
	
	public void do_click_on_clear_format_btn() {
		Utility.explicitWait(10, clear_format_btn);
		clear_format_btn.click();
	}
	
	public String get_header_title() {
		Utility.explicitWait(10, headers);
		String header_title=headers.getText();
		return header_title;
	}
	

}

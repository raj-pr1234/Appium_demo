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

public class SmsSendPage extends TestBase {

	private static Logger logger=LogManager.getLogger("SmsSendPage.class");

	public SmsSendPage(AppiumDriver<MobileElement>driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		logger.info("*************************Page Factory initialization *************************");
	}

	//By Locators----------------------------------------------
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'SMS Messaging']")
	public MobileElement sms_messaging_tap;

	@AndroidFindBy(className = "android.widget.CheckBox")
	public MobileElement enable_checkbox;

	@AndroidFindBy(id = "com.hmh.api:id/sms_recipient")
	public MobileElement sms_recipient;


	@AndroidFindBy(id = "com.hmh.api:id/sms_content")
	public MobileElement sms_content;

	@AndroidFindBy(id = "com.hmh.api:id/sms_send_message")
	public MobileElement sms_send_message_button;

	@AndroidFindBy(id = "com.hmh.api:id/sms_status")
	public MobileElement sms_status;
	
	
	// Action Method-------------------------------------------------------------------------------
	
	public void do_tap_on_sms_messaging_tap() {
		Utility.explicitWait(10, sms_messaging_tap);
		Utility.do_tap(sms_messaging_tap);
	}
	public void tap_on_checkbox() {
		Utility.explicitWait(10, enable_checkbox);
		Utility.do_tap(enable_checkbox);
	}
    
	public void send_recipient(String recipient_name) {
		Utility.explicitWait(10, sms_recipient);
		sms_recipient.setValue(recipient_name);
	}
	
	public void send_content(String content) {
		Utility.explicitWait(10, sms_content);
		sms_content.setValue(content);
	}
	
	public void submit_button() {
		Utility.explicitWait(10, sms_send_message_button);
		Utility.do_tap(sms_send_message_button);
	}
	
	public String get_sms_status() {
		Utility.explicitWait(10, sms_status);
		return sms_status.getText();
	}
	
}

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

public class HomePage extends TestBase{

	private static Logger logger=LogManager.getLogger("HomePage.class");

	public HomePage(AppiumDriver<MobileElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		logger.info("*************Page Factory is initiated in homepage******************");
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Animation']")
	public MobileElement animation_selector;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Views']")
	public MobileElement views_selector;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'OS']")
	public MobileElement os_selector;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'App']")
	public MobileElement app_selector;

	public boolean animation_option_is_displayed() {
		Utility.explicitWait(10, animation_selector);
		boolean flag=animation_selector.isDisplayed();
		return flag;
	}

	public boolean views_option_is_displayed() {
		Utility.explicitWait(10, views_selector);
		boolean flag = views_selector.isDisplayed();
		return flag;
	}
	public boolean os_option_is_displayed() {
		Utility.explicitWait(10, os_selector);
		boolean flag = os_selector.isDisplayed();
		return flag;
	}
	public boolean app_option_is_displayed() {
		return app_selector.isDisplayed();
	}

	public void do_click_on_animation() {
		Utility.do_tap(animation_selector);
	}

	public void do_click_on_views() {
		Utility.do_tap(views_selector);
	}

	public void do_tap_on_os() {
		Utility.do_tap(os_selector);
	}
	
	public void do_tap_on_App() {
		Utility.explicitWait(10, app_selector);
		Utility.do_tap(app_selector);
	}
}

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

public class FragmentMenuPage extends TestBase{

	private Logger logger =LogManager.getLogger("FragmentMenuPage.class");

	//constructor to initialize the page factory
	public FragmentMenuPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		logger.info("*************************Page Factory initialization *************************");
	}
    
	//By Locators:-----------------------------------------------------------------------------------
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text = 'Fragment']")
	public MobileElement fragment_option;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text = 'Receive Result']")
	public MobileElement result_option;
	
	@AndroidFindBy(id="com.hmh.api:id/results")
	public MobileElement get_results;
	
	@AndroidFindBy(id="com.hmh.api:id/corky")
	public MobileElement get_corky;
	
	@AndroidFindBy(id="com.hmh.api:id/get")
	public MobileElement get_result_button;
	
	@AndroidFindBy(id="	com.hmh.api:id/violet")
	public MobileElement get_violet;
	
	//action methods on locators----------------------------------------------------------------------------
	
	public void do_tap_on_fragment() {
		Utility.explicitWait(10, fragment_option);
		Utility.do_tap(fragment_option);
	}
	
	public void do_tap_on_result() {
		Utility.explicitWait(10, result_option);
		Utility.do_tap(result_option);
	}
	
	public String user_get_text() {
		Utility.explicitWait(10, get_results);
		String results=get_results.getText();
		return results;
	}
	
	
	public void do_tap_on_get_result_button() {
		Utility.explicitWait(10, get_result_button);
		Utility.do_tap(get_result_button);
	}
	
	public void do_tap_on_corky() {
		Utility.explicitWait(10, get_corky);
		Utility.do_tap(get_corky);
	}
	
	public void do_tap_on_violet() {
		Utility.explicitWait(10, get_violet);
		Utility.do_tap(get_violet);
	}
}

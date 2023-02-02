package com.APIDemos.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.APIDemos.base.TestBase;
import com.APIDemos.utilities.Utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TextSwitcherPage extends TestBase{
	
	
	private static Logger logger=LogManager.getLogger("TextSwitcherPage.class");
	
	public TextSwitcherPage(AppiumDriver<MobileElement>driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		logger.info("*************************Page Factory initialization *************************");
	}
	
	//By Locators
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'TextSwitcher']")
	public MobileElement TextSwitcher; 
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Views/TextSwitcher']")
	public MobileElement title_of_page; 
	
	@AndroidFindBy(id ="com.hmh.api:id/next")
	public MobileElement next_tap;
	
	@AndroidFindBy(className = "android.widget.TextView")
	public MobileElement indicator;
	
	//Action method
	public void do_tap_on_text_switcher() {
		Utility.swiUPTillFindElement(By.xpath("//android.widget.TextView[@text = 'TextSwitcher']"), "not found", 2);
		Utility.explicitWait(10, TextSwitcher);
		Utility.do_tap(TextSwitcher);
	}
	public String get_title() {
		return title_of_page.getText();
	}
	
	public void  do_top_on_next_tap() {
		Utility.explicitWait(10, next_tap);
		Utility.do_tap(next_tap);
	}
	
	public String do_get_net_indictaor() {
		Utility.explicitWait(10, indicator);
		return indicator.getText();
	}
}
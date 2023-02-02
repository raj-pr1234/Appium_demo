package com.APIDemos.stepdefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.APIDemos.Pages.AlarmPage;
import com.APIDemos.Pages.HomePage;
import com.APIDemos.base.TestBase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlarmStepDef extends TestBase{
	
	private Logger logger=LogManager.getLogger("AlarmStepdef.class");
	private HomePage home_obj=new HomePage(driver);
	private AlarmPage alarm_obj=new AlarmPage(driver);
	
	@When("user tap on App")
	public void user_tap_on_app() {
	    logger.info("************** user tap on App ************************");
	    boolean checks=home_obj.app_option_is_displayed();
	    home_obj.do_tap_on_App();
	    Assert.assertTrue(checks, "App options is displayed");
	}

	@Then("user tap on Alarm")
	public void user_tap_on_alarm() {
	   alarm_obj.do_tap_on_alarm_selector();
	}

	@When("user tap on alarm controller")
	public void user_tap_on_alarm_controller() {
	    alarm_obj.do_tap_on_alarm_controller();
	}

	@Then("user verifies that buttons is clickable or not")
	public void user_verifies_that_buttons_is_clickable_or_not() {
	   boolean checks=alarm_obj.check_alarm_controller_buttons_clickable();
	   Assert.assertTrue(checks, "Alarm controllers all functions are functionale ");
	}

	@When("user tap on alarm service")
	public void user_tap_on_alarm_service() {
	    alarm_obj.do_tap_on_alarm_service();
	}

	@Then("user verifies that service buttons is working or not")
	public void user_verifies_that_service_buttons_is_working_or_not() {
	    boolean checks=alarm_obj.check_alarm_service_buttons_clickable();
	    Assert.assertTrue(checks, "Alarm service functions is working perfect");
	}

}

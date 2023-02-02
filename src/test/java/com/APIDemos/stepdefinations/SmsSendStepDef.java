package com.APIDemos.stepdefinations;

import org.testng.Assert;

import com.APIDemos.Pages.HomePage;
import com.APIDemos.Pages.SmsSendPage;
import com.APIDemos.base.TestBase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SmsSendStepDef  extends  TestBase{
	
	private HomePage home_obj=new HomePage(driver);
	private SmsSendPage sms_send_obj=new SmsSendPage(driver);
	
	@When("user tap on os Api")
	public void user_tap_on_os_api() {
	    home_obj.do_tap_on_os();
	}
	@Then("user tap on sms messaging button")
	public void user_tap_on_sms_messaging_button() {
		
	    sms_send_obj.do_tap_on_sms_messaging_tap();
	}
	@When("user enable the checkbox")
	public void user_enable_the_checkbox() {
	   sms_send_obj.tap_on_checkbox();
	}
	@Then("user select the name of recipient {string}")
	public void user_select_the_name_of_recipient(String recipient_name) {
	   sms_send_obj.send_recipient(recipient_name);
	}
	@Then("user fill the sms content with {string}")
	public void user_fill_the_sms_content_with(String content) {
	    sms_send_obj.send_content(content);
	}
	@Then("user send the sms")
	public void user_send_the_sms() {
	    sms_send_obj.submit_button();
	}
	
	@Then("user verify the status of message {string}")
	public void user_verify_the_status_of_message(String sms_status) {
	   String status=sms_send_obj.get_sms_status();
	   Assert.assertEquals(sms_status, status);
	}

	@Then("user enter the invalid recipient name as {string}")
	public void user_enter_the_invalid_recipient_name_as(String recipient_name) {
	    sms_send_obj.send_recipient(recipient_name);
	}

	@Then("user enter the sms content like as {string}")
	public void user_enter_the_sms_content_like_as(String string) {
	   sms_send_obj.send_content(string);
	}

	@Then("user tap on submit button")
	public void user_tap_on_submit_button() {
	    sms_send_obj.submit_button();
	}

	@Then("user check the status with {string}")
	public void user_check_the_status_with(String sms_status) {
		String status=sms_send_obj.get_sms_status();
		   Assert.assertEquals(sms_status, status);
	}
	
}

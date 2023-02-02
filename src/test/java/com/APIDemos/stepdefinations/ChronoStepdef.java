package com.APIDemos.stepdefinations;



import org.testng.Assert;

import com.APIDemos.Pages.ChronoMeterPage;
import com.APIDemos.Pages.HomePage;
import com.APIDemos.base.TestBase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChronoStepdef extends TestBase{

	private HomePage home_obj=new HomePage(driver);
	private ChronoMeterPage chrono_obj= new ChronoMeterPage(driver);
	String output;
	
	@When("user checks that views is displayed")
	public void user_checks_that_views_is_displayed() {
	   boolean flag= home_obj.views_option_is_displayed();
	   Assert.assertTrue(flag);
	}

	@Then("user click on views")
	public void user_click_on_views() {
	   home_obj.do_click_on_views();
	}

	@When("user click on chronometer")
	public void user_click_on_chronometer() {
	   chrono_obj.do_click_on_chronometer();
	}

	@Then("user start the meter and save the reading and stop the meter")
	public void user_start_the_meter_and_save_the_reading_and_stop_the_meter() {
	    chrono_obj.do_click_on_start_meter();
	    chrono_obj.do_click_on_stop_meter();
	    output=chrono_obj.get_chrono_timer(); 
	}

	@Then("user checks that meter is stoped or not")
	public void user_checks_that_meter_is_stoped_or_not() {
		String checker=chrono_obj.get_chrono_timer();
	    Assert.assertEquals(output, checker);
	}

	@When("user click on reset button")
	public void user_click_on_reset_button() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    chrono_obj.do_click_on_reset_btn();
	}

	@When("user get the meter value")
	public void user_get_the_meter_value() {
		 output=chrono_obj.get_chrono_timer();
	}

	@Then("user verify the meter value")
	public void user_verify_the_meter_value() {
	   Assert.assertEquals(output, chrono_obj.get_chrono_timer());
	}
	
	@When("user click on set format btn")
	public void user_click_on_set_format_btn() {
		
		chrono_obj.do_click_on_set_format_btn();
	}

	@Then("user click on start button")
	public void user_click_on_start_button() {
	    chrono_obj.do_click_on_start_meter();
	}

	@Then("user click on stop button and save the meter data")
	public void user_click_on_stop_button_and_save_the_meter_data() {
	    chrono_obj.do_click_on_stop_meter();
	    output=chrono_obj.get_chrono_timer();
	}

	@Then("verify the the meter data format")
	public void verify_the_the_meter_data_format() {
	    Assert.assertNotEquals(output, "Formatted time (00:00)");
	}
	
	@When("user tap on the set format button")
	public void user_tap_on_the_set_format_button() {
	   chrono_obj.do_click_on_set_format_btn();
	}

	@When("user tap on reset button")
	public void user_tap_on_reset_button() {
	   chrono_obj.do_click_on_reset_btn();
	}

	@Then("user get the meter format and verify with {string}")
	public void user_get_the_meter_format_and_verify_with(String formated_value) {
	    Assert.assertEquals(formated_value, chrono_obj.get_chrono_timer());
	}

	@When("user click on clear format button")
	public void user_click_on_clear_format_button() {
	   chrono_obj.do_click_on_clear_format_btn();
	}
	
	@When("user click on reset button for clearing format")
	public void user_click_on_reset_button_for_clearing_format() {
	    chrono_obj.do_click_on_reset_btn();
	}

	@Then("user get the meter format and verify with clear data {string}")
	public void user_get_the_meter_format_and_verify_with_clear_data(String clear_formated_value) {
	    Assert.assertEquals(clear_formated_value, chrono_obj.get_chrono_timer());
	}
}

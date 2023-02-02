package com.APIDemos.stepdefinations;

import org.testng.Assert;

import com.APIDemos.Pages.HomePage;
import com.APIDemos.Pages.TextSwitcherPage;
import com.APIDemos.base.TestBase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TextSwitcherStepDef extends TestBase {
	
	private HomePage home_obj=new HomePage(driver);
	private TextSwitcherPage text_switcher_obj=new TextSwitcherPage(driver);

	@When("user verify the view tap")
	public void user_verify_the_view_tap() {
	   boolean flag= home_obj.views_option_is_displayed();
	   Assert.assertTrue(flag);
	}

	@When("user tap on views")
	public void user_tap_on_views() {
	    home_obj.do_click_on_views();
	}

	@Then("user tap on textswitcher tap")
	public void user_tap_on_textswitcher_tap() {
	    text_switcher_obj.do_tap_on_text_switcher();
	}

	@When("user tap on next")
	public void user_tap_on_next() {
	   text_switcher_obj.do_top_on_next_tap();
	}

	@Then("User get the incremented tap meter")
	public void user_get_the_incremented_tap_meter() {
	   String result=text_switcher_obj.do_get_net_indictaor();
	   Assert.assertEquals("Views/TextSwitcher", result);
	}

}

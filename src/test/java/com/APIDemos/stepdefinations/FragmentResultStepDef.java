package com.APIDemos.stepdefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.APIDemos.Pages.FragmentMenuPage;
import com.APIDemos.Pages.HomePage;
import com.APIDemos.base.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class FragmentResultStepDef extends TestBase{

	private Logger logger=LogManager.getLogger("FragmentMenuStepDef.class");
	private HomePage home_obj=new HomePage(driver);
	private FragmentMenuPage menu_obj=new FragmentMenuPage(driver);
	private String results="";
	
	//Step-definitions--------------------------------------------------------------------------
	
	//Background-step-def-----------------------------------------------------------------------
	@Given("user tap on app")
	public void user_tap_on_app() {
	    home_obj.do_tap_on_App();
	    logger.info("********************* user tap on app ****************************************");
	}

	@When("user tap on Fragment")
	public void user_tap_on_fragment() {
	    menu_obj.do_tap_on_fragment();
	}

	//--------------------------------------------------------------------------------------------
	
	
	//Scenario first def--------------------------------------------------------------------------
	@When("user tap on the result")
	public void user_tap_on_the_result() {
	    menu_obj.do_tap_on_result();
	}

	@Then("user tap on get result")
	public void user_tap_on_get_result() {
	    menu_obj.do_tap_on_get_result_button();
	}

	@Then("user tap on get corky")
	public void user_tap_on_get_corky() {
	  menu_obj.do_tap_on_corky();
	}

	@Then("user verify that results text with {string}")
	public void user_verify_that_results_text_with(String result_text) {
	   results=menu_obj.user_get_text();
	   Assert.assertEquals(result_text, results);
	}

}

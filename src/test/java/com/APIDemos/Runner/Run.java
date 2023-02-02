package com.APIDemos.Runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src\\test\\java\\com\\APIDemos\\feature\\Chronometerfeature.feature","src\\test\\java\\com\\APIDemos\\feature\\Textswitcherfeature.feature",
				"src\\test\\java\\com\\APIDemos\\feature\\Smssendfeature.feature","src\\test\\java\\com\\APIDemos\\feature\\Alarmfeature.feature",
				"src\\test\\java\\com\\APIDemos\\feature\\Fragmentmenufeature.feature"},


		glue={"com.APIDemos.stepdefinations","HookFile"},
		dryRun = false,
		monochrome = true,//it will display the console output in proper readable format
		tags = ("@ChronoMeterTest or @TextSwitcherTest or  @SmsSendTest or @AlarmTest or @FragmentResultsTest"),
		plugin = {"pretty","html:cucumber-reports/reports_html.html"
				,"json:cucumber-reports/report_json.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class Run extends AbstractTestNGCucumberTests {
	/*This class will be empty*/
}

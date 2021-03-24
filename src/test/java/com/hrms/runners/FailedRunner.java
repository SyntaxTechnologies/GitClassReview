package com.hrms.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/FailedTests.txt",
                 glue = "com/hrms/stepdefinitions",
                 plugin = {"pretty",
                         "html:target/cucumber-default-reports",
                          "rerun:target/FailedTests.txt"}   )
public class FailedRunner {
}

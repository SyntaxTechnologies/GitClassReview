package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class DashboardStepDefinition extends CommonMethods {

    @Then("verify the following tabs on dashboard")
    public void verify_the_following_tabs_on_dashboard(DataTable dashboardTabs) {
        List<String> expectedDashTabs = dashboardTabs.asList();
        List<String> actualDashTabs = dashboardPage.getDashTabs();

        System.out.println(expectedDashTabs);
        System.out.println(actualDashTabs);

        Assert.assertEquals("Verifying dashboard tabs", expectedDashTabs, actualDashTabs);
    }
}

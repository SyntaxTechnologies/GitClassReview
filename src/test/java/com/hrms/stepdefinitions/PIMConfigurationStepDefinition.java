package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class PIMConfigurationStepDefinition extends CommonMethods {

    @When("click on configuration dropdown")
    public void click_on_configuration_dropdown() {
        pimConfigurationPage.clickOnConfigDropDown();
    }

    @When("click on optional fields")
    public void click_on_optional_fields() {
        pimConfigurationPage.clickOnOptionalFields();
    }

    @Then("click on edit button")
    public void click_on_edit_button() {
        pimConfigurationPage.clickOnEditButton();
    }

    @Then("uncheck unnecessary checkboxes")
    public void uncheck_unnecessary_checkboxes(DataTable checkBoxOptions) throws InterruptedException {
        List<String> expectedCheckBoxOptions = checkBoxOptions.asList();
        for(int i = 0; i < expectedCheckBoxOptions.size(); i++) {
            clickRadioOrCheckBoxByText(pimConfigurationPage.checkBoxes, expectedCheckBoxOptions.get(i));
        }
        Thread.sleep(5000);
    }
}

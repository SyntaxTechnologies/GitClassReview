package com.hrms.stepdefinitions;

import java.util.List;
import java.util.Map;
import com.hrms.utils.DbUtils;
import com.hrms.utils.GlobalVariables;

import io.cucumber.java.en.Then;

public class DbSteps {

	@Then("collect employee data from hrms database")
	public void collect_employee_data_from_hrms_database() {

		String query = "select emp_firstname, emp_middle_name, emp_lastname" 
						+ " from hs_hr_employees"
						+ " where employee_id=" + GlobalVariables.emp_Id;

		GlobalVariables.dbList = DbUtils.getDbDataIntoList(query);
	}

}

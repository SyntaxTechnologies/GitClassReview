package com.hrms.api;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class hardcodedexamples {
    String baseURI=RestAssured.baseURI="http://3.237.189.167/syntaxapi/api";
    String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTEwNTI0OTMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxMTA5NTY5MywidXNlcklkIjoiMjI1NSJ9.qIgNmVIWzEdBp-CENFrhoHPvVlqZK2N7Pt_acBQQ4pg";
    static String employeeID;
    //@Test
    public void sampleTest() {

        RequestSpecification preparingGetOneEmployeeRequest= given().header("Authorization",token).header("Content-Type","Application/json").queryParam("employee_id","11374");
        Response getOneEmployeeResponse=preparingGetOneEmployeeRequest.when().get("/getOneEmployee.php");

        System.out.println(getOneEmployeeResponse.asString());
    }



    @Test

    public void aPostcreateEmployee() {
        RequestSpecification createEmployeeRequest = given().header("Authorization",token).header("Content-Type","Application/json").body("{\r\n"
                + "  \"emp_firstname\": \"Moazzam\",\r\n"
                + "  \"emp_lastname\": \"string\",\r\n"
                + "  \"emp_middle_name\": \"Sadiq\",\r\n"
                + "  \"emp_gender\": \"M\",\r\n"
                + "  \"emp_birthday\": \"2021-01-13\",\r\n"
                + "    \"emp_job_title\":\"Cloud Architect\",\r\n"
                + "            \"emp_status\": \"Employee\"\r\n"
                + "}");

        Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");

        createEmployeeResponse.prettyPrint();

        employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
        System.out.println(employeeID);
        createEmployeeResponse.then().assertThat().statusCode(201);
        createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));
        createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Moazzam"));
        createEmployeeResponse.then().header("Server","Apache/2.4.39 (Win64) PHP/7.2.18");



    }

    @Test
    public void bGetcreatedEmployee() {

        RequestSpecification getCreatedEmployee = given().header("Authorization",token).header("Content-Type","Application/json").queryParam("employee_id",employeeID);

        Response getCreatedEmployeeResponse = getCreatedEmployee.when().get("/getOneEmployee.php");

        getCreatedEmployeeResponse.prettyPrint();

        String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");

        boolean VerifyingEmployeeID = empID.equalsIgnoreCase(employeeID);

        Assert.assertTrue(VerifyingEmployeeID);
        getCreatedEmployeeResponse.then().assertThat().statusCode(200);

        String response=getCreatedEmployeeResponse.asString();
        JsonPath js=new JsonPath(response);

        String firstName=js.getString("employee[0].emp_firstname");

        Assert.assertEquals(firstName,"Moazzam");


    }


    @Test
    public void cGETallEmployees() {
        RequestSpecification getAllEmployeesRequest = given().header("Content-Type","application/json").header("Authorization",token);

        Response getAllEmployeesResponse = getAllEmployeesRequest.when().get("/getAllEmployees.php");

        getAllEmployeesResponse.prettyPrint();

        String response = getAllEmployeesResponse.asString();
        JsonPath js =new JsonPath(response);
        int count =js.getInt("Employees.size()");
        System.out.println(count);

        //printing out all employee ids
        for(int i=0; i<count ;i++) {
            String allEmployeeIDs=js.getString("Employees["+i+"].employee_id");
            if (allEmployeeIDs.contentEquals(employeeID)) {

                System.out.println("Employee ID:"+employeeID+"is present in the body");
                String FirstNameOfEmpID=js.getString("Employees["+i+"].emp_firstname");
                System.out.println(FirstNameOfEmpID);
                break;
            }
        }


    }


    @Test
    public void dPUTupdateCreatedEmployee() {

        given().body("{\r\n"
                + "    \"employee_id\":\"employeeID\" ,\r\n"
                + "  \"emp_firstname\": \"Moazzam\",\r\n"
                + "  \"emp_lastname\": \"updated\",\r\n"
                + "  \"emp_middle_name\": \"Sadiq\",\r\n"
                + "  \"emp_gender\": \"M\",\r\n"
                + "  \"emp_birthday\": \"2021-01-13\",\r\n"
                + "    \"emp_job_title\":\"Cloud Architect\",\r\n"
                + " \"emp_status\": \"Employee\"\r\n"
                + "}");



    }
}


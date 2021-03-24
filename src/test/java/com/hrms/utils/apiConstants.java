package com.hrms.utils;

import io.restassured.RestAssured;

public class apiConstants {

    public static final String BaseURI= RestAssured.baseURI="http://3.237.189.167/syntaxapi/api";
    public static final String GENERATE_TOKEN_URI=BaseURI+"/generateToken.php";
    public static final String CREATE_EMPLOYEE_URI=BaseURI+"/createEmployee.php";
    public static final String GET_ONE_EMPLOYEE_URI=BaseURI+"/getOneEmployee.php";
    public static final String UPDATE_EMPLOYEE_URI=BaseURI+"/updateEmployee.php";
    public static final String GET_ALL_EMPLOYEE_URI=BaseURI+"/getAllEmployees.php";
    public static final String DELETE_EMPLOYEE_URI=BaseURI+"/deleteEmployee.php";
    public static final String PARTIALLY_UPDATE_EMPLOYEE_URI=BaseURI+"/updatePartialEmplyeesDetails.php";
    public static final String GET_EMPLOYEE_STATUS_URI=BaseURI+"/employeeStatus.php";


    public static final String Header_Content_type="Content-type";
    public static final String Content_type="application/json";

    public static final String Header_Authorization="Authorization";

    public static final String CREATE_EMPLOYEE_JSON=System.getProperty("user.dir")+"/src/test/resources/JsonData/createUser.json";

}

package com.hrms.utils;

import com.hrms.api.generateTokenSteps;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class apiCommonMethods {
    /**Create Employee Request
     *
     * @param token
     * @param Employee_Body
     * @return
     */

public static RequestSpecification createEmployeeRequest(String token,String Employee_Body){
  return given().header(apiConstants.Header_Content_type,"application.json")
            .header(apiConstants.Header_Authorization,token)
            .body(Employee_Body);
}

    /**Get one Employee Request
     *
     * @param token
     * @param employeeID
     * @return
     */
    public static RequestSpecification getOneEmployeeRequest(String token, String employeeID) {
    return given().header(apiConstants.Header_Content_type, "application/json")
            .header(apiConstants.Header_Authorization,token)
            .queryParam("employee_id", employeeID).log().all();
    }

}

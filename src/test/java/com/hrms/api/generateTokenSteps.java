package com.hrms.api;

import com.hrms.utils.apiConstants;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class generateTokenSteps {

    static String token;
    @Given("a JWT is generated")

    public void a_JWT_is_generated() {

        RequestSpecification generateTokenRequest = given().header("Content-type", "application/json")
                .body("{\"email\":\"Moazzamsadiq85@gmail.com\"" +
                        ",\"password\":\"123456789\"}");
        Response generateTokenResponse = generateTokenRequest.when().post(apiConstants.GENERATE_TOKEN_URI);
        generateTokenResponse.prettyPrint();

        token="Bearer "+generateTokenResponse.jsonPath().getString("token");

    }

}

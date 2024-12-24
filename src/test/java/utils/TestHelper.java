package utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class TestHelper {
    public static RequestSpecification getRequestSpec() {
        return RestAssured.given()
                .header("username", "testuser")
                .header("password", "testpass")
                .contentType("application/json");
    }
}

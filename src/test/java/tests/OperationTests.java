package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utils.TestHelper;

import static org.hamcrest.Matchers.equalTo;

public class OperationTests {

    @Test
    public void testAdditionOperation() {
        Response response = TestHelper.getRequestSpec()
                .post("http://mockapi.local/api/add?params=1,2");

        response.then()
                .statusCode(200)
                .body("result", equalTo(3))
                .body("user", equalTo("info"));
    }

    @Test
    public void testMultiplicationOperation() {
        Response response = TestHelper.getRequestSpec()
                .post("http://mockapi.local/api/multiplication?params=3,2,3");

        response.then()
                .statusCode(200)
                .body("result", equalTo(18))
                .body("user", equalTo("info"));
    }

    @Test
    public void testInvalidParams() {
        Response response = TestHelper.getRequestSpec()
                .post("http://mockapi.local/api/add?params=a,b");

        response.then()
                .statusCode(400);
    }
}

package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utils.TestHelper;

import static org.hamcrest.Matchers.equalTo;

public class SumEndpointTests {

    @Test
    public void testSumSuccess() {
        Response response = TestHelper.getRequestSpec()
                .get("http://mockapi.local/api/sum?params=5");

        response.then()
                .statusCode(200)
                .body("result", equalTo(15))
                .body("user", equalTo("info"));
    }

    @Test
    public void testSumWithInvalidParams() {
        Response response = TestHelper.getRequestSpec()
                .get("http://mockapi.local/api/sum?params=a");

        response.then()
                .statusCode(400);
    }
}

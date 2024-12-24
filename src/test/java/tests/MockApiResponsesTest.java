package tests;

import org.junit.jupiter.api.Test;
import utils.MockApiResponses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MockApiResponsesTest {

    @Test
    public void testAdditionMock() {
        String endpoint = "/add";
        String params = "1,2,3";

        var response = MockApiResponses.getMockResponse(endpoint, params);

        assertEquals(6, response.get("result"));
        assertEquals("info", response.get("user"));
    }

    @Test
    public void testDivisionByZeroMock() {
        String endpoint = "/division";
        String params = "10,0";

        var response = MockApiResponses.getMockResponse(endpoint, params);

        assertTrue(response.containsKey("error"));
        assertEquals("Division by zero", response.get("error"));
    }
}

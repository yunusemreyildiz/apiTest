package utils;

import java.util.HashMap;
import java.util.Map;

public class MockApiResponses {

    // Mocked responses for different API endpoints
    public static Map<String, Object> getMockResponse(String endpoint, String params) {
        Map<String, Object> response = new HashMap<>();

        switch (endpoint) {
            case "/add":
                response = handleAddition(params);
                break;

            case "/subtraction":
                response = handleSubtraction(params);
                break;

            case "/multiplication":
                response = handleMultiplication(params);
                break;

            case "/division":
                response = handleDivision(params);
                break;

            case "/sum":
                response = handleSum(params);
                break;

            default:
                response.put("error", "Invalid endpoint");
        }

        return response;
    }

    // Handle addition endpoint
    private static Map<String, Object> handleAddition(String params) {
        Map<String, Object> response = new HashMap<>();
        try {
            String[] numbers = params.split(",");
            int result = 0;
            for (String num : numbers) {
                result += Integer.parseInt(num.trim());
            }
            response.put("result", result);
            response.put("user", "info");
        } catch (Exception e) {
            response.put("error", "Invalid parameters");
        }
        return response;
    }

    // Handle subtraction endpoint
    private static Map<String, Object> handleSubtraction(String params) {
        Map<String, Object> response = new HashMap<>();
        try {
            String[] numbers = params.split(",");
            int result = Integer.parseInt(numbers[0].trim());
            for (int i = 1; i < numbers.length; i++) {
                result -= Integer.parseInt(numbers[i].trim());
            }
            response.put("result", result);
            response.put("user", "info");
        } catch (Exception e) {
            response.put("error", "Invalid parameters");
        }
        return response;
    }

    // Handle multiplication endpoint
    private static Map<String, Object> handleMultiplication(String params) {
        Map<String, Object> response = new HashMap<>();
        try {
            String[] numbers = params.split(",");
            int result = 1;
            for (String num : numbers) {
                result *= Integer.parseInt(num.trim());
            }
            response.put("result", result);
            response.put("user", "info");
        } catch (Exception e) {
            response.put("error", "Invalid parameters");
        }
        return response;
    }

    // Handle division endpoint
    private static Map<String, Object> handleDivision(String params) {
        Map<String, Object> response = new HashMap<>();
        try {
            String[] numbers = params.split(",");
            int result = Integer.parseInt(numbers[0].trim());
            for (int i = 1; i < numbers.length; i++) {
                int divisor = Integer.parseInt(numbers[i].trim());
                if (divisor == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result /= divisor;
            }
            response.put("result", result);
            response.put("user", "info");
        } catch (ArithmeticException e) {
            response.put("error", e.getMessage());
        } catch (Exception e) {
            response.put("error", "Invalid parameters");
        }
        return response;
    }

    // Handle sum endpoint
    private static Map<String, Object> handleSum(String params) {
        Map<String, Object> response = new HashMap<>();
        try {
            int n = Integer.parseInt(params.trim());
            int result = (n * (n + 1)) / 2; // Sum formula: n(n+1)/2
            response.put("result", result);
            response.put("user", "info");
        } catch (Exception e) {
            response.put("error", "Invalid parameters");
        }
        return response;
    }
}

package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import utils.TestHelper;

import static org.hamcrest.Matchers.equalTo;

public class UserAuthenticationTest {

    @Test
    public void testAuthentication() {
        // Başlangıçta bir başlık ekleme
        RequestSpecification request = RestAssured.given();
        request.header("username", "user");
        request.header("password", "pass");

        // İsteği gönder ve yanıtı doğrula
        request.post("/login").then().statusCode(200).body("user", equalTo("info"));

        // Başlıkları yeniden tanımla (eski başlıklar bu şekilde etkisiz olur)
        request = RestAssured.given(); // Yeni bir RequestSpecification oluştur
        request.post("/login").then().statusCode(400); // Başlık olmadığında beklenen hata
    }

    @Test
    public void testValidHeaders() {
        Response response = TestHelper.getRequestSpec()
                .post("http://mockapi.local/api/add?params=1,2");

        response.then()
                .statusCode(200)
                .body("user", equalTo("info"));
    }

    @Test
    public void testDynamicHeaderManagement() {
        // İlk istek: Başlıklarla
        RequestSpecification requestWithHeaders = RestAssured.given();
        requestWithHeaders.header("username", "user").header("password", "pass");

        requestWithHeaders.post("/login").then().statusCode(200).body("user", equalTo("info"));

        // İkinci istek: Başlıklar olmadan
        RequestSpecification requestWithoutHeaders = RestAssured.given();
        requestWithoutHeaders.post("/login").then().statusCode(400); // Başlıklar olmadığında kötü istek hatası
    }

}

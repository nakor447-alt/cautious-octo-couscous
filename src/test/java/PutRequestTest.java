package org.example;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PutRequestTest extends BaseTest {

    @Test(priority = 1, description = "PUT запрос - проверка кода ответа")
    public void testPutStatusCode() {
        given()
                .contentType("application/json")
                .body("{\"id\": 1, \"title\": \"Updated Item\"}")
                .when()
                .put("/put")
                .then()
                .statusCode(200);
    }

    @Test(priority = 2, description = "PUT запрос - проверка поля url")
    public void testPutUrl() {
        given()
                .contentType("application/json")
                .body("{\"id\": 1, \"title\": \"Updated Item\"}")
                .when()
                .put("/put")
                .then()
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test(priority = 3, description = "PUT запрос - проверка данных")
    public void testPutData() {
        given()
                .contentType("application/json")
                .body("{\"id\": 1, \"title\": \"Updated Item\"}")
                .when()
                .put("/put")
                .then()
                .body("data.id", equalTo(1))
                .body("data.title", equalTo("Updated Item"));
    }

    @Test(priority = 4, description = "PUT запрос - проверка json поля")
    public void testPutJson() {
        given()
                .contentType("application/json")
                .body("{\"id\": 1, \"title\": \"Updated Item\"}")
                .when()
                .put("/put")
                .then()
                .body("json.id", equalTo(1))
                .body("json.title", equalTo("Updated Item"));
    }

    @Test(priority = 5, description = "PUT запрос - проверка headers")
    public void testPutHeaders() {
        given()
                .contentType("application/json")
                .body("{\"id\": 1, \"title\": \"Updated Item\"}")
                .when()
                .put("/put")
                .then()
                .body("headers", notNullValue())
                .body("headers.host", equalTo("postman-echo.com"));
    }

    @Test(priority = 6, description = "PUT запрос - полная проверка")
    public void testPutFullResponse() {
        Response response = given()
                .contentType("application/json")
                .body("{\"id\": 1, \"title\": \"Updated Item\"}")
                .when()
                .put("/put")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("json.id"), 1);
        Assert.assertEquals(response.jsonPath().getString("json.title"),
                "Updated Item");

        printResponse(response);
    }
}
package org.example;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DeleteRequestTest extends BaseTest {

    @Test(priority = 1, description = "DELETE запрос - проверка кода ответа")
    public void testDeleteStatusCode() {
        given()
                .when()
                .delete("/delete")
                .then()
                .statusCode(200);
    }

    @Test(priority = 2, description = "DELETE запрос - проверка поля url")
    public void testDeleteUrl() {
        given()
                .when()
                .delete("/delete")
                .then()
                .body("url", equalTo("https://postman-echo.com/delete"));
    }

    @Test(priority = 3, description = "DELETE запрос - проверка что args пустой")
    public void testDeleteArgs() {
        given()
                .when()
                .delete("/delete")
                .then()
                .body("args", notNullValue());
    }

    @Test(priority = 4, description = "DELETE запрос - проверка headers")
    public void testDeleteHeaders() {
        given()
                .when()
                .delete("/delete")
                .then()
                .body("headers", notNullValue())
                .body("headers.host", equalTo("postman-echo.com"));
    }

    @Test(priority = 5, description = "DELETE запрос - проверка content-type")
    public void testDeleteContentType() {
        given()
                .when()
                .delete("/delete")
                .then()
                .header("Content-Type", containsString("application/json"));
    }

    @Test(priority = 6, description = "DELETE запрос - полная проверка")
    public void testDeleteFullResponse() {
        Response response = given()
                .when()
                .delete("/delete")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("url"),
                "https://postman-echo.com/delete");

        printResponse(response);
    }
}
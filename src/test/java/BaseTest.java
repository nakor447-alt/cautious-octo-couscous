package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    // Базовый URL для всех запросов
    public static final String BASE_URL = "https://postman-echo.com";

    @BeforeClass
    public void setup() {
        // Устанавливаем базовый URL для всех запросов
        RestAssured.baseURI = BASE_URL;

        // Включаем логирование при ошибках
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    /**
     * Вспомогательный метод для печати ответа (для отладки)
     */
    public void printResponse(Response response) {
        System.out.println("=== Response ===");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asPrettyString());
        System.out.println("================");
    }
}
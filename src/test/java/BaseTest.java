package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public static final String BASE_URL = "https://postman-echo.com";

    @BeforeClass
    public void setup() {
        // Устанавливаем базовый URL
        RestAssured.baseURI = BASE_URL;

        // Включаем логирование при ошибках
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        System.out.println("=== Настройка BaseTest ===");
        System.out.println("Base URL: " + BASE_URL);
        System.out.println("===========================");
    }

    public void printResponse(Response response) {
        System.out.println("=== Ответ ===");
        System.out.println("Код: " + response.getStatusCode());
        System.out.println("Тело: " + response.getBody().asPrettyString());
        System.out.println("=============");
    }
}
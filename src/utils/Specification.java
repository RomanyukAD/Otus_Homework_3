package ru.otus.qa.Specification;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class Specifications {

    public static void ConfigureRestAssured() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        RestAssured.requestSpecification = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().method()
                .log().uri()
                .log().body();

        RestAssured.responseSpecification = given().expect().statusCode(HttpStatus.SC_OK);
    }
}

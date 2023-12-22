package co.com.sofka.peticion;

import co.com.sofka.objeto.Users;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchUser {
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "/api";
        RestAssured.filters(
                new RequestLoggingFilter(),
                new ResponseLoggingFilter()
        );
    }

    @Test
    void patchUser() {
        Users updatedUser = new Users();
        updatedUser.setName("Diego");

        given()
                .contentType(ContentType.JSON)
                .body(updatedUser)
        .when()
                .patch("users/3")
        .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo("Diego"));
    }
}

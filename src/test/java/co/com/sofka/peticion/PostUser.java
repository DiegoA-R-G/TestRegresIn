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
import static org.hamcrest.Matchers.notNullValue;

class PostUser {

    @BeforeAll
    static void setup(){
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "/api";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());


    }
    @Test
    void createUser(){
        Users user = new Users();
                user.setName("morpheus");
        user.setJob("leader");

        given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("users")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("id", notNullValue());
    }
    @Test
    void getUser(){
        given()
                .contentType(ContentType.JSON)
                .get("users?delay=3")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", notNullValue());
    }
}

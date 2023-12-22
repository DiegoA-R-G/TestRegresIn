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

public class PutUser {
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "/api";
        RestAssured.filters(
                new RequestLoggingFilter(),
                new ResponseLoggingFilter()
        );
        // Resgistra (log) información detallada sobre las solicitudes HTTP que
        // realiza tu aplicación o recibe tu servidor. Puede incluir detalles
        // como la URL, el método HTTP, los encabezados y el cuerpo de la solicitud.
    }

    @Test
    void putUser() {
        Users updatedUser = new Users();
        updatedUser.setName("Jhorman");
        updatedUser.setJob("QA Tester");

        given()
                .contentType(ContentType.JSON)
                .body(updatedUser)
        .when()
                .put("users/2")
        .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo("Jhorman"))
                .body("job", equalTo("QA Tester"));
    }

    @Test
    void getUser() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("users/23")
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}

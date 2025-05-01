package br.unitins.tp1.resource;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;



@QuarkusTest
public class CapaceteResourceTest{
    @Test
    void testBuscarTodos(){
        given()
            .when().get("/capacetes")
            .then()
                 .statusCode(200);
    }
}
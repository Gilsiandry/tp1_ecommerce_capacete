package br.unitins.tp1.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.JugularDTO;
import br.unitins.tp1.dto.JugularResponseDTO;
import br.unitins.tp1.service.JugularService;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

@QuarkusTest
public class JugularResourceTest {

    @Inject
    JugularService jugularService;

    static Long id = null;

    @Test
    void testBuscarTodos() {
        given()
            .when().get("/jugulares")
            .then()
                .statusCode(200);
    }

    @Test
    void testIncluir() {
        JugularDTO jugular = new JugularDTO(
            "Clic-Clac 2"
        );

        given()
            .contentType(ContentType.JSON)
            .body(jugular)
            .when().post("/jugulares")
            .then()
                .statusCode(201)
                .body(
                    "id", notNullValue(),
                    "tipoFechamento", is("Clic-Clac 2")
                );
    }

    @Test
    void testAlterar() {
        JugularDTO jugular = new JugularDTO(
            "D-ring"
        );

        id = jugularService.create(jugular).id();

        JugularDTO jugularAlterada = new JugularDTO(
            "D-ring alterada"
        );

        given()
            .contentType(ContentType.JSON)
            .body(jugularAlterada)
            .when().put("/jugulares/" + id)
            .then()
                .statusCode(204);

        JugularResponseDTO response = jugularService.findById(id);
        assertThat(response.tipoFechamento(), is("D-ring alterada"));
    }

    @Test
    void testApagar() {
        given()
            .when().delete("/jugulares/" + id)
            .then()
                .statusCode(204);

        JugularResponseDTO response = jugularService.findById(id);
        assertNull(response);
    }
}
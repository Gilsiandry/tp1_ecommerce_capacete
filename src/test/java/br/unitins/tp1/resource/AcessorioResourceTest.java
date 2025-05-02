package br.unitins.tp1.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.AcessorioDTO;
import br.unitins.tp1.dto.AcessorioResponseDTO;
import br.unitins.tp1.service.AcessorioService;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

@QuarkusTest
public class AcessorioResourceTest {

    @Inject
    AcessorioService acessorioService;

    static Long id = null;

    @Test
    void testBuscarTodos() {
        given()
            .when().get("/acessorios")
            .then()
                .statusCode(200);
    }

    @Test
    void testIncluir() {
        AcessorioDTO acessorio = new AcessorioDTO(
            "viseira 2",
            "espelhada"
        );

        given()
            .contentType(ContentType.JSON)
            .body(acessorio)
            .when().post("/acessorios")
            .then()
                .statusCode(201)
                .body(
                    "id", notNullValue(),
                    "nome", is("viseira 2"),
                    "cor", is("espelhada")
                );
    }

    @Test
    void testAlterar() {
        AcessorioDTO acessorio = new AcessorioDTO(
            "viseira",
            "Cristal"
        );

        id = acessorioService.create(acessorio).id();

        AcessorioDTO acessorioAlterado = new AcessorioDTO(
            "viseira alterada",
            "iridium"
        );

        given()
            .contentType(ContentType.JSON)
            .body(acessorioAlterado)
            .when().put("/acessorios/" + id)
            .then()
                .statusCode(204);

        AcessorioResponseDTO response = acessorioService.findById(id);
        assertThat(response.nome(), is("viseira alterada"));
        assertThat(response.cor(), is("iridium"));
    }

    @Test
    void testApagar() {
        given()
            .when().delete("/acessorios/" + id)
            .then()
                .statusCode(204);

        AcessorioResponseDTO response = acessorioService.findById(id);
        assertNull(response);
    }
}
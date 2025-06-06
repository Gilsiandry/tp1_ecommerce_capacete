package br.unitins.tp1.resource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.CapaceteDTO;
import br.unitins.tp1.dto.CapaceteResponseDTO;
import br.unitins.tp1.service.CapaceteService;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

@QuarkusTest
public class CapaceteResourceTest {

    @Inject
    CapaceteService capaceteService;

    static Long id = null;

    @Test
    void testBuscarTodos() {
        given()
            .when().get("/capacetes")
            .then()
                .statusCode(200);
    }

    @Test
    void testIncluir() {
        CapaceteDTO capacete = new CapaceteDTO(
            "Capacete Street Pro",
            "Bell",
            "Aberto",
            "Street Pro",
            "Preto Fosco",
            60,
            649.90
        );

        given()
            .contentType(ContentType.JSON)
            .body(capacete)
            .when().post("/capacetes")
            .then()
                .statusCode(201)
                .body(
                    "id", notNullValue(),
                    "nome", is("Capacete Street Pro"),
                    "marca", is("Bell"),
                    "categoria", is("Aberto"),
                    "modelo", is("Street Pro"),
                    "cor", is("Preto Fosco"),
                    "tamanho", is(60),
                    "preco", is(649.90)
                );
    }

    @Test
    void testAlterar() {
        CapaceteDTO capacete = new CapaceteDTO(
            "Capacete Speed",
            "AGV",
            "Fechado",
            "aa1",
            "Azul",
            56,
            1050.90
        );

        id = capaceteService.create(capacete).id();

        CapaceteDTO capaceteAlterado = new CapaceteDTO(
            "Capacete Speed Alterado",
            "AGV",
            "Fechado",
            "K3-SV",
            "Vermelho",
            58,
            950.00
        );

        given()
            .contentType(ContentType.JSON)
            .body(capaceteAlterado)
            .when().put("/capacetes/" + id)
            .then()
                .statusCode(204);

        CapaceteResponseDTO response = capaceteService.findById(id);
        assertThat(response.nome(), is("Capacete Speed Alterado"));
        assertThat(response.modelo(), is("K3-SV"));
    }

    @Test
    void testApagar() {
        given()
            .when().delete("/capacetes/" + id)
            .then()
                .statusCode(204);

        CapaceteResponseDTO response = capaceteService.findById(id);
        assertNull(response);
    }
}
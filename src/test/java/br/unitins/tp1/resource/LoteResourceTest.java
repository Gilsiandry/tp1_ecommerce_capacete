package br.unitins.tp1.resource;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.LoteDTO;
import br.unitins.tp1.dto.LoteResponseDTO;
import br.unitins.tp1.service.LoteService;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

@QuarkusTest
public class LoteResourceTest {

    @Inject
    LoteService loteService;

    static Long id = null;

    @Test
    void testBuscarTodos() {
        given()
            .when().get("/lotes")
            .then()
                .statusCode(200);
    }

    @Test
    void testIncluir() {
        LoteDTO lote = new LoteDTO(
            "c1011",
            LocalDate.parse("2025-05-02")
        );

        given()
            .contentType(ContentType.JSON)
            .body(lote)
            .when().post("/lotes")
            .then()
                .statusCode(201)
                .body(
                    "id", notNullValue(),
                    "codigo", is("c1011"),
                    "dataFabricacao", is("2025-05-02")
                );
    }

    @Test
    void testAlterar() {
        LoteDTO lote = new LoteDTO(
            "C1234",
            LocalDate.parse("2025-05-01")
        );

        id = loteService.create(lote).id();

        LoteDTO loteAlterado = new LoteDTO(
            "C1234 Alterado",
            LocalDate.parse("2025-05-02")
        );

        given()
            .contentType(ContentType.JSON)
            .body(loteAlterado)
            .when().put("/lotes/" + id)
            .then()
                .statusCode(204);

        LoteResponseDTO response = loteService.findById(id);
        assertThat(response.codigo(), is("C1234 Alterado"));
        assertThat(response.dataFabricacao(), is(LocalDate.parse("2025-05-02")));
    }

    @Test
    void testApagar() {
        given()
            .when().delete("/lotes/" + id)
            .then()
                .statusCode(204);

        LoteResponseDTO response = loteService.findById(id);
        assertNull(response);
    }
}
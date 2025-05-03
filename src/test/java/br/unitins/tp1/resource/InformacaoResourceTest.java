package br.unitins.tp1.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.InformacaoDTO;
import br.unitins.tp1.dto.InformacaoResponseDTO;
import br.unitins.tp1.service.InformacaoService;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

@QuarkusTest
public class InformacaoResourceTest {

    @Inject
    InformacaoService informacaoService;

    static Long id = null;

    @Test
    void testBuscarTodos() {
        given()
            .when().get("/informacoes")
            .then()
                .statusCode(200);
    }

    @Test
    void testIncluir() {
        InformacaoDTO informacao = new InformacaoDTO(
            "Capacete Pro Tork Alta performace",
            2025
        );

        given()
            .contentType(ContentType.JSON)
            .body(informacao)
            .when().post("/informacoes")
            .then()
                .statusCode(201)
                .body(
                    "id", notNullValue(),
                    "descricao", is("Capacete Pro Tork Alta performace"),
                    "anoLancamento", is(2025)
                );
    }

    @Test
    void testAlterar() {
        InformacaoDTO informacao = new InformacaoDTO(
            "Capacete AGV Fechado. Proteção, Estilo e Desempenho.",
            2024
        );

        id = informacaoService.create(informacao).id();

        InformacaoDTO informacaoAlterado = new InformacaoDTO(
            "Capacete AGV Fechado. Proteção, Estilo e Desempenho. Alterado",
            2025
        );

        given()
            .contentType(ContentType.JSON)
            .body(informacaoAlterado)
            .when().put("/informacoes/" + id)
            .then()
                .statusCode(204);

        InformacaoResponseDTO response = informacaoService.findById(id);
        assertThat(response.descricao(), is("Capacete AGV Fechado. Proteção, Estilo e Desempenho. Alterado"));
        assertThat(response.anoLancamento(), is(2025));
    }

    @Test
    void testApagar() {
        given()
            .when().delete("/informacoes/" + id)
            .then()
                .statusCode(204);

        InformacaoResponseDTO response = informacaoService.findById(id);
        assertNull(response);
    }
}
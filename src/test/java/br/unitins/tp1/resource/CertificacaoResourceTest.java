package br.unitins.tp1.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.CertificacaoDTO;
import br.unitins.tp1.dto.CertificacaoResponseDTO;
import br.unitins.tp1.service.CertificacaoService;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

@QuarkusTest
public class CertificacaoResourceTest {

    @Inject
    CertificacaoService certificacaoService;

    static Long id = null;

    @Test
    void testBuscarTodos() {
        given()
            .when().get("/certificacoes")
            .then()
                .statusCode(200);
    }

    @Test
    void testIncluir() {
        CertificacaoDTO certificacao = new CertificacaoDTO(
            "Imetro 2",
            "Brasil",
            "Instituto Nacional de Metrologia, Qualidade e Tecnologia - Brasil"
        );

        given()
            .contentType(ContentType.JSON)
            .body(certificacao)
            .when().post("/certificacoes")
            .then()
                .statusCode(201)
                .body(
                    "id", notNullValue(),
                    "nome", is("Imetro 2"),
                    "pais", is("Brasil"),
                    "descricao", is("Instituto Nacional de Metrologia, Qualidade e Tecnologia - Brasil")
                    
                );
    }

    @Test
    void testAlterar() {
        CertificacaoDTO certificacao = new CertificacaoDTO(
            "Ecc 22.06",
            "Suiça",
            "Economic Commission for Europe - Europa"
        );

        id = certificacaoService.create(certificacao).id();

        CertificacaoDTO certificacaoAlterado = new CertificacaoDTO(
            "Ecc 22.06 alterado",
            "Suiça",
            "Economic Commission for Europe - Europa. Alterado"
        );

        given()
            .contentType(ContentType.JSON)
            .body(certificacaoAlterado)
            .when().put("/certificacoes/" + id)
            .then()
                .statusCode(204);

        CertificacaoResponseDTO response = certificacaoService.findById(id);
        assertThat(response.nome(), is("Ecc 22.06 alterado"));
        assertThat(response.pais(), is("Suiça"));
        assertThat(response.descricao(), is("Economic Commission for Europe - Europa. Alterado"));
        
    }

    @Test
    void testApagar() {
        given()
            .when().delete("/certificacoes/" + id)
            .then()
                .statusCode(204);

        CertificacaoResponseDTO response = certificacaoService.findById(id);
        assertNull(response);
    }
}
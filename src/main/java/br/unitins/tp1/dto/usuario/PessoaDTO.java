package br.unitins.tp1.dto.usuario;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "tipo"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = PessoaFisicaDTO.class, name = "fisica"),
    @JsonSubTypes.Type(value = PessoaJuridicaDTO.class, name = "juridica")
})
public interface PessoaDTO {
    String nome();
}

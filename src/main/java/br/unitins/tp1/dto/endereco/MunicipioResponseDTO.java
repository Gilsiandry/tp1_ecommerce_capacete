package br.unitins.tp1.dto.endereco;

import br.unitins.tp1.model.endereco.Municipio;

public record MunicipioResponseDTO(
        Long id,
        String nome,
        EstadoResponseDTO estado) {

    public static MunicipioResponseDTO valueOf(Municipio municipio) {
        return new MunicipioResponseDTO(
                municipio.getId(),
                municipio.getNome(),
                EstadoResponseDTO.valueOf(municipio.getEstado()));
    }
    
}

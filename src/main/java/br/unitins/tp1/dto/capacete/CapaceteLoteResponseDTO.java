package br.unitins.tp1.dto.capacete;

import java.util.List;

import br.unitins.tp1.model.capacete.Categoria;
import br.unitins.tp1.model.capacete.Jugular;
import br.unitins.tp1.model.capacete.Capacete;

public record CapaceteLoteResponseDTO(
        Long id,
        String nome,
        String cor,
        Integer tamanho,
        Double preco,
        MarcaResponseDTO marca,
        MarcaResponseDTO viseira,
        Categoria categoria,
        Jugular jugular,
        
        List<String> imagens) {
    public static CapaceteLoteResponseDTO valueOf(Capacete capacete) {
        return new CapaceteLoteResponseDTO(capacete.getId(), capacete.getNome(), capacete.getCor(), capacete.getTamanho(),
                capacete.getPreco(), MarcaResponseDTO.valueOf(capacete.getMarca()), ViseiraResponseDTO.valueOf(capacete.getViseira()),
                capacete.getCategoria(), capacete.getJugular(), capacete.getImagens());

    }
}
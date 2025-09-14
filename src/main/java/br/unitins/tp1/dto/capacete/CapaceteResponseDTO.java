package br.unitins.tp1.dto.capacete;

import java.util.List;

import org.jboss.resteasy.reactive.DateFormat;

import br.unitins.tp1.model.capacete.TipoCapacete;
import br.unitins.tp1.model.capacete.Capacete;

public record CapaceteResponseDTO(
        Long id,
        String nome,
        String cor,
        int tamanho,
        Double preco,
        String lote,
        int quantidadeEstoque,

        
        MarcaResponseDTO marca,
        TipoCapacete tipoCapacete,
        
        List<String> imagens) {

    public static CapaceteResponseDTO valueOf(Capacete capacete) {
        return new CapaceteResponseDTO(capacete.getId(),
                capacete.getNome(),
                capacete.getCor(),
                capacete.getTamanho(),
                capacete.getPreco(),
                MarcaResponseDTO.valueOf(capacete.getMarca()),
                capacete.getTipoCapacete(),
                
                capacete.getImagens());
    }
}
package br.unitins.tp1.dto.capacete;

import java.util.List;
import br.unitins.tp1.model.capacete.Capacete;
import br.unitins.tp1.model.capacete.Jugular;
import br.unitins.tp1.model.capacete.Categoria;
import br.unitins.tp1.model.capacete.Cor;
import br.unitins.tp1.model.capacete.Tamanho;

public record CapaceteResponseDTO(
    Long id,
    String nome,
    Double preco,
    ModeloResponseDTO modelo;
    ViseiraResponseDTO viseira;
    Jugular jugular;
    Categoria categoria;
    Cor cor;
    Tamanho tamanho;
    List<String> imagens) {


    

    public static CapaceteResponseDTO valueOf(Capacete capacete) {
        return new CapaceteResponseDTO(capacete.getId(),
                capacete.getNome(),
                capacete.getPreco(),
                ModeloResponseDTO.valueOf(capacete.getMarca()),
                ViseiraResponseDTO.valueOf(capacete.getMarca()),
                capacete.getJugular(),
                capacete.getCategoria(),
                capacete.getCor(),
                capacete.getTamanho(),
                capacete.getImagens());
    }
}
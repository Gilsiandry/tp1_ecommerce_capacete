package br.unitins.tp1.service.endereco;

import java.util.List;

import br.unitins.tp1.dto.endereco.MunicipioRequestDTO;
import br.unitins.tp1.dto.endereco.MunicipioResponseDTO;

public interface MunicipioService {

        // recursos basicos
        List<MunicipioResponseDTO> getAll(int page, int pageSize);

        MunicipioResponseDTO findById(Long id);
    
        MunicipioResponseDTO create(MunicipioRequestDTO dto);
    
        MunicipioResponseDTO update(Long id, MunicipioRequestDTO dto);
    
        void delete(Long id);
    
        // recursos extras
    
        List<MunicipioResponseDTO> findByNome(String nome, int page, int pageSize);
    
        long count();
    
}
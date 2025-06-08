package br.unitins.tp1.service.usuario;

import java.util.List;

import br.unitins.tp1.dto.PessoaJuridicaDTO;
import br.unitins.tp1.dto.PessoaJuridicaResponseDTO;

public interface PessoaJuridicaService {

    PessoaJuridicaResponseDTO create(PessoaJuridicaDTO pessoajuridica);
    void update(long id, PessoaJuridicaDTO pessoajuridica);
    void delete(long id);
    PessoaJuridicaResponseDTO findById(long id);
    List<PessoaJuridicaResponseDTO> findByNome(String nome);
    PessoaJuridicaResponseDTO findByCnpj(String cnpj);
    List<PessoaJuridicaResponseDTO> findAll();
    
}
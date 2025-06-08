package br.unitins.tp1.service.usuario;

import java.util.List;

import br.unitins.tp1.dto.PessoaJuridicaDTO;
import br.unitins.tp1.dto.PessoaJuridicaResponseDTO;
import br.unitins.tp1.model.PessoaJuridica;
import br.unitins.tp1.repository.usuario.PessoaJuridicaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PessoaJuridicaServiceImpl implements PessoaJuridicaService {

    @Inject
    PessoaJuridicaRepository pessoajuridicaRepository;

    @Override
    @Transactional
    public PessoaJuridicaResponseDTO create(PessoaJuridicaDTO pessoajuridica) {
        PessoaJuridica novoPessoaJuridica = new PessoaJuridica();
        novoPessoaJuridica.setNome(pessoajuridica.nome());
        novoPessoaJuridica.setCnpj(pessoajuridica.cnpj());
       
        // realizando inclusao
        pessoajuridicaRepository.persist(novoPessoaJuridica);

        return PessoaJuridicaResponseDTO.valueOf(novoPessoaJuridica);
    }

    @Override
    @Transactional
    public void update(long id, PessoaJuridicaDTO pessoajuridica) {
        PessoaJuridica edicaoPessoaJuridica = pessoajuridicaRepository.findById(id);

        edicaoPessoaJuridica.setNome(pessoajuridica.nome());
        edicaoPessoaJuridica.setCnpj(pessoajuridica.cnpj());
    }

    @Override
    @Transactional
    public void delete(long id) {
        pessoajuridicaRepository.deleteById(id);
    }

    @Override
    public PessoaJuridicaResponseDTO findById(long id) {
        return PessoaJuridicaResponseDTO.valueOf(pessoajuridicaRepository.findById(id));
    }

    @Override
    public PessoaJuridicaResponseDTO findByCnpj(String cnpj) {
        return PessoaJuridicaResponseDTO.valueOf(pessoajuridicaRepository.findByCnpj(cnpj));
    }

    @Override
    public List<PessoaJuridicaResponseDTO> findByNome(String nome) {
        return pessoajuridicaRepository.findByNome(nome).stream().map(pf -> PessoaJuridicaResponseDTO.valueOf(pf)).toList();
    }

    @Override
    public List<PessoaJuridicaResponseDTO> findAll() {
        return pessoajuridicaRepository.findAll().stream().map(e -> PessoaJuridicaResponseDTO.valueOf(e)).toList();
    }
}
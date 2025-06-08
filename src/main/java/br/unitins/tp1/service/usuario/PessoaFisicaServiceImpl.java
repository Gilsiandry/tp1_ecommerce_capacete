package br.unitins.tp1.service.usuario;

import java.util.List;

import br.unitins.tp1.dto.PessoaFisicaDTO;
import br.unitins.tp1.dto.PessoaFisicaResponseDTO;
import br.unitins.tp1.model.PessoaFisica;
import br.unitins.tp1.repository.usuario.PessoaFisicaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PessoaFisicaServiceImpl implements PessoaFisicaService {

    @Inject
    PessoaFisicaRepository pessoafisicaRepository;

    @Override
    @Transactional
    public PessoaFisicaResponseDTO create(PessoaFisicaDTO pessoafisica) {
        PessoaFisica novoPessoaFisica = new PessoaFisica();
        novoPessoaFisica.setNome(pessoafisica.nome());
        novoPessoaFisica.setCpf(pessoafisica.cpf());
       
        // realizando inclusao
        pessoafisicaRepository.persist(novoPessoaFisica);

        return PessoaFisicaResponseDTO.valueOf(novoPessoaFisica);
    }

    @Override
    @Transactional
    public void update(long id, PessoaFisicaDTO pessoafisica) {
        PessoaFisica edicaoPessoaFisica = pessoafisicaRepository.findById(id);

        edicaoPessoaFisica.setNome(pessoafisica.nome());
        edicaoPessoaFisica.setCpf(pessoafisica.cpf());
    }

    @Override
    @Transactional
    public void delete(long id) {
        pessoafisicaRepository.deleteById(id);
    }

    @Override
    public PessoaFisicaResponseDTO findById(long id) {
        return PessoaFisicaResponseDTO.valueOf(pessoafisicaRepository.findById(id));
    }

    @Override
    public PessoaFisicaResponseDTO findByCpf(String cpf) {
        return PessoaFisicaResponseDTO.valueOf(pessoafisicaRepository.findByCpf(cpf));
    }

    @Override
    public List<PessoaFisicaResponseDTO> findByNome(String nome) {
        return pessoafisicaRepository.findByNome(nome).stream().map(pf -> PessoaFisicaResponseDTO.valueOf(pf)).toList();
    }

    @Override
    public List<PessoaFisicaResponseDTO> findAll() {
        return pessoafisicaRepository.findAll().stream().map(e -> PessoaFisicaResponseDTO.valueOf(e)).toList();
    }
}
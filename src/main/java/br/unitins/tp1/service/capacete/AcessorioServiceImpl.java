package br.unitins.tp1.service.capacete;

import java.util.List;

import br.unitins.tp1.dto.AcessorioDTO;
import br.unitins.tp1.dto.AcessorioResponseDTO;
import br.unitins.tp1.model.Acessorio;
import br.unitins.tp1.repository.AcessorioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AcessorioServiceImpl implements AcessorioService {

    @Inject
    AcessorioRepository acessorioRepository;

    public AcessorioServiceImpl() {
    }

    @Override
    @Transactional
    public AcessorioResponseDTO create(AcessorioDTO acessorio) {
        Acessorio novoAcessorio = new Acessorio();
        novoAcessorio.setNome(acessorio.nome());
        novoAcessorio.setCor(acessorio.cor());
       

        // realizando inclusao
        acessorioRepository.persist(novoAcessorio);

        return AcessorioResponseDTO.valueOf(novoAcessorio);
    }

    @Override
    @Transactional
    public void update(long id, AcessorioDTO acessorio) {
        Acessorio edicaoAcessorio = acessorioRepository.findById(id);

        edicaoAcessorio.setNome(acessorio.nome());
        edicaoAcessorio.setCor(acessorio.cor());
    
    }

    @Override
    @Transactional
    public void delete(long id) {
        acessorioRepository.deleteById(id);
    }

    @Override
    public AcessorioResponseDTO findById(long id) {
        return AcessorioResponseDTO.valueOf(acessorioRepository.findById(id));
    }

    @Override
    public List<AcessorioResponseDTO> findByCor(String cor) {
        return acessorioRepository.findByCor(cor).stream().map(acessorio -> AcessorioResponseDTO.valueOf(acessorio)).toList();
    }


    @Override
    public List<AcessorioResponseDTO> findAll() {
        return acessorioRepository.findAll().stream().map(p -> AcessorioResponseDTO.valueOf(p)).toList();
    }
    
}
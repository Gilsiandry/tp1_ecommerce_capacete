package br.unitins.tp1.service.capacete;

import java.util.ArrayList;
import java.util.List;

import br.unitins.tp1.dto.capacete.CapaceteRequestDTO;
import br.unitins.tp1.model.capacete.Marca;
import br.unitins.tp1.model.capacete.Capacete;
import br.unitins.tp1.repository.CapaceteRepository;
import br.unitins.tp1.service.capacete.MarcaService;
import br.unitins.tp1.validation.EntidadeNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CapaceteServiceImpl implements CapaceteService {

    @Inject
    public CapaceteRepository capaceteRepository;

    @Inject
    public MarcaService marcaService;


    @Override
    public Capacete findById(Long id) {
        Capacete capacete = capaceteRepository.findById(id);
        if (capacete == null)
            throw new EntidadeNotFoundException("id", "Capacete não encontrado!");

        return capacete;
    }

    @Override
    public List<Capacete> findByNome(String nome) {
        return capaceteRepository.findByNome(nome);
    }

    @Override
    public List<Capacete> findByPreco(Double preco) {
        return capaceteRepository.findByPreco(preco);
    }

    @Override
    public List<Capacete> findAll() {
        return capaceteRepository.listAll();
    }


    @Override
    @Transactional
    public void update(Long id, CapaceteRequestDTO dto) {
        Capacete capaceteToUpdate = capaceteRepository.findById(id);
        if (capaceteToUpdate == null)
            throw new EntidadeNotFoundException("id", "Capacete não encontrado!");
        capaceteToUpdate.setNome(dto.nome());
        capaceteToUpdate.setCor(dto.cor());
        capaceteToUpdate.setTamanho(dto.tamanho());
        capaceteToUpdate.setPreco(dto.preco());
        capaceteToUpdate.setMarca(marcaService.findById(dto.idMarca()));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Capacete capaceteToDelete = capaceteRepository.findById(id);
        if (capaceteToDelete == null)
            throw new EntidadeNotFoundException("id", "Capacete não encontrado!");
        capaceteRepository.delete(capaceteToDelete);
    }

    @Override
    public List<Capacete> findByPrecoMinAndMax(Double precoMin, Double precoMax) {
        return capaceteRepository.findByPrecoMinAndMax(precoMin, precoMax);
    }

    @Override
    public List<Capacete> findByMarca(String marca) {
        return capaceteRepository.findByMarca(marca);
    }


    @Override
    @Transactional
    public void updateNomeImagem(Long id, String nomeImagem) {
        Capacete capacete = capaceteRepository.findById(id);

        if (capacete.getImagens() == null) {
            capacete.setImagens(new ArrayList<>());
            return;
        }

        capacete.getImagens().add(nomeImagem);
    }

    @Override
    public List<Capacete> findByMostRated() {
        return capaceteRepository.findMostRatedCapacete();
    }

}
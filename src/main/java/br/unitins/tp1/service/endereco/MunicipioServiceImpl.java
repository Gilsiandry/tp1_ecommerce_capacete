package br.unitins.tp1.service.endereco;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.tp1.dto.endereco.MunicipioRequestDTO;
import br.unitins.tp1.dto.endereco.MunicipioResponseDTO;
import br.unitins.tp1.model.endereco.Municipio;
import br.unitins.tp1.repository.endereco.EstadoRepository;
import br.unitins.tp1.repository.endereco.MunicipioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class MunicipioServiceImpl implements MunicipioService {

    @Inject
    MunicipioRepository municipioRepository;

    @Inject
    EstadoRepository estadoRepository;

    @Inject
    Validator validator;

    @Override
    public List<MunicipioResponseDTO> getAll(int page, int pageSize) {
        List<Municipio> list = municipioRepository.findAll2().page(page, pageSize).list();
        return list.stream().map(e -> MunicipioResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public MunicipioResponseDTO findById(Long id) {
        Municipio municipio = municipioRepository.findById(id);
        if (municipio == null)
            throw new NotFoundException("Municipio não encontrada.");
        return MunicipioResponseDTO.valueOf(municipio);
    }

    @Override
    @Transactional
    public MunicipioResponseDTO create(MunicipioRequestDTO municipioDTO) throws ConstraintViolationException {
        validar(municipioDTO);

        Municipio entity = new Municipio();
        entity.setNome(municipioDTO.nome());
        entity.setEstado(estadoRepository.findById(municipioDTO.idEstado()));

        municipioRepository.persist(entity);

        return MunicipioResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public MunicipioResponseDTO update(Long id, MunicipioRequestDTO municipioDTO) throws ConstraintViolationException {
        validar(municipioDTO);

        Municipio entity = municipioRepository.findById(id);

        entity.setNome(municipioDTO.nome());
        entity.setEstado(estadoRepository.findById(municipioDTO.idEstado()));

        return MunicipioResponseDTO.valueOf(entity);
    }

    private void validar(MunicipioRequestDTO municipioDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<MunicipioRequestDTO>> violations = validator.validate(municipioDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        municipioRepository.deleteById(id);
    }

    @Override
    public List<MunicipioResponseDTO> findByNome(String nome, int page, int pageSize) {
        List<Municipio> list = municipioRepository.findByNome(nome).page(page, pageSize).list();
        return list.stream().map(e -> MunicipioResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return municipioRepository.count();
    }
}
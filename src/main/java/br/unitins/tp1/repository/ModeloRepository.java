package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.capacete.Modelo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ModeloRepository implements PanacheRepository<Modelo> {

    public List<Modelo> findByMarca(Long idMarca) {
        return list("marca.id = ?1", idMarca);
    }
}
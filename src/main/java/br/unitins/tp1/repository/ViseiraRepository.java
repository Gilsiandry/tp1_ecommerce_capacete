package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.capacete.Viseira;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ViseiraRepository implements PanacheRepository<Viseira> {

    public List<Viseira> findByMarca(Long idMarca) {
        return list("marca.id = ?1", idMarca);
    }
}